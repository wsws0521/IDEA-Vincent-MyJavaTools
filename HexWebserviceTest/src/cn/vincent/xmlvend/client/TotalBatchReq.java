
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 *  Request to totalise the request batch or batches.
 * 			
 * 
 * <p>TotalBatchReq complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="TotalBatchReq">
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
@XmlType(name = "TotalBatchReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema")
@XmlSeeAlso({
    TotalShiftBatchReq.class,
    TotalSalesBatchReq.class,
    TotalBankBatchReq.class,
    TotalAllBatchesReq.class
})
public abstract class TotalBatchReq
    extends BaseReq
{


}
