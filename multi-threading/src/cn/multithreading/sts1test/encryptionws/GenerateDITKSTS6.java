
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>generateDITKSTS6 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="generateDITKSTS6">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NumComps" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "generateDITKSTS6", propOrder = {
    "ea",
    "numComps"
})
public class GenerateDITKSTS6 {

    @XmlElement(name = "EA")
    protected String ea;
    @XmlElement(name = "NumComps")
    protected int numComps;

    /**
     * 获取ea属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEA() {
        return ea;
    }

    /**
     * 设置ea属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEA(String value) {
        this.ea = value;
    }

    /**
     * 获取numComps属性的值。
     * 
     */
    public int getNumComps() {
        return numComps;
    }

    /**
     * 设置numComps属性的值。
     * 
     */
    public void setNumComps(int value) {
        this.numComps = value;
    }

}
