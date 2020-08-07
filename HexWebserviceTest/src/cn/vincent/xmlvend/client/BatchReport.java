
package cn.vincent.xmlvend.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * The Sales total
 * 				can be broken down into sales per
 * 				paytype, sales per operator, sales per transaction
 * 				type.
 * 			
 * 
 * <p>BatchReport complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BatchReport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="txTotal" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}TxTotal" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="operatorTotal" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}OperatorTotal" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="payTypeTotal" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}PayTypeTotal" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="resTot" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}ResourceTotal" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchReport", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "txTotal",
    "operatorTotal",
    "payTypeTotal",
    "resTot"
})
public class BatchReport {

    protected List<TxTotal> txTotal;
    protected List<OperatorTotal> operatorTotal;
    protected List<PayTypeTotal> payTypeTotal;
    protected List<ResourceTotal> resTot;

    /**
     * Gets the value of the txTotal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the txTotal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTxTotal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TxTotal }
     * 
     * 
     */
    public List<TxTotal> getTxTotal() {
        if (txTotal == null) {
            txTotal = new ArrayList<TxTotal>();
        }
        return this.txTotal;
    }

    /**
     * Gets the value of the operatorTotal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operatorTotal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperatorTotal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OperatorTotal }
     * 
     * 
     */
    public List<OperatorTotal> getOperatorTotal() {
        if (operatorTotal == null) {
            operatorTotal = new ArrayList<OperatorTotal>();
        }
        return this.operatorTotal;
    }

    /**
     * Gets the value of the payTypeTotal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the payTypeTotal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPayTypeTotal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PayTypeTotal }
     * 
     * 
     */
    public List<PayTypeTotal> getPayTypeTotal() {
        if (payTypeTotal == null) {
            payTypeTotal = new ArrayList<PayTypeTotal>();
        }
        return this.payTypeTotal;
    }

    /**
     * Gets the value of the resTot property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resTot property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResTot().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResourceTotal }
     * 
     * 
     */
    public List<ResourceTotal> getResTot() {
        if (resTot == null) {
            resTot = new ArrayList<ResourceTotal>();
        }
        return this.resTot;
    }

}
