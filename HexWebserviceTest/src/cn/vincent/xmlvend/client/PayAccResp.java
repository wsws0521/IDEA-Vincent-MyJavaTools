
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Response, to a pay account request. Containing a
 * 				receipt, confirming
 * 				that the account has been paid.
 * 			
 * 
 * <p>PayAccResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PayAccResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseVendResp">
 *       &lt;sequence>
 *         &lt;element name="payAccReceipt" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}PayAccReceipt"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PayAccResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "payAccReceipt"
})
public class PayAccResp
    extends BaseVendResp
{

    @XmlElement(required = true)
    protected PayAccReceipt payAccReceipt;

    /**
     * 获取payAccReceipt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PayAccReceipt }
     *     
     */
    public PayAccReceipt getPayAccReceipt() {
        return payAccReceipt;
    }

    /**
     * 设置payAccReceipt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PayAccReceipt }
     *     
     */
    public void setPayAccReceipt(PayAccReceipt value) {
        this.payAccReceipt = value;
    }

}
