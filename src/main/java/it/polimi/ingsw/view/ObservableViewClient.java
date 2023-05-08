package it.polimi.ingsw.view;

import it.polimi.ingsw.network.observer.VMObserver;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ObservableViewClient {
    protected final ArrayList<ObserverViewClient> observers = new ArrayList<>();


    /**
     * add an observer
     * @param observer observer that is added
     */
    public void addObserver(ObserverViewClient observer){
        observers.add(observer);
    }

    /**
     * remove an observer from list
     * @param observer observer to be removed
     */
    public void removeObserver(ObserverViewClient observer){
        observers.remove(observer);
    }

    /**
     * adds more than one observer
     * @param obs arraylist of observers to be added
     */
    public void addAllObservers(ArrayList<ObserverViewClient> obs){
        this.observers.addAll(obs);
    }
    /**
     * notify all the observers
     * @param lambda to be applied on the observer
     */
    public void notifyObserver(Consumer<ObserverViewClient> lambda){
        for(ObserverViewClient observer : observers){
            lambda.accept(observer);
        }
    }
}
