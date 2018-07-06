package com.nostra13.universalimageloader.core.assist.deque;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockingDeque<E>
  extends AbstractQueue<E>
  implements BlockingDeque<E>, Serializable
{
  private static final long serialVersionUID = -387911632671998426L;
  private final int capacity;
  private transient int count;
  transient Node<E> first;
  transient Node<E> last;
  final ReentrantLock lock = new ReentrantLock();
  private final Condition notEmpty = this.lock.newCondition();
  private final Condition notFull = this.lock.newCondition();
  
  public LinkedBlockingDeque()
  {
    this(2147483647);
  }
  
  public LinkedBlockingDeque(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException();
    }
    this.capacity = paramInt;
  }
  
  public LinkedBlockingDeque(Collection<? extends E> paramCollection)
  {
    this(2147483647);
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    for (;;)
    {
      Object localObject2;
      try
      {
        Iterator localIterator = paramCollection.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = localIterator.next();
        if (localObject2 == null) {
          throw new NullPointerException();
        }
      }
      finally
      {
        localReentrantLock.unlock();
      }
      if (!linkLast(new Node(localObject2))) {
        throw new IllegalStateException("Deque full");
      }
    }
    localReentrantLock.unlock();
  }
  
  private boolean linkFirst(Node<E> paramNode)
  {
    if (this.count >= this.capacity) {
      return false;
    }
    Node localNode = this.first;
    paramNode.next = localNode;
    this.first = paramNode;
    if (this.last == null) {
      this.last = paramNode;
    }
    for (;;)
    {
      this.count = (1 + this.count);
      this.notEmpty.signal();
      return true;
      localNode.prev = paramNode;
    }
  }
  
  private boolean linkLast(Node<E> paramNode)
  {
    if (this.count >= this.capacity) {
      return false;
    }
    Node localNode = this.last;
    paramNode.prev = localNode;
    this.last = paramNode;
    if (this.first == null) {
      this.first = paramNode;
    }
    for (;;)
    {
      this.count = (1 + this.count);
      this.notEmpty.signal();
      return true;
      localNode.next = paramNode;
    }
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.count = 0;
    this.first = null;
    this.last = null;
    for (;;)
    {
      Object localObject = paramObjectInputStream.readObject();
      if (localObject == null) {
        return;
      }
      add(localObject);
    }
  }
  
  private E unlinkFirst()
  {
    Node localNode1 = this.first;
    if (localNode1 == null) {
      return null;
    }
    Node localNode2 = localNode1.next;
    Object localObject = localNode1.item;
    localNode1.item = null;
    localNode1.next = localNode1;
    this.first = localNode2;
    if (localNode2 == null) {
      this.last = null;
    }
    for (;;)
    {
      this.count = (-1 + this.count);
      this.notFull.signal();
      return localObject;
      localNode2.prev = null;
    }
  }
  
  private E unlinkLast()
  {
    Node localNode1 = this.last;
    if (localNode1 == null) {
      return null;
    }
    Node localNode2 = localNode1.prev;
    Object localObject = localNode1.item;
    localNode1.item = null;
    localNode1.prev = localNode1;
    this.last = localNode2;
    if (localNode2 == null) {
      this.first = null;
    }
    for (;;)
    {
      this.count = (-1 + this.count);
      this.notFull.signal();
      return localObject;
      localNode2.next = null;
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      paramObjectOutputStream.defaultWriteObject();
      for (Node localNode = this.first; localNode != null; localNode = localNode.next) {
        paramObjectOutputStream.writeObject(localNode.item);
      }
      paramObjectOutputStream.writeObject(null);
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean add(E paramE)
  {
    addLast(paramE);
    return true;
  }
  
  public void addFirst(E paramE)
  {
    if (!offerFirst(paramE)) {
      throw new IllegalStateException("Deque full");
    }
  }
  
  public void addLast(E paramE)
  {
    if (!offerLast(paramE)) {
      throw new IllegalStateException("Deque full");
    }
  }
  
  public void clear()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      Node localNode;
      for (Object localObject2 = this.first; localObject2 != null; localObject2 = localNode)
      {
        ((Node)localObject2).item = null;
        localNode = ((Node)localObject2).next;
        ((Node)localObject2).prev = null;
        ((Node)localObject2).next = null;
      }
      this.last = null;
      this.first = null;
      this.count = 0;
      this.notFull.signalAll();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean contains(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      for (Node localNode = this.first; localNode != null; localNode = localNode.next)
      {
        boolean bool = paramObject.equals(localNode.item);
        if (bool) {
          return true;
        }
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Iterator<E> descendingIterator()
  {
    return new DescendingItr(null);
  }
  
  public int drainTo(Collection<? super E> paramCollection)
  {
    return drainTo(paramCollection, 2147483647);
  }
  
  public int drainTo(Collection<? super E> paramCollection, int paramInt)
  {
    if (paramCollection == null) {
      throw new NullPointerException();
    }
    if (paramCollection == this) {
      throw new IllegalArgumentException();
    }
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      int i = Math.min(paramInt, this.count);
      for (int j = 0; j < i; j++)
      {
        paramCollection.add(this.first.item);
        unlinkFirst();
      }
      return i;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E element()
  {
    return getFirst();
  }
  
  public E getFirst()
  {
    Object localObject = peekFirst();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public E getLast()
  {
    Object localObject = peekLast();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public Iterator<E> iterator()
  {
    return new Itr(null);
  }
  
  public boolean offer(E paramE)
  {
    return offerLast(paramE);
  }
  
  public boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return offerLast(paramE, paramLong, paramTimeUnit);
  }
  
  public boolean offerFirst(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    Node localNode = new Node(paramE);
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      boolean bool = linkFirst(localNode);
      return bool;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean offerFirst(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    Node localNode = new Node(paramE);
    long l1 = paramTimeUnit.toNanos(paramLong);
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lockInterruptibly();
    try
    {
      for (;;)
      {
        boolean bool = linkFirst(localNode);
        if (bool) {
          break;
        }
        if (l1 <= 0L) {
          return false;
        }
        long l2 = this.notFull.awaitNanos(l1);
        l1 = l2;
      }
      return true;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean offerLast(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    Node localNode = new Node(paramE);
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      boolean bool = linkLast(localNode);
      return bool;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean offerLast(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    Node localNode = new Node(paramE);
    long l1 = paramTimeUnit.toNanos(paramLong);
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lockInterruptibly();
    try
    {
      for (;;)
      {
        boolean bool = linkLast(localNode);
        if (bool) {
          break;
        }
        if (l1 <= 0L) {
          return false;
        }
        long l2 = this.notFull.awaitNanos(l1);
        l1 = l2;
      }
      return true;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E peek()
  {
    return peekFirst();
  }
  
  /* Error */
  public E peekFirst()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore_1
    //   5: aload_1
    //   6: invokevirtual 54	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   9: aload_0
    //   10: getfield 97	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:first	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnonnull +13 -> 28
    //   18: aconst_null
    //   19: astore 4
    //   21: aload_1
    //   22: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   25: aload 4
    //   27: areturn
    //   28: aload_0
    //   29: getfield 97	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:first	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   32: getfield 131	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node:item	Ljava/lang/Object;
    //   35: astore 4
    //   37: goto -16 -> 21
    //   40: astore_2
    //   41: aload_1
    //   42: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   45: aload_2
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	LinkedBlockingDeque
    //   4	38	1	localReentrantLock	ReentrantLock
    //   40	6	2	localObject1	Object
    //   13	2	3	localNode	Node
    //   19	17	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	14	40	finally
    //   28	37	40	finally
  }
  
  /* Error */
  public E peekLast()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore_1
    //   5: aload_1
    //   6: invokevirtual 54	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   9: aload_0
    //   10: getfield 101	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:last	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnonnull +13 -> 28
    //   18: aconst_null
    //   19: astore 4
    //   21: aload_1
    //   22: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   25: aload 4
    //   27: areturn
    //   28: aload_0
    //   29: getfield 101	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:last	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   32: getfield 131	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node:item	Ljava/lang/Object;
    //   35: astore 4
    //   37: goto -16 -> 21
    //   40: astore_2
    //   41: aload_1
    //   42: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   45: aload_2
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	LinkedBlockingDeque
    //   4	38	1	localReentrantLock	ReentrantLock
    //   40	6	2	localObject1	Object
    //   13	2	3	localNode	Node
    //   19	17	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	14	40	finally
    //   28	37	40	finally
  }
  
  public E poll()
  {
    return pollFirst();
  }
  
  public E poll(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return pollFirst(paramLong, paramTimeUnit);
  }
  
  public E pollFirst()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      Object localObject2 = unlinkFirst();
      return localObject2;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E pollFirst(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    long l1 = paramTimeUnit.toNanos(paramLong);
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lockInterruptibly();
    try
    {
      Object localObject2;
      for (;;)
      {
        localObject2 = unlinkFirst();
        if (localObject2 != null) {
          break;
        }
        if (l1 <= 0L) {
          return null;
        }
        long l2 = this.notEmpty.awaitNanos(l1);
        l1 = l2;
      }
      return localObject2;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E pollLast()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      Object localObject2 = unlinkLast();
      return localObject2;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E pollLast(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    long l1 = paramTimeUnit.toNanos(paramLong);
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lockInterruptibly();
    try
    {
      Object localObject2;
      for (;;)
      {
        localObject2 = unlinkLast();
        if (localObject2 != null) {
          break;
        }
        if (l1 <= 0L) {
          return null;
        }
        long l2 = this.notEmpty.awaitNanos(l1);
        l1 = l2;
      }
      return localObject2;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E pop()
  {
    return removeFirst();
  }
  
  public void push(E paramE)
  {
    addFirst(paramE);
  }
  
  public void put(E paramE)
    throws InterruptedException
  {
    putLast(paramE);
  }
  
  public void putFirst(E paramE)
    throws InterruptedException
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    Node localNode = new Node(paramE);
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      if (!linkFirst(localNode)) {
        this.notFull.await();
      }
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public void putLast(E paramE)
    throws InterruptedException
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    Node localNode = new Node(paramE);
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      if (!linkLast(localNode)) {
        this.notFull.await();
      }
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public int remainingCapacity()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      int i = this.capacity;
      int j = this.count;
      int k = i - j;
      return k;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E remove()
  {
    return removeFirst();
  }
  
  public boolean remove(Object paramObject)
  {
    return removeFirstOccurrence(paramObject);
  }
  
  public E removeFirst()
  {
    Object localObject = pollFirst();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public boolean removeFirstOccurrence(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      for (Node localNode = this.first; localNode != null; localNode = localNode.next) {
        if (paramObject.equals(localNode.item))
        {
          unlink(localNode);
          return true;
        }
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E removeLast()
  {
    Object localObject = pollLast();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public boolean removeLastOccurrence(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      for (Node localNode = this.last; localNode != null; localNode = localNode.prev) {
        if (paramObject.equals(localNode.item))
        {
          unlink(localNode);
          return true;
        }
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public int size()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      int i = this.count;
      return i;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E take()
    throws InterruptedException
  {
    return takeFirst();
  }
  
  public E takeFirst()
    throws InterruptedException
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    Object localObject2;
    try
    {
      for (;;)
      {
        localObject2 = unlinkFirst();
        if (localObject2 != null) {
          break;
        }
        this.notEmpty.await();
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    return localObject2;
  }
  
  public E takeLast()
    throws InterruptedException
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    Object localObject2;
    try
    {
      for (;;)
      {
        localObject2 = unlinkLast();
        if (localObject2 != null) {
          break;
        }
        this.notEmpty.await();
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    return localObject2;
  }
  
  public Object[] toArray()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      Object[] arrayOfObject = new Object[this.count];
      Node localNode = this.first;
      int j;
      for (int i = 0; localNode != null; i = j)
      {
        j = i + 1;
        arrayOfObject[i] = localNode.item;
        localNode = localNode.next;
      }
      return arrayOfObject;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      if (paramArrayOfT.length < this.count) {
        paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.count);
      }
      Node localNode = this.first;
      int j;
      for (int i = 0; localNode != null; i = j)
      {
        j = i + 1;
        paramArrayOfT[i] = localNode.item;
        localNode = localNode.next;
      }
      if (paramArrayOfT.length > i) {
        paramArrayOfT[i] = null;
      }
      return paramArrayOfT;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  /* Error */
  public java.lang.String toString()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore_1
    //   5: aload_1
    //   6: invokevirtual 54	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   9: aload_0
    //   10: getfield 97	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:first	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnonnull +11 -> 26
    //   18: aload_1
    //   19: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   22: ldc_w 288
    //   25: areturn
    //   26: new 290	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 291	java/lang/StringBuilder:<init>	()V
    //   33: astore 4
    //   35: aload 4
    //   37: bipush 91
    //   39: invokevirtual 295	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_3
    //   44: getfield 131	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node:item	Ljava/lang/Object;
    //   47: astore 6
    //   49: aload 6
    //   51: aload_0
    //   52: if_acmpne +8 -> 60
    //   55: ldc_w 297
    //   58: astore 6
    //   60: aload 4
    //   62: aload 6
    //   64: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_3
    //   69: getfield 99	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   72: astore_3
    //   73: aload_3
    //   74: ifnonnull +22 -> 96
    //   77: aload 4
    //   79: bipush 93
    //   81: invokevirtual 295	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   84: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore 8
    //   89: aload_1
    //   90: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   93: aload 8
    //   95: areturn
    //   96: aload 4
    //   98: bipush 44
    //   100: invokevirtual 295	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   103: bipush 32
    //   105: invokevirtual 295	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: goto -66 -> 43
    //   112: astore_2
    //   113: aload_1
    //   114: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   117: aload_2
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	LinkedBlockingDeque
    //   4	110	1	localReentrantLock	ReentrantLock
    //   112	6	2	localObject1	Object
    //   13	61	3	localNode	Node
    //   33	64	4	localStringBuilder	java.lang.StringBuilder
    //   47	16	6	localObject2	Object
    //   87	7	8	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   9	14	112	finally
    //   26	43	112	finally
    //   43	49	112	finally
    //   60	73	112	finally
    //   77	89	112	finally
    //   96	109	112	finally
  }
  
  void unlink(Node<E> paramNode)
  {
    Node localNode1 = paramNode.prev;
    Node localNode2 = paramNode.next;
    if (localNode1 == null)
    {
      unlinkFirst();
      return;
    }
    if (localNode2 == null)
    {
      unlinkLast();
      return;
    }
    localNode1.next = localNode2;
    localNode2.prev = localNode1;
    paramNode.item = null;
    this.count = (-1 + this.count);
    this.notFull.signal();
  }
  
  private abstract class AbstractItr
    implements Iterator<E>
  {
    private LinkedBlockingDeque.Node<E> lastRet;
    LinkedBlockingDeque.Node<E> next;
    E nextItem;
    
    /* Error */
    AbstractItr()
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 20	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:this$0	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque;
      //   5: aload_0
      //   6: invokespecial 23	java/lang/Object:<init>	()V
      //   9: aload_1
      //   10: getfield 29	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
      //   13: astore_2
      //   14: aload_2
      //   15: invokevirtual 33	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   18: aload_0
      //   19: aload_0
      //   20: invokevirtual 37	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:firstNode	()Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
      //   23: putfield 39	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
      //   26: aload_0
      //   27: getfield 39	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
      //   30: ifnonnull +17 -> 47
      //   33: aconst_null
      //   34: astore 4
      //   36: aload_0
      //   37: aload 4
      //   39: putfield 41	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:nextItem	Ljava/lang/Object;
      //   42: aload_2
      //   43: invokevirtual 44	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   46: return
      //   47: aload_0
      //   48: getfield 39	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
      //   51: getfield 49	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node:item	Ljava/lang/Object;
      //   54: astore 4
      //   56: goto -20 -> 36
      //   59: astore_3
      //   60: aload_2
      //   61: invokevirtual 44	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   64: aload_3
      //   65: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	66	0	this	AbstractItr
      //   0	66	1	this$1	LinkedBlockingDeque
      //   13	48	2	localReentrantLock	ReentrantLock
      //   59	6	3	localObject1	Object
      //   34	21	4	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   18	33	59	finally
      //   36	42	59	finally
      //   47	56	59	finally
    }
    
    private LinkedBlockingDeque.Node<E> succ(LinkedBlockingDeque.Node<E> paramNode)
    {
      for (;;)
      {
        LinkedBlockingDeque.Node localNode = nextNode(paramNode);
        if (localNode == null) {
          localNode = null;
        }
        while (localNode.item != null) {
          return localNode;
        }
        if (localNode == paramNode) {
          return firstNode();
        }
        paramNode = localNode;
      }
    }
    
    /* Error */
    void advance()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 20	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:this$0	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque;
      //   4: getfield 29	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
      //   7: astore_1
      //   8: aload_1
      //   9: invokevirtual 33	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   12: aload_0
      //   13: aload_0
      //   14: aload_0
      //   15: getfield 39	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
      //   18: invokespecial 57	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:succ	(Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;)Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
      //   21: putfield 39	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
      //   24: aload_0
      //   25: getfield 39	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
      //   28: ifnonnull +15 -> 43
      //   31: aconst_null
      //   32: astore_3
      //   33: aload_0
      //   34: aload_3
      //   35: putfield 41	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:nextItem	Ljava/lang/Object;
      //   38: aload_1
      //   39: invokevirtual 44	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   42: return
      //   43: aload_0
      //   44: getfield 39	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
      //   47: getfield 49	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node:item	Ljava/lang/Object;
      //   50: astore_3
      //   51: goto -18 -> 33
      //   54: astore_2
      //   55: aload_1
      //   56: invokevirtual 44	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   59: aload_2
      //   60: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	AbstractItr
      //   7	49	1	localReentrantLock	ReentrantLock
      //   54	6	2	localObject1	Object
      //   32	19	3	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   12	31	54	finally
      //   33	38	54	finally
      //   43	51	54	finally
    }
    
    abstract LinkedBlockingDeque.Node<E> firstNode();
    
    public boolean hasNext()
    {
      return this.next != null;
    }
    
    public E next()
    {
      if (this.next == null) {
        throw new NoSuchElementException();
      }
      this.lastRet = this.next;
      Object localObject = this.nextItem;
      advance();
      return localObject;
    }
    
    abstract LinkedBlockingDeque.Node<E> nextNode(LinkedBlockingDeque.Node<E> paramNode);
    
    public void remove()
    {
      LinkedBlockingDeque.Node localNode = this.lastRet;
      if (localNode == null) {
        throw new IllegalStateException();
      }
      this.lastRet = null;
      ReentrantLock localReentrantLock = LinkedBlockingDeque.this.lock;
      localReentrantLock.lock();
      try
      {
        if (localNode.item != null) {
          LinkedBlockingDeque.this.unlink(localNode);
        }
        return;
      }
      finally
      {
        localReentrantLock.unlock();
      }
    }
  }
  
  private class DescendingItr
    extends LinkedBlockingDeque.AbstractItr
  {
    private DescendingItr()
    {
      super();
    }
    
    LinkedBlockingDeque.Node<E> firstNode()
    {
      return LinkedBlockingDeque.this.last;
    }
    
    LinkedBlockingDeque.Node<E> nextNode(LinkedBlockingDeque.Node<E> paramNode)
    {
      return paramNode.prev;
    }
  }
  
  private class Itr
    extends LinkedBlockingDeque.AbstractItr
  {
    private Itr()
    {
      super();
    }
    
    LinkedBlockingDeque.Node<E> firstNode()
    {
      return LinkedBlockingDeque.this.first;
    }
    
    LinkedBlockingDeque.Node<E> nextNode(LinkedBlockingDeque.Node<E> paramNode)
    {
      return paramNode.next;
    }
  }
  
  static final class Node<E>
  {
    E item;
    Node<E> next;
    Node<E> prev;
    
    Node(E paramE)
    {
      this.item = paramE;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque
 * JD-Core Version:    0.7.0.1
 */