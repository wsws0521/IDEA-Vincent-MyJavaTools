
package cn.vincent.xmlvend.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  The response to a reprint request, containing one or
 * 				more previous
 * 				transactions for a specific meter.
 * 			
 * 
 * <p>ReprintResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ReprintResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp">
 *       &lt;sequence>
 *         &lt;element name="reprint" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseVendResp" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReprintResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "reprint"
})
public class ReprintResp
    extends BaseResp
{

    @XmlElement(required = true)
    protected List<BaseVendResp> reprint;

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
     * {@link BaseVendResp }
     * 
     * 
     */
    public List<BaseVendResp> getReprint() {
        if (reprint == null) {
            reprint = new ArrayList<BaseVendResp>();
        }
        return this.reprint;
    }

}
