
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 *  Request to create a deposit slip for the vendor to
 * 				bank his sales.
 * 			
 * 
 * <p>DepositReq complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DepositReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseReq">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DepositReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema")
public class DepositReq
    extends BaseReq
{


}
