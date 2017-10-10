package com.example.android_db_biz.sqlitedatabase;

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
 * @data : 2017/10/9 1:04
 * @package : com.example.android_db_biz.sqlitedatabase
 */
public class DataBaseContext extends ContextWrapper {

    private static final String DB_PATH = "AndroidDevelopment/nc/miss08/database";

    public DataBaseContext(Context base) {
        super(base);
    }

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

        File file = FileUtils.buildDataBasePath(DB_PATH, name);
        return file != null ? file : super.getDatabasePath(name);
    }
}
