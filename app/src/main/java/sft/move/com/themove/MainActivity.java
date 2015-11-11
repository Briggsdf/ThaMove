package sft.move.com.themove;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  RecyclerView rv;

    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv =  (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());

        rv.setLayoutManager(llm);




        ParseObject.registerSubclass(MoveVenue.class);

        final List<MoveVenue> moveVenues = new ArrayList<MoveVenue>();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("MoveVenue");

        query.findInBackground(new FindCallback<ParseObject>() {
                                   public void done(List<ParseObject> objects, ParseException e) {
                                       if (e == null) {
                                           for (ParseObject po : objects) {
                                               MoveVenue moveVenue = new MoveVenue(po);
                                               moveVenues.add(moveVenue);

                                           }
                                           final   MoveAdapter adapter = new MoveAdapter(moveVenues,getApplicationContext());

                                           rv.setAdapter(adapter);
                                           rv.addOnItemTouchListener(
                                                   new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                                                       @Override
                                                       public void onItemClick(View view, int position) {
                                                           MoveAdapter.MoveViewHolder mT= (MoveAdapter.MoveViewHolder)view.getTag();
                                                           Intent venueActivityIntent = new Intent(getApplicationContext(), VenueActivity.class);
                                                           venueActivityIntent.putExtra("venueName", mT.venueName.getText().toString());
                                                         //  BitmapDrawable bitmapDrawable = ((BitmapDrawable) mT.moveIV.getDrawable());
                                                          // Bitmap bitmap = bitmapDrawable .getBitmap();
                                                          // ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                                          // bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                                                          // byte[] imageInByte = stream.toByteArray();
                                                          // venueActivityIntent.putExtra("venuePicture", imageInByte);

                                                           startActivity(venueActivityIntent);
                                                       }
                                                   })
                                           );
                                       } else {
                                           Log.d("ParseError For services", e.getMessage());
                                           Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                                       }

                                   }
                               }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
