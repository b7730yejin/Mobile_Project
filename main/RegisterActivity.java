package com.example.lee.movie;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private EditText reg_email_field;
    private EditText reg_pass_field;
    private EditText reg_confirm_field;
    private Button reg_btn;
    private ProgressBar reg_progress;

    private FirebaseAuth mAuth;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        reg_email_field = (EditText) findViewById(R.id.reg_email);
        reg_pass_field = (EditText) findViewById(R.id.reg_pass);
        reg_confirm_field = (EditText) findViewById(R.id.reg_confirm);
        reg_btn = (Button) findViewById(R.id.reg_btn);
        reg_progress = (ProgressBar) findViewById(R.id.reg_progress);

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = reg_email_field.getText().toString();
                String pass = reg_pass_field.getText().toString();
                String confirm_pass = reg_confirm_field.getText().toString();

                if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass) && !TextUtils.isEmpty(confirm_pass)){
                    if(pass.equals(confirm_pass)){
                        createUser(email, pass);
                    }
                    else {
                        Toast.makeText(RegisterActivity.this, "비밀번호가 일치하지 않습니다!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private void writeNewUser(String str, String email, String nowDate){

    }
    // 회원가입
    private void createUser(final String email, String password) {
        reg_progress.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 회원가입 성공
                            Toast.makeText(RegisterActivity.this, R.string.success_signup, Toast.LENGTH_SHORT).show();
                            String strs[] = email.split("@");
                           // writeNewUser(strs[0], email, nowDate);
                            sendToLogin();
                        } else {
                            // 회원가입 실패
                            Toast.makeText(RegisterActivity.this, R.string.failed_signup, Toast.LENGTH_SHORT).show();
                        }
                        reg_progress.setVisibility(View.INVISIBLE);
                    }
                });
    }
    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            sendToLogin();
        }
    }

    private void sendToLogin() {

        Intent mainIntent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(mainIntent);
        finish();
    }
}
