
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  The response to cancel request, confirming that the
 * 				transaction has been
 * 				canceled and the original transaction.
 * 			
 * 
 * <p>CancelVendResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CancelVendResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseVendResp">
 *       &lt;sequence>
 *         &lt;element name="origTx" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}CreditVendTx"/>
 *       &lt;/sequence>
 *       &lt;attribute name="cancelRefNo" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}ReceiptNo" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelVendResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "origTx"
})
public class CancelVendResp
    extends BaseVendResp
{

    @XmlElement(required = true)
    protected CreditVendTx origTx;
    @XmlAttribute(name = "cancelRefNo")
    protected String cancelRefNo;

    /**
     * ��ȡorigTx���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CreditVendTx }
     *     
     */
    public CreditVendTx getOrigTx() {
        return origTx;
    }

    /**
     * ����origTx���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CreditVendTx }
     *     
     */
    public void setOrigTx(CreditVendTx value) {
        this.origTx = value;
    }

    /**
     * ��ȡcancelRefNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancelRefNo() {
        return cancelRefNo;
    }

    /**
     * ����cancelRefNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancelRefNo(String value) {
        this.cancelRefNo = value;
    }

}
