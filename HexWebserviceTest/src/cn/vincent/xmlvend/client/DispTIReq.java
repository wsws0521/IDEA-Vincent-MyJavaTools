
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Request for non-Meter specific engineering token to display current tariff index of the meter.
 * 		
 * 
 * <p>DispTIReq complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DispTIReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}NonMeterSpecificEngReq">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DispTIReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema")
public class DispTIReq
    extends NonMeterSpecificEngReq
{


}
