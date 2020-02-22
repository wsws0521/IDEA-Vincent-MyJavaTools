
package cn.multithreading.sts1test.encryptionws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ManufactoryKeyTokenSTS6Response complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡkeyVersionR���Ե�ֵ��
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
     * ����keyVersionR���Ե�ֵ��
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
     * ��ȡkeyExpiredR���Ե�ֵ��
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
     * ����keyExpiredR���Ե�ֵ��
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
     * ��ȡear���Ե�ֵ��
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
     * ����ear���Ե�ֵ��
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
     * ��ȡtimeBaseLineR���Ե�ֵ��
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
     * ����timeBaseLineR���Ե�ֵ��
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
     * ��ȡerrorCode���Ե�ֵ��
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
     * ����errorCode���Ե�ֵ��
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
