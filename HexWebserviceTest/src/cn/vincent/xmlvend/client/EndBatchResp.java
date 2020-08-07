
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Response to and end batch request. The batch or
 * 				batches are closed and
 * 				the summaries returned.
 * 			
 * 
 * <p>EndBatchResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="EndBatchResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp">
 *       &lt;sequence>
 *         &lt;element name="endBatch" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Batch"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EndBatchResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "endBatch"
})
public class EndBatchResp
    extends BaseResp
{

    @XmlElement(required = true)
    protected Batch endBatch;

    /**
     * 获取endBatch属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Batch }
     *     
     */
    public Batch getEndBatch() {
        return endBatch;
    }

    /**
     * 设置endBatch属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Batch }
     *     
     */
    public void setEndBatch(Batch value) {
        this.endBatch = value;
    }

}
