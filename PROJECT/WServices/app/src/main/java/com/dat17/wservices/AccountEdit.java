package com.dat17.wservices;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class AccountEdit extends AppCompatActivity implements AsyncResponse {

    TextView txtUsername;
    EditText edtPassword, edtEmail,edtImageURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_edit);
        txtUsername = (TextView) findViewById(R.id.txtUsername);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtImageURL=(EditText)findViewById(R.id.edtImageURL);

        Bundle bundle = getIntent().getExtras();
//        String[] account = bundle.getString("account").split(" - ");
        txtUsername.setText(bundle.getString("username"));
        edtPassword.setText(bundle.getString("password"));
        edtEmail.setText(bundle.getString("email"));
        edtImageURL.setText(bundle.getString("imgURL"));
    }

    public void updateAccount(View view) {
        String username = txtUsername.getText().toString();
        String password = edtPassword.getText().toString();
        String email = edtEmail.getText().toString();
        String imageURL=edtImageURL.getText().toString();

        HashMap dataPost = new HashMap();
        dataPost.put("action","update");
        dataPost.put("txtUsername", username);
        dataPost.put("edtPassword", password);
        dataPost.put("edtEmail", email);
        dataPost.put("imageURL",imageURL);


        PostResponseAsyncTask asyncTask = new PostResponseAsyncTask(this, dataPost);
        asyncTask.execute("http://devmobile.club/services/index.php");
//        finish();
    }

    public void deleteAccount() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Delete this account ?");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String username = txtUsername.getText().toString();
                HashMap dataPost = new HashMap();
                dataPost.put("action","delete");
                dataPost.put("txtUsername", username);
                PostResponseAsyncTask asyncTask = new PostResponseAsyncTask(AccountEdit.this, dataPost);
                asyncTask.execute("http://devmobile.club/services/index.php");
//                finish();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }

    @Override
    public void processFinish(String s) {
        if (s.equals("update_success")) {
            Toast.makeText(AccountEdit.this, "Update success.", Toast.LENGTH_SHORT).show();
        }
        if (s.equals("delete_success")) {
            Toast.makeText(AccountEdit.this, "Delete success.", Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mnu_account, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itmDelete:
                deleteAccount();
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}
