
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GetBoxKmcDetailInfoSTS6 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="GetBoxKmcDetailInfoSTS6">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kekSlotId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetBoxKmcDetailInfoSTS6", propOrder = {
    "kekSlotId"
})
public class GetBoxKmcDetailInfoSTS6 {

    protected String kekSlotId;

    /**
     * 获取kekSlotId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKekSlotId() {
        return kekSlotId;
    }

    /**
     * 设置kekSlotId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKekSlotId(String value) {
        this.kekSlotId = value;
    }

}
