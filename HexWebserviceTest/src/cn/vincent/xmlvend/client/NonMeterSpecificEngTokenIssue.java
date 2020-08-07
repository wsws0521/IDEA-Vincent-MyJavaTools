
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>NonMeterSpecificEngTokenIssue complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="NonMeterSpecificEngTokenIssue">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}NonMeterSpecificTokenIssue">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NonMeterSpecificEngTokenIssue", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema")
@XmlSeeAlso({
    DispConsTotTokenIssue.class,
    DispTamperTokenIssue.class,
    TestDisplayTokenIssue.class,
    DispKRNTokenIssue.class,
    DispTITokenIssue.class,
    TestBreakerTokenIssue.class,
    DispPwrLmtTokenIssue.class,
    DispInstPwrTokenIssue.class,
    DispVerTokenIssue.class,
    TestAllTokenIssue.class,
    DispPhUnbalanceTokenIssue.class
})
public abstract class NonMeterSpecificEngTokenIssue
    extends NonMeterSpecificTokenIssue
{


}
