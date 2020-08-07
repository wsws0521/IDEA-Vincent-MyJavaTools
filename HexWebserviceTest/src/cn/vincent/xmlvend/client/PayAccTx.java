
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 *  A pay account transaction 
 * 
 * <p>PayAccTx complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PayAccTx">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Tx">
 *       &lt;sequence>
 *         &lt;element name="accDesc" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Msg"/>
 *         &lt;element name="accNo" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}AccountNo" minOccurs="0"/>
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
@XmlType(name = "PayAccTx", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "accDesc",
    "accNo",
    "tariff"
})
@XmlSeeAlso({
    DebtRecoveryTx.class,
    ServiceChrgTx.class
})
public class PayAccTx
    extends Tx
{

    @XmlElement(required = true)
    protected String accDesc;
    protected String accNo;
    protected Tariff tariff;

    /**
     * ��ȡaccDesc���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccDesc() {
        return accDesc;
    }

    /**
     * ����accDesc���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccDesc(String value) {
        this.accDesc = value;
    }

    /**
     * ��ȡaccNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccNo() {
        return accNo;
    }

    /**
     * ����accNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccNo(String value) {
        this.accNo = value;
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
