
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GetBoxKmcDetailInfoSTS6Response complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取getBoxKmcDetailInfoSTS6Result属性的值。
     * 
     */
    public boolean isGetBoxKmcDetailInfoSTS6Result() {
        return getBoxKmcDetailInfoSTS6Result;
    }

    /**
     * 设置getBoxKmcDetailInfoSTS6Result属性的值。
     * 
     */
    public void setGetBoxKmcDetailInfoSTS6Result(boolean value) {
        this.getBoxKmcDetailInfoSTS6Result = value;
    }

    /**
     * 获取vks属性的值。
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
     * 设置vks属性的值。
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
     * 获取kekSlotStatus属性的值。
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
     * 设置kekSlotStatus属性的值。
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
