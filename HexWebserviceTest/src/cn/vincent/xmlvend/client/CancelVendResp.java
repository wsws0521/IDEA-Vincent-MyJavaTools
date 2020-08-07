
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
 * <p>CancelVendResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取origTx属性的值。
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
     * 设置origTx属性的值。
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
     * 获取cancelRefNo属性的值。
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
     * 设置cancelRefNo属性的值。
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
