package com.dat17.wservices;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

/**
 * A login screen that offers login via email/password.
 */
public class Register extends AppCompatActivity implements OnClickListener, AsyncResponse {


    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordConfirm;
    private EditText mPasswordView;
    private EditText mUsernameView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupActionBar();
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.edtEmail);

        mPasswordView = (EditText) findViewById(R.id.edtPassword);
        mPasswordConfirm = (EditText) findViewById(R.id.edtPasswordComfirm);
        mUsernameView = (EditText) findViewById(R.id.edtUsername);

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(this);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setupActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        String username = mUsernameView.getText().toString();
        String password = mPasswordView.getText().toString();
        String passwordConfirm = mPasswordConfirm.getText().toString();
        String email = mEmailView.getText().toString();
        if (username.equals("")) {
            Toast.makeText(Register.this, "Please enter you username.", Toast.LENGTH_SHORT).show();
        } else {
            if (password.equals("")) {
                Toast.makeText(Register.this, "Please enter you password.", Toast.LENGTH_SHORT).show();
            } else {
                if (passwordConfirm.equals("")) {
                    Toast.makeText(Register.this, "Please enter you password.", Toast.LENGTH_SHORT).show();
                } else {
                    if (!password.equals(passwordConfirm)) {
                        Toast.makeText(Register.this, "Check again password confirm", Toast.LENGTH_SHORT).show();
                    } else {
                        if (email.equals("")) {
                            Toast.makeText(Register.this, "Please enter you email.", Toast.LENGTH_SHORT).show();
                        } else {
                            HashMap dataPost = new HashMap();
                            dataPost.put("action","register");
                            dataPost.put("edtUsername", username);
                            dataPost.put("edtPassword", password);
                            dataPost.put("edtEmail", email);
							dataPost.put("imageURL","http://trongdat.info/image/java.jpg");
							
                            PostResponseAsyncTask asyncTask = new PostResponseAsyncTask(this, dataPost);
                            asyncTask.execute("http://devmobile.club/services/index.php");
                        }
                    }
                }
            }
        }
    }

    @Override
    public void processFinish(String s) {
        if (s.equals("register_success")) {
            Toast.makeText(Register.this, "Signup is success.", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(Register.this,AccountList.class);
            intent.putExtra("username",mUsernameView.getText().toString());
            startActivity(intent);
        } else {
            if (s.equals("exists"))
                Toast.makeText(Register.this, "Username is exists.", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(Register.this, "Error.", Toast.LENGTH_SHORT).show();
        }
    }
}

