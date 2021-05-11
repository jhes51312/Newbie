package com.example.myapplicationtttt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Xml;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv01 = (TextView)findViewById(R.id.textView1);
        TextView tv02 = (TextView)findViewById(R.id.textView2);
        int i= 0;
        XmlPullParser pullParser = Xml.newPullParser();
        //因為將test.xml放在/assets之下，所以必須以讀取檔案的方式來處理
        AssetManager assetManager = getAssets();
        InputStream is;
        try
        {
            is = assetManager.open("test.xml"); //讀取檔案
            pullParser.setInput(is , "utf-8");  //設定語系
            //利用eventType來判斷目前分析到XML是哪一個部份
            int eventType = pullParser.getEventType();
            //XmlPullParser.END_DOCUMENT表示已經完成分析XML
            while(eventType != XmlPullParser.END_DOCUMENT)
            {
                i++;
                //XmlPullParser.START_TAG表示目前分析到的是XML的Tag，如<title>
                if (eventType == XmlPullParser.START_TAG) {
                    String name = pullParser.getName();
                    tv01.setText(tv01.getText() + ", " + name);
                }
                //XmlPullParser.TEXT表示目前分析到的是XML Tag的值，如：台南美食吃不完
                if (eventType==XmlPullParser.TEXT) {
                    String value = pullParser.getText();
                    tv02.setText(tv02.getText() + ", " + value);
                }
                //分析下一個XML Tag
                eventType = pullParser.next();
            }
        } catch (IOException e) {
            tv02.setText(e.toString());
        } catch (XmlPullParserException e) {
            tv02.setText(e.toString());
        }
    }


}