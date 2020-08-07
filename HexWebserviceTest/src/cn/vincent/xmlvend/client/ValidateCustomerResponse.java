
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ValidateCustomerResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ValidateCustomerResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="validateCustomerResult" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}ValidateCustomerResult"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidateCustomerResponse", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "validateCustomerResult"
})
public class ValidateCustomerResponse {

    @XmlElement(required = true)
    protected ValidateCustomerResult validateCustomerResult;

    /**
     * 获取validateCustomerResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ValidateCustomerResult }
     *     
     */
    public ValidateCustomerResult getValidateCustomerResult() {
        return validateCustomerResult;
    }

    /**
     * 设置validateCustomerResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ValidateCustomerResult }
     *     
     */
    public void setValidateCustomerResult(ValidateCustomerResult value) {
        this.validateCustomerResult = value;
    }

}
