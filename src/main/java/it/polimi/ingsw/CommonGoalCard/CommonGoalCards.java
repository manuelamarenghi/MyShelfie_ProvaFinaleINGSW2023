package it.polimi.ingsw.CommonGoalCard;

import it.polimi.ingsw.Library;
import it.polimi.ingsw.Player;

public interface CommonGoalCards {
    public boolean check(Library library);
    public boolean expired(Library library);
    public void getImage();

}
