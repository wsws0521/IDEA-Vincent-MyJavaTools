
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 *  The meter configuration information as obtained from a meter card or old
 * 				token or some other source where all the meter configuration data is available.
 * 			
 * 
 * <p>MeterDetail complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="MeterDetail">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterConfig">
 *       &lt;sequence>
 *         &lt;element name="meterType" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="msno" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MSNO" />
 *       &lt;attribute name="sgc" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}STSSupplyGroupCode" />
 *       &lt;attribute name="krn" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}STSKeyRevNo" />
 *       &lt;attribute name="ti" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}STSTariffIndex" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterDetail", propOrder = {
    "meterType"
})
@XmlSeeAlso({
    ExtMeterDetail.class
})
public class MeterDetail
    extends MeterConfig
{

    @XmlElement(required = true)
    protected MeterType meterType;
    @XmlAttribute(name = "msno", required = true)
    protected String msno;
    @XmlAttribute(name = "sgc", required = true)
    protected String sgc;
    @XmlAttribute(name = "krn", required = true)
    protected String krn;
    @XmlAttribute(name = "ti", required = true)
    protected String ti;

    /**
     * 获取meterType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MeterType }
     *     
     */
    public MeterType getMeterType() {
        return meterType;
    }

    /**
     * 设置meterType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MeterType }
     *     
     */
    public void setMeterType(MeterType value) {
        this.meterType = value;
    }

    /**
     * 获取msno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsno() {
        return msno;
    }

    /**
     * 设置msno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsno(String value) {
        this.msno = value;
    }

    /**
     * 获取sgc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSgc() {
        return sgc;
    }

    /**
     * 设置sgc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSgc(String value) {
        this.sgc = value;
    }

    /**
     * 获取krn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKrn() {
        return krn;
    }

    /**
     * 设置krn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKrn(String value) {
        this.krn = value;
    }

    /**
     * 获取ti属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTi() {
        return ti;
    }

    /**
     * 设置ti属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTi(String value) {
        this.ti = value;
    }

}
