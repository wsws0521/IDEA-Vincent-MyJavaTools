
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>counterIncrementResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="counterIncrementResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CounterIncrement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "counterIncrementResponse", propOrder = {
    "counterIncrement"
})
public class CounterIncrementResponse {

    @XmlElement(name = "CounterIncrement")
    protected String counterIncrement;

    /**
     * 获取counterIncrement属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCounterIncrement() {
        return counterIncrement;
    }

    /**
     * 设置counterIncrement属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCounterIncrement(String value) {
        this.counterIncrement = value;
    }

}
