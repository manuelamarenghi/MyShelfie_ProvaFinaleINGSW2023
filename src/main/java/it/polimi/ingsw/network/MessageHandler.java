package it.polimi.ingsw.network;

import it.polimi.ingsw.message.AskNumbPlayer;
import it.polimi.ingsw.message.Message;
import it.polimi.ingsw.message.*;
import it.polimi.ingsw.modello.Match;
import it.polimi.ingsw.network.observer.Observer;
import it.polimi.ingsw.view.VirtualModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageHandler implements Observer {
    VirtualModel virtualModel;
    ExecutorService executor;
    public MessageHandler(VirtualModel virtualModel){
        this.virtualModel=virtualModel;
        executor= Executors.newSingleThreadExecutor();

    }
    @Override
    public void update(Message message) {
        message.visit(this);
    }

    /**
     * hande Message messages and notify the player's view of their payload.
     * @param message
     */
    public void handle(Message message){
        executor.execute(()->{
            virtualModel.notifyObserver(obs->obs.onShowReq("Server message: "+message.getType()));}
        );
    }

    /**
     * handle AskNumbPlayer messages and notify the first player's view that server requested for the number of players.
     * @param message
     */
    public void handle(AskNumbPlayer message){
        executor.execute(()->{
            virtualModel.notifyObserver(obs->obs.onNumbPlayerReq());}
        );
    }
    /**
     * handle UpdateBoard messages, update the virtualModel.board value and notify the player's view of the new board using a Board obj.
     * @param message
     */
    public void handle(UpdateBoard message){
        executor.execute(()->{
            virtualModel.updateBoard(message.getB());
            virtualModel.notifyObserver(obs->obs.onShowNewBoardReq(message.getB()));}
        );
    }

    /**
     * handle UpdateLibrary message, update the player library in the virtualModel and notify the player of the change
     * @param message
     */
    public void handle(Updatelibrary message){
        executor.execute(()->{
            if(virtualModel.getMe().getNickname().equals(message.getnickname())){
                virtualModel.getMe().setLibrary(message.getL());
                virtualModel.notifyObserver(obs->obs.onShowNewMyLibraryReq(message.getL()));
            }
            else{
            virtualModel.getPlayer(message.getnickname()).setLibrary(message.getL());
            virtualModel.notifyObserver(obs->obs.onNotifyNewLibraryReq(message.getnickname(), message.getL()));}
        }
        );
    }

    /**
     * handle ShowColumn messages and notify the player's view of the columns that he could use, with his library to.
     * @param message
     */
    public void handle(ShowColumn message){
        executor.execute(()->{
            virtualModel.notifyObserver(obs->obs.onShowPossibleColumnReq(message.getX(),virtualModel.getMe().getLibrary()));}
        );
    }

    /**
     * handle WaitList messages and notify the player's view that the game he wants to join is already full.
     * @param message
     */
    public void handle(WaitList message){
        executor.execute(()->{
            virtualModel.notifyObserver(obs->obs.onNotifyGameFullReq());}
        );
    }

    /**
     * handle AnotherPlayerDisconnected messages, update virtualModel.players and notify the player's view the leaving player's object.
     * @param message
     */
    public void handle(AnotherPlayerDisconnect message){
        executor.execute(()->{
            virtualModel.removePlayer(message.getnickname());
            virtualModel.notifyObserver(obs->obs.onNotifyPlayerDisconnectionReq(virtualModel.getPlayer(message.getnickname())));}
        );
    }

    /**
     * handle PlayerReturned messages, update virtualModel.players and notify the player's view the returning player's object.
     * @param message
     */
    public void handle(PlayerReturned message){
        executor.execute(()->{
            virtualModel.addPlayer(message.getP());
            virtualModel.notifyObserver(obs->obs.onNotifyPlayerReconnectionReq(virtualModel.getPlayer(message.getnickname())));}
        );
    }

    /**
     * handle Assigned_CC messages, update the message.nickname's player.commonScore in the virtualModel and notify the player's view of the
     * completed CommonGoalCard with the associated score.
     * @param message
     */
    public void handle(Assigned_CC message){
        executor.execute(()->{
            virtualModel.updateCommonScore(message.getnickname(),message.getPoint());
            virtualModel.notifyObserver(obs->obs.onNotifyReachedCommonGoalCardReq(message.getCard(),message.getPoint()));}
        );
    }

    /**
     * handle ChairAssigned messages, update virtualModel.chair and notify the player's view of which player detains the chair.
     * @param message
     */
    public void handle(ChairAssigned message){
        executor.execute(()->{
            virtualModel.updateChair(message.getnickname());
            virtualModel.notifyObserver(obs->obs.onNotifyChairAssignedReq(message.getnickname()));}
        );
    }

    /**
     * handle NotTakeCardBoard messages and notify player's view that the cards chosen aren't adjacent.
     * @param message
     */
    public void handle(NotTakeCardBoard message){
        executor.execute(()->{
            virtualModel.notifyObserver(obs->obs.onNotifyCardsAreNotAdjacentReq());}
        );

    }

    /**
     * handle AcceptPlayer messages and notify the player's view if him or another player have been accepted.
     * @param message
     */
    public void handle(AcceptPlayer message){
        executor.execute(()->{
            if(virtualModel.getMe().getNickname().equals(message.getnickname()))
                virtualModel.notifyObserver(obs->obs.onNotifyConnectionAcceptedReq());
            else
                virtualModel.notifyObserver(obs->obs.onNotifyPlayerConnectionReq(virtualModel.getPlayer(message.getnickname())));}
        );
    }

    /**
     * handle Created_Match messages, create the virtualModel based on the one received from the server and notify the player's view
     * with the ArrayList of the players.
     * @param message
     */
    public void handle(Created_Match message){
        executor.execute(()->{
            virtualModel=new VirtualModel(message.getMatch());
            virtualModel.notifyObserver(obs->obs.onNotifyMatchHasStartedReq(virtualModel.getPlayers()));}
        );
    }

    /**
     * handle Final_Point messages and notify the player's view with the final scoreboard received from server.
     * @param message
     */
    public void handle(Final_point message){
        executor.execute(()->{
            virtualModel.notifyObserver(obs->obs.onShowFinalScoreBoardReq(message.getPoint()));}
        );
    }

    /**
     * handle First_finish messages, update the virtualModel.firstFinish value and notify the player's view of the first finishing player.
     * @param message
     */
    public void handle(First_finish message){
        executor.execute(()->{
            virtualModel.setFirstFinish(message.getnickname());
            virtualModel.notifyObserver(obs->obs.onNotifyPlayerFinishedFirstReq(virtualModel.getPlayer(message.getnickname())));}
        );
    }

    /**
     * handle Numb_Player_Answer messages, update virtualModel.playerNumber and notify the player's view of the player number chosen by
     * the first player.
     * @param message
     */
    public void handle(Numb_Player_Answer message){
        executor.execute(()->{
            virtualModel.setPlayerNumber(message.getX());
            virtualModel.notifyObserver(obs->obs.onNotifyNumbPlayerReq(message.getX()));}
        );
    }
}
