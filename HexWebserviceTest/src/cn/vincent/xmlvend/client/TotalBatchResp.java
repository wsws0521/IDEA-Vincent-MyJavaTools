
package cn.vincent.xmlvend.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Response to totalise batch request. The batch
 * 				summaries to date are
 * 				returned. Batch status remains unchanged.
 * 			
 * 
 * <p>TotalBatchResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TotalBatchResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp">
 *       &lt;sequence>
 *         &lt;element name="totalBatch" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Batch" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TotalBatchResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "totalBatch"
})
public class TotalBatchResp
    extends BaseResp
{

    @XmlElement(required = true)
    protected List<Batch> totalBatch;

    /**
     * Gets the value of the totalBatch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the totalBatch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTotalBatch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Batch }
     * 
     * 
     */
    public List<Batch> getTotalBatch() {
        if (totalBatch == null) {
            totalBatch = new ArrayList<Batch>();
        }
        return this.totalBatch;
    }

}
