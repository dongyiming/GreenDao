package com.example.android_db_biz.greendao;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;

import com.example.android_db_biz.FileUtils;

import java.io.File;

/**
 * @version : 1.0
 * @Description : TODO
 * @autho : dongyiming
 * @data : 2017/10/8 14:34
 * @package : com.example.android_db_biz
 */
public class DaoSessionManager {

    private final String DB_NAME = "android.db";
    private final String DB_PATH = "AndroidDevelopment/nc/miss08/database";
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    private DaoSessionManager() {
    }

    public static DaoSessionManager mInstance = new DaoSessionManager();

    public static DaoSessionManager getInstace() {

        return mInstance;
    }

    public DaoMaster getDaoMaster(Context mContext) {

        DaoMaster.DevOpenHelper mHelper = new DaoMaster.DevOpenHelper(mContext, DB_NAME, null);
        daoMaster = new DaoMaster(mHelper.getWritableDatabase());
        return daoMaster;
    }

    public DaoMaster getDaoMaster(Context mContext, final String path) {

        DaoMaster.DevOpenHelper mHelper = new VersionChangeHelper(new ContextWrapper(mContext) {

            @Override
            public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
                return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), null);
            }

            @Override
            public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
                return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), null);
            }

            @Override
            public File getDatabasePath(String name) {
                File file = FileUtils.buildDataBasePath(path, name);
                return file != null ? file : super.getDatabasePath(name);
            }
        }, DB_NAME);
        daoMaster = new DaoMaster(mHelper.getWritableDatabase());
        return daoMaster;
    }

    public DaoSession getDaoSession(Context mContext) {

        if (daoSession == null) {

            if (daoMaster == null) {
                getDaoMaster(mContext, DB_PATH);
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

}
