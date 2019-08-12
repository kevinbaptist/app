package ovh.ladon.snake.snakeAI.ga.geneticOperators;

import ovh.ladon.snake.snakeAI.ga.Individual;

public abstract class Mutation <I extends Individual> extends GeneticOperator{

    public Mutation(double probability){
        super(probability);
    }

    public abstract void run(I individual);
}
