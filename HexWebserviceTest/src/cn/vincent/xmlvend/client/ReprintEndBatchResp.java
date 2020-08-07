
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
 * <p>ReprintEndBatchResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡendBatchReprint���Ե�ֵ��
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
     * ����endBatchReprint���Ե�ֵ��
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
