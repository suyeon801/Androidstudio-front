package com.example.myrecylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ID 찾기
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //---LayoutManager 아래 3가지중 하나를 선택하여 사용---
        // 1) LinearLayoutManager()
        // 2) GridLayoutManager()
        // 3) StaggeredGridLayoutManager()
        //--------------------------------------------------
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        //Adapter 연결
        SingerAdapter adapter = new SingerAdapter(getApplicationContext());

        //데이터 설정
        adapter.addItem(new SingerItem("소녀시대", "010-1000-1000"));
        adapter.addItem(new SingerItem("걸스데이", "010-2000-2000"));
        adapter.addItem(new SingerItem("여자친구", "010-3000-3000"));

        recyclerView.setAdapter(adapter);
    }
}