
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Request to pay an account. 
 * 
 * <p>PayAccReq complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡreqAmt���Ե�ֵ��
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
     * ����reqAmt���Ե�ֵ��
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
     * ��ȡpayType���Ե�ֵ��
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
     * ����payType���Ե�ֵ��
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
     * ��ȡpayAccount���Ե�ֵ��
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
     * ����payAccount���Ե�ֵ��
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
