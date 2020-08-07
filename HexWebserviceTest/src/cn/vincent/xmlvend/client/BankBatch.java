
package cn.vincent.xmlvend.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 *  Batch specialisation, used when the bank batch is
 * 				closed.
 * 			
 * 
 * <p>BankBatch complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BankBatch">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Batch">
 *       &lt;sequence>
 *         &lt;element name="firstSalesSeqNo" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}ShiftSalesBatchSeqNo" minOccurs="0"/>
 *         &lt;element name="lastSalesSeqNo" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}ShiftSalesBatchSeqNo" minOccurs="0"/>
 *         &lt;element name="depSlip" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}DepositSlip" minOccurs="0"/>
 *         &lt;element name="salesBatch" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}SalesBatch" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "BankBatch", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "firstSalesSeqNo",
    "lastSalesSeqNo",
    "depSlip",
    "salesBatch"
})
public class BankBatch
    extends Batch
{

    protected String firstSalesSeqNo;
    protected String lastSalesSeqNo;
    protected DepositSlip depSlip;
    protected List<SalesBatch> salesBatch;
    @XmlAttribute(name = "seqNo", required = true)
    protected String seqNo;

    /**
     * 获取firstSalesSeqNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstSalesSeqNo() {
        return firstSalesSeqNo;
    }

    /**
     * 设置firstSalesSeqNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstSalesSeqNo(String value) {
        this.firstSalesSeqNo = value;
    }

    /**
     * 获取lastSalesSeqNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastSalesSeqNo() {
        return lastSalesSeqNo;
    }

    /**
     * 设置lastSalesSeqNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastSalesSeqNo(String value) {
        this.lastSalesSeqNo = value;
    }

    /**
     * 获取depSlip属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DepositSlip }
     *     
     */
    public DepositSlip getDepSlip() {
        return depSlip;
    }

    /**
     * 设置depSlip属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DepositSlip }
     *     
     */
    public void setDepSlip(DepositSlip value) {
        this.depSlip = value;
    }

    /**
     * Gets the value of the salesBatch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the salesBatch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSalesBatch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SalesBatch }
     * 
     * 
     */
    public List<SalesBatch> getSalesBatch() {
        if (salesBatch == null) {
            salesBatch = new ArrayList<SalesBatch>();
        }
        return this.salesBatch;
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
