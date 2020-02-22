
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>KmcApplyResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="KmcApplyResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="KmcApplyResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="fhjg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kmcId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cxml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newZt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "KmcApplyResponse", propOrder = {
    "kmcApplyResult",
    "fhjg",
    "kmcId",
    "cxml",
    "newZt",
    "errorCode",
    "errorMsg"
})
public class KmcApplyResponse {

    @XmlElement(name = "KmcApplyResult")
    protected boolean kmcApplyResult;
    protected String fhjg;
    protected String kmcId;
    protected String cxml;
    protected String newZt;
    protected String errorCode;
    protected String errorMsg;

    /**
     * 获取kmcApplyResult属性的值。
     * 
     */
    public boolean isKmcApplyResult() {
        return kmcApplyResult;
    }

    /**
     * 设置kmcApplyResult属性的值。
     * 
     */
    public void setKmcApplyResult(boolean value) {
        this.kmcApplyResult = value;
    }

    /**
     * 获取fhjg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFhjg() {
        return fhjg;
    }

    /**
     * 设置fhjg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFhjg(String value) {
        this.fhjg = value;
    }

    /**
     * 获取kmcId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKmcId() {
        return kmcId;
    }

    /**
     * 设置kmcId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKmcId(String value) {
        this.kmcId = value;
    }

    /**
     * 获取cxml属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCxml() {
        return cxml;
    }

    /**
     * 设置cxml属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCxml(String value) {
        this.cxml = value;
    }

    /**
     * 获取newZt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewZt() {
        return newZt;
    }

    /**
     * 设置newZt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewZt(String value) {
        this.newZt = value;
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
