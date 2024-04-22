package cn.vincent.enums;

public enum ShelvesStatus {

    /**
     * 货架状态枚举
     */
    NotPutOn( 0, "未上架" ),
    PutOnReview( 1, "上架审核中" ),
    PutOnReviewFail( 2, "上架审核失败" ),
    PullOffReview( 3, "下架审核中" ),
    PullOffReviewFail( 4, "下架审核失败" ),
    PutOn( 5, "已上架" );

    private final Integer type;
    private final String name;

    private ShelvesStatus(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public static String getNameByType(Integer type) {
        if(type != null){
            for (ShelvesStatus e : ShelvesStatus.values()) {
                if (type.equals( e.type )) {
                    return e.name;
                }
            }
        }
        return null;
    }

    public Integer getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }



    public static ShelvesStatus getEnumByType(Integer type){
        if(type != null){
            for (ShelvesStatus e : ShelvesStatus.values()) {
                if (type.equals( e.type )) {
                    return e;
                }
            }
        }
        return null;
    }

}
