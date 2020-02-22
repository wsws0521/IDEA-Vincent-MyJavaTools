
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GetVendingTimesResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="GetVendingTimesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetVendingTimesResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="sysdcs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "GetVendingTimesResponse", propOrder = {
    "getVendingTimesResult",
    "sysdcs",
    "errorCode",
    "errorMsg"
})
public class GetVendingTimesResponse {

    @XmlElement(name = "GetVendingTimesResult")
    protected boolean getVendingTimesResult;
    protected String sysdcs;
    protected String errorCode;
    protected String errorMsg;

    /**
     * 获取getVendingTimesResult属性的值。
     * 
     */
    public boolean isGetVendingTimesResult() {
        return getVendingTimesResult;
    }

    /**
     * 设置getVendingTimesResult属性的值。
     * 
     */
    public void setGetVendingTimesResult(boolean value) {
        this.getVendingTimesResult = value;
    }

    /**
     * 获取sysdcs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysdcs() {
        return sysdcs;
    }

    /**
     * 设置sysdcs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysdcs(String value) {
        this.sysdcs = value;
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
