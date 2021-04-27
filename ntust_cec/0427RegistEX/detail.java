package comample.a0427regist;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class detail extends AppCompatActivity {

    private Button button;
    private ImageView imageView;
    private TextView textView4 , textView8 , textView9 , textView10;
    int redId[] = new int[]{};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
}
