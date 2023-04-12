package it.polimi.ingsw.message;

import it.polimi.ingsw.modello.Player;

public abstract  class Message {
    protected Player nickname;
    protected String payload;

    public String getPayload() {
        return payload;
    }
    public Player getNickname() {
        return nickname;
    }
    /**
     * set each specific payload based on override made in a subclass
     * @param s
     */
    abstract void setPayload(String s);
    /**
     * redirectAnswer() let clientHandler "find" method to handle this request
     */
    abstract void redirectAnswer();
}
