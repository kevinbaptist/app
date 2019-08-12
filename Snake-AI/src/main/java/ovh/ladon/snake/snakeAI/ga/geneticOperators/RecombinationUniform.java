package ovh.ladon.snake.snakeAI.ga.geneticOperators;

import ovh.ladon.snake.snakeAI.ga.GeneticAlgorithm;
import ovh.ladon.snake.snakeAI.ga.Individual;

public class RecombinationUniform <I extends Individual> extends Recombination<I> {

    public RecombinationUniform(double probability) {
        super(probability);
    }

    @Override
    public void run(I ind1, I ind2) {
        int indSize = ind1.getNumGenes();

        for (int i = 0; i < indSize; i++) {
            if (GeneticAlgorithm.random.nextInt(2) == 0) {
                ind1.swapGenes(ind2, i);
            }
        }
    }

    @Override
    public String toString(){
        return "uniform\t" + probability;
    }
}