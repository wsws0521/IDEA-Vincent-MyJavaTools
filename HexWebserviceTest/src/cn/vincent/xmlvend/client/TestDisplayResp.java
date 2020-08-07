
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TestDisplayResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡtestDisp���Ե�ֵ��
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
     * ����testDisp���Ե�ֵ��
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
