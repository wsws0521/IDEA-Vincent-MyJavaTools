
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
 * <p>CustReportFaultReq complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡcustDetail���Ե�ֵ��
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
     * ����custDetail���Ե�ֵ��
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
     * ��ȡcustFaultReport���Ե�ֵ��
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
     * ����custFaultReport���Ե�ֵ��
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
