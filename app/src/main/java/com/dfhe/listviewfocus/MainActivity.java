package com.dfhe.listviewfocus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView lv;
    private ArrayList<String> list;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();

    }

    private void initLayout() {
        if(list == null){
            list = new ArrayList<>();
        }

        for (int i = 0; i < 20; i++) {
            list.add("正常显示.....");
        }

        lv = (ListView) findViewById(R.id.lv);
        adapter = new MyAdapter(list,this);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.setCurrentPosition(position);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
