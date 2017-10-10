package com.example.android_db_biz.sqlitedatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @version : 1.0
 * @Description : TODO
 * @autho : dongyiming
 * @data : 2017/10/8 22:30
 * @package : com.example.android_db_biz.sqlitedatabase
 */
public class DBHelper extends SQLiteOpenHelper {

    //数据库名
    private static final String DB_NAME = "android2.db";
    //版本号
    private static final int VERSION_CODE = 1;
    //创建table的sql语句
    private static final String SQL_CREATE_TABLE = String.format("create table %s ( " +
                    "%s integer primary key autoincrement" +
                    ",%s text" +
                    ",%s text)"
            , ISingerRepository.TABLE
            , ISingerRepository.ID
            , ISingerRepository.SINGER_CODE
            , ISingerRepository.SINGER_NAME);

    public DBHelper(Context mContext) {
        super(mContext, DB_NAME, null, VERSION_CODE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (newVersion > oldVersion) {
            //增加一列
            String sql = String.format("alter table %s add %s text", ISingerRepository.TABLE, ISingerRepository.SINGER_DESC);
            db.execSQL(sql);
        }
    }
}
