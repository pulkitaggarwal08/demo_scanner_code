package com.demo_scanner.pulkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.demo_scanner.pulkit.activities.ScanActivity;

public class MainActivity extends AppCompatActivity {

    Button scan_qr_bar_code;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findIds();
        init();
    }

    private void findIds() {
        scan_qr_bar_code = (Button) findViewById(R.id.scan_qr_bar_code);
    }

    private void init() {

        scan_qr_bar_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),ScanActivity.class);
                startActivity(intent);
            }
        });
    }


}
