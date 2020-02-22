
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BoxAuthorizeResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BoxAuthorizeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BoxAuthorizeResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="sdcssx" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gqrq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "BoxAuthorizeResponse", propOrder = {
    "boxAuthorizeResult",
    "sdcssx",
    "gqrq",
    "errorCode",
    "errorMsg"
})
public class BoxAuthorizeResponse {

    @XmlElement(name = "BoxAuthorizeResult")
    protected boolean boxAuthorizeResult;
    protected String sdcssx;
    protected String gqrq;
    protected String errorCode;
    protected String errorMsg;

    /**
     * 获取boxAuthorizeResult属性的值。
     * 
     */
    public boolean isBoxAuthorizeResult() {
        return boxAuthorizeResult;
    }

    /**
     * 设置boxAuthorizeResult属性的值。
     * 
     */
    public void setBoxAuthorizeResult(boolean value) {
        this.boxAuthorizeResult = value;
    }

    /**
     * 获取sdcssx属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSdcssx() {
        return sdcssx;
    }

    /**
     * 设置sdcssx属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSdcssx(String value) {
        this.sdcssx = value;
    }

    /**
     * 获取gqrq属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGqrq() {
        return gqrq;
    }

    /**
     * 设置gqrq属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGqrq(String value) {
        this.gqrq = value;
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
