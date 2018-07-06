package org.apache.commons.httpclient.protocol;

import java.io.IOException;
import java.net.InetAddress;

class ControllerThreadSocketFactory$1
  extends ControllerThreadSocketFactory.SocketTask
{
  private final String val$host;
  private final InetAddress val$localAddress;
  private final int val$localPort;
  private final int val$port;
  private final ProtocolSocketFactory val$socketfactory;
  
  ControllerThreadSocketFactory$1(ProtocolSocketFactory paramProtocolSocketFactory, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    this.val$socketfactory = paramProtocolSocketFactory;
    this.val$host = paramString;
    this.val$port = paramInt1;
    this.val$localAddress = paramInetAddress;
    this.val$localPort = paramInt2;
  }
  
  public void doit()
    throws IOException
  {
    setSocket(this.val$socketfactory.createSocket(this.val$host, this.val$port, this.val$localAddress, this.val$localPort));
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.protocol.ControllerThreadSocketFactory.1
 * JD-Core Version:    0.7.0.1
 */