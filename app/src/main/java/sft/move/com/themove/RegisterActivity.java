package sft.move.com.themove;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {

    private EditText etUserName;
    private EditText etPassword;
    private EditText etPasswordConf;
    private EditText etEmail;
    private Button btnSignup;
    private CheckBox cbAgeCheck;

    public void signUpMoveUser(View v) {
        String username = MoveHelper.getStringFromEditText(etUserName);
        String password = MoveHelper.getStringFromEditText(etPassword);
        String passwordConf = MoveHelper.getStringFromEditText(etPasswordConf);
        String email = MoveHelper.getStringFromEditText(etEmail);
        Boolean ageCheck = cbAgeCheck.isChecked();
        if (username == null || password == null || passwordConf == null || email == null) {
            //Fields have been left blank
            Toast t = Toast.makeText(this, "Invalid submission, please make sure each field is filled.", Toast.LENGTH_SHORT);
            t.show();
        } else {
            if (ageCheck) {

                if (password.equals(passwordConf)) {
                    MoveUser mv = new MoveUser(username,password, email,18,null);
                    mv.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast t = Toast.makeText(getApplicationContext(), "Thank you for registering for The Move! Please login.", Toast.LENGTH_SHORT);
                                t.show();
                                Intent backToLoginIntent = new Intent(getApplicationContext(), LoginActivity.class);
                                backToLoginIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                startActivity(backToLoginIntent);
                            } else {
                                Toast t = Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_SHORT);
                                t.show();
                            }
                        }
                    });

                }
                else {
                    Toast t = Toast.makeText(this, "Sorry, Your passwords do not match please reenter them to continue.", Toast.LENGTH_SHORT);
                    t.show();
                }

            } else {
                //User is not of Age
                Toast t = Toast.makeText(this, "Sorry, You must be 18 or older to use this application.", Toast.LENGTH_SHORT);
                t.show();

            }

        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etUserName = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        etPasswordConf = (EditText)findViewById(R.id.etPasswordConf);
        btnSignup = (Button)findViewById(R.id.btnSignup);
        cbAgeCheck = (CheckBox)findViewById(R.id.cbAgeCheck);

    }

}
