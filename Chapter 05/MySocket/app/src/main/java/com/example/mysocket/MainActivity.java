package com.example.mysocket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import kotlinx.coroutines.android.AndroidExceptionPreHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClientThread thread = new ClientThread();
                thread.start();
            }
        });
    }
    class ClientThread extends Thread{
        public void run(){
            String host = "localhost";
            int port = 5001;
            try {
                Socket socket = new Socket(host, port);

                ObjectOutputStream outstream = new ObjectOutputStream(socket.getOutputStream());
                outstream.writeObject("안녕");
                outstream.flush();
                Log.d("ClientThread", "서버로 보냄.");

                ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
                Object input = inStream.readObject();
                //String input = (String) inStream.readObject();
                Log.d("ClientThread", "받은 데이터 : "+input);

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}