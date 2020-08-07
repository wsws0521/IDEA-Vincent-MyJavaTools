
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Response to batch reprint request. Contains the
 * 				requested batch.
 * 			
 * 
 * <p>ReprintEndBatchResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ReprintEndBatchResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp">
 *       &lt;sequence>
 *         &lt;element name="endBatchReprint" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}EndBatchResp"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReprintEndBatchResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "endBatchReprint"
})
public class ReprintEndBatchResp
    extends BaseResp
{

    @XmlElement(required = true)
    protected EndBatchResp endBatchReprint;

    /**
     * 获取endBatchReprint属性的值。
     * 
     * @return
     *     possible object is
     *     {@link EndBatchResp }
     *     
     */
    public EndBatchResp getEndBatchReprint() {
        return endBatchReprint;
    }

    /**
     * 设置endBatchReprint属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EndBatchResp }
     *     
     */
    public void setEndBatchReprint(EndBatchResp value) {
        this.endBatchReprint = value;
    }

}
