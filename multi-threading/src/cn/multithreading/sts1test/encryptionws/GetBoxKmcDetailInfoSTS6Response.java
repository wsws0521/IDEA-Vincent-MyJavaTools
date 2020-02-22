
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GetBoxKmcDetailInfoSTS6Response complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="GetBoxKmcDetailInfoSTS6Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetBoxKmcDetailInfoSTS6Result" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="vks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kekSlotStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "GetBoxKmcDetailInfoSTS6Response", propOrder = {
    "getBoxKmcDetailInfoSTS6Result",
    "vks",
    "kekSlotStatus",
    "errorCode",
    "errorMsg"
})
public class GetBoxKmcDetailInfoSTS6Response {

    @XmlElement(name = "GetBoxKmcDetailInfoSTS6Result")
    protected boolean getBoxKmcDetailInfoSTS6Result;
    protected String vks;
    protected String kekSlotStatus;
    protected String errorCode;
    protected String errorMsg;

    /**
     * ��ȡgetBoxKmcDetailInfoSTS6Result���Ե�ֵ��
     * 
     */
    public boolean isGetBoxKmcDetailInfoSTS6Result() {
        return getBoxKmcDetailInfoSTS6Result;
    }

    /**
     * ����getBoxKmcDetailInfoSTS6Result���Ե�ֵ��
     * 
     */
    public void setGetBoxKmcDetailInfoSTS6Result(boolean value) {
        this.getBoxKmcDetailInfoSTS6Result = value;
    }

    /**
     * ��ȡvks���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVks() {
        return vks;
    }

    /**
     * ����vks���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVks(String value) {
        this.vks = value;
    }

    /**
     * ��ȡkekSlotStatus���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKekSlotStatus() {
        return kekSlotStatus;
    }

    /**
     * ����kekSlotStatus���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKekSlotStatus(String value) {
        this.kekSlotStatus = value;
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
