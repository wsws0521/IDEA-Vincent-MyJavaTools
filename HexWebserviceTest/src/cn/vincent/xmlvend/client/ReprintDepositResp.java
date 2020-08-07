
package cn.vincent.xmlvend.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Response to reprint deposit slip request. Contains
 * 				the last X created
 * 				deposit slips.
 * 			
 * 
 * <p>ReprintDepositResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ReprintDepositResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp">
 *       &lt;sequence>
 *         &lt;element name="reprint" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}DepositResp" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReprintDepositResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "reprint"
})
public class ReprintDepositResp
    extends BaseResp
{

    @XmlElement(required = true)
    protected List<DepositResp> reprint;

    /**
     * Gets the value of the reprint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reprint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReprint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DepositResp }
     * 
     * 
     */
    public List<DepositResp> getReprint() {
        if (reprint == null) {
            reprint = new ArrayList<DepositResp>();
        }
        return this.reprint;
    }

}
