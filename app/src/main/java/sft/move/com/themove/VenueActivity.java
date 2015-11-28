package sft.move.com.themove;

import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseException;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VenueActivity extends AppCompatActivity {

    private ImageView venueBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue);
        String venueName = getIntent().getStringExtra("venueName");
        venueBanner = (ImageView)findViewById(R.id.v_pic);
        ParseQuery query = new ParseQuery("MoveVenue");

        query.whereEqualTo("Name", venueName);
        query.findInBackground(new com.parse.FindCallback<ParseObject>() {

            public void done(List<ParseObject> objects, com.parse.ParseException e) {
                if (e == null) {
                    ParseFile moveImage = objects.get(0).getParseFile("Picture");
                    String imageURL = moveImage.getUrl();
                    Uri moveImageUri = Uri.parse(imageURL);
                    try {
                        Picasso.with(getApplicationContext()).load(moveImageUri).into(venueBanner);
                    } catch (Exception se) {
                        new Toast(getApplicationContext()).makeText(getApplicationContext(),se.getMessage(),Toast.LENGTH_LONG).show();
                    }
                } else {
                    Log.d("Brand", "Error: " + e.getMessage());
                }

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_venue, menu);
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
