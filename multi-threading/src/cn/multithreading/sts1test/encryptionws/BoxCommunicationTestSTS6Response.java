
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BoxCommunicationTestSTS6Response complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="BoxCommunicationTestSTS6Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BoxCommunicationTestSTS6Result" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="testResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="errorMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BoxCommunicationTestSTS6Response", propOrder = {
    "boxCommunicationTestSTS6Result",
    "testResult",
    "errorCode",
    "errorMsg"
})
public class BoxCommunicationTestSTS6Response {

    @XmlElement(name = "BoxCommunicationTestSTS6Result")
    protected boolean boxCommunicationTestSTS6Result;
    protected String testResult;
    protected String errorCode;
    protected String errorMsg;

    /**
     * ��ȡboxCommunicationTestSTS6Result���Ե�ֵ��
     * 
     */
    public boolean isBoxCommunicationTestSTS6Result() {
        return boxCommunicationTestSTS6Result;
    }

    /**
     * ����boxCommunicationTestSTS6Result���Ե�ֵ��
     * 
     */
    public void setBoxCommunicationTestSTS6Result(boolean value) {
        this.boxCommunicationTestSTS6Result = value;
    }

    /**
     * ��ȡtestResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestResult() {
        return testResult;
    }

    /**
     * ����testResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestResult(String value) {
        this.testResult = value;
    }

    /**
     * ��ȡerrorCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * ����errorCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    /**
     * ��ȡerrorMsg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * ����errorMsg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMsg(String value) {
        this.errorMsg = value;
    }

}
