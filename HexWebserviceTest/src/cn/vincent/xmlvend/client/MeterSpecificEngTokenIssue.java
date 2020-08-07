
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 *  Generic Meter specific engineering token issue. 
 * 
 * <p>MeterSpecificEngTokenIssue complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="MeterSpecificEngTokenIssue">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterSpecificTokenIssue">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterSpecificEngTokenIssue")
@XmlSeeAlso({
    PhUnbalTokenIssue.class,
    PwrLmtTokenIssue.class,
    WaterFactorTokenIssue.class,
    KCTokenIssue.class,
    ClearCreditTokenIssue.class,
    ClearTamperTokenIssue.class
})
public abstract class MeterSpecificEngTokenIssue
    extends MeterSpecificTokenIssue
{


}
