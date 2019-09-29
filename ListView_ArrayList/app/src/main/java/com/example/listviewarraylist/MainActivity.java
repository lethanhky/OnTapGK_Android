package com.example.listviewarraylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<NhanVien> arrNhanvien = null;
    MyArrayAdapter adapter = null;
    ListView lvNhanvien = null;
    Button btnNhap;
    ImageButton btnRemoveAll;
    EditText txtMa, txtTen;
    RadioGroup genderGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNhap = (Button)findViewById(R.id.button);
        btnRemoveAll = (ImageButton)findViewById(R.id.imageButton);
        txtMa = (EditText) findViewById(R.id.txtId);
        txtTen = (EditText)findViewById(R.id.txtName);
        genderGroup = (RadioGroup)findViewById(R.id.rdg_gioitinh);

        lvNhanvien = (ListView)findViewById(R.id.lsv_danhsach);
        arrNhanvien = new ArrayList<NhanVien>();
        adapter = new MyArrayAdapter(this,R.layout.my_item_layout,arrNhanvien);
        lvNhanvien.setAdapter(adapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ma = txtMa.getText() + "";
                String ten = txtTen.getText() + "";
                boolean giotinh = false;
                if(genderGroup.getCheckedRadioButtonId() == R.id.radioButton){
                    giotinh = true;
                }
                NhanVien nv = new NhanVien();
                nv.setId(ma);
                nv.setName(ten);
                nv.setGender(giotinh);

                arrNhanvien.add(nv);
                adapter.notifyDataSetChanged();
                txtMa.setText("");
                txtMa.setText("");
                txtMa.requestFocus();
            }
        });

        btnRemoveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = lvNhanvien.getChildCount() - 1; i >= 0 ;i--)
                {
                    View v = lvNhanvien.getChildAt(i);
                    CheckBox chk = (CheckBox)v.findViewById(R.id.chk_item);
                    if(chk.isChecked()){
                        arrNhanvien.remove(i);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });


    }
}
