
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Customer request to log a fault with the utility.
 * 		
 * 
 * <p>CustReportFaultReq complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CustReportFaultReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseReq">
 *       &lt;sequence>
 *         &lt;element name="custDetail" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}CustDetail"/>
 *         &lt;element name="custFaultReport" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}CustFaultReport"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustReportFaultReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "custDetail",
    "custFaultReport"
})
public class CustReportFaultReq
    extends BaseReq
{

    @XmlElement(required = true)
    protected CustDetail custDetail;
    @XmlElement(required = true)
    protected CustFaultReport custFaultReport;

    /**
     * 获取custDetail属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CustDetail }
     *     
     */
    public CustDetail getCustDetail() {
        return custDetail;
    }

    /**
     * 设置custDetail属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CustDetail }
     *     
     */
    public void setCustDetail(CustDetail value) {
        this.custDetail = value;
    }

    /**
     * 获取custFaultReport属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CustFaultReport }
     *     
     */
    public CustFaultReport getCustFaultReport() {
        return custFaultReport;
    }

    /**
     * 设置custFaultReport属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CustFaultReport }
     *     
     */
    public void setCustFaultReport(CustFaultReport value) {
        this.custFaultReport = value;
    }

}
