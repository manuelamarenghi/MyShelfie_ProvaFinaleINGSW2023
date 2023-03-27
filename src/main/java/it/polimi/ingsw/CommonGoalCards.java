package it.polimi.ingsw;

<<<<<<< HEAD
public interface CommonGoalCards {
    public boolean check();
    public boolean expiered();
=======
import it.polimi.ingsw.Library;

public interface CommonGoalCards {
    public boolean check(Library library);
    public boolean expired(Player player);
>>>>>>> faa7c6a (Start implementation of CGC with EightEqualsCards)
    public void getImage();
}
