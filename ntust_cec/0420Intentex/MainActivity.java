package commple.a0420intent;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnView = (Button) findViewById(R.id.btnView);
        Button btnDial = (Button) findViewById(R.id.btnDial);
        Button btnCall = (Button) findViewById(R.id.btnCall);
        Button btnPage2 = (Button) findViewById(R.id.btnPage2);

        btnView.setOnClickListener(listen);
        btnDial.setOnClickListener(listen);
        btnCall.setOnClickListener(listen);
        btnPage2.setOnClickListener(Page2listen);

        requestPermissions();

    }

    private void requestPermissions() {
        if (Build.VERSION.SDK_INT >= 23) {
            int hasPermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
            if (hasPermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "denied", Toast.LENGTH_SHORT).show();
                finish();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }

    private Button.OnClickListener listen = new Button.OnClickListener() {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnView: {
                    Uri uri = Uri.parse("http://tw.yahoo.com");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                    break;
                }
                case R.id.btnDial: {
                    Uri uri = Uri.parse("tel:0999123456");
                    Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                    startActivity(intent);
                    break;
                }
                case R.id.btnCall: {
                    Uri uri = Uri.parse("tel:0912345678");
                    Intent intent = new Intent(Intent.ACTION_CALL, uri);
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                        startActivity(intent);
                    }
                    break;
                }
            }
        }
    };

    private Button.OnClickListener Page2listen = new Button.OnClickListener() {
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, Second.class);
            startActivity(intent);

            String name = "DAVID";
            int age = 27;
            Double tall = 182.5;

            Bundle bundle = new Bundle();
            bundle.putString("NAME",name);
            bundle.putInt("AGE",age);
            bundle.putDouble("TALL",tall);;;
            intent.putExtras(bundle);

            startActivity(intent);
        }

    };
}