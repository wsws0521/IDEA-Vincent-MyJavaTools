package cn.vincent.builder.inLombok;

import lombok.Builder;

import java.util.Date;

@Builder
public class BuildLombokObject {
    private long id;
    private String name;
    private String content;
    private int type;
    private int status;
    private Date finishDate;
}
