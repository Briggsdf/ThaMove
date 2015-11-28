package sft.move.com.themove;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseFile;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by De'Rio on 10/18/2015.
 */
public class MoveAdapter extends RecyclerView.Adapter<MoveAdapter.MoveViewHolder> {

    List<MoveVenue> moveVenues;
    Context context;

    MoveAdapter(List<MoveVenue>moveVenues,Context context){
        this.moveVenues = moveVenues;
        this.context = context;

    }

    public static class MoveViewHolder extends RecyclerView.ViewHolder  {
        CardView cv;
        TextView venueName;
        ImageView moveIV;


        MoveViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.card_view);
            venueName = (TextView) itemView.findViewById(R.id.venue_text);
            moveIV = (ImageView) itemView.findViewById(R.id.venue_pic);
            itemView.setTag(this);
        }
 
    }

    @Override
    public MoveViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.move_cv, viewGroup, false);
        MoveViewHolder moveViewHolder = new MoveViewHolder(v);
        return moveViewHolder;
    }




    public void onBindViewHolder(MoveViewHolder moveViewHolder, int i) {
       if(moveVenues.get(i).getVenueName()!=null){
            moveViewHolder.venueName.setText(moveVenues.get(i).getVenueName());

       }

        if(moveVenues.get(i).getVenuePicture()!=null){
            ParseFile moveImage = moveVenues.get(i).getVenuePicture();
            String imageURL = moveImage.getUrl();
            Uri moveImageUri = Uri.parse(imageURL);
            try {
                Picasso.with(context).load(moveImageUri).into(moveViewHolder.moveIV);
            } catch (Exception e) {
                new Toast(context).makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount(){
        return moveVenues.size();

    }
    
}
