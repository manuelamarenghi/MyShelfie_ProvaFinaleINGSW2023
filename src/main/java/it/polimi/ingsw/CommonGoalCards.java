package it.polimi.ingsw;

import it.polimi.ingsw.Library;

public interface CommonGoalCards {
    public boolean check(Library library);
    public boolean expired(Player player);
    public void getImage();
}