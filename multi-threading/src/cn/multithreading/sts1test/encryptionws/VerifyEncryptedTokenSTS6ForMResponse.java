
package cn.multithreading.sts1test.encryptionws;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>VerifyEncryptedTokenSTS6ForMResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="VerifyEncryptedTokenSTS6ForMResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VerifyEncryptedTokenResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="transferAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="tokenClass" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *         &lt;element name="tokenSubClass" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *         &lt;element name="tokenId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
@XmlType(name = "VerifyEncryptedTokenSTS6ForMResponse", propOrder = {
    "verifyEncryptedTokenResult",
    "transferAmount",
    "tokenClass",
    "tokenSubClass",
    "tokenId",
    "errorCode",
    "errorMsg"
})
public class VerifyEncryptedTokenSTS6ForMResponse {

    @XmlElement(name = "VerifyEncryptedTokenResult")
    protected boolean verifyEncryptedTokenResult;
    protected BigDecimal transferAmount;
    protected Byte tokenClass;
    protected Byte tokenSubClass;
    protected Integer tokenId;
    protected Integer errorCode;
    protected String errorMsg;

    /**
     * 获取verifyEncryptedTokenResult属性的值。
     * 
     */
    public boolean isVerifyEncryptedTokenResult() {
        return verifyEncryptedTokenResult;
    }

    /**
     * 设置verifyEncryptedTokenResult属性的值。
     * 
     */
    public void setVerifyEncryptedTokenResult(boolean value) {
        this.verifyEncryptedTokenResult = value;
    }

    /**
     * 获取transferAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    /**
     * 设置transferAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTransferAmount(BigDecimal value) {
        this.transferAmount = value;
    }

    /**
     * 获取tokenClass属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getTokenClass() {
        return tokenClass;
    }

    /**
     * 设置tokenClass属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setTokenClass(Byte value) {
        this.tokenClass = value;
    }

    /**
     * 获取tokenSubClass属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getTokenSubClass() {
        return tokenSubClass;
    }

    /**
     * 设置tokenSubClass属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setTokenSubClass(Byte value) {
        this.tokenSubClass = value;
    }

    /**
     * 获取tokenId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTokenId() {
        return tokenId;
    }

    /**
     * 设置tokenId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTokenId(Integer value) {
        this.tokenId = value;
    }

    /**
     * 获取errorCode属性的值。
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
     * 设置errorCode属性的值。
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
