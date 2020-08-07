
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Specialised account payment transaction, used to
 * 				collect service charges.
 * 			
 * 
 * <p>ServiceChrgTx complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ServiceChrgTx">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}PayAccTx">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceChrgTx", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema")
public class ServiceChrgTx
    extends PayAccTx
{


}
