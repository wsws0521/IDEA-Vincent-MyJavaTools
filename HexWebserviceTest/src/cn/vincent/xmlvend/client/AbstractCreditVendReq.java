
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 *  Abstract request to obtain a credit token. Must be
 * 				specialised.
 * 
 * <p>AbstractCreditVendReq complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="AbstractCreditVendReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseVendReq">
 *       &lt;sequence>
 *         &lt;element name="purchaseValue" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}PurchaseValue"/>
 *         &lt;element name="payType" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}PayType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractCreditVendReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "purchaseValue",
    "payType"
})
@XmlSeeAlso({
    TrialCreditVendReq.class,
    CreditVendReq.class
})
public abstract class AbstractCreditVendReq
    extends BaseVendReq
{

    @XmlElement(required = true)
    protected PurchaseValue purchaseValue;
    protected PayType payType;

    /**
     * 获取purchaseValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PurchaseValue }
     *     
     */
    public PurchaseValue getPurchaseValue() {
        return purchaseValue;
    }

    /**
     * 设置purchaseValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PurchaseValue }
     *     
     */
    public void setPurchaseValue(PurchaseValue value) {
        this.purchaseValue = value;
    }

    /**
     * 获取payType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PayType }
     *     
     */
    public PayType getPayType() {
        return payType;
    }

    /**
     * 设置payType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PayType }
     *     
     */
    public void setPayType(PayType value) {
        this.payType = value;
    }

}
