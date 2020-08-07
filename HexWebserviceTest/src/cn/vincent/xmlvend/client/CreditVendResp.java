
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
 * <p>CreditVendResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡcreditVendReceipt���Ե�ֵ��
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
     * ����creditVendReceipt���Ե�ֵ��
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
