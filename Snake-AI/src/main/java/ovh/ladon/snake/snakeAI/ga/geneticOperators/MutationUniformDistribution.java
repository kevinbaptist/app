package ovh.ladon.snake.snakeAI.ga.geneticOperators;

import ovh.ladon.snake.snakeAI.ga.GeneticAlgorithm;
import ovh.ladon.snake.snakeAI.ga.RealVectorIndividual;

public class MutationUniformDistribution <I extends RealVectorIndividual> extends Mutation<I> {

    public MutationUniformDistribution(double probability) {
        super(probability);
    }

    @Override
    public void run(I ind) {

        for (int i = 0; i < ind.getNumGenes(); i++) {
            if (GeneticAlgorithm.random.nextDouble() < probability) {

                ind.setGene(i, ind.getGene(i) +GeneticAlgorithm.getRandom(-1, 1));
            }
        }

    }

    @Override
    public String toString(){
        return "Uniform distribution\t" + probability +"\tNotApplied";
    }
}