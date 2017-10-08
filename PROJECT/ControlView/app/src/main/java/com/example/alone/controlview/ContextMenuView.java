package com.example.alone.controlview;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ContextMenuView extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_view);
        getSupportActionBar().setTitle("Context Menu");

        Button btFIT=(Button)findViewById(R.id.btFIT);
        registerForContextMenu(btFIT);
        Button btUTEHY=(Button)findViewById(R.id.btUTEHY);
        registerForContextMenu(btUTEHY);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId())
        {
            case R.id.btFIT:
                getMenuInflater().inflate(R.menu.fit,menu);
                break;
            case R.id.btUTEHY:
                getMenuInflater().inflate(R.menu.utehy,menu);
                break;
        }

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AlertDialog.Builder al=new AlertDialog.Builder(ContextMenuView.this);
        al.setTitle("Context Menu");
        switch(item.getItemId())
        {
            case R.id.itemCNDD:
                al.setMessage("Ban chon Cong nghe di dong");
                break;
            case R.id.itemCNWEB:
                al.setMessage("Ban chon Cong nghe Web");
                break;
            case R.id.itemNhung:
                al.setMessage("Ban chon Cong nghe Nhung");
                break;
            case R.id.itemTester:
                al.setMessage("Ban chon Kiem thu phan mem");
                break;
            case R.id.itemMang:
                al.setMessage("Ban chon Mang may tinh");
                break;


            case R.id.itemCNTT:
                al.setMessage("Ban chon KHOA CONG NGHE THONG TIN");
                break;
            case R.id.itemMay:
                al.setMessage("Ban chon KHOA CONG NGHE MAY");
                break;
            case R.id.itemNgoaiNgu:
                al.setMessage("Ban chon KHOA NGOAI NGU");
                break;
            case R.id.itemKinhTe:
                al.setMessage("Ban chon KHOA KINH TE");
                break;
        }
        al.create().show();
        return  true;
    }
}
