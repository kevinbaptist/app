package ovh.ladon.snake.snakeAI.ga;

import ovh.ladon.snake.snakeAI.ga.experiments.ExperimentListener;

public interface GAListener extends ExperimentListener {

    void generationEnded(GAEvent e);

    void runEnded(GAEvent e);
}
