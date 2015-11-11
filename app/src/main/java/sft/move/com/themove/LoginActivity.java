package sft.move.com.themove;

import android.content.Context;
import android.content.Intent;
import android.location.GpsSatellite;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.squareup.picasso.Picasso;

import java.text.ParseException;

public class LoginActivity extends AppCompatActivity {

    private EditText etPassword;
    private EditText etUsername;
    private Button btnRegister;
    private Button btnLogin;
    private MoveUser mv;


    public void goToRegisterScreen(View v){
        Intent registerScreenIntent = new Intent(this, RegisterActivity.class);
        startActivity(registerScreenIntent);


    }

    public void loginMoveUser(View v){
        String password = MoveHelper.getStringFromEditText(etPassword);
        String username = MoveHelper.getStringFromEditText(etUsername);
        mv= new MoveUser();
        if(password==null||username==null){
           Toast t = Toast.makeText(this,"Username/Password cannot be blank",Toast.LENGTH_SHORT);
            t.show();
        }
        else{
            mv.logInInBackground(username, password, new LogInCallback(){
                @Override
                public void done(ParseUser user, com.parse.ParseException e) {
                    if (e == null && user != null) {
                        Intent mainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(mainActivityIntent);
                        finish();
                    } else if (user == null) {
                        Toast t = Toast.makeText(getApplicationContext(),"Username or Password is Invalid, please re-enter your credentials!",Toast.LENGTH_SHORT);
                        t.show();
                    } else {
                        Toast t = Toast.makeText(getApplicationContext(),"Error: "+e.getLocalizedMessage(),Toast.LENGTH_SHORT);
                        t.show();
                    }
                }
            });
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ParseUser.registerSubclass(MoveUser.class);
        etUsername =(EditText)findViewById(R.id.etUsername);
        etPassword =(EditText)findViewById(R.id.etPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnRegister = (Button)findViewById(R.id.btnRegister);

         if( ParseUser.getCurrentUser()!=null){
             Intent mainActivityIntent = new Intent(this, MainActivity.class);
             startActivity(mainActivityIntent);
             finish();

         }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
