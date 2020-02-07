package cn.vincent.pojo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;

public class VdCcumuValue {
    Integer LESSEE_ID;
    BigInteger CUMU_ID;
    BigInteger RULE_ID;
    // 01用户02计量点03电表
    String CUMU_OBJ;
    // 累计所属对象的标识，与CUMU_OBJ合用
    String CUMU_OBJ_ID;
    // 对计费参数的累计对象
    String CUMU_ITEM;
    // 都是0点0分0秒开始，包含
    Date START_TIME;
    // 都是0点0分0秒开始，包含
    Date END_TIME;
    // 累计值
    BigDecimal CUMU_VALUE;
    // KEH
    String VALUE_UNIT;

    public Integer getLESSEE_ID() {
        return LESSEE_ID;
    }

    public void setLESSEE_ID(Integer LESSEE_ID) {
        this.LESSEE_ID = LESSEE_ID;
    }

    public BigInteger getCUMU_ID() {
        return CUMU_ID;
    }

    public void setCUMU_ID(BigInteger CUMU_ID) {
        this.CUMU_ID = CUMU_ID;
    }

    public BigInteger getRULE_ID() {
        return RULE_ID;
    }

    public void setRULE_ID(BigInteger RULE_ID) {
        this.RULE_ID = RULE_ID;
    }

    public String getCUMU_OBJ() {
        return CUMU_OBJ;
    }

    public void setCUMU_OBJ(String CUMU_OBJ) {
        this.CUMU_OBJ = CUMU_OBJ;
    }

    public String getCUMU_OBJ_ID() {
        return CUMU_OBJ_ID;
    }

    public void setCUMU_OBJ_ID(String CUMU_OBJ_ID) {
        this.CUMU_OBJ_ID = CUMU_OBJ_ID;
    }

    public String getCUMU_ITEM() {
        return CUMU_ITEM;
    }

    public void setCUMU_ITEM(String CUMU_ITEM) {
        this.CUMU_ITEM = CUMU_ITEM;
    }

    public Date getSTART_TIME() {
        return START_TIME;
    }

    public void setSTART_TIME(Date START_TIME) {
        this.START_TIME = START_TIME;
    }

    public Date getEND_TIME() {
        return END_TIME;
    }

    public void setEND_TIME(Date END_TIME) {
        this.END_TIME = END_TIME;
    }

    public BigDecimal getCUMU_VALUE() {
        return CUMU_VALUE;
    }

    public void setCUMU_VALUE(BigDecimal CUMU_VALUE) {
        this.CUMU_VALUE = CUMU_VALUE;
    }

    public String getVALUE_UNIT() {
        return VALUE_UNIT;
    }

    public void setVALUE_UNIT(String VALUE_UNIT) {
        this.VALUE_UNIT = VALUE_UNIT;
    }
}
