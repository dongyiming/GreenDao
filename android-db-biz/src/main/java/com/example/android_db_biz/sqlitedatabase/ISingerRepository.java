package com.example.android_db_biz.sqlitedatabase;

import java.util.List;

/**
 * @version : 1.0
 * @Description : TODO
 * @autho : dongyiming
 * @data : 2017/10/8 23:23
 * @package : com.example.android_db_biz.sqlitedatabase
 */
public interface ISingerRepository<T, ID> {

    public static final String TABLE = "singer";
    public static final String COLUMN_PREFIX = TABLE.concat("_");
    public static final String ID = "_id";
    public static final String SINGER_CODE = COLUMN_PREFIX + "code";
    public static final String SINGER_NAME = COLUMN_PREFIX + "name";
    public static final String SINGER_DESC = COLUMN_PREFIX + "desc";

    //只给出简单的增删改查
    public long add(T var1);

    public int update(T var1);

    T queryById(ID var1);

    List<T> queryForAll();

    int delete(ID var1);
}
