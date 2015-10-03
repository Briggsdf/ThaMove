package sft.move.com.themove;

import com.parse.*;

import java.util.List;

/**
 * Created by De'Rio on 9/24/2015.
 */
@ParseClassName("MoveVenue")
public abstract class MoveVenue extends ParseObject {

    private String venueName;
    private List<String> venueEvents;


}
