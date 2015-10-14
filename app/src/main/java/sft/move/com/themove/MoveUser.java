package sft.move.com.themove;

import com.parse.ParseClassName;
import com.parse.ParseUser;

/**
 * Created by De'Rio on 10/3/2015.
 */
@ParseClassName("_User")
public class MoveUser extends ParseUser {

    private static final String MOVEUSER_AGE = "Age";
    private static final String MOVEUSER_MUSICPREF ="MusicPref";

    private  int age;
    private  String college;


    public MoveUser(){

    }

    public MoveUser(String username, String password){

        this.setPassword(password);
        this.setUsername(username);
    }

    public MoveUser(String username, String password,String email,int age, String College){
        this.setEmail(email);
        this.setPassword(password);
        this.setUsername(username);
        this.put(MOVEUSER_AGE,age);

    }

    @Override
    public String toString() {
        return "ParseUser=[College:"+
                college+"][Age="+
                age+"][Username="+
                getUsername()+"]";
    }
}
