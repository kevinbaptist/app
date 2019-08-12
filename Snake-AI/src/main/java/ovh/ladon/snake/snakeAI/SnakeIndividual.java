package ovh.ladon.snake.snakeAI;

import ovh.ladon.snake.Environment.Environment;
import ovh.ladon.snake.snakeAI.ga.RealVectorIndividual;
import ovh.ladon.snake.snakeAI.nn.SnakeAI;

public class SnakeIndividual extends RealVectorIndividual<SnakeProblem, SnakeIndividual> {

    private int maxFood;

    protected static final int WEIGHT_FOOD = 10000;
    protected static final double WEIGHT_MOVEMENT = 0.2;

    public SnakeIndividual(SnakeProblem problem, int size) {
        super(problem, size);
    }

    public SnakeIndividual(SnakeIndividual original) {
        super(original);
        this.maxFood = original.maxFood;
    }

    @Override
    public double computeFitness(int seed) {
        int food;

        totalMovements = totalFoodSnake1 =  maxFood=0;
        Environment envirnoment = problem.getEnvironment();

        SnakeAI aiAgent = envirnoment.getAgentAI();

        for (int i = 0; i < problem.getNumEvironmentSimulations();i++) {

            //inicializar o envirnoment
            envirnoment.initialize(i);


            aiAgent.setWeights(genome);

            //simular o envirnoment
            envirnoment.simulate();


            //obter o numero de movimentos
            totalMovements += envirnoment.getMovementNumber();

            //obter o numero de comidas
            food = envirnoment.getTotalFood();
            this.totalFoodSnake1 += food;

            if (maxFood < food)
                maxFood = food;

        }
        this.seed = seed;
        fitness = totalMovements *WEIGHT_MOVEMENT + totalFoodSnake1 *WEIGHT_FOOD;

        return fitness;
    }

    public double[] getGenome(){
        return genome;
    }

    public void setGenome(double[] genome){
        this.genome = genome;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nSeed used: ");
        sb.append(seed);

        sb.append("\nFitness: ");
        sb.append(fitness);
        sb.append("\nTotal movements (avarage): ");
        sb.append(totalMovements /problem.getNumEvironmentSimulations());

        sb.append("\nTotal Food (avarage): ");
        sb.append(totalFoodSnake1 /problem.getNumEvironmentSimulations());

        sb.append("\nTotal Food (max): ");
        sb.append(maxFood);



        return sb.toString();
    }

    /**
     *
     * @param i
     * @return 1 if this object is BETTER than i, -1 if it is WORST than I and
     * 0, otherwise.
     */
    @Override
    public int compareTo(SnakeIndividual i) {
        //
        if (fitness == i.fitness)
            return 0;

        return (fitness > i.fitness)? 1: -1;
    }

    @Override
    public SnakeIndividual clone() {
        return new SnakeIndividual(this);
    }
}
