package ovh.ladon.snake.snakeAdhoc;

import ovh.ladon.snake.Action;
import ovh.ladon.snake.Cell;
import ovh.ladon.snake.Environment.Environment;
import ovh.ladon.snake.Perception;
import ovh.ladon.snake.SnakeAgent;

import java.awt.*;


public class SnakeAdhocAgent extends SnakeAgent {

    public SnakeAdhocAgent(Cell head, Color color, Environment environment) {
        super(head, color, environment);
    }


    @Override
    protected Action decide(Perception perception) {
        //obter coordenadas comida
        Cell food = environment.getFood().getCell();
        int columnFood = food.getColumn();
        int lineFood = food.getLine();


        Cell cell = perception.getN();
        if (cell != null && !cell.hasAgent() && cell.getLine() >= lineFood ){
            return Action.NORTH;
        }

        cell = perception.getE();
        if (cell != null && !cell.hasAgent() && cell.getColumn() <= columnFood){
            return Action.EAST;
        }

        cell = perception.getS();

        if (cell != null && !cell.hasAgent() && cell.getLine()<= lineFood){
            return Action.SOUTH;
        }



        cell = perception.getW();
        if (cell != null && !cell.hasAgent() &&  cell.getColumn() >= columnFood){
            return Action.WEST;
        }


        cell = perception.getN();
        if (cell != null && !cell.hasAgent()){
            return Action.NORTH;
        }

        cell = perception.getE();
        if (cell != null && !cell.hasAgent() ){
            return Action.EAST;
        }

        cell = perception.getS();

        if (cell != null && !cell.hasAgent() ){
            return Action.SOUTH;
        }



        cell = perception.getW();
        if (cell != null && !cell.hasAgent()){
            return Action.WEST;
        }

        environment.stop();
        return null;
        }

}
