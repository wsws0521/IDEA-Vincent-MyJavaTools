
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BoxCommunicationTestSTS6Response complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取boxCommunicationTestSTS6Result属性的值。
     * 
     */
    public boolean isBoxCommunicationTestSTS6Result() {
        return boxCommunicationTestSTS6Result;
    }

    /**
     * 设置boxCommunicationTestSTS6Result属性的值。
     * 
     */
    public void setBoxCommunicationTestSTS6Result(boolean value) {
        this.boxCommunicationTestSTS6Result = value;
    }

    /**
     * 获取testResult属性的值。
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
     * 设置testResult属性的值。
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
     * 获取errorCode属性的值。
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
     * 设置errorCode属性的值。
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
     * 获取errorMsg属性的值。
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
     * 设置errorMsg属性的值。
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
