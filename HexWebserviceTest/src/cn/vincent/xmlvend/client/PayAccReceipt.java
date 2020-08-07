
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 *  Receipt returned as part of Pay Account response.
 * 			
 * 
 * <p>PayAccReceipt complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PayAccReceipt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Receipt">
 *       &lt;sequence>
 *         &lt;element name="meterDetail" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PayAccReceipt", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "meterDetail"
})
public class PayAccReceipt
    extends Receipt
{

    protected MeterDetail meterDetail;

    /**
     * 获取meterDetail属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MeterDetail }
     *     
     */
    public MeterDetail getMeterDetail() {
        return meterDetail;
    }

    /**
     * 设置meterDetail属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MeterDetail }
     *     
     */
    public void setMeterDetail(MeterDetail value) {
        this.meterDetail = value;
    }

}
