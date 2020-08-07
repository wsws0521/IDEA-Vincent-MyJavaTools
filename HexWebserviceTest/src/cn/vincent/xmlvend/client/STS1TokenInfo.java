
package cn.vincent.xmlvend.client;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Token information for STS1 tokens. 
 * 
 * <p>STS1TokenInfo complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="STS1TokenInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}TokenInfo">
 *       &lt;sequence>
 *         &lt;element name="tokenID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="transferAmt" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="tokenClass" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}TokenSubClassType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "STS1TokenInfo", propOrder = {
    "tokenID",
    "transferAmt",
    "tokenClass"
})
public class STS1TokenInfo
    extends TokenInfo
{

    @XmlElement(required = true)
    protected BigDecimal tokenID;
    @XmlElement(required = true)
    protected BigDecimal transferAmt;
    @XmlElement(required = true)
    protected TokenSubClassType tokenClass;

    /**
     * ��ȡtokenID���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTokenID() {
        return tokenID;
    }

    /**
     * ����tokenID���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTokenID(BigDecimal value) {
        this.tokenID = value;
    }

    /**
     * ��ȡtransferAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTransferAmt() {
        return transferAmt;
    }

    /**
     * ����transferAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTransferAmt(BigDecimal value) {
        this.transferAmt = value;
    }

    /**
     * ��ȡtokenClass���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TokenSubClassType }
     *     
     */
    public TokenSubClassType getTokenClass() {
        return tokenClass;
    }

    /**
     * ����tokenClass���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TokenSubClassType }
     *     
     */
    public void setTokenClass(TokenSubClassType value) {
        this.tokenClass = value;
    }

}
