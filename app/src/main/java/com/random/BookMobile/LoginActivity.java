package com.random.BookMobile;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.random.BookMobile.R;
/**
 *  remember to import the database
 */

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    private final String TAG = "LoginActivity";
    private Button mRegisterBtn;
    private Button mLoginBtn;
    private EditText mUsername;
    private EditText mPassword;

    private static String mCurrentUsername;
    private static String mCurrentPassword;
    private static String mCurrentEmail;
    private static String mCurrentAvatar;
    private static int mCurrentAvatarChoice;

    private static int mCurrentUserID;
    /**
     * Id to identity READ_CONTACTS permission request.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mRegisterBtn = findViewById(R.id.registerButton);
        mLoginBtn = findViewById(R.id.loginButton);
        mUsername = findViewById(R.id.usernameLogin);
        mPassword = findViewById(R.id.passwordLogin);


        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpRegisterIntent = new Intent(getBaseContext(), RegistrationActivity.class);
                startActivity(jumpRegisterIntent);
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsername.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                validateUser(username, password);
            }
        });
    }
    private void validateUser(String username, String password){
        Log.d(TAG, "Login button is clicked");

                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent loginSuccessIntent = new Intent(this, MainActivity.class);
                    startActivity(loginSuccessIntent);



    }



    public static String getUsername(){
        return mCurrentUsername;
    }

    public static String getPassword(){
        return mCurrentPassword;
    }

    public static int getAvatarChoice(){return mCurrentAvatarChoice;}

    public static String getEmail(){return mCurrentEmail;}

    public static int getUserID(){return mCurrentUserID;}


    private static void updateEmail(String email){
        mCurrentEmail = email;
    }
    private static void updateAvatar(int Avatar){
        mCurrentAvatarChoice = Avatar;
    }

}
