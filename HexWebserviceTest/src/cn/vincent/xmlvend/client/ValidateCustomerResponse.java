
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ValidateCustomerResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡvalidateCustomerResult���Ե�ֵ��
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
     * ����validateCustomerResult���Ե�ֵ��
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
