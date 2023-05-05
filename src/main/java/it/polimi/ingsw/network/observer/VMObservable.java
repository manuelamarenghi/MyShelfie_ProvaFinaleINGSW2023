package it.polimi.ingsw.network.observer;

import java.util.ArrayList;
import java.util.function.Consumer;

public class VMObservable {
    protected final ArrayList<VMObserver> observers = new ArrayList<>();


    /**
     * add an observer
     * @param observer observer that is added
     */
    public void addObserver(VMObserver observer){
        observers.add(observer);
    }

    /**
     * remove an observer from list
     * @param observer observer to be removed
     */
    public void removeObserver(VMObserver observer){
        observers.remove(observer);
    }

    /**
     * adds more than one observer
     * @param obs arraylist of observers to be added
     */
    public void addAllObservers(ArrayList<VMObserver> obs){
        this.observers.addAll(obs);
    }
    /**
     * notify all the observers
     * @param lambda to be applied on the observer
     */
    public void notifyObserver(Consumer<VMObserver> lambda){
        for(VMObserver observer : observers){
            lambda.accept(observer);
        }
    }
}
