
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Batch complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Batch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="started" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ended" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="batchTot" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency"/>
 *         &lt;element name="totTax" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Tax" minOccurs="0"/>
 *         &lt;element name="batchReport" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}BatchReport" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Batch", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "started",
    "ended",
    "batchTot",
    "totTax",
    "batchReport"
})
@XmlSeeAlso({
    SalesBatch.class,
    BankBatch.class,
    ShiftBatch.class
})
public abstract class Batch {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar started;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ended;
    @XmlElement(required = true)
    protected Currency batchTot;
    protected Tax totTax;
    protected BatchReport batchReport;

    /**
     * ��ȡstarted���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStarted() {
        return started;
    }

    /**
     * ����started���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStarted(XMLGregorianCalendar value) {
        this.started = value;
    }

    /**
     * ��ȡended���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnded() {
        return ended;
    }

    /**
     * ����ended���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnded(XMLGregorianCalendar value) {
        this.ended = value;
    }

    /**
     * ��ȡbatchTot���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getBatchTot() {
        return batchTot;
    }

    /**
     * ����batchTot���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setBatchTot(Currency value) {
        this.batchTot = value;
    }

    /**
     * ��ȡtotTax���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Tax }
     *     
     */
    public Tax getTotTax() {
        return totTax;
    }

    /**
     * ����totTax���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Tax }
     *     
     */
    public void setTotTax(Tax value) {
        this.totTax = value;
    }

    /**
     * ��ȡbatchReport���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BatchReport }
     *     
     */
    public BatchReport getBatchReport() {
        return batchReport;
    }

    /**
     * ����batchReport���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BatchReport }
     *     
     */
    public void setBatchReport(BatchReport value) {
        this.batchReport = value;
    }

}
