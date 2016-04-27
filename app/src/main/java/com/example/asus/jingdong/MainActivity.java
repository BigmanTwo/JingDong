package com.example.asus.jingdong;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asus.jingdong.adpter.MyAdpter;
import com.example.asus.jingdong.bean.Goods;
import com.example.asus.jingdong.sql.MyGoodsSql;
import com.example.asus.jingdong.sql.MySqlplite;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener{
    private ListView mListView;
    private List<Goods> mList;
    private MyGoodsSql myGoodsSql;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MySqlplite open=new MySqlplite(this,"Goods",null,1);
        //通过getWritableDatabase方法获得数据库的操作权限
        //Writer既可以读也可以写，reader只能读
        SQLiteDatabase database=open.getWritableDatabase();
        myGoodsSql=new MyGoodsSql(database);


        mListView=(ListView)findViewById(R.id.list_item);
        mButton=(Button)findViewById(R.id.but1);
        mButton.setOnClickListener(this);
        mList=new ArrayList<>();
        for(int i=0;i<20;i++){
            mList.add(new Goods(R.mipmap.caocao,"曹操"+i,250));
        }
        MyAdpter adpter=new MyAdpter(mList,MainActivity.this);
        mListView.setAdapter(adpter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,ShopActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Goods goods=mList.get(position);
        myGoodsSql.addData(goods);
        Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
    }
}
