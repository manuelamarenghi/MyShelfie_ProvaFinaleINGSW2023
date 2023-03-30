package it.polimi.ingsw;

import it.polimi.ingsw.Library;

public interface CommonGoalCards {
     boolean check(Library library);
     boolean expired(Library library);
     void getImage();

}
