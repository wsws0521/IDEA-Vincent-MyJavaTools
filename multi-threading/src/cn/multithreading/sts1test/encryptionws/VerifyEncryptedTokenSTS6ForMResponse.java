
package cn.multithreading.sts1test.encryptionws;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>VerifyEncryptedTokenSTS6ForMResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡverifyEncryptedTokenResult���Ե�ֵ��
     * 
     */
    public boolean isVerifyEncryptedTokenResult() {
        return verifyEncryptedTokenResult;
    }

    /**
     * ����verifyEncryptedTokenResult���Ե�ֵ��
     * 
     */
    public void setVerifyEncryptedTokenResult(boolean value) {
        this.verifyEncryptedTokenResult = value;
    }

    /**
     * ��ȡtransferAmount���Ե�ֵ��
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
     * ����transferAmount���Ե�ֵ��
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
     * ��ȡtokenClass���Ե�ֵ��
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
     * ����tokenClass���Ե�ֵ��
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
     * ��ȡtokenSubClass���Ե�ֵ��
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
     * ����tokenSubClass���Ե�ֵ��
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
     * ��ȡtokenId���Ե�ֵ��
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
     * ����tokenId���Ե�ֵ��
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
