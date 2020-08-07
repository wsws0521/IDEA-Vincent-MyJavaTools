
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 *  Request to end a batch or batches on the server.
 * 			
 * 
 * <p>EndBatchReq complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="EndBatchReq">
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
@XmlType(name = "EndBatchReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema")
@XmlSeeAlso({
    EndSalesBatchReq.class,
    EndShiftBatchReq.class,
    EndAllBatchesReq.class,
    EndBankBatchReq.class
})
public abstract class EndBatchReq
    extends BaseReq
{


}
