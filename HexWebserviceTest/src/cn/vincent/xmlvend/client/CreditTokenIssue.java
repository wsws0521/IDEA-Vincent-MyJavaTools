
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 *  Information that is returned with all credit tokens that are vended by
 * 				the server. 
 * 
 * <p>CreditTokenIssue complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CreditTokenIssue">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterSpecificTokenIssue">
 *       &lt;sequence>
 *         &lt;element name="units" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Units"/>
 *         &lt;element name="resource" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Resource"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditTokenIssue", propOrder = {
    "units",
    "resource"
})
@XmlSeeAlso({
    FBECredTokenIssue.class,
    SaleCredTokenIssue.class,
    MCTCredTokenIssue.class,
    FreeCredTokenIssue.class
})
public class CreditTokenIssue
    extends MeterSpecificTokenIssue
{

    @XmlElement(required = true)
    protected Units units;
    @XmlElement(required = true)
    protected Resource resource;

    /**
     * 获取units属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Units }
     *     
     */
    public Units getUnits() {
        return units;
    }

    /**
     * 设置units属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Units }
     *     
     */
    public void setUnits(Units value) {
        this.units = value;
    }

    /**
     * 获取resource属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Resource }
     *     
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * 设置resource属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Resource }
     *     
     */
    public void setResource(Resource value) {
        this.resource = value;
    }

}
