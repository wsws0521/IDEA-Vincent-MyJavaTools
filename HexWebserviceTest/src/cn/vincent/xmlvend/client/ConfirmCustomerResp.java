
package cn.vincent.xmlvend.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  A response containing customer details.
 * 			
 * 
 * <p>ConfirmCustomerResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ConfirmCustomerResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp">
 *       &lt;sequence>
 *         &lt;element name="confirmCustResult" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}ConfirmCustResult" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfirmCustomerResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "confirmCustResult"
})
public class ConfirmCustomerResp
    extends BaseResp
{

    @XmlElement(required = true)
    protected List<ConfirmCustResult> confirmCustResult;

    /**
     * Gets the value of the confirmCustResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the confirmCustResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConfirmCustResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConfirmCustResult }
     * 
     * 
     */
    public List<ConfirmCustResult> getConfirmCustResult() {
        if (confirmCustResult == null) {
            confirmCustResult = new ArrayList<ConfirmCustResult>();
        }
        return this.confirmCustResult;
    }

}
