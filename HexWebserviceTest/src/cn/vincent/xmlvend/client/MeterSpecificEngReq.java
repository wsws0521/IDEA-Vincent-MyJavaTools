
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Request for a meter specific STS engineering token. Contains parameters for the specific engineering token.
 * 		
 * 
 * <p>MeterSpecificEngReq complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="MeterSpecificEngReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseVendReq">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterSpecificEngReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema")
@XmlSeeAlso({
    SetWaterFactorReq.class,
    ClearTamperReq.class,
    ClearCreditReq.class,
    DefCreditReq.class,
    PhUnbalReq.class,
    EngKCTReq.class,
    PwrLmtReq.class
})
public abstract class MeterSpecificEngReq
    extends BaseVendReq
{


}
