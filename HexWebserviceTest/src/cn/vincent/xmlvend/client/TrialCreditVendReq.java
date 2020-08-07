
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 *  Trial Credit Vend requests a credit token (normal
 * 				sale) from the server, without the server actually generating a
 * 				valid token.
 * 
 * <p>TrialCreditVendReq complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TrialCreditVendReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}AbstractCreditVendReq">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrialCreditVendReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema")
public class TrialCreditVendReq
    extends AbstractCreditVendReq
{


}
