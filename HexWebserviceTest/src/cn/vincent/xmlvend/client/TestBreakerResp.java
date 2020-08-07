
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TestBreakerResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="TestBreakerResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}NonMeterSpecificEngResp">
 *       &lt;sequence>
 *         &lt;element name="testBreaker" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}TestBreakerTokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TestBreakerResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "testBreaker"
})
public class TestBreakerResp
    extends NonMeterSpecificEngResp
{

    @XmlElement(required = true)
    protected TestBreakerTokenIssue testBreaker;

    /**
     * ��ȡtestBreaker���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TestBreakerTokenIssue }
     *     
     */
    public TestBreakerTokenIssue getTestBreaker() {
        return testBreaker;
    }

    /**
     * ����testBreaker���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TestBreakerTokenIssue }
     *     
     */
    public void setTestBreaker(TestBreakerTokenIssue value) {
        this.testBreaker = value;
    }

}
