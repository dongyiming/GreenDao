package com.example.android_db_biz.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

/**
 * @version : 1.0
 * @Description : TODO
 * @autho : dongyiming
 * @data : 2017/10/8 16:44
 * @package : com.example.android_db_biz
 */
public class VersionChangeHelper extends DaoMaster.DevOpenHelper {

    public VersionChangeHelper(Context context, String name) {
        this(context, name, null);
    }

    public VersionChangeHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        //super.onUpgrade(db, oldVersion, newVersion);

        MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {

            @Override
            public void onCreateAllTables(Database db, boolean ifNotExists) {
                Log.e("dongyiming", "onCreateAllTables");
                //DaoMaster.createAllTables(db, ifNotExists);
            }

            @Override
            public void onDropAllTables(Database db, boolean ifExists) {
                Log.e("dongyiming", "onDropAllTables");
                //DaoMaster.dropAllTables(db, ifExists);
            }
        }, SongDao.class);

        //MigrationHelper.migrate(db, MenuInfoDao.class);
        Log.e("dongyiming", "onUpgrade");
        SingerDao.dropTable(db, true);
    }
}
