package com.suek.ex13alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //  8)
    EditText et;              //뷰를 참조할때는 무조건 멤버변수 만들어주기 *******
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickBtn(View view) {
        // 1) AlertDialog 를  만들어주는 건축가(Builder 라는 클래스)객체 생성
        //    건축가(Builder)에게 요청(set)함- 뭐를? ex; set.positive.. set.negative..set.neutral..
        AlertDialog.Builder builder= new AlertDialog.Builder(this);   //여기서 .Builders 는 빌더의 참조변수(AlertDialog 의 참조변수가 아님)

        // 2) 건축가에게 만들고자 하는 AlertDialog 의 제목과 아이콘
        builder.setTitle("Dialog Title");   //제목을 '빌더'에 세팅함
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        // 3) 다이얼로그에 보일 메세지 설정
        //builder.setMessage("Do you want to Exit?");





        // 6/7) 다이얼로그에 보일 '커스텀뷰' 설정
        //    XML 에 뷰의 모양을 설계하고 이를 객체로 생성하여 다이얼로그에 설정  --> dialog.xml
        //    res/layout/dialog.xml 를 자바의 View 객체로 만들어주는 객체(LayoutInflater)소환
        LayoutInflater inflater= this.getLayoutInflater();   //여기서 this 는 MainActivity 임
        View v= inflater.inflate(R.layout.dialog, null);    //여기서 v 가 LinearLayout 을 참조하는 참조변수
                                                                 //**** dialog 안에 v(LinearLayout)안에 EditText(et), Button(), TextView(tv) 가 있음.


        // 9) 만들어진 v(LinearLayout)에게 안에있는 EditText, TextView 를 찾아달라고..
        //id를 이용해서 뷰를 찾아와 참조변수 대입
        et= v.findViewById(R.id.et);      //여기서 v는 LinearLayout
        tv= v.findViewById(R.id.tv);

        builder.setView(v);




        // 4) 다이얼로그에 붙을 버튼달기
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {     //onClick= 익명클래스
                // OK 이 버튼이 눌러졌을때 자동으로 실행되는 메소드
                // OK 버튼 누르고 메세지로 눌렀다고 토스트메세지 하나 띄우기
                Toast t= Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT);  //this 라고 만쓰면 onClick 이 익명클래스여서
                t.show();
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast t= Toast.makeText(MainActivity.this, "CANCEL", Toast.LENGTH_SHORT);
                t.show();
            }
        });







        // 5) 건축가에게 요구사항을 모두 설정했으니..
        //    이 요구사항대로 AlertDialog 를 만들어 달라고 요청
        AlertDialog dialog= builder.create();        //다이얼로그가 만들어짐


        // 다이얼로그의 바깥쪽을 터치했을때 다이얼로그가 사라지는 여부 설정
        dialog.setCanceledOnTouchOutside(false);    //false 를 해주면 바깥쪽을 눌러도 다이얼로그가 안꺼짐 하지만, 뒤로가기 버튼을 누르면 꺼짐
        dialog.setCancelable(false);   //뒤도가기 버튼으로도 꺼지지 않도록...
                                       //(dialog.setCancelable(false);를 쓰면 굳이 dialog.setCanceledOnTouchOutside(false); 안써도됨)

        // 만들어진 다이얼로그를 화면에 보이기
        dialog.show();

    }//clickBtn method...




    // 6/7)  다이얼로그 안에 있는 커스텀뷰 안에 있는 Button 을 클릭했을때 실행되는 메소드--> dialog.xml
    public void clickDialogBtn(View v){
        // 10) EditText 에 있는 글씨를 얻어오기
        String s=et.getText().toString();

        // 10) 얻어온 글씨를 TextView 에 보이기
        tv.setText(s);
    }

}//MainActivity class...
