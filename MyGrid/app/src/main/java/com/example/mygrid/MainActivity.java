package com.example.mygrid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SingerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridView);

        //ListView 객체 찾기

        adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("소녀시대", "010-1000-1000", R.drawable.icon01));
        adapter.addItem(new SingerItem("걸스데이", "010-2000-2000", R.drawable.icon02));
        adapter.addItem(new SingerItem("여자친구", "010-3000-3000", R.drawable.icon03));
        adapter.addItem(new SingerItem("티아라", "010-4000-4000", R.drawable.icon04));
        adapter.addItem(new SingerItem("애프터스쿨", "010-5000-5000", R.drawable.icon05));

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택:" + item.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    //SingerAdapter 클래스 만들기
    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        //몇개의 아이템?
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        //각각의 아이템에 대한 뷰
        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            SingeritemView view = null;
            if(convertView == null){
                view = new SingeritemView(getApplicationContext());
            }else{
                view = (SingeritemView) convertView;
            }

            SingerItem item = items.get(i);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImage(item.getResID());

            return view;
        }
    }
}

