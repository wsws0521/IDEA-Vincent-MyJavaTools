
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 *  Abstract request to reprint an already closed batch
 * 				or batches.
 * 			
 * 
 * <p>ReprintEndBatchReq complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ReprintEndBatchReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseReq">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReprintEndBatchReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema")
@XmlSeeAlso({
    ReprintEndSalesBatchReq.class,
    ReprintEndBankingBatchReq.class,
    ReprintEndShiftBatchReq.class
})
public abstract class ReprintEndBatchReq
    extends BaseReq
{


}
