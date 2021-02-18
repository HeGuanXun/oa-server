package com.hgx.common.utils;

/**
 * <p>TODO</p>
 *
 * @author 何冠勋
 * @since 2020/7/15
 **/
public enum PermissionTypeEnum {

    ADD("新增", 1),
    DEL("删除", 2),
    UPDATE("修改", 3),
    VIEW("查看", 4);

    private String name;

    private int type;

    PermissionTypeEnum(String name, int type) {
        this.name = name;
        this.type = type;
    }

    // 普通方法
    public static String getName(int index) {
        for (PermissionTypeEnum c : PermissionTypeEnum.values()) {
            if (c.getType() == index) {
                return c.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
