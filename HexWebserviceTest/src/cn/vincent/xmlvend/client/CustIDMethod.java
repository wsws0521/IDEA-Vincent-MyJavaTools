
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Identifier used to identify the customer. 
 * 
 * <p>CustIDMethod complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CustIDMethod">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}IDMethod">
 *       &lt;sequence>
 *         &lt;element name="custIdentifier" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}CustIdentifier"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustIDMethod", propOrder = {
    "custIdentifier"
})
public class CustIDMethod
    extends IDMethod
{

    @XmlElement(required = true)
    protected CustIdentifier custIdentifier;

    /**
     * 获取custIdentifier属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CustIdentifier }
     *     
     */
    public CustIdentifier getCustIdentifier() {
        return custIdentifier;
    }

    /**
     * 设置custIdentifier属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CustIdentifier }
     *     
     */
    public void setCustIdentifier(CustIdentifier value) {
        this.custIdentifier = value;
    }

}
