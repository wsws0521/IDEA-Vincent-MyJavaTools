
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Card complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Card">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}PayType">
 *       &lt;sequence>
 *         &lt;element name="cardAmt" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency"/>
 *         &lt;element name="accHolderName" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}PersonName"/>
 *         &lt;element name="pan" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}AccountNo"/>
 *         &lt;element name="expDate" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BankCardExpiry"/>
 *         &lt;element name="cvNum" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BankCardCVNum"/>
 *         &lt;element name="clearingHouse" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}OrganisationName"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Card", propOrder = {
    "cardAmt",
    "accHolderName",
    "pan",
    "expDate",
    "cvNum",
    "clearingHouse"
})
@XmlSeeAlso({
    DebitCard.class,
    CreditCard.class
})
public abstract class Card
    extends PayType
{

    @XmlElement(required = true)
    protected Currency cardAmt;
    @XmlElement(required = true)
    protected String accHolderName;
    @XmlElement(required = true)
    protected String pan;
    @XmlElement(required = true)
    protected String expDate;
    @XmlElement(required = true)
    protected String cvNum;
    @XmlElement(required = true)
    protected String clearingHouse;

    /**
     * 获取cardAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getCardAmt() {
        return cardAmt;
    }

    /**
     * 设置cardAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setCardAmt(Currency value) {
        this.cardAmt = value;
    }

    /**
     * 获取accHolderName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccHolderName() {
        return accHolderName;
    }

    /**
     * 设置accHolderName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccHolderName(String value) {
        this.accHolderName = value;
    }

    /**
     * 获取pan属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPan() {
        return pan;
    }

    /**
     * 设置pan属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPan(String value) {
        this.pan = value;
    }

    /**
     * 获取expDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpDate() {
        return expDate;
    }

    /**
     * 设置expDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpDate(String value) {
        this.expDate = value;
    }

    /**
     * 获取cvNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCvNum() {
        return cvNum;
    }

    /**
     * 设置cvNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCvNum(String value) {
        this.cvNum = value;
    }

    /**
     * 获取clearingHouse属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClearingHouse() {
        return clearingHouse;
    }

    /**
     * 设置clearingHouse属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClearingHouse(String value) {
        this.clearingHouse = value;
    }

}
