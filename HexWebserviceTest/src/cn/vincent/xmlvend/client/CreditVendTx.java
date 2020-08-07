
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Transaction that has a credit token associated with
 * 				it. 
 * 
 * <p>CreditVendTx complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CreditVendTx">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Tx">
 *       &lt;sequence>
 *         &lt;element name="creditTokenIssue" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}CreditTokenIssue"/>
 *         &lt;element name="kcTokenIssue" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}KCTokenIssue" minOccurs="0"/>
 *         &lt;element name="tariff" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Tariff" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditVendTx", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "creditTokenIssue",
    "kcTokenIssue",
    "tariff"
})
public class CreditVendTx
    extends Tx
{

    @XmlElement(required = true)
    protected CreditTokenIssue creditTokenIssue;
    protected KCTokenIssue kcTokenIssue;
    protected Tariff tariff;

    /**
     * 获取creditTokenIssue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditTokenIssue }
     *     
     */
    public CreditTokenIssue getCreditTokenIssue() {
        return creditTokenIssue;
    }

    /**
     * 设置creditTokenIssue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditTokenIssue }
     *     
     */
    public void setCreditTokenIssue(CreditTokenIssue value) {
        this.creditTokenIssue = value;
    }

    /**
     * 获取kcTokenIssue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link KCTokenIssue }
     *     
     */
    public KCTokenIssue getKcTokenIssue() {
        return kcTokenIssue;
    }

    /**
     * 设置kcTokenIssue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link KCTokenIssue }
     *     
     */
    public void setKcTokenIssue(KCTokenIssue value) {
        this.kcTokenIssue = value;
    }

    /**
     * 获取tariff属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Tariff }
     *     
     */
    public Tariff getTariff() {
        return tariff;
    }

    /**
     * 设置tariff属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Tariff }
     *     
     */
    public void setTariff(Tariff value) {
        this.tariff = value;
    }

}
