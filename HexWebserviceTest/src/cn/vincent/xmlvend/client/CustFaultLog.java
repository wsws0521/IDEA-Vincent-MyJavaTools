
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Information about the customer fault logged on the sever.
 * 		
 * 
 * <p>CustFaultLog complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CustFaultLog">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="custDetail" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}CustDetail"/>
 *         &lt;element name="faultReport" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}CustFaultReport"/>
 *       &lt;/sequence>
 *       &lt;attribute name="refNo" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}RefNo" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustFaultLog", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "custDetail",
    "faultReport"
})
public class CustFaultLog {

    @XmlElement(required = true)
    protected CustDetail custDetail;
    @XmlElement(required = true)
    protected CustFaultReport faultReport;
    @XmlAttribute(name = "refNo", required = true)
    protected String refNo;

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
     * ��ȡfaultReport���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CustFaultReport }
     *     
     */
    public CustFaultReport getFaultReport() {
        return faultReport;
    }

    /**
     * ����faultReport���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CustFaultReport }
     *     
     */
    public void setFaultReport(CustFaultReport value) {
        this.faultReport = value;
    }

    /**
     * ��ȡrefNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefNo() {
        return refNo;
    }

    /**
     * ����refNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefNo(String value) {
        this.refNo = value;
    }

}
