package com.example.android_db_biz.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @version : 1.0
 * @Description : TODO
 * @autho : dongyiming
 * @data : 2017/10/8 23:10
 * @package : com.example.android_db_biz.sqlitedatabase
 */
public class BaseRepository<T> {

    public final DBHelper dbHelper;

    public BaseRepository(Context mContext) {
        DataBaseContext context = new DataBaseContext(mContext);
        this.dbHelper = new DBHelper(context);
    }

    public long insert(String table, String nullColumnHack, ContentValues values) {
        long ret = 0L;
        SQLiteDatabase database = this.dbHelper.getWritableDatabase();
        database.beginTransaction();

        try {
            ret = database.insert(table, nullColumnHack, values);
            database.setTransactionSuccessful();
        } catch (RuntimeException var11) {
            Log.e("miss08", "exception : " + var11);
        } finally {
            database.endTransaction();
        }

        return ret;
    }

    public <T> List<T> query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, Integer limit) {
        Object results = new ArrayList();
        Cursor cursor = null;

        try {
            if (limit != null) {
                cursor = this.dbHelper.getReadableDatabase().query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit + "");
            } else {
                cursor = this.dbHelper.getReadableDatabase().query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
            }

            results = this.queryResult(cursor);
        } catch (RuntimeException var15) {
            Log.e("miss08", "exception : " + var15);
        } finally {
            if (cursor != null) {
                cursor.close();
            }

        }

        return (List) results;
    }

    public <T> List<T> query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return this.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, (Integer) null);
    }

    public <T> List<T> queryResult(Cursor cursor) {
        throw new RuntimeException("Please overwrite method.");
    }

    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        int ret = 0;
        SQLiteDatabase database = this.dbHelper.getWritableDatabase();
        database.beginTransaction();

        try {
            ret = database.update(table, values, whereClause, whereArgs);
            database.setTransactionSuccessful();
        } catch (RuntimeException var11) {
            Log.e("miss08", "exception : " + var11);
        } finally {
            database.endTransaction();
        }

        return ret;
    }

    public int delete(String table, String whereClause, String[] whereArgs) {
        int ret = 0;
        SQLiteDatabase database = this.dbHelper.getWritableDatabase();
        database.beginTransaction();

        try {
            ret = database.delete(table, whereClause, whereArgs);
            database.setTransactionSuccessful();
        } catch (RuntimeException var10) {
            Log.e("miss08", "exception : " + var10);
        } finally {
            database.endTransaction();
        }

        return ret;
    }
}
