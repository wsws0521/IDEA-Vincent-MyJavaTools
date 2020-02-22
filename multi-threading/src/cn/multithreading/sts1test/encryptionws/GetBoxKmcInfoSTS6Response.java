
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GetBoxKmcInfoSTS6Response complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="GetBoxKmcInfoSTS6Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetBoxKmcInfoSTS6Result" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="kmcs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "GetBoxKmcInfoSTS6Response", propOrder = {
    "getBoxKmcInfoSTS6Result",
    "kmcs",
    "errorCode",
    "errorMsg"
})
public class GetBoxKmcInfoSTS6Response {

    @XmlElement(name = "GetBoxKmcInfoSTS6Result")
    protected boolean getBoxKmcInfoSTS6Result;
    protected String kmcs;
    protected String errorCode;
    protected String errorMsg;

    /**
     * 获取getBoxKmcInfoSTS6Result属性的值。
     * 
     */
    public boolean isGetBoxKmcInfoSTS6Result() {
        return getBoxKmcInfoSTS6Result;
    }

    /**
     * 设置getBoxKmcInfoSTS6Result属性的值。
     * 
     */
    public void setGetBoxKmcInfoSTS6Result(boolean value) {
        this.getBoxKmcInfoSTS6Result = value;
    }

    /**
     * 获取kmcs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKmcs() {
        return kmcs;
    }

    /**
     * 设置kmcs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKmcs(String value) {
        this.kmcs = value;
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
