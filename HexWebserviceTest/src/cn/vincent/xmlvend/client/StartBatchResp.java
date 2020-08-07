
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
 * <p>StartBatchResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡstartedBatch���Ե�ֵ��
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
     * ����startedBatch���Ե�ֵ��
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
