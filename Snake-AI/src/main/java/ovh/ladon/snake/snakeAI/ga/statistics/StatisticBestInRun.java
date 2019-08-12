package ovh.ladon.snake.snakeAI.ga.statistics;

import ovh.ladon.snake.snakeAI.ga.*;
import ovh.ladon.snake.snakeAI.ga.experiments.ExperimentEvent;
import ovh.ladon.snake.snakeAI.ga.utils.FileOperations;

public class StatisticBestInRun<I extends Individual, P extends Problem<I>> implements GAListener {

    private I bestInExperiment;

    public StatisticBestInRun() {
    }

    @Override
    public void generationEnded(GAEvent e) {
    }

    @Override
    public void runEnded(GAEvent e) {
        GeneticAlgorithm<I, P> ga = e.getSource();
        if (bestInExperiment == null || ga.getBestInRun().compareTo(bestInExperiment) > 0) {
            bestInExperiment = (I) ga.getBestInRun().clone();

        }
    }

    @Override
    public void experimentEnded(ExperimentEvent e) {
        FileOperations.appendToTextFile("statistic_best_per_experiment_fitness.xls",
                this.bestInExperiment.getSeed() +
                "\t" + e.getSource() +

                "\t" + this.bestInExperiment.getFitness() +
                "\t"  + this.bestInExperiment.getTotalFoodSnake1() +
                "\t" + this.bestInExperiment.getTotalMovements() +"\r\n");


        FileOperations.appendToTextFile("statistic_best_per_experiment.txt", "\r\n\r\n" + e.getSource() + "\r\n" + this.bestInExperiment);
    }
}
