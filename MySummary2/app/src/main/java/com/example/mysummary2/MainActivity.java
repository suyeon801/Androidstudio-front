package com.example.mysummary2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button likeButton;
    TextView likeCountView;

    int likeCount = 1;
    boolean likeState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //객체화
        setContentView(R.layout.activity_main);
        // ID 찾기
        likeButton = (Button) findViewById(R.id.likeButton);
        // Button 눌렸을 때
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(likeState) {
                    decrLikeCount();
                }
                else {
                    incrLikeCount();
                }
                likeState = !likeState;
            }
        });
        likeCountView = (TextView) findViewById(R.id.likeCountView);

        ListView listView = (ListView) findViewById(R.id.listView);
        CommentAdapter adapter = new CommentAdapter();
        listView.setAdapter(adapter);
    }

    class CommentAdapter extends BaseAdapter{

    }

    //새로운 함수
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
}