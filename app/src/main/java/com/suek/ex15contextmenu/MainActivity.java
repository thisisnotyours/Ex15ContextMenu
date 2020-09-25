package com.suek.ex15contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 3)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 4)
        btn= findViewById(R.id.btn);


        //2)
        //액티비티에게 btn 객체를 ContextMenu 로 등록
        this.registerForContextMenu(btn);

    }//onCreate method



    // 3)  Context 메뉴로 지정된 View(btn)이 롱~클릭 되었을때
    //    보여지는 Context 의 Menu 를 만드는 작업을 하는 콜벡메소드
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        // 전달받은 Menu 객체에 MenuItem 을 추가
        // res/menu/context.xml 문서 파일을 만들어서 메뉴항목을 작성
        // 만든 xml 문서를 읽어와서 Menu 객체로 만들기(부풀리다)
        //MenuInflater menuInflater= this.getMenuInflater();  this 생략가능
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.context, menu);     //에뮬레이터에 버튼을 꾸욱 길게 눌러보기- save 와 delete 이 뜸



        super.onCreateContextMenu(menu, v, menuInfo);
    }





    // 4)  콘텍스트 메뉴의 메뉴 아이템을 선택했을때 자동으로 발동하는 콜백메소드
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int id= item.getItemId();
        switch (id){
            case R.id.menu_save:
                Toast.makeText(this, "SAVE", Toast.LENGTH_SHORT ).show();
                break;

            case R.id.menu_delete:
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    // 1)
    public void clickBtn(View view) {
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
    }
}
