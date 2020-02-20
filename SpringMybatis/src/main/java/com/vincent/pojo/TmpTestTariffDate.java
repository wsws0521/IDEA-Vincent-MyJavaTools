package com.vincent.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.util.Date;

public class TmpTestTariffDate {

    BigInteger verId;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")// 不加这个，就要2020-02-20T01:00:00Z格式
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    Date activeSince;
    Date activeUntil;
    Date issueDate;

    public BigInteger getVerId() {
        return verId;
    }

    public void setVerId(BigInteger verId) {
        this.verId = verId;
    }

    public Date getActiveSince() {
        return activeSince;
    }

    public void setActiveSince(Date activeSince) {
        this.activeSince = activeSince;
    }

    public Date getActiveUntil() {
        return activeUntil;
    }

    public void setActiveUntil(Date activeUntil) {
        this.activeUntil = activeUntil;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
}
