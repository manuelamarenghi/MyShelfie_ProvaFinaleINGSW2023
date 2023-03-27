package it.polimi.ingsw.CommonGoalCard;

import it.polimi.ingsw.Library;
import it.polimi.ingsw.Player;

public interface CommonGoalCards {
    public boolean check(Library library);
    public void expired(Player player);
    public void getImage();

}
