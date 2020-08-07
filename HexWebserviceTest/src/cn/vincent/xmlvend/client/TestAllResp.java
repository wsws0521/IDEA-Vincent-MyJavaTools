
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TestAllResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TestAllResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}NonMeterSpecificEngResp">
 *       &lt;sequence>
 *         &lt;element name="testAll" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}TestAllTokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TestAllResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "testAll"
})
public class TestAllResp
    extends NonMeterSpecificEngResp
{

    @XmlElement(required = true)
    protected TestAllTokenIssue testAll;

    /**
     * 获取testAll属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TestAllTokenIssue }
     *     
     */
    public TestAllTokenIssue getTestAll() {
        return testAll;
    }

    /**
     * 设置testAll属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TestAllTokenIssue }
     *     
     */
    public void setTestAll(TestAllTokenIssue value) {
        this.testAll = value;
    }

}
