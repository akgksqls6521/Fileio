package kr.hs.emirim.qls6521.fileio;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button butOut, butIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butOut=(Button)findViewById(R.id.but_output);
        butIn=(Button)findViewById(R.id.but_input);
        butOut.setOnClickListener(new View.OnClickListener() {//이름 없이 이 부분이 상속받는 부분임
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream out = openFileOutput("1017uri_zip.txt", Context.MODE_WORLD_WRITEABLE);
                    String message="미림여자정보과학고 화이팅";
                    out.write(message.getBytes());//1차원 byte배열
                    out.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        });//익명클래스

        butIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream in = openFileInput("1017uri_zip.txt");
                    byte[] readMessage = new byte[200];
                    in.read(readMessage);
                    Toast.makeText(getApplicationContext(),new String(readMessage),Toast.LENGTH_LONG).show();
                    in.close();
                }catch(FileNotFoundException e){
                    Toast.makeText(getApplicationContext(),new String("존재하지 않는 파일입니다."),Toast.LENGTH_LONG).show();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}

