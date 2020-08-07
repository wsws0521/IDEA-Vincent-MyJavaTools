
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 *  Request for a credit token, that does not require
 * 				payment and is issued
 * 				for a specific purpose eg. marketing, etc.
 * 			
 * 
 * <p>FreeIssueReq complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="FreeIssueReq">
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
@XmlType(name = "FreeIssueReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema")
public class FreeIssueReq
    extends BaseVendReq
{


}
