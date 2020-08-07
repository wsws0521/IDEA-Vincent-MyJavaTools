
package cn.vincent.xmlvend.client;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CustVendDetail complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CustVendDetail">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}CustDetail">
 *       &lt;attribute name="daysLastPurchase" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustVendDetail")
public class CustVendDetail
    extends CustDetail
{

    @XmlAttribute(name = "daysLastPurchase")
    protected BigInteger daysLastPurchase;

    /**
     * 获取daysLastPurchase属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDaysLastPurchase() {
        return daysLastPurchase;
    }

    /**
     * 设置daysLastPurchase属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDaysLastPurchase(BigInteger value) {
        this.daysLastPurchase = value;
    }

}
