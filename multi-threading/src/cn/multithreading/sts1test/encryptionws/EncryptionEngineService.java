
package cn.multithreading.sts1test.encryptionws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "EncryptionEngineService", targetNamespace = "http://tempuri.org/", wsdlLocation = "http://192.168.80.35:8010/EncrptionService/ws/EncrptionService?wsdl")
public class EncryptionEngineService
    extends Service
{

    private final static URL ENCRYPTIONENGINESERVICE_WSDL_LOCATION;
    private final static WebServiceException ENCRYPTIONENGINESERVICE_EXCEPTION;
    private final static QName ENCRYPTIONENGINESERVICE_QNAME = new QName("http://tempuri.org/", "EncryptionEngineService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.80.35:8010/EncrptionService/ws/EncrptionService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ENCRYPTIONENGINESERVICE_WSDL_LOCATION = url;
        ENCRYPTIONENGINESERVICE_EXCEPTION = e;
    }

    public EncryptionEngineService() {
        super(__getWsdlLocation(), ENCRYPTIONENGINESERVICE_QNAME);
    }

    public EncryptionEngineService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ENCRYPTIONENGINESERVICE_QNAME, features);
    }

    public EncryptionEngineService(URL wsdlLocation) {
        super(wsdlLocation, ENCRYPTIONENGINESERVICE_QNAME);
    }

    public EncryptionEngineService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ENCRYPTIONENGINESERVICE_QNAME, features);
    }

    public EncryptionEngineService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EncryptionEngineService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns EncrptionService
     */
    @WebEndpoint(name = "EncryptionEnginePort")
    public EncrptionService getEncryptionEnginePort() {
        return super.getPort(new QName("http://tempuri.org/", "EncryptionEnginePort"), EncrptionService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EncrptionService
     */
    @WebEndpoint(name = "EncryptionEnginePort")
    public EncrptionService getEncryptionEnginePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "EncryptionEnginePort"), EncrptionService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ENCRYPTIONENGINESERVICE_EXCEPTION!= null) {
            throw ENCRYPTIONENGINESERVICE_EXCEPTION;
        }
        return ENCRYPTIONENGINESERVICE_WSDL_LOCATION;
    }

}
