package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;

public abstract interface ae
  extends IInterface
{
  public abstract IntentSender a(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest)
    throws RemoteException;
  
  public abstract IntentSender a(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest)
    throws RemoteException;
  
  public abstract void a(RealtimeDocumentSyncRequest paramRealtimeDocumentSyncRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(AddEventListenerRequest paramAddEventListenerRequest, ag paramag, String paramString, af paramaf)
    throws RemoteException;
  
  public abstract void a(AuthorizeAccessRequest paramAuthorizeAccessRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(CancelPendingActionsRequest paramCancelPendingActionsRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(CheckResourceIdsExistRequest paramCheckResourceIdsExistRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(CloseContentsAndUpdateMetadataRequest paramCloseContentsAndUpdateMetadataRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(CloseContentsRequest paramCloseContentsRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(CreateContentsRequest paramCreateContentsRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(CreateFileRequest paramCreateFileRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(CreateFolderRequest paramCreateFolderRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(DeleteResourceRequest paramDeleteResourceRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(DisconnectRequest paramDisconnectRequest)
    throws RemoteException;
  
  public abstract void a(GetDriveIdFromUniqueIdentifierRequest paramGetDriveIdFromUniqueIdentifierRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(GetMetadataRequest paramGetMetadataRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(ListParentsRequest paramListParentsRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(LoadRealtimeRequest paramLoadRealtimeRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(OpenContentsRequest paramOpenContentsRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(QueryRequest paramQueryRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(RemoveEventListenerRequest paramRemoveEventListenerRequest, ag paramag, String paramString, af paramaf)
    throws RemoteException;
  
  public abstract void a(SetDrivePreferencesRequest paramSetDrivePreferencesRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(SetFileUploadPreferencesRequest paramSetFileUploadPreferencesRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(SetResourceParentsRequest paramSetResourceParentsRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(TrashResourceRequest paramTrashResourceRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(UpdateMetadataRequest paramUpdateMetadataRequest, af paramaf)
    throws RemoteException;
  
  public abstract void a(af paramaf)
    throws RemoteException;
  
  public abstract void b(QueryRequest paramQueryRequest, af paramaf)
    throws RemoteException;
  
  public abstract void b(af paramaf)
    throws RemoteException;
  
  public abstract void c(af paramaf)
    throws RemoteException;
  
  public abstract void d(af paramaf)
    throws RemoteException;
  
  public abstract void e(af paramaf)
    throws RemoteException;
  
  public abstract void f(af paramaf)
    throws RemoteException;
  
  public abstract void g(af paramaf)
    throws RemoteException;
  
  public abstract void h(af paramaf)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements ae
  {
    public static ae X(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
      if ((localIInterface != null) && ((localIInterface instanceof ae))) {
        return (ae)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.drive.internal.IDriveService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i22 = paramParcel1.readInt();
        GetMetadataRequest localGetMetadataRequest = null;
        if (i22 != 0) {
          localGetMetadataRequest = (GetMetadataRequest)GetMetadataRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localGetMetadataRequest, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i21 = paramParcel1.readInt();
        QueryRequest localQueryRequest2 = null;
        if (i21 != 0) {
          localQueryRequest2 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localQueryRequest2, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i20 = paramParcel1.readInt();
        UpdateMetadataRequest localUpdateMetadataRequest = null;
        if (i20 != 0) {
          localUpdateMetadataRequest = (UpdateMetadataRequest)UpdateMetadataRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localUpdateMetadataRequest, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i19 = paramParcel1.readInt();
        CreateContentsRequest localCreateContentsRequest = null;
        if (i19 != 0) {
          localCreateContentsRequest = (CreateContentsRequest)CreateContentsRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localCreateContentsRequest, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i18 = paramParcel1.readInt();
        CreateFileRequest localCreateFileRequest = null;
        if (i18 != 0) {
          localCreateFileRequest = (CreateFileRequest)CreateFileRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localCreateFileRequest, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i17 = paramParcel1.readInt();
        CreateFolderRequest localCreateFolderRequest = null;
        if (i17 != 0) {
          localCreateFolderRequest = (CreateFolderRequest)CreateFolderRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localCreateFolderRequest, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i16 = paramParcel1.readInt();
        OpenContentsRequest localOpenContentsRequest = null;
        if (i16 != 0) {
          localOpenContentsRequest = (OpenContentsRequest)OpenContentsRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localOpenContentsRequest, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i15 = paramParcel1.readInt();
        CloseContentsRequest localCloseContentsRequest = null;
        if (i15 != 0) {
          localCloseContentsRequest = (CloseContentsRequest)CloseContentsRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localCloseContentsRequest, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        a(af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i14 = paramParcel1.readInt();
        OpenFileIntentSenderRequest localOpenFileIntentSenderRequest = null;
        if (i14 != 0) {
          localOpenFileIntentSenderRequest = (OpenFileIntentSenderRequest)OpenFileIntentSenderRequest.CREATOR.createFromParcel(paramParcel1);
        }
        IntentSender localIntentSender2 = a(localOpenFileIntentSenderRequest);
        paramParcel2.writeNoException();
        if (localIntentSender2 != null)
        {
          paramParcel2.writeInt(1);
          localIntentSender2.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i13 = paramParcel1.readInt();
        CreateFileIntentSenderRequest localCreateFileIntentSenderRequest = null;
        if (i13 != 0) {
          localCreateFileIntentSenderRequest = (CreateFileIntentSenderRequest)CreateFileIntentSenderRequest.CREATOR.createFromParcel(paramParcel1);
        }
        IntentSender localIntentSender1 = a(localCreateFileIntentSenderRequest);
        paramParcel2.writeNoException();
        if (localIntentSender1 != null)
        {
          paramParcel2.writeInt(1);
          localIntentSender1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i12 = paramParcel1.readInt();
        AuthorizeAccessRequest localAuthorizeAccessRequest = null;
        if (i12 != 0) {
          localAuthorizeAccessRequest = (AuthorizeAccessRequest)AuthorizeAccessRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localAuthorizeAccessRequest, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i11 = paramParcel1.readInt();
        ListParentsRequest localListParentsRequest = null;
        if (i11 != 0) {
          localListParentsRequest = (ListParentsRequest)ListParentsRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localListParentsRequest, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i10 = paramParcel1.readInt();
        AddEventListenerRequest localAddEventListenerRequest = null;
        if (i10 != 0) {
          localAddEventListenerRequest = (AddEventListenerRequest)AddEventListenerRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localAddEventListenerRequest, ag.a.Z(paramParcel1.readStrongBinder()), paramParcel1.readString(), af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i9 = paramParcel1.readInt();
        RemoveEventListenerRequest localRemoveEventListenerRequest = null;
        if (i9 != 0) {
          localRemoveEventListenerRequest = (RemoveEventListenerRequest)RemoveEventListenerRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localRemoveEventListenerRequest, ag.a.Z(paramParcel1.readStrongBinder()), paramParcel1.readString(), af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i8 = paramParcel1.readInt();
        DisconnectRequest localDisconnectRequest = null;
        if (i8 != 0) {
          localDisconnectRequest = (DisconnectRequest)DisconnectRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localDisconnectRequest);
        paramParcel2.writeNoException();
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i7 = paramParcel1.readInt();
        TrashResourceRequest localTrashResourceRequest = null;
        if (i7 != 0) {
          localTrashResourceRequest = (TrashResourceRequest)TrashResourceRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localTrashResourceRequest, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i6 = paramParcel1.readInt();
        CloseContentsAndUpdateMetadataRequest localCloseContentsAndUpdateMetadataRequest = null;
        if (i6 != 0) {
          localCloseContentsAndUpdateMetadataRequest = (CloseContentsAndUpdateMetadataRequest)CloseContentsAndUpdateMetadataRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localCloseContentsAndUpdateMetadataRequest, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i5 = paramParcel1.readInt();
        QueryRequest localQueryRequest1 = null;
        if (i5 != 0) {
          localQueryRequest1 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(paramParcel1);
        }
        b(localQueryRequest1, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        b(af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        c(af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        d(af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 23: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        e(af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i4 = paramParcel1.readInt();
        DeleteResourceRequest localDeleteResourceRequest = null;
        if (i4 != 0) {
          localDeleteResourceRequest = (DeleteResourceRequest)DeleteResourceRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localDeleteResourceRequest, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 27: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i3 = paramParcel1.readInt();
        LoadRealtimeRequest localLoadRealtimeRequest = null;
        if (i3 != 0) {
          localLoadRealtimeRequest = (LoadRealtimeRequest)LoadRealtimeRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localLoadRealtimeRequest, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 28: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i2 = paramParcel1.readInt();
        SetResourceParentsRequest localSetResourceParentsRequest = null;
        if (i2 != 0) {
          localSetResourceParentsRequest = (SetResourceParentsRequest)SetResourceParentsRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localSetResourceParentsRequest, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 29: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int i1 = paramParcel1.readInt();
        GetDriveIdFromUniqueIdentifierRequest localGetDriveIdFromUniqueIdentifierRequest = null;
        if (i1 != 0) {
          localGetDriveIdFromUniqueIdentifierRequest = (GetDriveIdFromUniqueIdentifierRequest)GetDriveIdFromUniqueIdentifierRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localGetDriveIdFromUniqueIdentifierRequest, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 30: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int n = paramParcel1.readInt();
        CheckResourceIdsExistRequest localCheckResourceIdsExistRequest = null;
        if (n != 0) {
          localCheckResourceIdsExistRequest = (CheckResourceIdsExistRequest)CheckResourceIdsExistRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localCheckResourceIdsExistRequest, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 31: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        f(af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 32: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        g(af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 33: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int m = paramParcel1.readInt();
        SetDrivePreferencesRequest localSetDrivePreferencesRequest = null;
        if (m != 0) {
          localSetDrivePreferencesRequest = (SetDrivePreferencesRequest)SetDrivePreferencesRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localSetDrivePreferencesRequest, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 34: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int k = paramParcel1.readInt();
        RealtimeDocumentSyncRequest localRealtimeDocumentSyncRequest = null;
        if (k != 0) {
          localRealtimeDocumentSyncRequest = (RealtimeDocumentSyncRequest)RealtimeDocumentSyncRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localRealtimeDocumentSyncRequest, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 35: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        h(af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 36: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        int j = paramParcel1.readInt();
        SetFileUploadPreferencesRequest localSetFileUploadPreferencesRequest = null;
        if (j != 0) {
          localSetFileUploadPreferencesRequest = (SetFileUploadPreferencesRequest)SetFileUploadPreferencesRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localSetFileUploadPreferencesRequest, af.a.Y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      int i = paramParcel1.readInt();
      CancelPendingActionsRequest localCancelPendingActionsRequest = null;
      if (i != 0) {
        localCancelPendingActionsRequest = (CancelPendingActionsRequest)CancelPendingActionsRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a(localCancelPendingActionsRequest, af.a.Y(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class a
      implements ae
    {
      private IBinder le;
      
      a(IBinder paramIBinder)
      {
        this.le = paramIBinder;
      }
      
      public IntentSender a(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCreateFileIntentSenderRequest != null)
            {
              localParcel1.writeInt(1);
              paramCreateFileIntentSenderRequest.writeToParcel(localParcel1, 0);
              this.le.transact(11, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                localIntentSender = (IntentSender)IntentSender.CREATOR.createFromParcel(localParcel2);
                return localIntentSender;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IntentSender localIntentSender = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public IntentSender a(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramOpenFileIntentSenderRequest != null)
            {
              localParcel1.writeInt(1);
              paramOpenFileIntentSenderRequest.writeToParcel(localParcel1, 0);
              this.le.transact(10, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                localIntentSender = (IntentSender)IntentSender.CREATOR.createFromParcel(localParcel2);
                return localIntentSender;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IntentSender localIntentSender = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(RealtimeDocumentSyncRequest paramRealtimeDocumentSyncRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramRealtimeDocumentSyncRequest != null)
            {
              localParcel1.writeInt(1);
              paramRealtimeDocumentSyncRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(34, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(AddEventListenerRequest paramAddEventListenerRequest, ag paramag, String paramString, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramAddEventListenerRequest != null)
            {
              localParcel1.writeInt(1);
              paramAddEventListenerRequest.writeToParcel(localParcel1, 0);
              if (paramag != null)
              {
                localIBinder1 = paramag.asBinder();
                localParcel1.writeStrongBinder(localIBinder1);
                localParcel1.writeString(paramString);
                IBinder localIBinder2 = null;
                if (paramaf != null) {
                  localIBinder2 = paramaf.asBinder();
                }
                localParcel1.writeStrongBinder(localIBinder2);
                this.le.transact(14, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder1 = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(AuthorizeAccessRequest paramAuthorizeAccessRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramAuthorizeAccessRequest != null)
            {
              localParcel1.writeInt(1);
              paramAuthorizeAccessRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(12, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(CancelPendingActionsRequest paramCancelPendingActionsRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCancelPendingActionsRequest != null)
            {
              localParcel1.writeInt(1);
              paramCancelPendingActionsRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(37, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(CheckResourceIdsExistRequest paramCheckResourceIdsExistRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCheckResourceIdsExistRequest != null)
            {
              localParcel1.writeInt(1);
              paramCheckResourceIdsExistRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(30, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(CloseContentsAndUpdateMetadataRequest paramCloseContentsAndUpdateMetadataRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCloseContentsAndUpdateMetadataRequest != null)
            {
              localParcel1.writeInt(1);
              paramCloseContentsAndUpdateMetadataRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(18, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(CloseContentsRequest paramCloseContentsRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCloseContentsRequest != null)
            {
              localParcel1.writeInt(1);
              paramCloseContentsRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(8, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(CreateContentsRequest paramCreateContentsRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCreateContentsRequest != null)
            {
              localParcel1.writeInt(1);
              paramCreateContentsRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(4, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(CreateFileRequest paramCreateFileRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCreateFileRequest != null)
            {
              localParcel1.writeInt(1);
              paramCreateFileRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(5, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(CreateFolderRequest paramCreateFolderRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCreateFolderRequest != null)
            {
              localParcel1.writeInt(1);
              paramCreateFolderRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(6, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(DeleteResourceRequest paramDeleteResourceRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramDeleteResourceRequest != null)
            {
              localParcel1.writeInt(1);
              paramDeleteResourceRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(24, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public void a(DisconnectRequest paramDisconnectRequest)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 136	com/google/android/gms/drive/internal/DisconnectRequest:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 15	com/google/android/gms/drive/internal/ae$a$a:le	Landroid/os/IBinder;
        //   33: bipush 16
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 47 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 50	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 69	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 69	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_2
        //   58: iconst_0
        //   59: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 69	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 69	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramDisconnectRequest	DisconnectRequest
        //   3	69	2	localParcel1	Parcel
        //   7	61	3	localParcel2	Parcel
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	14	65	finally
        //   18	29	65	finally
        //   29	48	65	finally
        //   57	62	65	finally
      }
      
      public void a(GetDriveIdFromUniqueIdentifierRequest paramGetDriveIdFromUniqueIdentifierRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramGetDriveIdFromUniqueIdentifierRequest != null)
            {
              localParcel1.writeInt(1);
              paramGetDriveIdFromUniqueIdentifierRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(29, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(GetMetadataRequest paramGetMetadataRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramGetMetadataRequest != null)
            {
              localParcel1.writeInt(1);
              paramGetMetadataRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(1, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(ListParentsRequest paramListParentsRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramListParentsRequest != null)
            {
              localParcel1.writeInt(1);
              paramListParentsRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(13, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(LoadRealtimeRequest paramLoadRealtimeRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramLoadRealtimeRequest != null)
            {
              localParcel1.writeInt(1);
              paramLoadRealtimeRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(27, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(OpenContentsRequest paramOpenContentsRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramOpenContentsRequest != null)
            {
              localParcel1.writeInt(1);
              paramOpenContentsRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(7, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(QueryRequest paramQueryRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramQueryRequest != null)
            {
              localParcel1.writeInt(1);
              paramQueryRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(2, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(RemoveEventListenerRequest paramRemoveEventListenerRequest, ag paramag, String paramString, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramRemoveEventListenerRequest != null)
            {
              localParcel1.writeInt(1);
              paramRemoveEventListenerRequest.writeToParcel(localParcel1, 0);
              if (paramag != null)
              {
                localIBinder1 = paramag.asBinder();
                localParcel1.writeStrongBinder(localIBinder1);
                localParcel1.writeString(paramString);
                IBinder localIBinder2 = null;
                if (paramaf != null) {
                  localIBinder2 = paramaf.asBinder();
                }
                localParcel1.writeStrongBinder(localIBinder2);
                this.le.transact(15, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder1 = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(SetDrivePreferencesRequest paramSetDrivePreferencesRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramSetDrivePreferencesRequest != null)
            {
              localParcel1.writeInt(1);
              paramSetDrivePreferencesRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(33, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(SetFileUploadPreferencesRequest paramSetFileUploadPreferencesRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramSetFileUploadPreferencesRequest != null)
            {
              localParcel1.writeInt(1);
              paramSetFileUploadPreferencesRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(36, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(SetResourceParentsRequest paramSetResourceParentsRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramSetResourceParentsRequest != null)
            {
              localParcel1.writeInt(1);
              paramSetResourceParentsRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(28, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(TrashResourceRequest paramTrashResourceRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramTrashResourceRequest != null)
            {
              localParcel1.writeInt(1);
              paramTrashResourceRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(17, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(UpdateMetadataRequest paramUpdateMetadataRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramUpdateMetadataRequest != null)
            {
              localParcel1.writeInt(1);
              paramUpdateMetadataRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(3, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public void a(af paramaf)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 83 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 86	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/drive/internal/ae$a$a:le	Landroid/os/IBinder;
        //   36: bipush 9
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 69	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 69	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 69	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 69	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramaf	af
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      public IBinder asBinder()
      {
        return this.le;
      }
      
      public void b(QueryRequest paramQueryRequest, af paramaf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramQueryRequest != null)
            {
              localParcel1.writeInt(1);
              paramQueryRequest.writeToParcel(localParcel1, 0);
              if (paramaf != null)
              {
                localIBinder = paramaf.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(19, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public void b(af paramaf)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 83 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 86	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/drive/internal/ae$a$a:le	Landroid/os/IBinder;
        //   36: bipush 20
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 69	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 69	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 69	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 69	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramaf	af
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      /* Error */
      public void c(af paramaf)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 83 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 86	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/drive/internal/ae$a$a:le	Landroid/os/IBinder;
        //   36: bipush 21
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 69	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 69	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 69	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 69	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramaf	af
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      /* Error */
      public void d(af paramaf)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 83 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 86	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/drive/internal/ae$a$a:le	Landroid/os/IBinder;
        //   36: bipush 22
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 69	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 69	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 69	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 69	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramaf	af
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      /* Error */
      public void e(af paramaf)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 83 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 86	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/drive/internal/ae$a$a:le	Landroid/os/IBinder;
        //   36: bipush 23
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 69	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 69	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 69	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 69	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramaf	af
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      /* Error */
      public void f(af paramaf)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 83 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 86	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/drive/internal/ae$a$a:le	Landroid/os/IBinder;
        //   36: bipush 31
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 69	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 69	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 69	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 69	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramaf	af
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      /* Error */
      public void g(af paramaf)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 83 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 86	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/drive/internal/ae$a$a:le	Landroid/os/IBinder;
        //   36: bipush 32
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 69	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 69	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 69	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 69	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramaf	af
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      /* Error */
      public void h(af paramaf)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 83 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 86	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/drive/internal/ae$a$a:le	Landroid/os/IBinder;
        //   36: bipush 35
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 69	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 69	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 69	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 69	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramaf	af
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ae
 * JD-Core Version:    0.7.0.1
 */