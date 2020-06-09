package tangdi.ws.service;

public class HexingWsProxy implements HexingWs {
  private String _endpoint = null;
  private HexingWs hexingWs = null;
  
  public HexingWsProxy() {
    _initHexingWsProxy();
  }
  
  public HexingWsProxy(String endpoint) {
    _endpoint = endpoint;
    _initHexingWsProxy();
  }
  
  private void _initHexingWsProxy() {
    try {
      hexingWs = (new tangdi.ws.service.HexingWsServiceLocator()).getHexingWsPort();
      if (hexingWs != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)hexingWs)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)hexingWs)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (hexingWs != null)
      ((javax.xml.rpc.Stub)hexingWs)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public HexingWs getHexingWs() {
    if (hexingWs == null)
      _initHexingWsProxy();
    return hexingWs;
  }
  
  public String trans(String arg0, String arg1) throws java.rmi.RemoteException{
    if (hexingWs == null)
      _initHexingWsProxy();
    return hexingWs.trans(arg0, arg1);
  }
  
  
}