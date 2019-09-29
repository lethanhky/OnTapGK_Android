package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.mi12B:
                break;
            case R.id.mi12A:
                break;
            case 113:
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        int itemID = 113;
        menu.add(0,itemID,0,"   DHKTPM12BTT");
        return  true;
    }
}
