package tool.vincent.exception;


import com.sun.deploy.util.StringUtils;

import java.text.MessageFormat;

public class MyException extends RuntimeException {
    private String msgFormat;
    private Object[] msgParams;

    // 无参数时，直接显示模板
    public MyException(String msgFormat) {
        super(msgFormat);
        this.msgFormat = msgFormat;
    }

    public MyException(String msgFormat, Object... msgParams) {
        this.msgFormat = msgFormat;
        this.msgParams = msgParams;
    }

    @Override
    public String getMessage() {
        if(msgFormat != null){
            if(msgParams != null && msgParams.length > 0){
                return MessageFormat.format(msgFormat, msgParams);
            }
        }
        return super.getMessage();
    }
}
