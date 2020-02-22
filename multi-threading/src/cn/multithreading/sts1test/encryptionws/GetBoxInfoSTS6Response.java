
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GetBoxInfoSTS6Response complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="GetBoxInfoSTS6Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetBoxInfoSTS6Result" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="boxId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="boxType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hardwareId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firmwareId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "GetBoxInfoSTS6Response", propOrder = {
    "getBoxInfoSTS6Result",
    "boxId",
    "boxType",
    "hardwareId",
    "firmwareId",
    "errorCode",
    "errorMsg"
})
public class GetBoxInfoSTS6Response {

    @XmlElement(name = "GetBoxInfoSTS6Result")
    protected boolean getBoxInfoSTS6Result;
    protected String boxId;
    protected String boxType;
    protected String hardwareId;
    protected String firmwareId;
    protected String errorCode;
    protected String errorMsg;

    /**
     * 获取getBoxInfoSTS6Result属性的值。
     * 
     */
    public boolean isGetBoxInfoSTS6Result() {
        return getBoxInfoSTS6Result;
    }

    /**
     * 设置getBoxInfoSTS6Result属性的值。
     * 
     */
    public void setGetBoxInfoSTS6Result(boolean value) {
        this.getBoxInfoSTS6Result = value;
    }

    /**
     * 获取boxId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoxId() {
        return boxId;
    }

    /**
     * 设置boxId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoxId(String value) {
        this.boxId = value;
    }

    /**
     * 获取boxType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoxType() {
        return boxType;
    }

    /**
     * 设置boxType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoxType(String value) {
        this.boxType = value;
    }

    /**
     * 获取hardwareId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHardwareId() {
        return hardwareId;
    }

    /**
     * 设置hardwareId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHardwareId(String value) {
        this.hardwareId = value;
    }

    /**
     * 获取firmwareId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirmwareId() {
        return firmwareId;
    }

    /**
     * 设置firmwareId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirmwareId(String value) {
        this.firmwareId = value;
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
