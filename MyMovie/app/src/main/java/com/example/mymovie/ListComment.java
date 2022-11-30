package com.example.mymovie;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public abstract class ListComment extends AppCompatActivity {
    Button commentButton;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_comment);

        //CommentButton 찾기
        commentButton = (Button) findViewById(R.id.commentButton);
        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCommentWriteActiviy();
            }
        });

        //ListView 찾기
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(MainActivity.adapter);

    }
    //Adapter클래스 생성
    class CommentAdapter extends BaseAdapter {
        ArrayList<CommentItem> items = new ArrayList<CommentItem>();

        @Override
        public int getCount() {return items.size();}

        public void addItem(CommentItem item) {items.add(item);}

        @Override
        public Object getItem(int i) {return items.get(i);}

        @Override
        public long getItemId(int i) {return i;}

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            CommentItemView Cview = null;
            if (view == null) {
                Cview = new CommentItemView(getApplicationContext());
            } else {
                Cview = (CommentItemView) view;
            }
            CommentItem item = items.get(i);
            Cview.setUser_id(item.getUser_id());
            Cview.setUser_time(item.getUser_time());
            Cview.setUser_comment(item.getUser_comment());
            return Cview;
        }
    }

    //comment 작성하는 화면으로 넘어가기
    public void showCommentWriteActiviy(){
        Intent intent = new Intent(getApplicationContext(), CommentWriteActivity.class);
        startActivityForResult(intent, 101);
    }
}