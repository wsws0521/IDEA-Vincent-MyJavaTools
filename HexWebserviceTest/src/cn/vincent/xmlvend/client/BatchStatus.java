
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 *  Reports the status (open / closed) of the all the batches.
 * 			
 * 
 * <p>BatchStatus complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BatchStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="banking" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BatchStatusType" />
 *       &lt;attribute name="sales" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BatchStatusType" />
 *       &lt;attribute name="shift" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BatchStatusType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchStatus")
public class BatchStatus {

    @XmlAttribute(name = "banking", required = true)
    protected BatchStatusType banking;
    @XmlAttribute(name = "sales", required = true)
    protected BatchStatusType sales;
    @XmlAttribute(name = "shift", required = true)
    protected BatchStatusType shift;

    /**
     * 获取banking属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BatchStatusType }
     *     
     */
    public BatchStatusType getBanking() {
        return banking;
    }

    /**
     * 设置banking属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BatchStatusType }
     *     
     */
    public void setBanking(BatchStatusType value) {
        this.banking = value;
    }

    /**
     * 获取sales属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BatchStatusType }
     *     
     */
    public BatchStatusType getSales() {
        return sales;
    }

    /**
     * 设置sales属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BatchStatusType }
     *     
     */
    public void setSales(BatchStatusType value) {
        this.sales = value;
    }

    /**
     * 获取shift属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BatchStatusType }
     *     
     */
    public BatchStatusType getShift() {
        return shift;
    }

    /**
     * 设置shift属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BatchStatusType }
     *     
     */
    public void setShift(BatchStatusType value) {
        this.shift = value;
    }

}
