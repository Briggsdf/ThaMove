package sft.move.com.themove;

import com.parse.*;
import com.squareup.picasso.Picasso;

import java.util.List;
/**
 * Created by De'Rio on 9/24/2015.
 */
@ParseClassName("MoveVenue")
public abstract class MoveVenue extends ParseObject {

    private static final String MOVEVENUE_NAME = "Name";
    private static final String MOVEVENUE_DRESSCODE = "DressCode";
    private static final String MOVEVENUE_PICTURE = "Picture";

    private String venueName;
    private List<String> venueEvents;
    private Boolean dressCode;
    private ParseFile venuePicture;

    public Boolean getDressCode() {

        return this.getBoolean(MOVEVENUE_DRESSCODE);
    }

    public void setDressCode(Boolean dressCode) {
        this.put(MOVEVENUE_DRESSCODE,dressCode);
    }

    public String getVenueName() {
        return this.getString(MOVEVENUE_NAME);
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
        return this.getParseFile(MOVEVENUE_PICTURE);
    }

    public void setVenuePicture(ParseFile venuePicture) {
        this.put(MOVEVENUE_PICTURE,venuePicture);
    }
}
