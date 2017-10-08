package com.example.alone.review;

import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TabHost;

public class Tab_Review extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab__review);
        TabHost tabHost=(TabHost)findViewById(R.id.tabHost);

        tabHost.setup();
        TabHost.TabSpec spec;

        spec=tabHost.newTabSpec("t1");
        spec.setContent(R.id.TABL1);
        spec.setIndicator("LOGIN");
        tabHost.addTab(spec);

        spec=tabHost.newTabSpec("t2");
        spec.setContent(R.id.TABL2);
        spec.setIndicator("HISTORY");
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
    }

    public void login(View view)
    {
        EditText edtUser,edtPassword;
        edtUser=(EditText)findViewById(R.id.edtUser);
        edtPassword=(EditText)findViewById(R.id.edtPass);

        String user=edtUser.getText().toString();
        String password=edtPassword.getText().toString();

        AlertDialog.Builder al=new AlertDialog.Builder(this);
        al.setTitle("Login");
        if (user.equalsIgnoreCase("utehy")&&password.equals("fit"))
        {

            al.setMessage("Dang nhap thanh cong!").create().show();
        }
        else
        {
            al.setMessage("Sai thong tin!").create().show();
        }
    }
}
