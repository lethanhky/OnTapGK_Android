package com.example.menucontext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnShowContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowContext = (Button)findViewById(R.id.btnSC);
        registerForContextMenu(btnShowContext);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu,v,menuInfo);
        getMenuInflater().inflate(R.menu.my_layout_menu,menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.itemRed:
                btnShowContext.setTextColor(
                        getResources().getColor(R.color.clrred));
                break;
            case R.id.itemGreen:
                btnShowContext.setTextColor(
                        getResources().getColor(R.color.clrrgreen));
                break;
            case R.id.itemBlue:
                btnShowContext.setTextColor(
                        getResources().getColor(R.color.clrblue));
                break;
            default:
                btnShowContext.setTextColor(
                        getResources().getColor(R.color.clrred));
                break;
        }
        return super.onContextItemSelected(item);
    }
}
