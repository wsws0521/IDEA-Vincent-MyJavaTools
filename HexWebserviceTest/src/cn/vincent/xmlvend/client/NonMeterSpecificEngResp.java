
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Response to non-Meter specific engineering token request. Contains the token cipher for the request non-Meter specific engineering token.
 * 		
 * 
 * <p>NonMeterSpecificEngResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="NonMeterSpecificEngResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NonMeterSpecificEngResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema")
@XmlSeeAlso({
    DispPhUnbalanceResp.class,
    TestBreakerResp.class,
    DispConsTotResp.class,
    DispInstPwrResp.class,
    DispTamperResp.class,
    DispKRNResp.class,
    DispVerResp.class,
    DispTIResp.class,
    TestDisplayResp.class,
    TestAllResp.class,
    DispPwrLmtResp.class
})
public abstract class NonMeterSpecificEngResp
    extends BaseResp
{


}
