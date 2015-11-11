package sft.move.com.themove;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by De'Rio on 10/21/2015.
 */
public class App extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "FewEue7br14gf1yPQi6xn79zAFXmU7ceSSIJjF0D", "QUera4MIlcLPs1SVoZXgH43g5sS0qOx5ARl1PWAP");


    }

}
