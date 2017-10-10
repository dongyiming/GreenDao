package com.example.pver.androiddevelopment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android_db_biz.greendao.DaoSession;
import com.example.android_db_biz.greendao.DaoSessionManager;
import com.example.android_db_biz.greendao.MenuInfoDao;
import com.example.android_db_biz.greendao.SingerDao;
import com.example.android_db_biz.greendao.SongDao;
import com.example.android_db_biz.vo.MenuInfo;
import com.example.android_db_biz.vo.Singer;
import com.example.android_db_biz.vo.Song;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* 普通SQLite数据库操作================================================================== */
//        SingerRepository singerRepository = new SingerRepository(this);
//        Singer singer = new Singer();
//        singer.setSingerCode("112");
//        singer.setSingerName("张三");
//        singerRepository.add(singer);
//        int delete = singerRepository.delete(0);


        /* GreenDao框架的数据库操作============================================================================*/
        //获取Song这张表的操作类SongDao
        DaoSession daoSession = DaoSessionManager.getInstace().getDaoSession(getApplicationContext());
        SongDao songDao = daoSession.getSongDao();
        MenuInfoDao menuInfoDao = daoSession.getMenuInfoDao();
        SingerDao singerDao = daoSession.getSingerDao();

        //创建一个对象
        Song song = new Song();
        song.setSingerCode(111);
        MenuInfo menuInfo = new MenuInfo();
        menuInfo.setMenuCode("121");
        Singer singer = new Singer();
        singer.setSingerCode("333");

        //增加
//        songDao.insert(song);
//        menuInfoDao.insert(menuInfo);
//        singerDao.insert(singer);


        //改
        //song.setSingerName("miss08");
        //songDao.update(song);

        //查
        //Song query = songDao.queryBuilder().where(SongDao.Properties.SingerCode.eq(111)).list().get(0);

        //删
        //songDao.delete(song);
    }
}
