
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Response to a changeOutVend Request, contains the
 * 				credit token, and the
 * 				change out details.
 * 			
 * 
 * <p>MeterCreditTransferResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="MeterCreditTransferResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseVendResp">
 *       &lt;sequence>
 *         &lt;element name="creditTransferDetail" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}CreditTransferDetail"/>
 *         &lt;element name="creditTransferTx" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}CreditVendTx"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterCreditTransferResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "creditTransferDetail",
    "creditTransferTx"
})
public class MeterCreditTransferResp
    extends BaseVendResp
{

    @XmlElement(required = true)
    protected CreditTransferDetail creditTransferDetail;
    @XmlElement(required = true)
    protected CreditVendTx creditTransferTx;

    /**
     * 获取creditTransferDetail属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditTransferDetail }
     *     
     */
    public CreditTransferDetail getCreditTransferDetail() {
        return creditTransferDetail;
    }

    /**
     * 设置creditTransferDetail属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditTransferDetail }
     *     
     */
    public void setCreditTransferDetail(CreditTransferDetail value) {
        this.creditTransferDetail = value;
    }

    /**
     * 获取creditTransferTx属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditVendTx }
     *     
     */
    public CreditVendTx getCreditTransferTx() {
        return creditTransferTx;
    }

    /**
     * 设置creditTransferTx属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditVendTx }
     *     
     */
    public void setCreditTransferTx(CreditVendTx value) {
        this.creditTransferTx = value;
    }

}
