package com.example.lee.movie;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SetSelect extends AppCompatActivity {
    private SQLiteDatabase db;

    int a, b = 0;
    int num = 0;
    int pay = 0;
    String date;

    TextView setview, payview, test;

    private EditText editdate;

    ImageButton[][] buttons = new ImageButton[6][9];

    Button paybut;


    Integer[][] butid = {
            {R.id.setA1, R.id.setA2, R.id.setA3, R.id.setA4, R.id.setA5, R.id.setA6, R.id.setA7, R.id.setA8, R.id.setA9},
            {R.id.setB1, R.id.setB2, R.id.setB3, R.id.setB4, R.id.setB5, R.id.setB6, R.id.setB7, R.id.setB8, R.id.setB9},
            {R.id.setC1, R.id.setC2, R.id.setC3, R.id.setC4, R.id.setC5, R.id.setC6, R.id.setC7, R.id.setC8, R.id.setC9},
            {R.id.setD1, R.id.setD2, R.id.setD3, R.id.setD4, R.id.setD5, R.id.setD6, R.id.setD7, R.id.setD8, R.id.setD9},
            {R.id.setE1, R.id.setE2, R.id.setE3, R.id.setE4, R.id.setE5, R.id.setE6, R.id.setE7, R.id.setE8, R.id.setE9},
            {R.id.setF1, R.id.setF2, R.id.setF3, R.id.setF4, R.id.setF5, R.id.setF6, R.id.setF7, R.id.setF8, R.id.setF9}
    };

    boolean clicked[][] = {
            {false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false}
    };

//    private ArrayList<String> DataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paybut = (Button) findViewById(R.id.paybut);

        setview = (TextView) findViewById(R.id.parsonNum);
        payview = (TextView) findViewById(R.id.totalpay);





        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 9; j++) {

                buttons[i][j] = (ImageButton) findViewById(butid[i][j]);
                buttons[i][j].setTag(i);
            }
        }

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        for (a = 0; a < buttons.length; a++) {
                            for (b = 0; b < buttons[a].length; b++) {
                                if (v.getId() == buttons[a][b].getId()) {
                                    switch (a) {
                                        case 0:
                                            switch (b) {
                                                default:
                                                    if (clicked[a][b] == false) { //count가 0이면, 즉 한번도 눌리지 않았으면
                                                        buttons[a][b].setImageResource(R.drawable.bt_click); //눌렸을때 이미지를 stop으로 전환
                                                        ++num;
                                                        setview.setText(String.valueOf(num) + " 명");
                                                        totalpay();



                                                        Toast.makeText(getApplicationContext(), "A열 " + b + "번 좌석입니다.", Toast.LENGTH_SHORT).show();
                                                        clicked[a][b] = true;
                                                    } else if (clicked[a][b] == true) {//버튼이 한번 눌려졌을때

                                                        buttons[a][b].setImageResource(R.drawable.bt_unclick);//다시 누르는 경우 이미지를 start로 전환
                                                        --num;
                                                        setview.setText(String.valueOf(num) + " 명");
                                                        totalpay();
                                                        clicked[a][b] = false;
                                                        //count = 0; //count를 초기화시켜 다음 클릭시 다시 if문으로 돌아갈 수 있도록 함.
                                                        switch (b) {
                                                            default:
                                                                Toast.makeText(getApplicationContext(), "선택 취소", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                            }
                                            break;
                                        case 1:
                                            switch (b) {
                                                default:
                                                    if (clicked[a][b] == false) { //count가 0이면, 즉 한번도 눌리지 않았으면
                                                        buttons[a][b].setImageResource(R.drawable.bt_click); //눌렸을때 이미지를 stop으로 전환
                                                        ++num;
                                                        setview.setText(String.valueOf(num) + " 명");
                                                        totalpay();

                                                        Toast.makeText(getApplicationContext(), "B열 " + b + "번 좌석입니다.", Toast.LENGTH_SHORT).show();
                                                        clicked[a][b] = true;
                                                    } else if (clicked[a][b] == true) {//버튼이 한번 눌려졌을때

                                                        buttons[a][b].setImageResource(R.drawable.bt_unclick);//다시 누르는 경우 이미지를 start로 전환
                                                        --num;
                                                        setview.setText(String.valueOf(num) + " 명");
                                                        totalpay();
                                                        clicked[a][b] = false;
                                                        //count = 0; //count를 초기화시켜 다음 클릭시 다시 if문으로 돌아갈 수 있도록 함.
                                                        switch (b) {
                                                            default:
                                                                Toast.makeText(getApplicationContext(), "선택 취소", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                            }
                                            break;
                                        case 2:
                                            switch (b) {
                                                default:
                                                    if (clicked[a][b] == false) { //count가 0이면, 즉 한번도 눌리지 않았으면
                                                        buttons[a][b].setImageResource(R.drawable.bt_click); //눌렸을때 이미지를 stop으로 전환
                                                        ++num;
                                                        setview.setText(String.valueOf(num) + " 명");
                                                        totalpay();

                                                        Toast.makeText(getApplicationContext(), "C열 " + b + "번 좌석입니다.", Toast.LENGTH_SHORT).show();
                                                        clicked[a][b] = true;
                                                    } else if (clicked[a][b] == true) {//버튼이 한번 눌려졌을때

                                                        buttons[a][b].setImageResource(R.drawable.bt_unclick);//다시 누르는 경우 이미지를 start로 전환
                                                        --num;
                                                        setview.setText(String.valueOf(num) + " 명");
                                                        totalpay();
                                                        clicked[a][b] = false;
                                                        //count = 0; //count를 초기화시켜 다음 클릭시 다시 if문으로 돌아갈 수 있도록 함.
                                                        switch (b) {
                                                            default:
                                                                Toast.makeText(getApplicationContext(), "선택 취소", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                            }
                                            break;
                                        case 3:
                                            switch (b) {
                                                default:
                                                    if (clicked[a][b] == false) { //count가 0이면, 즉 한번도 눌리지 않았으면
                                                        buttons[a][b].setImageResource(R.drawable.bt_click); //눌렸을때 이미지를 stop으로 전환
                                                        ++num;
                                                        setview.setText(String.valueOf(num) + " 명");
                                                        totalpay();

                                                        Toast.makeText(getApplicationContext(), "D열 " + b + "번 좌석입니다.", Toast.LENGTH_SHORT).show();
                                                        clicked[a][b] = true;
                                                    } else if (clicked[a][b] == true) {//버튼이 한번 눌려졌을때

                                                        buttons[a][b].setImageResource(R.drawable.bt_unclick);//다시 누르는 경우 이미지를 start로 전환
                                                        --num;
                                                        setview.setText(String.valueOf(num) + " 명");
                                                        totalpay();
                                                        clicked[a][b] = false;
                                                        //count = 0; //count를 초기화시켜 다음 클릭시 다시 if문으로 돌아갈 수 있도록 함.
                                                        switch (b) {
                                                            default:
                                                                Toast.makeText(getApplicationContext(), "선택 취소", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                            }
                                            break;
                                        case 4:
                                            switch (b) {
                                                default:
                                                    if (clicked[a][b] == false) { //count가 0이면, 즉 한번도 눌리지 않았으면
                                                        buttons[a][b].setImageResource(R.drawable.bt_click); //눌렸을때 이미지를 stop으로 전환
                                                        ++num;
                                                        setview.setText(String.valueOf(num) + " 명");
                                                        totalpay();

                                                        Toast.makeText(getApplicationContext(), "E열 " + b + "번 좌석입니다.", Toast.LENGTH_SHORT).show();
                                                        clicked[a][b] = true;
                                                    } else if (clicked[a][b] == true) {//버튼이 한번 눌려졌을때

                                                        buttons[a][b].setImageResource(R.drawable.bt_unclick);//다시 누르는 경우 이미지를 start로 전환
                                                        --num;
                                                        setview.setText(String.valueOf(num) + " 명");
                                                        totalpay();
                                                        clicked[a][b] = false;
                                                        //count = 0; //count를 초기화시켜 다음 클릭시 다시 if문으로 돌아갈 수 있도록 함.
                                                        switch (b) {
                                                            default:
                                                                Toast.makeText(getApplicationContext(), "선택 취소", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                            }
                                            break;
                                        case 5:
                                            switch (b) {
                                                default:
                                                    if (clicked[a][b] == false) { //count가 0이면, 즉 한번도 눌리지 않았으면
                                                        buttons[a][b].setImageResource(R.drawable.bt_click); //눌렸을때 이미지를 stop으로 전환
                                                        ++num;
                                                        setview.setText(String.valueOf(num) + " 명");
                                                        totalpay();


                                                        Toast.makeText(getApplicationContext(), "F열 " + b + "번 좌석입니다.", Toast.LENGTH_SHORT).show();
                                                        clicked[a][b] = true;
                                                    } else if (clicked[a][b] == true) {//버튼이 한번 눌려졌을때

                                                        buttons[a][b].setImageResource(R.drawable.bt_unclick);//다시 누르는 경우 이미지를 start로 전환
                                                        --num;
                                                        setview.setText(String.valueOf(num) + " 명");
                                                        totalpay();
                                                        clicked[a][b] = false;
                                                        //count = 0; //count를 초기화시켜 다음 클릭시 다시 if문으로 돌아갈 수 있도록 함.
                                                        switch (b) {
                                                            default:
                                                                Toast.makeText(getApplicationContext(), "선택 취소", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                            }
                                            break;
                                    }

                                }
                            }
                        }

                    }
                });
            }
        }

    }

    public void totalpay() {
        pay = num * 10000;
        payview.setText(String.valueOf(pay) + " 원");

    }

    public void paying(View view) {


    }
}

