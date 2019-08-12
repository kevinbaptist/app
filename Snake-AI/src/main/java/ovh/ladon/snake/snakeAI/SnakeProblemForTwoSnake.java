package ovh.ladon.snake.snakeAI;

import ovh.ladon.snake.Environment.EnvironmentTwoSnake;
import ovh.ladon.snake.SnakeType;

public class SnakeProblemForTwoSnake extends SnakeProblem {
    private int numInputs2;
    private int numHiddenUnits2;
    private int numOutputs2;



    public SnakeProblemForTwoSnake(int environmentSize, int maxIterations, int numInputsSnake1, int numInputsSnake2,
                                   int numHiddenUnitsSnake1, int numHiddenUnitsSnake2,
                                   int numOutputsSnake1, int numOutputsSnake2, int numEnvironmentRuns, SnakeType type) {
        super(environmentSize, maxIterations, numInputsSnake1, numHiddenUnitsSnake1, numOutputsSnake1, numEnvironmentRuns, type);
        this.numInputs2 = numInputsSnake2;
        this.numHiddenUnits2 = numHiddenUnitsSnake2;
        this.numOutputs2 = numOutputsSnake2;



        //Implica que a segunda cobra tenha genoma maior
        int sizeDivision =(numInputs * numHiddenUnits)+(numHiddenUnits +1) * numOutputs;

        GENOME_SIZE =  sizeDivision + ((numInputs2*numHiddenUnits2)+(numHiddenUnits2+1) *numOutputs2);


        environment = new EnvironmentTwoSnake(environmentSize, maxIterations, numInputs, numInputs2, numHiddenUnits, numHiddenUnits2,
                numOutputs, numOutputs2, type, sizeDivision);

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Environment size: ");
        sb.append(environmentSize);
        sb.append("\n");

        sb.append("Number of environment simulations: ");
        sb.append(numEnvironmentRuns);
        sb.append("\n");

        sb.append("Maximum number of iterations: ");
        sb.append(maxIterations);
        sb.append("\n");

        sb.append("Snake AI 1:");
        sb.append("\n");
        sb.append("\t" + " -> Number of inputs: ");
        sb.append(numInputs);
        sb.append("\n");

        sb.append("\t" + " -> Number of hidden units: ");
        sb.append(numHiddenUnits);
        sb.append("\n");

        sb.append("\t" + " -> Number of outputs:");
        sb.append(numOutputs);

        sb.append("\n");
        sb.append("Snake AI 2:");
        sb.append("\n");
        sb.append("\t" + " -> Number of inputs: ");
        sb.append(numInputs2);
        sb.append("\n");
        sb.append("\t" + " -> Number of hidden units: ");
        sb.append(numHiddenUnits2);
        sb.append("\n");
        sb.append("\t" + " -> Number of outputs:");
        sb.append(numOutputs2);
        sb.append("\n");

        return sb.toString();
    }
}
