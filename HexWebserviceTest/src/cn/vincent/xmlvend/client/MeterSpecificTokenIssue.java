
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Token information for a specific meter. 
 * 
 * <p>MeterSpecificTokenIssue complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="MeterSpecificTokenIssue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="desc" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Msg"/>
 *         &lt;element name="meterDetail" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterDetail"/>
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
@XmlType(name = "MeterSpecificTokenIssue", propOrder = {
    "desc",
    "meterDetail",
    "token"
})
@XmlSeeAlso({
    MeterSpecificEngTokenIssue.class,
    CreditTokenIssue.class
})
public abstract class MeterSpecificTokenIssue {

    @XmlElement(required = true)
    protected String desc;
    @XmlElement(required = true)
    protected MeterDetail meterDetail;
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
