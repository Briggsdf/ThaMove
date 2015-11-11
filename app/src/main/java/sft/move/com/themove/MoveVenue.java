package sft.move.com.themove;

import com.parse.*;
import com.squareup.picasso.Picasso;

import java.util.List;
/**
 * Created by De'Rio on 9/24/2015.
 */
@ParseClassName("MoveVenue")
public  class MoveVenue extends ParseObject {

    private static final String MOVEVENUE_NAME = "Name";
    private static final String MOVEVENUE_DRESSCODE = "DressCode";
    private static final String MOVEVENUE_PICTURE = "Picture";

    private String venueName;
    private List<String> venueEvents;
    private Boolean dressCode;
    private ParseFile venuePicture;
    private int movePoints;

    public MoveVenue(ParseObject po){
        venuePicture = po.getParseFile(MOVEVENUE_PICTURE);
        venueName = po.getString(MOVEVENUE_NAME);


    }

    public  MoveVenue(){

    }

    public Boolean getDressCode() {

        return this.getBoolean(MOVEVENUE_DRESSCODE);
    }

    public void setDressCode(Boolean dressCode) {
        this.put(MOVEVENUE_DRESSCODE,dressCode);
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.put(MOVEVENUE_NAME, venueName);
    }

    public List<String> getVenueEvents() {
        return venueEvents;
    }

    public void setVenueEvents(List<String> venueEvents) {
        this.venueEvents = venueEvents;
    }

    public ParseFile getVenuePicture() {
        return venuePicture;
    }

    public void setVenuePicture(ParseFile venuePicture) {
        this.put(MOVEVENUE_PICTURE,venuePicture);
    }
}
