
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Response, to a verify token request. Contains details
 * 				of the token being
 * 				verified.
 * 			
 * 
 * <p>VerifyResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="VerifyResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseVendResp">
 *       &lt;sequence>
 *         &lt;element name="creditVendTx" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}CreditVendTx"/>
 *         &lt;element name="tokenInfo" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}TokenInfo"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerifyResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "creditVendTx",
    "tokenInfo"
})
public class VerifyResp
    extends BaseVendResp
{

    @XmlElement(required = true)
    protected CreditVendTx creditVendTx;
    @XmlElement(required = true)
    protected TokenInfo tokenInfo;

    /**
     * 获取creditVendTx属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditVendTx }
     *     
     */
    public CreditVendTx getCreditVendTx() {
        return creditVendTx;
    }

    /**
     * 设置creditVendTx属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditVendTx }
     *     
     */
    public void setCreditVendTx(CreditVendTx value) {
        this.creditVendTx = value;
    }

    /**
     * 获取tokenInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TokenInfo }
     *     
     */
    public TokenInfo getTokenInfo() {
        return tokenInfo;
    }

    /**
     * 设置tokenInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TokenInfo }
     *     
     */
    public void setTokenInfo(TokenInfo value) {
        this.tokenInfo = value;
    }

}
