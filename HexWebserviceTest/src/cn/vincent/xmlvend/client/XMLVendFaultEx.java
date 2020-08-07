
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 *  A XMLVend protocol related fault has occurred. 
 * 
 * <p>XMLVendFaultEx complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="XMLVendFaultEx">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Fault">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMLVendFaultEx")
@XmlSeeAlso({
    ConfirmationEx.class,
    LastResponseEx.class,
    UseCaseSupportEx.class,
    ClientIDSSLEx.class,
    XMLVendSchemaEx.class,
    ReversalEx.class
})
public abstract class XMLVendFaultEx
    extends Fault
{


}
