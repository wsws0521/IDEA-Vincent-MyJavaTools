
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Request to pay an account. 
 * 
 * <p>PayAccReq complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PayAccReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseReq">
 *       &lt;sequence>
 *         &lt;element name="reqAmt" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency"/>
 *         &lt;element name="payType" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}PayType" minOccurs="0"/>
 *         &lt;element name="payAccount" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}PayAccount"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PayAccReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "reqAmt",
    "payType",
    "payAccount"
})
public class PayAccReq
    extends BaseReq
{

    @XmlElement(required = true)
    protected Currency reqAmt;
    protected PayType payType;
    @XmlElement(required = true)
    protected PayAccount payAccount;

    /**
     * 获取reqAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getReqAmt() {
        return reqAmt;
    }

    /**
     * 设置reqAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setReqAmt(Currency value) {
        this.reqAmt = value;
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

    /**
     * 获取payAccount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PayAccount }
     *     
     */
    public PayAccount getPayAccount() {
        return payAccount;
    }

    /**
     * 设置payAccount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PayAccount }
     *     
     */
    public void setPayAccount(PayAccount value) {
        this.payAccount = value;
    }

}
