package it.polimi.ingsw;

import java.util.ArrayList;

public class PlayerManager {

    public void notifyAllObservers(Player player){

        for(Observer observer: player.getObservers())
        {
            if(observer.update(player))
                player.removeObserver(observer);
        }

    }

}
