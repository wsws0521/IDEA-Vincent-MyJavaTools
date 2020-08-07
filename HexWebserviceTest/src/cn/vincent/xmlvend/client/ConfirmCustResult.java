
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ConfirmCustResult complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ConfirmCustResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="custVendDetail" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}CustVendDetail"/>
 *         &lt;element name="custVendConfig" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}CustVendConfig"/>
 *         &lt;element name="meterDetail" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfirmCustResult", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "custVendDetail",
    "custVendConfig",
    "meterDetail"
})
public class ConfirmCustResult {

    @XmlElement(required = true)
    protected CustVendDetail custVendDetail;
    @XmlElement(required = true)
    protected CustVendConfig custVendConfig;
    protected MeterDetail meterDetail;

    /**
     * 获取custVendDetail属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CustVendDetail }
     *     
     */
    public CustVendDetail getCustVendDetail() {
        return custVendDetail;
    }

    /**
     * 设置custVendDetail属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CustVendDetail }
     *     
     */
    public void setCustVendDetail(CustVendDetail value) {
        this.custVendDetail = value;
    }

    /**
     * 获取custVendConfig属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CustVendConfig }
     *     
     */
    public CustVendConfig getCustVendConfig() {
        return custVendConfig;
    }

    /**
     * 设置custVendConfig属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CustVendConfig }
     *     
     */
    public void setCustVendConfig(CustVendConfig value) {
        this.custVendConfig = value;
    }

    /**
     * 获取meterDetail属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MeterDetail }
     *     
     */
    public MeterDetail getMeterDetail() {
        return meterDetail;
    }

    /**
     * 设置meterDetail属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MeterDetail }
     *     
     */
    public void setMeterDetail(MeterDetail value) {
        this.meterDetail = value;
    }

}
