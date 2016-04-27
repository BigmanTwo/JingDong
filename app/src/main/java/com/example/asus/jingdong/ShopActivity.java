package com.example.asus.jingdong;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.asus.jingdong.adpter.MyShopAdpter;
import com.example.asus.jingdong.bean.Goods;
import com.example.asus.jingdong.sql.MyGoodsSql;
import com.example.asus.jingdong.sql.MySqlplite;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity {
 private ListView mListView;
    private List<Goods> mList;
    private MyGoodsSql myGoodsSql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        MySqlplite open=new MySqlplite(this,"Goods",null,1);
        //通过getWritableDatabase方法获得数据库的操作权限
        //Writer既可以读也可以写，reader只能读
        SQLiteDatabase database=open.getWritableDatabase();
        myGoodsSql=new MyGoodsSql(database);

        mListView=(ListView)findViewById(R.id.scanner_list);
        query();

    }
    private void query(){
        mList=new ArrayList<>();
        mList=myGoodsSql.quary();
        MyShopAdpter myadpter=new MyShopAdpter(mList,this);
        mListView.setAdapter(myadpter);
    }
}
