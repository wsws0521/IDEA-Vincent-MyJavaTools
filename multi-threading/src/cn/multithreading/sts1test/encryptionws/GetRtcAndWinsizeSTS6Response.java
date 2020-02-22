
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GetRtcAndWinsizeSTS6Response complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="GetRtcAndWinsizeSTS6Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetRtcAndWinsizeSTS6Result" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="rtcTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="winSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
@XmlType(name = "GetRtcAndWinsizeSTS6Response", propOrder = {
    "getRtcAndWinsizeSTS6Result",
    "rtcTime",
    "winSize",
    "errorCode",
    "errorMsg"
})
public class GetRtcAndWinsizeSTS6Response {

    @XmlElement(name = "GetRtcAndWinsizeSTS6Result")
    protected boolean getRtcAndWinsizeSTS6Result;
    protected String rtcTime;
    protected Integer winSize;
    protected String errorCode;
    protected String errorMsg;

    /**
     * ��ȡgetRtcAndWinsizeSTS6Result���Ե�ֵ��
     * 
     */
    public boolean isGetRtcAndWinsizeSTS6Result() {
        return getRtcAndWinsizeSTS6Result;
    }

    /**
     * ����getRtcAndWinsizeSTS6Result���Ե�ֵ��
     * 
     */
    public void setGetRtcAndWinsizeSTS6Result(boolean value) {
        this.getRtcAndWinsizeSTS6Result = value;
    }

    /**
     * ��ȡrtcTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRtcTime() {
        return rtcTime;
    }

    /**
     * ����rtcTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRtcTime(String value) {
        this.rtcTime = value;
    }

    /**
     * ��ȡwinSize���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWinSize() {
        return winSize;
    }

    /**
     * ����winSize���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWinSize(Integer value) {
        this.winSize = value;
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
