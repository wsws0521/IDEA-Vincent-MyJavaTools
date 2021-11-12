package cn.vincent.husky.constant;

public enum ResultCode {
    SUCCESS("200", "操作成功"),
    RESTART_COMPONENT_FAIL("5000003", "组件重启失败"),
    COMPONENT_IS_NOT_EXIST("5000002", "组件名不存在"),
    STOP_COMPONENT_FAIL("5000001", "组件停止失败");

    private String code;

    private String desc;

    ResultCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
