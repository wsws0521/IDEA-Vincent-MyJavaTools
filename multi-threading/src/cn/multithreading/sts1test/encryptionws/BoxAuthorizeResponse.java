
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BoxAuthorizeResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="BoxAuthorizeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BoxAuthorizeResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="sdcssx" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gqrq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="errorMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BoxAuthorizeResponse", propOrder = {
    "boxAuthorizeResult",
    "sdcssx",
    "gqrq",
    "errorCode",
    "errorMsg"
})
public class BoxAuthorizeResponse {

    @XmlElement(name = "BoxAuthorizeResult")
    protected boolean boxAuthorizeResult;
    protected String sdcssx;
    protected String gqrq;
    protected String errorCode;
    protected String errorMsg;

    /**
     * ��ȡboxAuthorizeResult���Ե�ֵ��
     * 
     */
    public boolean isBoxAuthorizeResult() {
        return boxAuthorizeResult;
    }

    /**
     * ����boxAuthorizeResult���Ե�ֵ��
     * 
     */
    public void setBoxAuthorizeResult(boolean value) {
        this.boxAuthorizeResult = value;
    }

    /**
     * ��ȡsdcssx���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSdcssx() {
        return sdcssx;
    }

    /**
     * ����sdcssx���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSdcssx(String value) {
        this.sdcssx = value;
    }

    /**
     * ��ȡgqrq���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGqrq() {
        return gqrq;
    }

    /**
     * ����gqrq���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGqrq(String value) {
        this.gqrq = value;
    }

    /**
     * ��ȡerrorCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * ����errorCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    /**
     * ��ȡerrorMsg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * ����errorMsg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMsg(String value) {
        this.errorMsg = value;
    }

}
