package ovh.ladon.snake.snakeAI;

import ovh.ladon.snake.SnakeType;
import ovh.ladon.snake.snakeAI.ga.GAListener;
import ovh.ladon.snake.snakeAI.ga.GeneticAlgorithm;
import ovh.ladon.snake.snakeAI.ga.experiments.Experiment;
import ovh.ladon.snake.snakeAI.ga.experiments.ExperimentListener;
import ovh.ladon.snake.snakeAI.ga.experiments.ExperimentsFactory;
import ovh.ladon.snake.snakeAI.ga.geneticOperators.*;
import ovh.ladon.snake.snakeAI.ga.selectionMethods.RouletteWheel;
import ovh.ladon.snake.snakeAI.ga.selectionMethods.SelectionMethod;
import ovh.ladon.snake.snakeAI.ga.selectionMethods.Tournament;
import ovh.ladon.snake.snakeAI.ga.statistics.StatisticBestAverage;
import ovh.ladon.snake.snakeAI.ga.statistics.StatisticBestInRun;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SnakeExperimentsFactory extends ExperimentsFactory {

    private int populationSize;
    private int maxGenerations;
    private SelectionMethod<SnakeIndividual, SnakeProblem> selection;
    private Recombination<SnakeIndividual> recombination;
    private Mutation<SnakeIndividual> mutation;
    private SnakeProblem problem;
    private SnakeType type;

    private Experiment<SnakeExperimentsFactory, SnakeProblem> experiment;


    public SnakeExperimentsFactory(File configFile) throws IOException {
        super(configFile);
    }

    @Override
    public Experiment buildExperiment(SnakeType type) throws IOException {
        this.type = type;
        numRuns = Integer.parseInt(getParameterValue("Runs"));
        populationSize = Integer.parseInt(getParameterValue("Population size"));
        maxGenerations = Integer.parseInt(getParameterValue("Max generations"));

        //SELECTION
        switch(getParameterValue("Selection")) {
            case "tournament":
                int tournamentSize = Integer.parseInt(getParameterValue("Tournament size"));
                selection = new Tournament<>(populationSize, tournamentSize);
                break;
            case "roullette":
                selection = new RouletteWheel<>(populationSize);
        }

        //RECOMBINATION
        double recombinationProbability = Double.parseDouble(getParameterValue("Recombination probability"));
        switch(getParameterValue("Recombination")){
            case "one_cut":
                recombination = new RecombinationOneCut<>(recombinationProbability);
                break;
            case "two_cuts":
                recombination = new RecombinationTwoCuts<>(recombinationProbability);
                break;
            case "uniform":
                recombination = new RecombinationUniform<>(recombinationProbability);
        }



        //MUTATION
        double mutationProbability = Double.parseDouble(getParameterValue("Mutation probability"));


        switch (getParameterValue("Mutation")){
           case "uniform_distribution":
                mutation = new MutationUniformDistribution<>(mutationProbability );
                break;
           case "uniform_distribution_limit":
                double limit = Double.parseDouble(getParameterValue("Mutation limit"));
                mutation = new MutationUniformDistributionWithLimit<>(mutationProbability, limit );
               break;
           case "gaussian":
                mutation = new MutationGaussian<>(mutationProbability);
                break;
    }







        problem = SnakeProblem.buildProblemFromFile(new File(getParameterValue("Problem file")), type);

        String textualRepresentation = buildTextualExperiment();

        experiment = new Experiment<>(this, numRuns, problem, textualRepresentation);

        statistics = new ArrayList<>();
        for (String statisticName : statisticsNames) {
            ExperimentListener statistic = buildStatistic(statisticName);
            statistics.add(statistic);
            experiment.addExperimentListener(statistic);
        }

        return experiment;
    }

    @Override
    public GeneticAlgorithm generateGAInstance(int seed) {
        GeneticAlgorithm<SnakeIndividual, SnakeProblem> ga =
                new GeneticAlgorithm<>(
                    populationSize,
                    maxGenerations,
                    selection,
                    recombination,
                    mutation,
                    seed);

        for (ExperimentListener statistic : statistics) {
            ga.addGAListener((GAListener) statistic);
        }

        return ga;
    }

    private ExperimentListener buildStatistic(String statisticName) {
        switch(statisticName){
            case "BestIndividual":
                return new StatisticBestInRun();
            case "BestAverage":
                return new StatisticBestAverage(numRuns);
        }
        return null;
    }

    private String buildTextualExperiment() {
        StringBuilder sb = new StringBuilder();
        sb.append(type + "\t");
        sb.append(populationSize + "\t");
        sb.append(maxGenerations + "\t");
        sb.append(selection + "\t");
        sb.append(recombination + "\t");
        sb.append( mutation);


        return sb.toString();
    }
}
