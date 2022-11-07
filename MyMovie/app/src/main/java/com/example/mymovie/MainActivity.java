package com.example.mymovie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button likeButton;
    TextView likeCountView;
    int likeCount=15;
    boolean likeState = false;

    Button dislikeButton;
    TextView dislikeCountView;
    int dislikeCount=1;
    boolean dislikeState = false;

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