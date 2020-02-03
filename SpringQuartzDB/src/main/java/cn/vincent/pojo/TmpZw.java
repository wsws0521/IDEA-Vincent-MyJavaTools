package cn.vincent.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class TmpZw {
    String DEBTID;
    String CUSTOMER_ID;
    String DEBTNM;
    String Debt_total;
    String Balance;
    String DTYPE;
    String MINPAY;
    String PMONEYPCT;
    String AMOUNTPCT;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    Date CREATE_DATE;
    String LASTDATE;
    String DebtType;
    String PAYCTS;
    String AGREE_ID;
    String DebtStatus;

    public String getDEBTID() {
        return DEBTID;
    }

    public void setDEBTID(String DEBTID) {
        this.DEBTID = DEBTID;
    }

    public String getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public void setCUSTOMER_ID(String CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public String getDEBTNM() {
        return DEBTNM;
    }

    public void setDEBTNM(String DEBTNM) {
        this.DEBTNM = DEBTNM;
    }

    public String getDebt_total() {
        return Debt_total;
    }

    public void setDebt_total(String debt_total) {
        Debt_total = debt_total;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String balance) {
        Balance = balance;
    }

    public String getDTYPE() {
        return DTYPE;
    }

    public void setDTYPE(String DTYPE) {
        this.DTYPE = DTYPE;
    }

    public String getMINPAY() {
        return MINPAY;
    }

    public void setMINPAY(String MINPAY) {
        this.MINPAY = MINPAY;
    }

    public String getPMONEYPCT() {
        return PMONEYPCT;
    }

    public void setPMONEYPCT(String PMONEYPCT) {
        this.PMONEYPCT = PMONEYPCT;
    }

    public String getAMOUNTPCT() {
        return AMOUNTPCT;
    }

    public void setAMOUNTPCT(String AMOUNTPCT) {
        this.AMOUNTPCT = AMOUNTPCT;
    }

    public Date getCREATE_DATE() {
        return CREATE_DATE;
    }

    public void setCREATE_DATE(Date CREATE_DATE) {
        this.CREATE_DATE = CREATE_DATE;
    }

    public String getLASTDATE() {
        return LASTDATE;
    }

    public void setLASTDATE(String LASTDATE) {
        this.LASTDATE = LASTDATE;
    }

    public String getDebtType() {
        return DebtType;
    }

    public void setDebtType(String debtType) {
        DebtType = debtType;
    }

    public String getPAYCTS() {
        return PAYCTS;
    }

    public void setPAYCTS(String PAYCTS) {
        this.PAYCTS = PAYCTS;
    }

    public String getAGREE_ID() {
        return AGREE_ID;
    }

    public void setAGREE_ID(String AGREE_ID) {
        this.AGREE_ID = AGREE_ID;
    }

    public String getDebtStatus() {
        return DebtStatus;
    }

    public void setDebtStatus(String debtStatus) {
        DebtStatus = debtStatus;
    }
}
