package com.xiaoyaoprefecture.myspinnerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner mSpinner;
    MyAdapter adapter;
    List<String>list=new ArrayList<>();
    EditText mEd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSpinner= (Spinner) findViewById(R.id.mSpinner);
        mEd= (EditText) findViewById(R.id.mEd);
        initList();
        adapter=new MyAdapter(list,this);
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mEd.setCursorVisible(false);
                String sex=list.get(position);
                mEd.setText(sex);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mEd.setCursorVisible(false);
            }
        });
        mEd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEd.setCursorVisible(true);
            }
        });
    }

    /**
     * 初始化数据
     */
    private void initList() {
        for (int i=0;i<20;i++){
            list.add("中国"+i);
        }
    }
}
