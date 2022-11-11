package com.example.mymovie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button likeButton;
    TextView likeCountView;
    int likeCount=15;
    boolean likeState = false;

    Button dislikeButton;
    TextView dislikeCountView;
    int dislikeCount=1;
    boolean dislikeState = false;

    CommentAdapter commentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 좋아요 버튼
        likeButton = (Button) findViewById(R.id.likeButton);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(likeState){
                    decrLikeCount();
                }
                else if(dislikeState){
                    decrDisLikeCount();
                    incrLikeCount();
                    dislikeState = !dislikeState;
                }
                else {
                    incrLikeCount();
                }
                likeState = !likeState;
            }
        });
        likeCountView = (TextView) findViewById(R.id.likeCountView);

        // 싫어요 버튼
        dislikeButton = (Button) findViewById(R.id.dislikeButton);
        dislikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dislikeState){
                    decrDisLikeCount();
                }
                else if(likeState){
                    decrLikeCount();
                    incrDisLikeCount();
                    likeState = !likeState;
                }
                else {
                    incrDisLikeCount();
                }
                dislikeState = !dislikeState;
            }
        });
        dislikeCountView = (TextView) findViewById(R.id.dislikeCountView);

        //ListView 찾기
        ListView listView = (ListView) findViewById(R.id.listView);

        CommentAdapter adapter = new CommentAdapter();
        adapter.addItem(new CommentItem("kym71**", "10", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));
        adapter.addItem(new CommentItem("kym71**", "10", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));
        listView.setAdapter(adapter);
    }
    //Adapter클래스 생성
    class CommentAdapter extends BaseAdapter {
        ArrayList<CommentItem> items = new ArrayList<CommentItem>();

        @Override
        public int getCount() {return items.size();
        }

        public void addItem(CommentItem item) {items.add(item);
        }

        @Override
        public Object getItem(int i) {return items.get(i);
        }

        @Override
        public long getItemId(int i) {return i;
        }

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

    //좋아요 카운트 함수
    public void incrLikeCount(){
        likeCount += 1;
        likeCountView.setText(String.valueOf(likeCount));
        likeButton.setBackgroundResource(R.drawable.ic_thumb_up_selected);
    }
    public void decrLikeCount(){
        likeCount -= 1;
        likeCountView.setText(String.valueOf(likeCount));
        likeButton.setBackgroundResource(R.drawable.ic_thumb_up);
    }
    //싫어요 카운트 함수
    public void incrDisLikeCount(){
        dislikeCount += 1;
        dislikeCountView.setText(String.valueOf(dislikeCount));
        dislikeButton.setBackgroundResource(R.drawable.ic_thumb_down_selected);
    }
    public void decrDisLikeCount(){
        dislikeCount -= 1;
        dislikeCountView.setText(String.valueOf(dislikeCount));
        dislikeButton.setBackgroundResource(R.drawable.ic_thumb_down);
    }
}