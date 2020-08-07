
package cn.vincent.xmlvend.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Contains one or more transactions. 
 * 
 * <p>Transactions complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Transactions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tx" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Tx" maxOccurs="unbounded"/>
 *         &lt;element name="lessRound" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency" minOccurs="0"/>
 *         &lt;element name="tenderAmt" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency" minOccurs="0"/>
 *         &lt;element name="change" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transactions", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "tx",
    "lessRound",
    "tenderAmt",
    "change"
})
public class Transactions {

    @XmlElement(required = true)
    protected List<Tx> tx;
    protected Currency lessRound;
    protected Currency tenderAmt;
    protected Currency change;

    /**
     * Gets the value of the tx property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tx property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTx().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Tx }
     * 
     * 
     */
    public List<Tx> getTx() {
        if (tx == null) {
            tx = new ArrayList<Tx>();
        }
        return this.tx;
    }

    /**
     * ��ȡlessRound���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getLessRound() {
        return lessRound;
    }

    /**
     * ����lessRound���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setLessRound(Currency value) {
        this.lessRound = value;
    }

    /**
     * ��ȡtenderAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getTenderAmt() {
        return tenderAmt;
    }

    /**
     * ����tenderAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setTenderAmt(Currency value) {
        this.tenderAmt = value;
    }

    /**
     * ��ȡchange���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getChange() {
        return change;
    }

    /**
     * ����change���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setChange(Currency value) {
        this.change = value;
    }

}
