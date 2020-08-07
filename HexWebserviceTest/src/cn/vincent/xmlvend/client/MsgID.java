
package cn.vincent.xmlvend.client;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 *  Sequential identifier that allows each client request message to be
 * 				uniquely identified. 
 * 
 * <p>MsgID complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="MsgID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="dateTime" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MsgIDDateTime" />
 *       &lt;attribute name="uniqueNumber" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MsgIDUniqueNumber" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MsgID")
public class MsgID {

    @XmlAttribute(name = "dateTime", required = true)
    protected String dateTime;
    @XmlAttribute(name = "uniqueNumber", required = true)
    protected BigInteger uniqueNumber;

    /**
     * 获取dateTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * 设置dateTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateTime(String value) {
        this.dateTime = value;
    }

    /**
     * 获取uniqueNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUniqueNumber() {
        return uniqueNumber;
    }

    /**
     * 设置uniqueNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUniqueNumber(BigInteger value) {
        this.uniqueNumber = value;
    }

}
