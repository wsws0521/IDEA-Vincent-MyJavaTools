
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Response to a Customer Fault Report request. Contains customer and fault details, and a reference number.
 * 		
 * 
 * <p>CustReportFaultResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CustReportFaultResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp">
 *       &lt;sequence>
 *         &lt;element name="custFaultLog" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}CustFaultLog"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustReportFaultResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "custFaultLog"
})
public class CustReportFaultResp
    extends BaseResp
{

    @XmlElement(required = true)
    protected CustFaultLog custFaultLog;

    /**
     * 获取custFaultLog属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CustFaultLog }
     *     
     */
    public CustFaultLog getCustFaultLog() {
        return custFaultLog;
    }

    /**
     * 设置custFaultLog属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CustFaultLog }
     *     
     */
    public void setCustFaultLog(CustFaultLog value) {
        this.custFaultLog = value;
    }

}
