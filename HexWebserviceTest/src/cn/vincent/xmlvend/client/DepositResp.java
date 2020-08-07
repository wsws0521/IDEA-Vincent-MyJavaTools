
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Response to deposit request. Provides total sales
 * 				since last deposit
 * 				request and details to create a deposit slip.
 * 			
 * 
 * <p>DepositResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DepositResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp">
 *       &lt;sequence>
 *         &lt;element name="depSlip" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}DepositSlip"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DepositResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "depSlip"
})
public class DepositResp
    extends BaseResp
{

    @XmlElement(required = true)
    protected DepositSlip depSlip;

    /**
     * 获取depSlip属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DepositSlip }
     *     
     */
    public DepositSlip getDepSlip() {
        return depSlip;
    }

    /**
     * 设置depSlip属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DepositSlip }
     *     
     */
    public void setDepSlip(DepositSlip value) {
        this.depSlip = value;
    }

}
