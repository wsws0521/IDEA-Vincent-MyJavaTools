
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Response to a changeOutVend Request, contains the
 * 				credit token, and the
 * 				change out details.
 * 			
 * 
 * <p>MeterCreditTransferResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="MeterCreditTransferResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseVendResp">
 *       &lt;sequence>
 *         &lt;element name="creditTransferDetail" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}CreditTransferDetail"/>
 *         &lt;element name="creditTransferTx" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}CreditVendTx"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterCreditTransferResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "creditTransferDetail",
    "creditTransferTx"
})
public class MeterCreditTransferResp
    extends BaseVendResp
{

    @XmlElement(required = true)
    protected CreditTransferDetail creditTransferDetail;
    @XmlElement(required = true)
    protected CreditVendTx creditTransferTx;

    /**
     * ��ȡcreditTransferDetail���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CreditTransferDetail }
     *     
     */
    public CreditTransferDetail getCreditTransferDetail() {
        return creditTransferDetail;
    }

    /**
     * ����creditTransferDetail���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CreditTransferDetail }
     *     
     */
    public void setCreditTransferDetail(CreditTransferDetail value) {
        this.creditTransferDetail = value;
    }

    /**
     * ��ȡcreditTransferTx���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CreditVendTx }
     *     
     */
    public CreditVendTx getCreditTransferTx() {
        return creditTransferTx;
    }

    /**
     * ����creditTransferTx���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CreditVendTx }
     *     
     */
    public void setCreditTransferTx(CreditVendTx value) {
        this.creditTransferTx = value;
    }

}
