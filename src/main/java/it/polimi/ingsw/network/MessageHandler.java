package it.polimi.ingsw.network;

import it.polimi.ingsw.message.*;
import it.polimi.ingsw.network.observer.Observer;
import it.polimi.ingsw.view.VirtualModel;

public class MessageHandler implements Observer {
    VirtualModel virtualModel;

    public MessageHandler(VirtualModel virtualModel) {
        this.virtualModel = virtualModel;

    }

    @Override
    public void update(Message message) {
        message.visit(this);
    }

    /**
     * hande Message messages and notify the player's view of their payload.
     *
     * @param message
     */
    public void handle(Message message) {

        if (!message.getType().equals("Pong!"))
            virtualModel.notifyObserver(obs -> obs.onShowReq("Server message: " + message.getType()));
    }

    /**
     * handle AskNumbPlayer messages and notify the first player's view that server requested for the number of players.
     *
     * @param message
     */
    public void handle(AskNumbPlayer message) {

        virtualModel.notifyObserver(obs -> obs.onNumbPlayerReq());
    }

    /**
     * handle UpdateBoard messages, update the virtualModel.board value and notify the player's view of the new board using a Board obj.
     *
     * @param message
     */
    public void handle(UpdateBoard message) {

        virtualModel.updateBoard(message.getB());
        virtualModel.notifyObserver(obs -> obs.onShowNewBoardReq(message.getB()));
    }


    /**
     * handle UpdateLibrary message, update the player library in the virtualModel and notify the player of the change
     *
     * @param message
     */
    public void handle(Updatelibrary message) {

        if (virtualModel.getMe().getNickname().equals(message.getnickname())) {
            virtualModel.getMe().setLibrary(message.getL());
            virtualModel.notifyObserver(obs -> obs.onShowNewMyLibraryReq(message.getL()));
        } else {
            virtualModel.getPlayer(message.getnickname()).setLibrary(message.getL());

            //virtualModel.notifyObserver(obs -> obs.onNotifyNewLibraryReq(message.getnickname(), message.getL()));
        }
    }

    /**
     * handle ShowColumn messages and notify the player's view of the columns that he could use, with his library to.
     *
     * @param message
     */
    public void handle(ShowColumn message) {

        virtualModel.notifyObserver(obs -> obs.onShowPossibleColumnReq(message.getX(), message.getCards(), virtualModel.getMe().getLibrary()));
    }

    /**
     * handle WaitList messages and notify the player's view that the game he wants to join is already full.
     *
     * @param message
     */
    public void handle(WaitList message) {

        virtualModel.notifyObserver(obs -> obs.onNotifyGameFullReq());
    }

    /**
     * handle AnotherPlayerDisconnected messages, update virtualModel.players and notify the player's view the leaving player's object.
     *
     * @param message
     */
    public void handle(AnotherPlayerDisconnect message) {
        if (virtualModel.getPlayers() != null) {
            virtualModel.removePlayer(message.getnickname());
            virtualModel.notifyObserver(obs -> obs.onNotifyPlayerDisconnectionReq(virtualModel.getPlayer(message.getnickname())));
        } else {
            virtualModel.notifyObserver(obs -> obs.onShowReq("A player has disconnected"));
        }
    }
    /**
     * handle PlayerReturned messages, update virtualModel.players and notify the player's view the returning player's object.
     *
     * @param message
     */
    public void handle(PlayerReturned message) {

        virtualModel.notifyObserver(obs -> obs.onNotifyPlayerReconnectionReq(virtualModel.getPlayer(message.getnickname())));
    }


    /**
     * handle Assigned_CC messages, update the message.nickname's player.commonScore in the virtualModel and notify the player's view of the
     * completed CommonGoalCard with the associated score.
     *
     * @param message
     */
    public void handle(Assigned_CC message) {
        virtualModel.updateCommonScore(message.getnickname(), message.getPoint());
        virtualModel.notifyObserver(obs -> obs.onNotifyReachedCommonGoalCardReq(message.getnickname(), message.getCard(), message.getPoint()));
    }


    /**
     * handle ChairAssigned messages, update virtualModel.chair and notify the player's view of which player detains the chair.
     *
     * @param message
     */
    public void handle(ChairAssigned message) {
        //if(message.getnickname().equals(virtualModel.getMe().getNickname()))
        virtualModel.updateChair(message.getnickname());
        if (virtualModel.getMe().getNickname().equals(virtualModel.getChair().getNickname())) {
            if (!virtualModel.isMyTurn()) {
                virtualModel.updateIsMyTurn();
                virtualModel.notifyObserver(obs -> obs.onNotifyChairAssignedReq(message.getnickname()));
                virtualModel.notifyObserver(obs -> obs.onNotifyIsYourTurnReq(virtualModel.getBoard(), virtualModel.getMe().getLibrary()));
            }
        } else {
            virtualModel.notifyObserver(obs -> obs.onShowReq("Chair assigned to" + message.getnickname()));
        }
    }

    /**
     * handle NotTakeCardBoard messages and notify player's view that the cards chosen aren't adjacent.
     *
     * @param message
     */
    public void handle(NotTakeCardBoard message) {
        virtualModel.notifyObserver(obs -> obs.onNotifyCardsAreNotAdjacentReq());

    }

    /**
     * handle AcceptPlayer messages and notify the player's view if him or another player have been accepted.
     *
     * @param message
     */
    public void handle(AcceptPlayer message) {
        virtualModel.notifyObserver(obs -> obs.onNotifyPlayerConnectionReq(message.getnickname()));
    }


    /**
     * handle Final_Point messages and notify the player's view with the final scoreboard received from server.
     *
     * @param message
     */
    public void handle(Final_point message) {
        virtualModel.notifyObserver(obs -> obs.onShowFinalScoreBoardReq(message.getPoint()));
    }

    /**
     * handle First_finish messages, update the virtualModel.firstFinish value and notify the player's view of the first finishing player.
     *
     * @param message
     */
    public void handle(First_finish message) {
        virtualModel.setFirstFinish(message.getnickname());
        if (virtualModel.getMe().getNickname().equals(message.getnickname())) {
            virtualModel.notifyObserver(obs -> obs.onNotifyPlayerFinishedFirstReq(virtualModel.getPlayer(message.getnickname())));
        } else {
            virtualModel.notifyObserver(obs -> obs.onShowReq(message.getnickname() + " has finished his library.This is the last round"));
        }
    }
    /**
     * handle Numb_Player_Answer messages, update virtualModel.playerNumber and notify the player's view of the player number chosen by
     * the first player.
     *
     * @param message
     */
    public void handle(Numb_Player_Answer message) {
        virtualModel.setPlayerNumber(message.getX());
        virtualModel.notifyObserver(obs -> obs.onNotifyNumbPlayerReq(message.getX()));
    }

    /**
     * handle Disconnection_Answer messages, update the player's list and notify the player's view that server
     * accepted its disconnection request.
     *
     * @param message
     */
    public void handle(Disconnection_Answer message) {

        virtualModel.removePlayer(message.getnickname());
        virtualModel.notifyObserver(obs -> obs.onNotifyDisconnectionReqAcceptedAns());
    }

    /**
     * handle AskNewNickname messages and notify the player's view that the nickname chosen it's unavailable.
     *
     * @param message
     */
    public void handle(AskNewNickname message) {
        virtualModel.notifyObserver(obs -> obs.onNotifyNewNicknameReq());
    }

    /**
     * handle Turn messages, update virtualModel.isMyTurn attribute, and notify the player's view
     * if it's his turn, if his turn is ended or the new current player.
     *
     * @param message
     */
    public void handle(Turn message) {
        if (message.getTurnPlayer().equals(virtualModel.getMe().getNickname())) {
            if (!virtualModel.isMyTurn()) {
                virtualModel.updateIsMyTurn();
                virtualModel.notifyObserver(obs -> obs.onNotifyIsYourTurnReq(virtualModel.getBoard(), virtualModel.getMe().getLibrary()));
            }
        } else if (virtualModel.isMyTurn()) {
            virtualModel.updateIsMyTurn();
            virtualModel.notifyObserver(obs -> obs.onNotifyYourTurnIsEndedReq(message.getTurnPlayer()));
        } else {
            virtualModel.notifyObserver(obs -> obs.onNotifyWhoIsPlayingNowReq(message.getTurnPlayer()));
        }
    }

    /**
     * handle PersonalCard, notify the player's view his personal card
     *
     * @param message
     */
    public void handle(Send_PersonalCard message) {
        virtualModel.getMe().setPersonalCard(message.getPersonalGoalCard());
        virtualModel.notifyObserver(obs -> obs.onNotifyPersonalCardReq(message.getPersonalGoalCard()));
    }

    /**
     * handle AllPlayers message, notify the player his opponents
     *
     * @param message
     */
    public void handle(AllPlayer message) {
        virtualModel.setPlayers(message.getPlayers());
        virtualModel.notifyObserver(obs -> obs.onNotifyAllPlayerReq(message.getPlayers()));
    }

    public void handle(Connected_Before_FirstPlayer message) {
        try {
            virtualModel.notifyObserver(obs -> obs.onShowReq(message.getType()));
            virtualModel.notifyObserver(obs -> {
                try {
                    obs.NotifyaskNicknameReq();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void handle(Send_EffectiveCard message) {
        virtualModel.setCommonCards(message.getCards());
        virtualModel.notifyObserver(obs -> obs.onNotifyCommonCards(message.getCards()));

    }

    public void handle(Receiving_Mex message) {
        virtualModel.notifyObserver(obs -> obs.onNotifyMexInChat(message.getnickname(), message.getMex(), message.getDest()));
    }
}



