package com.demo_scanner.pulkit.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.demo_scanner.pulkit.R;
import com.demo_scanner.pulkit.adapters.ScannerAdapter;
import java.util.ArrayList;

public class ScanListActivity extends AppCompatActivity {

    private Toolbar toolbar;

    public ScannerAdapter scannerAdapter;
    private RecyclerView rv_scan_list;
    private ArrayList<String> productArrayList = new ArrayList<>();

    private String content_id_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_item_list);

        findIds();
        init();
    }

    private void findIds() {

        rv_scan_list = (RecyclerView) findViewById(R.id.rv_scan_list);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void init() {

//        int item_id = getIntent().getIntExtra("item_id", 0);
//        String content_name = getIntent().getStringExtra("content_name");
        content_id_result = getIntent().getStringExtra("content_id_result");

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv_scan_list.setLayoutManager(mLayoutManager);

        setAdapter();
    }

    private void setAdapter() {

        productArrayList.add(content_id_result);

        scannerAdapter = new ScannerAdapter(productArrayList, new ScannerAdapter.onClickListener() {
            @Override
            public void onClickButton(int position, int view, String product) {

            }
        });
        rv_scan_list.setAdapter(scannerAdapter);
    }

}
