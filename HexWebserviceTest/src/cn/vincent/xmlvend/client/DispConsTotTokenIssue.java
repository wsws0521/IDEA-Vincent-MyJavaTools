
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DispConsTotTokenIssue complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DispConsTotTokenIssue">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}NonMeterSpecificEngTokenIssue">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DispConsTotTokenIssue", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema")
public class DispConsTotTokenIssue
    extends NonMeterSpecificEngTokenIssue
{


}
