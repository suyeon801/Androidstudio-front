package com.example.mymovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CommentWriteActivity extends AppCompatActivity {

    EditText contentsInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_write);

        contentsInput = (EditText) findViewById(R.id.contentsInput);
        Button savedButton = (Button) findViewById(R.id.savedButton);
        savedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnToMain();
            }
        });

    }
    public void returnToMain(){
        String contents = contentsInput.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("contents", contents);

        setResult(RESULT_OK, intent);
        finish();
    }
}