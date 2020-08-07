
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Response to trial vend request, same as a credit vend
 * 				response, except
 * 				that token returned has no monetary value and is set
 * 				to "0000 0000 0000 0000".
 * 			
 * 
 * <p>TrialCreditVendResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="TrialCreditVendResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}CreditVendResp">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrialCreditVendResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema")
public class TrialCreditVendResp
    extends CreditVendResp
{


}
