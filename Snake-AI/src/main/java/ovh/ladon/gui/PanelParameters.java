package ovh.ladon.gui;

import ovh.ladon.snake.SnakeType;
import ovh.ladon.snake.snakeAI.SnakeIndividual;
import ovh.ladon.snake.snakeAI.SnakeProblem;
import ovh.ladon.snake.snakeAI.ga.geneticOperators.*;
import ovh.ladon.snake.snakeAI.ga.selectionMethods.RouletteWheel;
import ovh.ladon.snake.snakeAI.ga.selectionMethods.SelectionMethod;
import ovh.ladon.snake.snakeAI.ga.selectionMethods.Tournament;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PanelParameters extends PanelAtributesValue {

    public static final int TEXT_FIELD_LENGHT = 7;

    public static final String SEED = "1";
    public static final String POPULATION_SIZE = "80";
    public static final String GENERATIONS = "1000";
    public static final String TOURNAMENT_SIZE = "10";
    public static final String PROB_RECOMBINATION = "0.85";
    public static final String PROB_MUTATION = "0.2";

    public static final String LIMIT_MUTATION = "0.5";

    JTextField textFieldSeed = new JTextField(SEED, TEXT_FIELD_LENGHT);
    JTextField textFieldN = new JTextField(POPULATION_SIZE, TEXT_FIELD_LENGHT);
    JTextField textFieldGenerations = new JTextField(GENERATIONS, TEXT_FIELD_LENGHT);
    String[] selectionMethods = {"Tournament", "Roulette"};
    String[] selectionAlgorithm = {"AdDhoc Snake",
            "Random Snake",
            "AI1 Snake",
            "AI2 Snake",
            "Two AI2 snake ",
            "Two Different Snakes"};
    JComboBox comboBoxSelectionMethods = new JComboBox(selectionMethods);
    JComboBox comboBoxSelectionAlgorithm = new JComboBox(selectionAlgorithm);

    JTextField textFieldTournamentSize = new JTextField(TOURNAMENT_SIZE, TEXT_FIELD_LENGHT);
    String[] recombinationMethods = {"One cut", "Two cuts", "Uniform"};
    JComboBox comboBoxRecombinationMethods = new JComboBox(recombinationMethods);
    JTextField textFieldProbRecombination = new JTextField(PROB_RECOMBINATION, TEXT_FIELD_LENGHT);
    String[] selectionMutation = {"Uniform mutation", "Uniform mutation with limit" , "Gaussian mutation"};
    JComboBox comboBoxSelectionMutation = new JComboBox(selectionMutation);
    JTextField textFieldProbMutation = new JTextField(PROB_MUTATION, TEXT_FIELD_LENGHT);

    JTextField textFieldLimitMutation = new JTextField(LIMIT_MUTATION, TEXT_FIELD_LENGHT);

    private MainFrame mainFrame;

    public PanelParameters(MainFrame mainFrame) {
        title = "Genetic algorithm parameters";
        this.mainFrame = mainFrame;

        labels.add(new JLabel("Seed: "));
        valueComponents.add(textFieldSeed);
        textFieldSeed.addKeyListener(new IntegerTextField_KeyAdapter(null));

        labels.add(new JLabel("Population size: "));
        valueComponents.add(textFieldN);
        textFieldN.addKeyListener(new IntegerTextField_KeyAdapter(null));

        labels.add(new JLabel("# of generations: "));
        valueComponents.add(textFieldGenerations);
        textFieldGenerations.addKeyListener(new IntegerTextField_KeyAdapter(null));

        labels.add(new JLabel("Selection method: "));
        valueComponents.add(comboBoxSelectionMethods);
        comboBoxSelectionMethods.addActionListener(new JComboBoxSelectionMethods_ActionAdapter(this));


        labels.add(new JLabel("Tournament size: "));
        valueComponents.add(textFieldTournamentSize);
        textFieldTournamentSize.addKeyListener(new IntegerTextField_KeyAdapter(null));

        labels.add(new JLabel("Recombination method: "));
        valueComponents.add(comboBoxRecombinationMethods);

        labels.add(new JLabel("Recombination prob.: "));
        valueComponents.add(textFieldProbRecombination);

        labels.add(new JLabel("Selection mutation: "));
        valueComponents.add(comboBoxSelectionMutation);
        comboBoxSelectionMutation.addActionListener(new JComboBoxSelectionMutation_ActionAdapter(this));


        labels.add(new JLabel("Mutation prob.: "));
        valueComponents.add(textFieldProbMutation);

        labels.add(new JLabel("Limit mutation: "));
        valueComponents.add(textFieldLimitMutation);
        textFieldLimitMutation.addKeyListener(new IntegerTextField_KeyAdapter(null));
        textFieldLimitMutation.setEnabled(false);


        labels.add(new JLabel("Selection Algorithm: "));
        valueComponents.add(comboBoxSelectionAlgorithm);




        comboBoxSelectionAlgorithm.addActionListener(new JComboBoxSelectionAlgorithm_ActionAdapter(this));

        configure();

    }


    public SnakeType getAlgorithmSelected() {
        switch (comboBoxSelectionAlgorithm.getSelectedIndex()){
            case 0:
                return SnakeType.ADOC;
            case 1:
                return SnakeType.RANDOM;
            case 2:
                return SnakeType.AI1;
            case 3:
                return SnakeType.AI2;
            case 4:
                return SnakeType.TWO_AI_EQUAL;
            case 5:
                return SnakeType.TWO_AI_DIF;
        }
        return SnakeType.ADOC;
    }


    public void actionPerformedSelectionMethods(ActionEvent e) {
        textFieldTournamentSize.setEnabled(comboBoxSelectionMethods.getSelectedIndex() == 0);
    }

    public void actionPerformedSelectionMutationMethods(ActionEvent e){
        //Limit is only available if it is mutation with limit
        textFieldLimitMutation.setEnabled(comboBoxSelectionMutation.getSelectedIndex() == 1);
    }


    public void actionPerformedSelectionAlgorithm(ActionEvent e){
        if (comboBoxSelectionAlgorithm.getSelectedIndex() >= 2){
            mainFrame.manageButtons(true, false, false, false, false,true, false, false);
        }else{
            mainFrame.createProblem();
            mainFrame.manageButtons(false, false, false,false, false, false, false, true);
        }

    }

    public SelectionMethod<SnakeIndividual, SnakeProblem> getSelectionMethod() {

        switch (comboBoxSelectionMethods.getSelectedIndex()) {
            case 0:
                return new Tournament<>(Integer.parseInt(textFieldN.getText()), Integer.parseInt(textFieldTournamentSize.getText()));
            case 1:
                return new RouletteWheel<>(Integer.parseInt(textFieldN.getText()));

        }
        return null;
    }


    public Recombination<SnakeIndividual> getRecombinationMethod() {

        double recombinationProb = Double.parseDouble(textFieldProbRecombination.getText());

        switch (comboBoxRecombinationMethods.getSelectedIndex()) {
            case 0:
                return new RecombinationOneCut<>(recombinationProb);
            case 1:
                return new RecombinationTwoCuts<>(recombinationProb);
            case 2:
                return new RecombinationUniform<>(recombinationProb);
        }
        return null;
    }

    public Mutation<SnakeIndividual> getMutationMethod() {
        double mutationProbability = Double.parseDouble(textFieldProbMutation.getText());

        switch (comboBoxSelectionMutation.getSelectedIndex()){
            case 0:
                return new MutationUniformDistribution<>(mutationProbability);
            case 1:
                return new MutationUniformDistributionWithLimit<>(mutationProbability, Double.parseDouble(textFieldLimitMutation.getText()));//
            case 2:
                return new MutationGaussian<>(mutationProbability);
        }
        return null;
    }


}

class JComboBoxSelectionMethods_ActionAdapter implements ActionListener {

    final private PanelParameters adaptee;

    JComboBoxSelectionMethods_ActionAdapter(PanelParameters adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adaptee.actionPerformedSelectionMethods(e);
    }
}


class JComboBoxSelectionMutation_ActionAdapter implements ActionListener {
    final private PanelParameters adaptee;

    JComboBoxSelectionMutation_ActionAdapter(PanelParameters adaptee) {

        this.adaptee = adaptee;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adaptee.actionPerformedSelectionMutationMethods(e);
    }
}

class JComboBoxSelectionAlgorithm_ActionAdapter implements ActionListener {

    final private PanelParameters adaptee;

    JComboBoxSelectionAlgorithm_ActionAdapter(PanelParameters adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adaptee.actionPerformedSelectionAlgorithm(e);
    }
}


class IntegerTextField_KeyAdapter implements KeyListener {

    final private MainFrame adaptee;

    IntegerTextField_KeyAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
            e.consume();
        }
    }
}
