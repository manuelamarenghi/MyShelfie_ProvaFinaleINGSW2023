package it.polimi.ingsw.modello;
//import org.json.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

    /*public static void main(String[] args) {
       //Test of json file reading
    String jsonPath;
        ArrayList<PersonalGoalCard> test=new ArrayList<>(12);
        Card[] cards;

        {
            try{
                jsonPath = new String(Files.readAllBytes(Paths.get("./src/json/PersonalGoalCards.json")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            JSONArray jsonArray=new JSONArray(jsonPath);
            for(int i=0;i<jsonArray.length();i++){
                cards=new Card[6];
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                JSONArray obj=jsonObject.getJSONArray("objective");
                for(int j=0;j<obj.length();j++){
                    JSONObject pos=obj.getJSONObject(j).getJSONObject("coordinates");
                    Position position=new Position(pos.getInt("x"),pos.getInt("y"));
                    cards[j]=new Card(obj.getJSONObject(j).getString("colour"),position);
                }
                test.add(new PersonalGoalCard(cards));
            }
            for(PersonalGoalCard pgc:test){
                System.out.println("PersonalGoalCard");
                for(Card card:pgc.getPersonalObjective()){
                    System.out.println(card.getColour()+" "+card.getCoordinates().getX()+","+card.getCoordinates().getY());
                }
                pgc.showPersonalGoalCard();
                System.out.println("---------------------");

            }
    }
    }*/
}