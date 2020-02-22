
package cn.multithreading.sts1test.encryptionws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ManufactoryKeyTokenSTS6Response complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ManufactoryKeyTokenSTS6Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ManufactoryKeyTokenSTS6Result" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="keyVersionR" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="keyExpiredR" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="EAR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeBaseLineR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
@XmlType(name = "ManufactoryKeyTokenSTS6Response", propOrder = {
    "manufactoryKeyTokenSTS6Result",
    "keyVersionR",
    "keyExpiredR",
    "ear",
    "timeBaseLineR",
    "errorCode",
    "errorMsg"
})
public class ManufactoryKeyTokenSTS6Response {

    @XmlElement(name = "ManufactoryKeyTokenSTS6Result")
    protected List<Object> manufactoryKeyTokenSTS6Result;
    protected Integer keyVersionR;
    protected Integer keyExpiredR;
    @XmlElement(name = "EAR")
    protected String ear;
    protected String timeBaseLineR;
    protected Integer errorCode;
    protected String errorMsg;

    /**
     * Gets the value of the manufactoryKeyTokenSTS6Result property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the manufactoryKeyTokenSTS6Result property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getManufactoryKeyTokenSTS6Result().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getManufactoryKeyTokenSTS6Result() {
        if (manufactoryKeyTokenSTS6Result == null) {
            manufactoryKeyTokenSTS6Result = new ArrayList<Object>();
        }
        return this.manufactoryKeyTokenSTS6Result;
    }

    /**
     * 获取keyVersionR属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getKeyVersionR() {
        return keyVersionR;
    }

    /**
     * 设置keyVersionR属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setKeyVersionR(Integer value) {
        this.keyVersionR = value;
    }

    /**
     * 获取keyExpiredR属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getKeyExpiredR() {
        return keyExpiredR;
    }

    /**
     * 设置keyExpiredR属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setKeyExpiredR(Integer value) {
        this.keyExpiredR = value;
    }

    /**
     * 获取ear属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEAR() {
        return ear;
    }

    /**
     * 设置ear属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEAR(String value) {
        this.ear = value;
    }

    /**
     * 获取timeBaseLineR属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeBaseLineR() {
        return timeBaseLineR;
    }

    /**
     * 设置timeBaseLineR属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeBaseLineR(String value) {
        this.timeBaseLineR = value;
    }

    /**
     * 获取errorCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getErrorCode() {
        return errorCode;
    }

    /**
     * 设置errorCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setErrorCode(Integer value) {
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
