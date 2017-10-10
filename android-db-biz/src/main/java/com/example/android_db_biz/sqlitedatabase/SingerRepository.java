package com.example.android_db_biz.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.android_db_biz.vo.sqlite.Singer;

import java.util.ArrayList;
import java.util.List;

/**
 * @version : 1.0
 * @Description : TODO
 * @autho : dongyiming
 * @data : 2017/10/8 23:14
 * @package : com.example.android_db_biz.sqlitedatabase
 */
public class SingerRepository extends BaseRepository<Singer> implements ISingerRepository<Singer, Integer> {

    public SingerRepository(Context mContext) {
        super(mContext);
    }

    @Override
    public long add(Singer singer) {

        ContentValues cv = getContentValues(singer);
        long res = insert(TABLE, null, cv);
        return res;
    }

    @Override
    public int update(Singer singer) {
        ContentValues cv = getContentValues(singer);
        String whereClause = String.format("%s = ?", SINGER_CODE);
        update(TABLE, cv, whereClause, new String[]{singer.getSingerCode()});
        return 0;
    }

    @Override
    public Singer queryById(Integer id) {

        String sql = String.format("%s = ?", ID);
        List<Singer> singerList = query(TABLE, null, sql, new String[]{String.valueOf(id)}, null, null, null);
        if (singerList != null) {
            return singerList.get(0);
        }
        return null;
    }

    @Override
    public List<Singer> queryForAll() {
        return query(TABLE, null, null, null, null, null, null);
    }

    @Override
    public int delete(Integer id) {

        String sql = String.format("delete from %s where %s = ?", TABLE, ID);
        dbHelper.getWritableDatabase().execSQL(sql, new String[]{String.valueOf(id)});
        return 0;
    }

    public ContentValues getContentValues(Singer singer) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SINGER_CODE, singer.getSingerCode());
        contentValues.put(SINGER_NAME, singer.getSingerName());
        return contentValues;
    }

    //查询需要对cursor遍历，父类需要的方法
    public List<Singer> queryResult(Cursor cursor) {
        List<Singer> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            Singer singer = new Singer();
            singer.setId(cursor.getInt(cursor.getColumnIndex(ID)));
            singer.setSingerName(cursor.getString(cursor.getColumnIndex(SINGER_NAME)));
            singer.setSingerCode(cursor.getString(cursor.getColumnIndex(SINGER_CODE)));
            list.add(singer);
        }
        return list;
    }
}
