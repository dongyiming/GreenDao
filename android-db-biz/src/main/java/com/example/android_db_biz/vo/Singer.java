package com.example.android_db_biz.vo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @version : 1.0
 * @Description : TODO
 * @autho : dongyiming
 * @data : 2017/10/8 19:37
 * @package : com.example.android_db_biz.vo
 */
@Entity
public class Singer {

    @Id(autoincrement = true)
    private Long id;

    private String singerCode;

    private String singerName;

    private String singerDesc;

    @Generated(hash = 479037012)
    public Singer(Long id, String singerCode, String singerName,
            String singerDesc) {
        this.id = id;
        this.singerCode = singerCode;
        this.singerName = singerName;
        this.singerDesc = singerDesc;
    }

    @Generated(hash = 242898301)
    public Singer() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSingerCode() {
        return this.singerCode;
    }

    public void setSingerCode(String singerCode) {
        this.singerCode = singerCode;
    }

    public String getSingerName() {
        return this.singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSingerDesc() {
        return this.singerDesc;
    }

    public void setSingerDesc(String singerDesc) {
        this.singerDesc = singerDesc;
    }

}
