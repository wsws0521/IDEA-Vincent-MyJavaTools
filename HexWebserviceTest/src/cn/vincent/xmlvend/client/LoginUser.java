
package cn.vincent.xmlvend.client;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>LoginUser complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="LoginUser">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CDUID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CDUName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CDUBalance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MinVendAmt" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MaxVendAmt" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="LoginTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoginUser", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "id",
    "tid",
    "cduid",
    "cduName",
    "cduBalance",
    "minVendAmt",
    "maxVendAmt",
    "loginTime"
})
public class LoginUser {

    @XmlElement(name = "ID")
    protected int id;
    @XmlElement(name = "TID")
    protected int tid;
    @XmlElement(name = "CDUID")
    protected int cduid;
    @XmlElement(name = "CDUName")
    protected String cduName;
    @XmlElement(name = "CDUBalance", required = true)
    protected BigDecimal cduBalance;
    @XmlElement(name = "MinVendAmt", required = true)
    protected BigDecimal minVendAmt;
    @XmlElement(name = "MaxVendAmt", required = true)
    protected BigDecimal maxVendAmt;
    @XmlElement(name = "LoginTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar loginTime;

    /**
     * ��ȡid���Ե�ֵ��
     * 
     */
    public int getID() {
        return id;
    }

    /**
     * ����id���Ե�ֵ��
     * 
     */
    public void setID(int value) {
        this.id = value;
    }

    /**
     * ��ȡtid���Ե�ֵ��
     * 
     */
    public int getTID() {
        return tid;
    }

    /**
     * ����tid���Ե�ֵ��
     * 
     */
    public void setTID(int value) {
        this.tid = value;
    }

    /**
     * ��ȡcduid���Ե�ֵ��
     * 
     */
    public int getCDUID() {
        return cduid;
    }

    /**
     * ����cduid���Ե�ֵ��
     * 
     */
    public void setCDUID(int value) {
        this.cduid = value;
    }

    /**
     * ��ȡcduName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCDUName() {
        return cduName;
    }

    /**
     * ����cduName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCDUName(String value) {
        this.cduName = value;
    }

    /**
     * ��ȡcduBalance���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCDUBalance() {
        return cduBalance;
    }

    /**
     * ����cduBalance���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCDUBalance(BigDecimal value) {
        this.cduBalance = value;
    }

    /**
     * ��ȡminVendAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinVendAmt() {
        return minVendAmt;
    }

    /**
     * ����minVendAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinVendAmt(BigDecimal value) {
        this.minVendAmt = value;
    }

    /**
     * ��ȡmaxVendAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxVendAmt() {
        return maxVendAmt;
    }

    /**
     * ����maxVendAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxVendAmt(BigDecimal value) {
        this.maxVendAmt = value;
    }

    /**
     * ��ȡloginTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLoginTime() {
        return loginTime;
    }

    /**
     * ����loginTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLoginTime(XMLGregorianCalendar value) {
        this.loginTime = value;
    }

}
