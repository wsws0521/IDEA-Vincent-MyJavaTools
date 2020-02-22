
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>KmcLoadKR complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="KmcLoadKR">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="krContext" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kmcId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KmcLoadKR", propOrder = {
    "krContext",
    "kmcId"
})
public class KmcLoadKR {

    protected String krContext;
    protected String kmcId;

    /**
     * 获取krContext属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKrContext() {
        return krContext;
    }

    /**
     * 设置krContext属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKrContext(String value) {
        this.krContext = value;
    }

    /**
     * 获取kmcId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKmcId() {
        return kmcId;
    }

    /**
     * 设置kmcId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKmcId(String value) {
        this.kmcId = value;
    }

}
