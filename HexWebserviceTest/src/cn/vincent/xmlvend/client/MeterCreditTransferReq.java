
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Request for a credit token in units, for credit left
 * 				in a changed out
 * 				meter.
 * 			
 * 
 * <p>MeterCreditTransferReq complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="MeterCreditTransferReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseVendReq">
 *       &lt;sequence>
 *         &lt;element name="chgOutUnits" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}PurchaseValueUnits"/>
 *         &lt;element name="creditTransferDetail" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}CreditTransferDetail"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterCreditTransferReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "chgOutUnits",
    "creditTransferDetail"
})
public class MeterCreditTransferReq
    extends BaseVendReq
{

    @XmlElement(required = true)
    protected PurchaseValueUnits chgOutUnits;
    @XmlElement(required = true)
    protected CreditTransferDetail creditTransferDetail;

    /**
     * ��ȡchgOutUnits���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PurchaseValueUnits }
     *     
     */
    public PurchaseValueUnits getChgOutUnits() {
        return chgOutUnits;
    }

    /**
     * ����chgOutUnits���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PurchaseValueUnits }
     *     
     */
    public void setChgOutUnits(PurchaseValueUnits value) {
        this.chgOutUnits = value;
    }

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

}
