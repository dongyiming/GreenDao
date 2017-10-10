package com.example.android_db_biz.vo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @version : 1.0
 * @Description : TODO
 * @autho : dongyiming
 * @data : 2017/10/9 0:53
 * @package : com.example.android_db_biz.vo
 */
@Entity
public class MenuInfo {

    @Id(autoincrement = true)
    private Long id;

    private String menuCode;

    private String menuName;

    //增加的字段
    private String menuDesc;

    private int menuType;

    private String createTime;

    private String updateTime;

    @Generated(hash = 1298574679)
    public MenuInfo(Long id, String menuCode, String menuName, String menuDesc,
            int menuType, String createTime, String updateTime) {
        this.id = id;
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuDesc = menuDesc;
        this.menuType = menuType;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Generated(hash = 859137273)
    public MenuInfo() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuCode() {
        return this.menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDesc() {
        return this.menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getMenuType() {
        return this.menuType;
    }

    public void setMenuType(int menuType) {
        this.menuType = menuType;
    }
}
