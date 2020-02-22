
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>LoadKeyResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="LoadKeyResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LoadKeyResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadKeyResponse", propOrder = {
    "loadKeyResult"
})
public class LoadKeyResponse {

    @XmlElement(name = "LoadKeyResult")
    protected int loadKeyResult;

    /**
     * 获取loadKeyResult属性的值。
     * 
     */
    public int getLoadKeyResult() {
        return loadKeyResult;
    }

    /**
     * 设置loadKeyResult属性的值。
     * 
     */
    public void setLoadKeyResult(int value) {
        this.loadKeyResult = value;
    }

}
