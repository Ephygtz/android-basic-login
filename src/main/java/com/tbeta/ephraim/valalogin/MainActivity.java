package com.tbeta.ephraim.valalogin;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button LoginBtn, cancelBtn;
    EditText username, pass;
    TextView attempts;
    int counter = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginBtn = (Button) findViewById(R.id.loginBtn);
        cancelBtn = (Button) findViewById(R.id.cancelBtn);
        username = (EditText) findViewById(R.id.inputUserName);
        pass = (EditText) findViewById(R.id.inputPassword);
        attempts = (TextView) findViewById(R.id.attemptsLeft);
        attempts.setVisibility(View.INVISIBLE);

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") &&
                        pass.getText().toString().equals("password")){
                    Toast.makeText(MainActivity.this, "Login successfull, redirecting...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong username 0r Password", Toast.LENGTH_SHORT).show();
                    attempts.setVisibility(View.VISIBLE);
                    attempts.setBackgroundColor(Color.RED);
                    counter--;
                    attempts.setText(Integer.toString(counter));

                    if(counter == 0){
                        LoginBtn.setEnabled(false);
                    }
                }
            }

        });
    }
}











