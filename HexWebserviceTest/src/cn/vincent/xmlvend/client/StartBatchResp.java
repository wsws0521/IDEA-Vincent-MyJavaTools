
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Response to start batch request. Confirms the batch
 * 				or batches were
 * 				started.
 * 			
 * 
 * <p>StartBatchResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="StartBatchResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp">
 *       &lt;sequence>
 *         &lt;element name="startedBatch" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}StartBatch"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StartBatchResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "startedBatch"
})
public class StartBatchResp
    extends BaseResp
{

    @XmlElement(required = true)
    protected StartBatch startedBatch;

    /**
     * 获取startedBatch属性的值。
     * 
     * @return
     *     possible object is
     *     {@link StartBatch }
     *     
     */
    public StartBatch getStartedBatch() {
        return startedBatch;
    }

    /**
     * 设置startedBatch属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link StartBatch }
     *     
     */
    public void setStartedBatch(StartBatch value) {
        this.startedBatch = value;
    }

}
