package com.example.android_db_biz.vo.sqlite;

/**
 * @version : 1.0
 * @Description : TODO
 * @autho : dongyiming
 * @data : 2017/10/8 23:56
 * @package : com.example.android_db_biz.vo.sqlite
 */
public class Singer {

    private int id;

    private String singerCode;

    private String singerName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSingerCode() {
        return singerCode;
    }

    public void setSingerCode(String singerCode) {
        this.singerCode = singerCode;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }
}
