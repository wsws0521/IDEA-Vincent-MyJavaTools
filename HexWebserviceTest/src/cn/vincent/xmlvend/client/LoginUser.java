
package cn.vincent.xmlvend.client;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>LoginUser complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="LoginUser">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CDUID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CDUName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CDUBalance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MinVendAmt" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MaxVendAmt" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="LoginTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoginUser", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "id",
    "tid",
    "cduid",
    "cduName",
    "cduBalance",
    "minVendAmt",
    "maxVendAmt",
    "loginTime"
})
public class LoginUser {

    @XmlElement(name = "ID")
    protected int id;
    @XmlElement(name = "TID")
    protected int tid;
    @XmlElement(name = "CDUID")
    protected int cduid;
    @XmlElement(name = "CDUName")
    protected String cduName;
    @XmlElement(name = "CDUBalance", required = true)
    protected BigDecimal cduBalance;
    @XmlElement(name = "MinVendAmt", required = true)
    protected BigDecimal minVendAmt;
    @XmlElement(name = "MaxVendAmt", required = true)
    protected BigDecimal maxVendAmt;
    @XmlElement(name = "LoginTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar loginTime;

    /**
     * 获取id属性的值。
     * 
     */
    public int getID() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     */
    public void setID(int value) {
        this.id = value;
    }

    /**
     * 获取tid属性的值。
     * 
     */
    public int getTID() {
        return tid;
    }

    /**
     * 设置tid属性的值。
     * 
     */
    public void setTID(int value) {
        this.tid = value;
    }

    /**
     * 获取cduid属性的值。
     * 
     */
    public int getCDUID() {
        return cduid;
    }

    /**
     * 设置cduid属性的值。
     * 
     */
    public void setCDUID(int value) {
        this.cduid = value;
    }

    /**
     * 获取cduName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCDUName() {
        return cduName;
    }

    /**
     * 设置cduName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCDUName(String value) {
        this.cduName = value;
    }

    /**
     * 获取cduBalance属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCDUBalance() {
        return cduBalance;
    }

    /**
     * 设置cduBalance属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCDUBalance(BigDecimal value) {
        this.cduBalance = value;
    }

    /**
     * 获取minVendAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinVendAmt() {
        return minVendAmt;
    }

    /**
     * 设置minVendAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinVendAmt(BigDecimal value) {
        this.minVendAmt = value;
    }

    /**
     * 获取maxVendAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxVendAmt() {
        return maxVendAmt;
    }

    /**
     * 设置maxVendAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxVendAmt(BigDecimal value) {
        this.maxVendAmt = value;
    }

    /**
     * 获取loginTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLoginTime() {
        return loginTime;
    }

    /**
     * 设置loginTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLoginTime(XMLGregorianCalendar value) {
        this.loginTime = value;
    }

}
