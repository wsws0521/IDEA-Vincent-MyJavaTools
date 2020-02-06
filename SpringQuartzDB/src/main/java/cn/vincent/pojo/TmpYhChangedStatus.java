package cn.vincent.pojo;

public class TmpYhChangedStatus extends TmpYh{
    String statusold;
    String MT_COMM_ADDR;
    String MT_COMM_ADDRold;

    public String getMT_COMM_ADDR() {
        return MT_COMM_ADDR;
    }

    public void setMT_COMM_ADDR(String MT_COMM_ADDR) {
        this.MT_COMM_ADDR = MT_COMM_ADDR;
    }

    public String getMT_COMM_ADDRold() {
        return MT_COMM_ADDRold;
    }

    public void setMT_COMM_ADDRold(String MT_COMM_ADDRold) {
        this.MT_COMM_ADDRold = MT_COMM_ADDRold;
    }

    public String getStatusold() {
        return statusold;
    }

    public void setStatusold(String statusold) {
        this.statusold = statusold;
    }
}
