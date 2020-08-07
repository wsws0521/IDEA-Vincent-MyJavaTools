
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 *  Vending information for a customer. 
 * 
 * <p>CustVendConfig complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CustVendConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="canVend" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="fbeDue" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="maxVendAmt" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency" minOccurs="0"/>
 *         &lt;element name="minVendAmt" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustVendConfig", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "canVend",
    "fbeDue",
    "maxVendAmt",
    "minVendAmt"
})
public class CustVendConfig {

    protected boolean canVend;
    protected Boolean fbeDue;
    protected Currency maxVendAmt;
    protected Currency minVendAmt;

    /**
     * 获取canVend属性的值。
     * 
     */
    public boolean isCanVend() {
        return canVend;
    }

    /**
     * 设置canVend属性的值。
     * 
     */
    public void setCanVend(boolean value) {
        this.canVend = value;
    }

    /**
     * 获取fbeDue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFbeDue() {
        return fbeDue;
    }

    /**
     * 设置fbeDue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFbeDue(Boolean value) {
        this.fbeDue = value;
    }

    /**
     * 获取maxVendAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getMaxVendAmt() {
        return maxVendAmt;
    }

    /**
     * 设置maxVendAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setMaxVendAmt(Currency value) {
        this.maxVendAmt = value;
    }

    /**
     * 获取minVendAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getMinVendAmt() {
        return minVendAmt;
    }

    /**
     * 设置minVendAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setMinVendAmt(Currency value) {
        this.minVendAmt = value;
    }

}
