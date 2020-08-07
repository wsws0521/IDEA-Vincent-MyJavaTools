
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 *  Extension of the meter detail, to include further information about the
 * 				meter. 
 * 
 * <p>ExtMeterDetail complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ExtMeterDetail">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterDetail">
 *       &lt;attribute name="useSTT" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="track2Data" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}NRSTrack2Data" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtMeterDetail")
public class ExtMeterDetail
    extends MeterDetail
{

    @XmlAttribute(name = "useSTT")
    protected Boolean useSTT;
    @XmlAttribute(name = "track2Data", required = true)
    protected String track2Data;

    /**
     * 获取useSTT属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseSTT() {
        return useSTT;
    }

    /**
     * 设置useSTT属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseSTT(Boolean value) {
        this.useSTT = value;
    }

    /**
     * 获取track2Data属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrack2Data() {
        return track2Data;
    }

    /**
     * 设置track2Data属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrack2Data(String value) {
        this.track2Data = value;
    }

}
