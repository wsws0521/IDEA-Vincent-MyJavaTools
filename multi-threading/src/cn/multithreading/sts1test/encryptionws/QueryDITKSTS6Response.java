
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>queryDITKSTS6Response complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="queryDITKSTS6Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="queryDITKSTS6Result" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="keyCheckValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "queryDITKSTS6Response", propOrder = {
    "queryDITKSTS6Result",
    "keyCheckValue",
    "errorCode",
    "errorMsg"
})
public class QueryDITKSTS6Response {

    protected boolean queryDITKSTS6Result;
    protected String keyCheckValue;
    protected String errorCode;
    protected String errorMsg;

    /**
     * 获取queryDITKSTS6Result属性的值。
     * 
     */
    public boolean isQueryDITKSTS6Result() {
        return queryDITKSTS6Result;
    }

    /**
     * 设置queryDITKSTS6Result属性的值。
     * 
     */
    public void setQueryDITKSTS6Result(boolean value) {
        this.queryDITKSTS6Result = value;
    }

    /**
     * 获取keyCheckValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyCheckValue() {
        return keyCheckValue;
    }

    /**
     * 设置keyCheckValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyCheckValue(String value) {
        this.keyCheckValue = value;
    }

    /**
     * 获取errorCode属性的值。
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
     * 设置errorCode属性的值。
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
     * 获取errorMsg属性的值。
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
     * 设置errorMsg属性的值。
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
