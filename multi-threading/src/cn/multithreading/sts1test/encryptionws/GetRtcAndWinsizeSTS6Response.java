
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GetRtcAndWinsizeSTS6Response complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取getRtcAndWinsizeSTS6Result属性的值。
     * 
     */
    public boolean isGetRtcAndWinsizeSTS6Result() {
        return getRtcAndWinsizeSTS6Result;
    }

    /**
     * 设置getRtcAndWinsizeSTS6Result属性的值。
     * 
     */
    public void setGetRtcAndWinsizeSTS6Result(boolean value) {
        this.getRtcAndWinsizeSTS6Result = value;
    }

    /**
     * 获取rtcTime属性的值。
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
     * 设置rtcTime属性的值。
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
     * 获取winSize属性的值。
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
     * 设置winSize属性的值。
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
