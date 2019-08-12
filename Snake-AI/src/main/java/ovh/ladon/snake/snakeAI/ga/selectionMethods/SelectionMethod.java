package ovh.ladon.snake.snakeAI.ga.selectionMethods;

import ovh.ladon.snake.snakeAI.ga.Individual;
import ovh.ladon.snake.snakeAI.ga.Population;
import ovh.ladon.snake.snakeAI.ga.Problem;

public abstract class SelectionMethod <I extends Individual, P extends Problem<I>>{

    protected int popSize;

    public SelectionMethod(int popSize){
        this.popSize = popSize;
    }

    public abstract Population<I, P> run(Population<I, P> original);
}