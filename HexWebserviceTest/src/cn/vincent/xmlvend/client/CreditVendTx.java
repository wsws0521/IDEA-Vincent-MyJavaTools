
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Transaction that has a credit token associated with
 * 				it. 
 * 
 * <p>CreditVendTx complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡcreditTokenIssue���Ե�ֵ��
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
     * ����creditTokenIssue���Ե�ֵ��
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
     * ��ȡkcTokenIssue���Ե�ֵ��
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
     * ����kcTokenIssue���Ե�ֵ��
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
     * ��ȡtariff���Ե�ֵ��
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
     * ����tariff���Ե�ֵ��
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
