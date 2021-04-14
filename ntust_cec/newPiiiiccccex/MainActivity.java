package com.ple.newpiiiicccc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.PorterDuff;

public class MainActivity extends AppCompatActivity {
    ImageView img1 , img1_1 , img2 , img2_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1=(ImageView)findViewById(R.id.img1);
        img1_1=(ImageView)findViewById(R.id.img1_1);
        img2=(ImageView)findViewById(R.id.img2);
        img2_2=(ImageView)findViewById(R.id.img2_1);

        img1.setImageBitmap(getRoundedCornerBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.img01),200.0f));
        img2.setImageBitmap(getRoundedCornerBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.img02),100.0f));

    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx)
    {
        //用指定的位圖構造一個畫布，以將其繪製到其中。
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(),
                Bitmap.Config.ARGB_8888);
        //畫布功能
        Canvas canvas = new Canvas(output);
        final int color = 0xff424242;
        //繪製幾何圖形
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(),
                bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        //填充整個畫布
        canvas.drawARGB(0, 158, 245, 66);
        paint.setColor(color);
        //繪製圓角矩形
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        //使用指定的矩陣繪製位圖。
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }
}