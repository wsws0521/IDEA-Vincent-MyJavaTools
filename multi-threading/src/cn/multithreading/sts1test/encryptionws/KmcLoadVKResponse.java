
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>KmcLoadVKResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="KmcLoadVKResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="KmcLoadVKResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="fhjg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cxml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oldZt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "KmcLoadVKResponse", propOrder = {
    "kmcLoadVKResult",
    "fhjg",
    "cxml",
    "oldZt",
    "newZt",
    "errorCode",
    "errorMsg"
})
public class KmcLoadVKResponse {

    @XmlElement(name = "KmcLoadVKResult")
    protected boolean kmcLoadVKResult;
    protected String fhjg;
    protected String cxml;
    protected String oldZt;
    protected String newZt;
    protected String errorCode;
    protected String errorMsg;

    /**
     * ��ȡkmcLoadVKResult���Ե�ֵ��
     * 
     */
    public boolean isKmcLoadVKResult() {
        return kmcLoadVKResult;
    }

    /**
     * ����kmcLoadVKResult���Ե�ֵ��
     * 
     */
    public void setKmcLoadVKResult(boolean value) {
        this.kmcLoadVKResult = value;
    }

    /**
     * ��ȡfhjg���Ե�ֵ��
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
     * ����fhjg���Ե�ֵ��
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
     * ��ȡcxml���Ե�ֵ��
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
     * ����cxml���Ե�ֵ��
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
     * ��ȡoldZt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldZt() {
        return oldZt;
    }

    /**
     * ����oldZt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldZt(String value) {
        this.oldZt = value;
    }

    /**
     * ��ȡnewZt���Ե�ֵ��
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
     * ����newZt���Ե�ֵ��
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
