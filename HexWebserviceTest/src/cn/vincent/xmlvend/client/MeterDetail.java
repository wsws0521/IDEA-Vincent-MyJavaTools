
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
 * <p>MeterDetail complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡmeterType���Ե�ֵ��
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
     * ����meterType���Ե�ֵ��
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
     * ��ȡmsno���Ե�ֵ��
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
     * ����msno���Ե�ֵ��
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
     * ��ȡsgc���Ե�ֵ��
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
     * ����sgc���Ե�ֵ��
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
     * ��ȡkrn���Ե�ֵ��
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
     * ����krn���Ե�ֵ��
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
     * ��ȡti���Ե�ֵ��
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
     * ����ti���Ե�ֵ��
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
