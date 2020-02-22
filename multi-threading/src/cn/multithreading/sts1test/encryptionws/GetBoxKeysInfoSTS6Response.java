
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GetBoxKeysInfoSTS6Response complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="GetBoxKeysInfoSTS6Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetBoxKeysInfoSTS6Result" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="keyInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "GetBoxKeysInfoSTS6Response", propOrder = {
    "getBoxKeysInfoSTS6Result",
    "keyInfo",
    "errorCode",
    "errorMsg"
})
public class GetBoxKeysInfoSTS6Response {

    @XmlElement(name = "GetBoxKeysInfoSTS6Result")
    protected boolean getBoxKeysInfoSTS6Result;
    protected String keyInfo;
    protected String errorCode;
    protected String errorMsg;

    /**
     * 获取getBoxKeysInfoSTS6Result属性的值。
     * 
     */
    public boolean isGetBoxKeysInfoSTS6Result() {
        return getBoxKeysInfoSTS6Result;
    }

    /**
     * 设置getBoxKeysInfoSTS6Result属性的值。
     * 
     */
    public void setGetBoxKeysInfoSTS6Result(boolean value) {
        this.getBoxKeysInfoSTS6Result = value;
    }

    /**
     * 获取keyInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyInfo() {
        return keyInfo;
    }

    /**
     * 设置keyInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyInfo(String value) {
        this.keyInfo = value;
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
