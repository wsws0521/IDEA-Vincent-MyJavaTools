
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 *  Response to free issue request. Same as the credit
 * 				vend response.
 * 				Contains the credit token cipher and transaction
 * 				details.
 * 			
 * 
 * <p>FreeIssueResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="FreeIssueResp">
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
@XmlType(name = "FreeIssueResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema")
public class FreeIssueResp
    extends CreditVendResp
{


}
