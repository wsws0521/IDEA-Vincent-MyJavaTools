
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MeterSpecificEng的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="MeterSpecificEng">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SetPwrLmt"/>
 *     &lt;enumeration value="SetPhUnbalance"/>
 *     &lt;enumeration value="AddDefaultCred"/>
 *     &lt;enumeration value="ClearCred"/>
 *     &lt;enumeration value="ClearTamper"/>
 *     &lt;enumeration value="EngKCT"/>
 *     &lt;enumeration value="SetWaterFact"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MeterSpecificEng")
@XmlEnum
public enum MeterSpecificEng {

    @XmlEnumValue("SetPwrLmt")
    SET_PWR_LMT("SetPwrLmt"),
    @XmlEnumValue("SetPhUnbalance")
    SET_PH_UNBALANCE("SetPhUnbalance"),
    @XmlEnumValue("AddDefaultCred")
    ADD_DEFAULT_CRED("AddDefaultCred"),
    @XmlEnumValue("ClearCred")
    CLEAR_CRED("ClearCred"),
    @XmlEnumValue("ClearTamper")
    CLEAR_TAMPER("ClearTamper"),
    @XmlEnumValue("EngKCT")
    ENG_KCT("EngKCT"),
    @XmlEnumValue("SetWaterFact")
    SET_WATER_FACT("SetWaterFact");
    private final String value;

    MeterSpecificEng(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MeterSpecificEng fromValue(String v) {
        for (MeterSpecificEng c: MeterSpecificEng.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
