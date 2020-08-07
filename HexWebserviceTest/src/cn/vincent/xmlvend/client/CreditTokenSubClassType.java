
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CreditTokenSubClassType�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="CreditTokenSubClassType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Electricity Token"/>
 *     &lt;enumeration value="Water Token"/>
 *     &lt;enumeration value="Gas Token"/>
 *     &lt;enumeration value="Connection time Token"/>
 *     &lt;enumeration value="Currency Token"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CreditTokenSubClassType")
@XmlEnum
public enum CreditTokenSubClassType {

    @XmlEnumValue("Electricity Token")
    ELECTRICITY_TOKEN("Electricity Token"),
    @XmlEnumValue("Water Token")
    WATER_TOKEN("Water Token"),
    @XmlEnumValue("Gas Token")
    GAS_TOKEN("Gas Token"),
    @XmlEnumValue("Connection time Token")
    CONNECTION_TIME_TOKEN("Connection time Token"),
    @XmlEnumValue("Currency Token")
    CURRENCY_TOKEN("Currency Token");
    private final String value;

    CreditTokenSubClassType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CreditTokenSubClassType fromValue(String v) {
        for (CreditTokenSubClassType c: CreditTokenSubClassType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
