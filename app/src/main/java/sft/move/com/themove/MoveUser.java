package sft.move.com.themove;

import com.parse.ParseUser;

/**
 * Created by De'Rio on 10/3/2015.
 */
public class MoveUser extends ParseUser {

    int age;
    String college;


    public MoveUser(){

    }

    public MoveUser(String username, String password){

        this.setPassword(password);
        this.setUsername(username);

    }

    public MoveUser(String username, String password,int age, String College){

        this.setPassword(password);
        this.setUsername(username);

    }

    @Override
    public String toString() {
        return "ParseUser=[College:"+
                college+"][Age="+
                age+"][Username="+
                getUsername()+"]";
    }
}
