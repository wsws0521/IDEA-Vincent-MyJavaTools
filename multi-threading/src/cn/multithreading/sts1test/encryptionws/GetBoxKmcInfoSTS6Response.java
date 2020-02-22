
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GetBoxKmcInfoSTS6Response complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡgetBoxKmcInfoSTS6Result���Ե�ֵ��
     * 
     */
    public boolean isGetBoxKmcInfoSTS6Result() {
        return getBoxKmcInfoSTS6Result;
    }

    /**
     * ����getBoxKmcInfoSTS6Result���Ե�ֵ��
     * 
     */
    public void setGetBoxKmcInfoSTS6Result(boolean value) {
        this.getBoxKmcInfoSTS6Result = value;
    }

    /**
     * ��ȡkmcs���Ե�ֵ��
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
     * ����kmcs���Ե�ֵ��
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
