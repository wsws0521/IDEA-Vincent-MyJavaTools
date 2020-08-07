
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 *  A response to a creditVend request, containing the
 * 				prepaid transaction
 * 				and token cipher(possibly other transactions may
 * 				be present such as, debt recovery).
 * 			
 * 
 * <p>CreditVendResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CreditVendResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseVendResp">
 *       &lt;sequence>
 *         &lt;element name="creditVendReceipt" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}CreditVendReceipt"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditVendResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "creditVendReceipt"
})
@XmlSeeAlso({
    FreeIssueResp.class,
    TrialCreditVendResp.class,
    FBEResp.class
})
public class CreditVendResp
    extends BaseVendResp
{

    @XmlElement(required = true)
    protected CreditVendReceipt creditVendReceipt;

    /**
     * 获取creditVendReceipt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditVendReceipt }
     *     
     */
    public CreditVendReceipt getCreditVendReceipt() {
        return creditVendReceipt;
    }

    /**
     * 设置creditVendReceipt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditVendReceipt }
     *     
     */
    public void setCreditVendReceipt(CreditVendReceipt value) {
        this.creditVendReceipt = value;
    }

}
