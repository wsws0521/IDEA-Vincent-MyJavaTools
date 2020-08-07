
package cn.vincent.xmlvend.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 *  Batch specialisation, used when sales batch is
 * 				closed. 
 * 
 * <p>SalesBatch complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SalesBatch">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Batch">
 *       &lt;sequence>
 *         &lt;element name="firstTxSeqNo" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}TxSeqNo" minOccurs="0"/>
 *         &lt;element name="lastTxSeqNo" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}TxSeqNo" minOccurs="0"/>
 *         &lt;element name="shiftBatch" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}ShiftBatch" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="seqNo" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}ShiftSalesBatchSeqNo" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SalesBatch", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "firstTxSeqNo",
    "lastTxSeqNo",
    "shiftBatch"
})
public class SalesBatch
    extends Batch
{

    protected String firstTxSeqNo;
    protected String lastTxSeqNo;
    protected List<ShiftBatch> shiftBatch;
    @XmlAttribute(name = "seqNo", required = true)
    protected String seqNo;

    /**
     * ��ȡfirstTxSeqNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstTxSeqNo() {
        return firstTxSeqNo;
    }

    /**
     * ����firstTxSeqNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstTxSeqNo(String value) {
        this.firstTxSeqNo = value;
    }

    /**
     * ��ȡlastTxSeqNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastTxSeqNo() {
        return lastTxSeqNo;
    }

    /**
     * ����lastTxSeqNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastTxSeqNo(String value) {
        this.lastTxSeqNo = value;
    }

    /**
     * Gets the value of the shiftBatch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shiftBatch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShiftBatch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShiftBatch }
     * 
     * 
     */
    public List<ShiftBatch> getShiftBatch() {
        if (shiftBatch == null) {
            shiftBatch = new ArrayList<ShiftBatch>();
        }
        return this.shiftBatch;
    }

    /**
     * ��ȡseqNo���Ե�ֵ��
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
     * ����seqNo���Ե�ֵ��
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
