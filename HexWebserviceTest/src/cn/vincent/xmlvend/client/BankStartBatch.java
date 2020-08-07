
package cn.vincent.xmlvend.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BankStartBatch complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BankStartBatch">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}StartBatch">
 *       &lt;sequence>
 *         &lt;element name="salesStartBatch" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}SalesStartBatch" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="seqNo" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}BankBatchSeqNo" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankStartBatch", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "salesStartBatch"
})
public class BankStartBatch
    extends StartBatch
{

    protected List<SalesStartBatch> salesStartBatch;
    @XmlAttribute(name = "seqNo", required = true)
    protected String seqNo;

    /**
     * Gets the value of the salesStartBatch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the salesStartBatch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSalesStartBatch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SalesStartBatch }
     * 
     * 
     */
    public List<SalesStartBatch> getSalesStartBatch() {
        if (salesStartBatch == null) {
            salesStartBatch = new ArrayList<SalesStartBatch>();
        }
        return this.salesStartBatch;
    }

    /**
     * 获取seqNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeqNo() {
        return seqNo;
    }

    /**
     * 设置seqNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeqNo(String value) {
        this.seqNo = value;
    }

}
