
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Generic information that is returned with all non-Meter specific tokens that are issued.
 * 		
 * 
 * <p>NonMeterSpecificTokenIssue complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="NonMeterSpecificTokenIssue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="desc" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Msg"/>
 *         &lt;element name="meterType" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterType"/>
 *         &lt;element name="token" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Token"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NonMeterSpecificTokenIssue", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "desc",
    "meterType",
    "token"
})
@XmlSeeAlso({
    NonMeterSpecificEngTokenIssue.class
})
public abstract class NonMeterSpecificTokenIssue {

    @XmlElement(required = true)
    protected String desc;
    @XmlElement(required = true)
    protected MeterType meterType;
    @XmlElement(required = true)
    protected Token token;

    /**
     * 获取desc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置desc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesc(String value) {
        this.desc = value;
    }

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
     * 获取token属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Token }
     *     
     */
    public Token getToken() {
        return token;
    }

    /**
     * 设置token属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Token }
     *     
     */
    public void setToken(Token value) {
        this.token = value;
    }

}
