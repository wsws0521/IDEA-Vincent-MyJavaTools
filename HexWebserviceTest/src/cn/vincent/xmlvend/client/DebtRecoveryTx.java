
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Specialised account payment, used to collect debt
 * 				recovery payments.
 * 
 * <p>DebtRecoveryTx complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DebtRecoveryTx">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}PayAccTx">
 *       &lt;sequence>
 *         &lt;element name="balance" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DebtRecoveryTx", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "balance"
})
public class DebtRecoveryTx
    extends PayAccTx
{

    protected Currency balance;

    /**
     * 获取balance属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getBalance() {
        return balance;
    }

    /**
     * 设置balance属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setBalance(Currency value) {
        this.balance = value;
    }

}
