package com.example.listviewarraybt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinDm;
    EditText editma,editten;
    Button btnNhap;
    ListView lvsp;
    ArrayList<Catalog> arraySpiner = new ArrayList<Catalog>();
    ArrayAdapter<Catalog> adapterSpiner = null;

    ArrayList<Products> arrayListView = new ArrayList<Products>();
    ArrayAdapter<Products> adapterListView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidgetsControl();
        addEventsForFormWidgets();
        fakeDataCatalog();
    }
    private  void getWidgetsControl()
    {
        spinDm=(Spinner)findViewById(R.id.spDanhmuc);
        editma=(EditText)findViewById(R.id.editId);
        editten=(EditText)findViewById(R.id.editName);
        btnNhap=(Button)findViewById(R.id.btnInput);
        lvsp=(ListView)findViewById(R.id.lvsanpham);
        //cau hinh spiner
        adapterSpiner =new ArrayAdapter<Catalog>(this,
                android.R.layout.simple_spinner_item,
                arraySpiner);

        adapterSpiner.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinDm.setAdapter(adapterSpiner);

        //Listview
        adapterListView=new ArrayAdapter<Products>(this,
                android.R.layout.simple_list_item_1,
                arrayListView);
        lvsp.setAdapter(adapterListView);

    }
   // Hàm giả dữ liệu, tạo 3 danh mục mặc định cho Spinner
    private void fakeDataCatalog()
    {
        Catalog cat1=new Catalog("1", "SamSung");
        Catalog cat2=new Catalog("2", "Iphone");
        Catalog cat3=new Catalog("3", "IPad");
        adapterSpiner.add(cat1);
        adapterSpiner.add(cat2);
        adapterSpiner.add(cat3);
        adapterSpiner.notifyDataSetChanged();
    }
    private void addEventsForFormWidgets()
    {
        btnNhap.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                addProductForCatalog();
            }
        });
        spinDm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                //mỗi lần chọn danh mục trong Spinner thì cập nhập ListView
                loadListProductByCatalog(arraySpiner.get(arg2));
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });

    }
    private void addProductForCatalog()
    {
        Products p=new Products();
        p.setId(editma.getText()+"");
        p.setName(editten.getText()+"");
        Catalog c= (Catalog) spinDm.getSelectedItem();
        c.addProduct(p);
        //Mỗi lần thêm xong thì cập nhập lại ListView
        loadListProductByCatalog(c);
    }
    private void loadListProductByCatalog(Catalog c)
    {
        //xóa danh sách cũ
        arrayListView.clear();
        //lấy danh sách mới từ Catalog chọn trong Spinner
        arrayListView.addAll(c.getlistProducts());
        //cập nhật lại ListView
        adapterSpiner.notifyDataSetChanged();
    }
}
