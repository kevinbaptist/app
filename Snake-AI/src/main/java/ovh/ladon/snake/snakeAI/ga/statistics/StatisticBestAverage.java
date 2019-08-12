package ovh.ladon.snake.snakeAI.ga.statistics;

import ovh.ladon.snake.snakeAI.ga.*;
import ovh.ladon.snake.snakeAI.ga.experiments.ExperimentEvent;
import ovh.ladon.snake.snakeAI.ga.utils.FileOperations;
import ovh.ladon.snake.snakeAI.ga.utils.Maths;

public class StatisticBestAverage<E extends Individual, P extends Problem<E>> implements GAListener {

    private final double[] fitness;
    private final double [] totalFood;
    private int run;
    private final double[] movements;

    public StatisticBestAverage(int numRuns) {
        fitness = new double[numRuns];
        totalFood = new double[numRuns];
        movements = new double[numRuns];
    }

    @Override
    public void generationEnded(GAEvent e) {
    }

    @Override
    public void runEnded(GAEvent e) {
        GeneticAlgorithm<E, P> ga = e.getSource();
        totalFood[run] = ga.getBestInRun().getTotalFoodSnake1();
        movements[run] = ga.getBestInRun().getTotalMovements();
        fitness[run++] = ga.getBestInRun().getFitness();

    }

    @Override
    public void experimentEnded(ExperimentEvent e) {

        double avg_fitness = Maths.average(fitness);
        double avg_food = Maths.average(totalFood);
        double sd_fitness = Maths.standardDeviation(fitness, avg_fitness);

        double  sd_food = Maths.standardDeviation(totalFood, avg_food);

        double avg_movements = Maths.average(movements);
        double sd_movements = Maths.standardDeviation(movements, avg_movements);



        FileOperations.appendToTextFile("statistic_average_fitness.xls",
                e.getSource() + "\t" +
                        avg_fitness + "\t" + sd_fitness  + "\t"+
                        avg_food+ "\t" + sd_food + "\t"+
                        avg_movements + "\t"+ sd_movements +
                        "\r\n");
    }
}
