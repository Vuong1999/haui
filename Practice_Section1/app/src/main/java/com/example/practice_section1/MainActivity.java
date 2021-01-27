package com.example.practice_section1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText editTen,editCMND,editBoSung;
    CheckBox chk_docbao,chk_docsach,chk_doccode;
    Button btn_GuiTT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Lấy các điều khiển trên giao diện
        editTen = (EditText) findViewById(R.id.editTen);
        editCMND = (EditText) findViewById(R.id.editCMND);
        editBoSung = (EditText) findViewById(R.id.editBoSung);
        chk_docbao = (CheckBox) findViewById(R.id.chkdocbao);
        chk_docsach = (CheckBox) findViewById(R.id.chkdocsach);
        chk_doccode = (CheckBox) findViewById(R.id.chkdoccode);
        btn_GuiTT = (Button) findViewById(R.id.btnGuiTT);

        btn_GuiTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                doShowInformation();
            }
        });
    }
    public  void  doShowInformation() {
        //Kiểm tra tên hợp lệ
        String ten = editTen.getText() +"";
        ten = ten.trim();
        if (ten.length() < 3) {
            editTen.requestFocus();
            editTen.selectAll();
            Toast.makeText(this, "Tên phải >= 3 ký tự", Toast.LENGTH_LONG).show();
            return;
        }
        //kiểm tra CMND hợp lệ
        String cmnd = editCMND.getText() +"";
        cmnd = cmnd.trim();
        if (cmnd.length() != 9) {
            editCMND.requestFocus();
            editCMND.selectAll();
            Toast.makeText(this, "CMND phải đúng 9 ký tự", Toast.LENGTH_LONG).show();
            return;
        }
        //Kiểm tra bằng cấp
        String bang="";
        RadioGroup group=(RadioGroup) findViewById(R.id.radioGroup1);
        int id=group.getCheckedRadioButtonId();
        if(id==-1)
        {
            Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_LONG).show();
            return;
        }
        RadioButton rad=(RadioButton) findViewById(id);
        bang=rad.getText()+"";
        //Kiểm tra sở thích nối lại thành 1 xâu
        String sothich="";
        if(chk_docbao.isChecked())  sothich+=chk_docbao.getText()+"\n";
        if(chk_docsach.isChecked())  sothich+=chk_docsach.getText()+"\n";
        if(chk_doccode.isChecked())  sothich+=chk_doccode.getText()+"\n";

        String editBosung=editBoSung.getText()+"";
        //hiển thị dialog
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        //tạo nội dung
        String msg=ten+"\n";
        msg+= cmnd+"\n";
        msg+=bang+"\n";
        msg+=sothich;
        msg+="—————————–\n";
        msg+="Thông tin bổ sung:\n";
        msg+=editBosung+ "\n";
        msg+="—————————–";
        builder.setMessage(msg);//thiết lập nội dung
        builder.create().show();//hiển thị Dialog
    }
}