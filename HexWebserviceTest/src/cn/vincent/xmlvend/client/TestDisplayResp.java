
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TestDisplayResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TestDisplayResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}NonMeterSpecificEngResp">
 *       &lt;sequence>
 *         &lt;element name="testDisp" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}TestDisplayTokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TestDisplayResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "testDisp"
})
public class TestDisplayResp
    extends NonMeterSpecificEngResp
{

    @XmlElement(required = true)
    protected TestDisplayTokenIssue testDisp;

    /**
     * 获取testDisp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TestDisplayTokenIssue }
     *     
     */
    public TestDisplayTokenIssue getTestDisp() {
        return testDisp;
    }

    /**
     * 设置testDisp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TestDisplayTokenIssue }
     *     
     */
    public void setTestDisp(TestDisplayTokenIssue value) {
        this.testDisp = value;
    }

}
