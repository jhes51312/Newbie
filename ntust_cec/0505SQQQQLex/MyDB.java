package com.sunshihhung.a0505sqqqql;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.aware.PublishConfig;

import java.security.PublicKey;

public class MyDB {
    public SQLiteDatabase db = null;
    private final static String DATABASE_NAME = "db2.db";
    private final static String TABLE_NAME = "table01";
    private final static String _ID = "_id";
    private final static String NAME = "name";
    private final static String PRICE = "price";
    private final static String CREATE_TABLE =
            "CREATE TABLE "+TABLE_NAME+" ("+_ID+" INTEGER PRIMARY KEY ,"+NAME+" TEXT , "+PRICE+"INTERGER)";

    Context mContext = null;
    public MyDB(Context c){
        mContext =c;

    }
    public void open()throws SQLException{
        db=mContext.openOrCreateDatabase(DATABASE_NAME,Context.MODE_PRIVATE,null);
        try{
            db.execSQL(CREATE_TABLE);
        }catch (Exception e){
        }
    }

    public void close(){
        db.close();
    }

    public Cursor get(long reid)throws SQLException{
        Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + "WHERE _id ="+reid,null);
        if(mCursor != null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor getAll(){
        Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
        return cursor;
    }

    public long append(String name , int price){
        String str = "INSERT INTO "+TABLE_NAME+" ( "+NAME+","+PRICE+" ) values('"+name+"',"+price+")";
                db.execSQL(str);

                return 1;
    }

    public boolean delete(long rowId){
        String str = "DELETE FROM " +TABLE_NAME+ "WHERE _id ="+rowId;
        db.execSQL(str);

        return true;
    }

    public boolean updata(long rwID , String name , int price){
        String str = "UPDATE " +TABLE_NAME+ "SET name = '"+name+"' , price = '"+price+"' WHERE _id="+rwID;
        db.execSQL(str);

        return true;
    }

}
