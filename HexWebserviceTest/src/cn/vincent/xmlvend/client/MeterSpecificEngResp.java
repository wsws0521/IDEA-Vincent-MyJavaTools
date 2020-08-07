
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Response to Meter-specific request. Contains token cipher for the requested engineering token.
 * 		
 * 
 * <p>MeterSpecificEngResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="MeterSpecificEngResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseVendResp">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterSpecificEngResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema")
@XmlSeeAlso({
    PhUnbalResp.class,
    SetWaterFactorResp.class,
    DefCreditResp.class,
    PwrLmtResp.class,
    EngKCTResp.class,
    ClearTamperResp.class,
    ClearCreditResp.class
})
public abstract class MeterSpecificEngResp
    extends BaseVendResp
{


}
