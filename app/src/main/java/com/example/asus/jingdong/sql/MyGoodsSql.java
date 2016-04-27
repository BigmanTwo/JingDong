package com.example.asus.jingdong.sql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.asus.jingdong.bean.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 2016/4/25.
 */
public class MyGoodsSql  {
    private SQLiteDatabase db;

    public MyGoodsSql(SQLiteDatabase db) {
        this.db = db;
    }



    public void addData(Goods goods){
        db.execSQL("insert into goods(image,name,price)values(?,?,?)",
                new Object[]{goods.getImage(),goods.getName(),goods.getPrice()});
    }
    public List<Goods> quary(){
        List<Goods> list=new ArrayList<>();
        Cursor cursor=db.rawQuery("select * from goods",null);
        while(cursor.moveToNext()){
            int image=cursor.getInt(cursor.getColumnIndex("image"));
            String name=cursor.getString(cursor.getColumnIndex("name"));
            int price=cursor.getInt(cursor.getColumnIndex("price"));
            Goods goods=new Goods(image,name,price);
            list.add(goods);
        }
        return list;
    }

}
