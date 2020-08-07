
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 *  Advice specialisation, used to by the client to confirm that a previous
 * 				used case has been completed successfully. 
 * 
 * <p>ConfirmationAdviceReq complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ConfirmationAdviceReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}AdviceReq">
 *       &lt;sequence>
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
@XmlType(name = "ConfirmationAdviceReq", propOrder = {
    "payType"
})
public class ConfirmationAdviceReq
    extends AdviceReq
{

    protected PayType payType;

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

}
