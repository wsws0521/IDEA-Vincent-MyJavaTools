
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 *  The response to a FBE request, containing the FBE
 * 				token cipher.
 * 			
 * 
 * <p>FBEResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="FBEResp">
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
@XmlType(name = "FBEResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema")
public class FBEResp
    extends CreditVendResp
{


}
