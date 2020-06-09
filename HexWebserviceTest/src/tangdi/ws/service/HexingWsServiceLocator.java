/**
 * HexingWsServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package tangdi.ws.service;

public class HexingWsServiceLocator extends org.apache.axis.client.Service implements HexingWsService {

    public HexingWsServiceLocator() {
    }


    public HexingWsServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HexingWsServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HexingWsPort
//    private java.lang.String HexingWsPort_address = "http://115.238.36.165:19091/api/services/hexingws";
//    private java.lang.String HexingWsPort_address = "http://localhost:8000/api/services/hexingws";
  private String HexingWsPort_address = "http://172.16.101.220:9091/api/services/hexingws?wsdl";

    public String getHexingWsPortAddress() {
        return HexingWsPort_address;
    }

    // The WSDD service name defaults to the port name.
    private String HexingWsPortWSDDServiceName = "HexingWsPort";

    public String getHexingWsPortWSDDServiceName() {
        return HexingWsPortWSDDServiceName;
    }

    public void setHexingWsPortWSDDServiceName(String name) {
        HexingWsPortWSDDServiceName = name;
    }

    public HexingWs getHexingWsPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HexingWsPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHexingWsPort(endpoint);
    }

    public HexingWs getHexingWsPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            tangdi.ws.service.HexingWsServiceSoapBindingStub _stub = new tangdi.ws.service.HexingWsServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getHexingWsPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHexingWsPortEndpointAddress(String address) {
        HexingWsPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (HexingWs.class.isAssignableFrom(serviceEndpointInterface)) {
                tangdi.ws.service.HexingWsServiceSoapBindingStub _stub = new tangdi.ws.service.HexingWsServiceSoapBindingStub(new java.net.URL(HexingWsPort_address), this);
                _stub.setPortName(getHexingWsPortWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("HexingWsPort".equals(inputPortName)) {
            return getHexingWsPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.ws.tangdi/", "HexingWsService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.ws.tangdi/", "HexingWsPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("HexingWsPort".equals(portName)) {
            setHexingWsPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
