package ovh.ladon.gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import ovh.ladon.snake.SnakeType;
import ovh.ladon.snake.snakeAI.SnakeExperimentsFactory;
import ovh.ladon.snake.snakeAI.SnakeIndividual;
import ovh.ladon.snake.snakeAI.SnakeProblem;
import ovh.ladon.snake.snakeAI.ga.GAEvent;
import ovh.ladon.snake.snakeAI.ga.GAListener;
import ovh.ladon.snake.snakeAI.ga.GeneticAlgorithm;
import ovh.ladon.snake.snakeAI.ga.experiments.Experiment;
import ovh.ladon.snake.snakeAI.ga.experiments.ExperimentEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;

public class MainFrame extends JFrame implements GAListener {

    private static final long serialVersionUID = 1L;
    private SnakeProblem problem = new SnakeProblem(SnakeType.ADOC);
    private GeneticAlgorithm<SnakeIndividual, SnakeProblem> ga;
    private SnakeIndividual bestInRun;
    private SnakeExperimentsFactory experimentsFactory;
    private PanelTextArea problemPanel;
    private PanelTextArea bestIndividualPanel;
    private PanelParameters panelParameters = new PanelParameters(this);
    private JButton buttonDataSet = new JButton("Data set");
    private JButton buttonRun = new JButton("Run");
    private JButton buttonStop = new JButton("Stop");
    private JButton buttonLoad = new JButton("Load");
    private JButton buttonSave = new JButton("Save");
    private JButton buttonExperiments = new JButton("Experiments");
    private JButton buttonRunExperiments = new JButton("Run Experiments");
    private JTextField textFieldExperimentsStatus = new JTextField("", 10);
    private XYSeries seriesBestIndividual;
    private XYSeries seriesAverage;
    private SwingWorker<Void, Void> worker;

    private PanelSimulation simulationPanel;


    public PanelParameters getPanelParameters() {
        return panelParameters;
    }

    public MainFrame() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    private void jbInit() throws Exception {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("SNAKE AI");

        //North Left Panel
        JPanel panelNorthLeft = new JPanel(new BorderLayout());
        panelNorthLeft.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(""),
                BorderFactory.createEmptyBorder(1, 1, 1, 1)));

        panelNorthLeft.add(panelParameters, java.awt.BorderLayout.WEST);
        JPanel panelButtons = new JPanel();
        panelButtons.add(buttonDataSet);
        buttonDataSet.addActionListener(new ButtonDataSet_actionAdapter(this));

        //Começam a false pq o default é a snake Adhoc
        buttonDataSet.setEnabled(false);
        buttonExperiments.setEnabled(false);

        panelButtons.add(buttonRun);
        buttonRun.setEnabled(false);
        buttonRun.addActionListener(new ButtonRun_actionAdapter(this));
        panelButtons.add(buttonStop);
        buttonStop.setEnabled(false);
        buttonStop.addActionListener(new ButtonStop_actionAdapter(this));
        panelNorthLeft.add(panelButtons, java.awt.BorderLayout.SOUTH);

        //Botões save/load
        panelButtons.add(buttonSave);
        buttonSave.setEnabled(false);
        buttonSave.addActionListener(new ButtonSave_actionAdapter(this));
        panelButtons.add(buttonLoad);
        buttonLoad.setEnabled(false);
        buttonLoad.addActionListener(new ButtonLoad_actionAdapter(this));
        panelNorthLeft.add(panelButtons, java.awt.BorderLayout.SOUTH);

        //North Right Panel - Chart creation
        seriesBestIndividual = new XYSeries("Best");
        seriesAverage = new XYSeries("Average");

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(seriesBestIndividual);
        dataset.addSeries(seriesAverage);
        JFreeChart chart = ChartFactory.createXYLineChart("Evolution", // Title
                "generation", // x-axis Label
                "fitness", // y-axis Label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot Orientation
                true, // Show Legend
                true, // Use tooltips
                false // Configure chart to generate URLs?
        );
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(""),
                BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));

        //North Panel
        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(panelNorthLeft, java.awt.BorderLayout.WEST);
        northPanel.add(chartPanel, java.awt.BorderLayout.CENTER);

        //Center panel
        problemPanel = new PanelTextArea("Problem data: ", 20, 40);
        bestIndividualPanel = new PanelTextArea("Best solution: ", 20, 40);
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(problemPanel, java.awt.BorderLayout.WEST);
        centerPanel.add(bestIndividualPanel, java.awt.BorderLayout.CENTER);

        //South Panel
        JPanel southPanel = new JPanel();
        southPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(""),
                BorderFactory.createEmptyBorder(1, 1, 1, 1)));

        southPanel.add(buttonExperiments);
        buttonExperiments.addActionListener(new ButtonExperiments_actionAdapter(this));
        southPanel.add(buttonRunExperiments);
        buttonRunExperiments.setEnabled(false);
        buttonRunExperiments.addActionListener(new ButtonRunExperiments_actionAdapter(this));
        southPanel.add(new JLabel("Status: "));
        southPanel.add(textFieldExperimentsStatus);
        textFieldExperimentsStatus.setEditable(false);

        //Big left panel
        JPanel bigLeftPanel = new JPanel(new BorderLayout());
        bigLeftPanel.add(northPanel, java.awt.BorderLayout.NORTH);
        bigLeftPanel.add(centerPanel, java.awt.BorderLayout.CENTER);
        bigLeftPanel.add(southPanel, java.awt.BorderLayout.SOUTH);
        this.getContentPane().add(bigLeftPanel);

        simulationPanel = new PanelSimulation(this);

        //Global structure
        JPanel globalPanel = new JPanel(new BorderLayout());
        globalPanel.add(bigLeftPanel, java.awt.BorderLayout.WEST);
        globalPanel.add(simulationPanel, java.awt.BorderLayout.EAST);
        this.getContentPane().add(globalPanel);

        pack();
    }

    public SnakeProblem getProblem() {
        return problem;
    }

    public SnakeIndividual getBestInRun() {
        return bestInRun;
    }

    public void createProblem(){
        problem = new SnakeProblem(panelParameters.getAlgorithmSelected());
    }

    public void buttonDataSet_actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser(new java.io.File("."));
        int returnVal = fc.showOpenDialog(this);

        try {
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File dataSet = fc.getSelectedFile();
                problem = SnakeProblem.buildProblemFromFile(dataSet, panelParameters.getAlgorithmSelected());
                problemPanel.textArea.setText(problem.toString());
                problemPanel.textArea.setCaretPosition(0);
                buttonRun.setEnabled(true);
                buttonLoad.setEnabled(true);
            }
        } catch (IOException e1) {
            e1.printStackTrace(System.err);
        } catch (java.util.NoSuchElementException e2) {
            JOptionPane.showMessageDialog(this, "File format not valid", "Error!", JOptionPane.ERROR_MESSAGE);
        }catch (IndexOutOfBoundsException e3){
            JOptionPane.showMessageDialog(this, "File format not valid", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void jButtonRun_actionPerformed(ActionEvent e) {
        try {

            bestIndividualPanel.textArea.setText("");
            seriesBestIndividual.clear();
            seriesAverage.clear();

            Random random = new Random();
            ga = new GeneticAlgorithm<>(
                    Integer.parseInt(panelParameters.textFieldN.getText()),
                    Integer.parseInt(panelParameters.textFieldGenerations.getText()),
                    panelParameters.getSelectionMethod(),
                    panelParameters.getRecombinationMethod(),
                    panelParameters.getMutationMethod(),
                    Integer.parseInt(panelParameters.textFieldSeed.getText()));

            System.out.println(ga);

            ga.addGAListener(this);

            //
            manageButtons(false, false, true,false , false, false, false, false);

            worker = new SwingWorker<Void, Void>() {
                @Override
                public Void doInBackground() {
                    try {

                        bestInRun = ga.run(problem);

                    } catch (Exception e) {
                        e.printStackTrace(System.err);
                    }
                    return null;
                }

                @Override
                public void done() {
                    //gravarBestGenoma();
                    manageButtons(true, true, false, true, false, true, experimentsFactory != null, true);
                }
            };

            worker.execute();

        } catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(this, "Wrong parameters!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public  void jButtonSave_actionPerformed(ActionEvent e){
        JFileChooser fc = new JFileChooser(new java.io.File("."));
        int returnVal = fc.showSaveDialog(this);
        try
        {
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File dataSet = fc.getSelectedFile();
                BufferedWriter bw = new BufferedWriter(new FileWriter(dataSet.getName()));
                System.out.println(fc.getName());
                for (Double line : ga.getBestInRun().getGenome()) {
                    bw.write (line + "\r\n");
                }

                bw.close();
                JOptionPane.showMessageDialog(this, "Guardado com sucesso");
                manageButtons(true, true, false, false, false, true, experimentsFactory != null, true);

            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Não foi possivel guardar os valores");
        }

    }


    public  void jButtonLoad_actionPerformed(ActionEvent e){
        try {
            JFileChooser fc = new JFileChooser(new java.io.File("."));
            int returnVal = fc.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File dataSet = fc.getSelectedFile();

                int i = 0;
                int tamanho = problem.getGenomeSize();
                double[] prepGenoma = new double[tamanho];


                String rawInput;
                BufferedReader readFromFile = new BufferedReader(new FileReader(dataSet.getName()));

                while ((rawInput = readFromFile.readLine()) != null) {
                    prepGenoma[i++] = Double.parseDouble(rawInput);
                }
                ga = new GeneticAlgorithm<>(
                        Integer.parseInt(panelParameters.textFieldN.getText()),
                        Integer.parseInt(panelParameters.textFieldGenerations.getText()),
                        panelParameters.getSelectionMethod(),
                        panelParameters.getRecombinationMethod(),
                        panelParameters.getMutationMethod(),
                        Integer.parseInt(panelParameters.textFieldSeed.getText()));


                ga.addGAListener(this);


                worker = new SwingWorker<Void, Void>() {
                    @Override
                    public Void doInBackground() {
                        try {

                            bestInRun = new SnakeIndividual(problem, tamanho);
                            bestInRun.setGenome(prepGenoma);
                        } catch (Exception e) {
                            e.printStackTrace(System.err);
                        }
                        return null;
                    }
                };
                worker.execute();

                JOptionPane.showMessageDialog(this, "Ficheiro lido com Êxito");
                manageButtons(true, true, false, false, false, true, false, true);
            }


        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }catch (java.util.NoSuchElementException e2) {
            JOptionPane.showMessageDialog(this, "File format not valid", "Error!", JOptionPane.ERROR_MESSAGE);
        }catch (IndexOutOfBoundsException e3){
            JOptionPane.showMessageDialog(this, "File format not valid", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }


    @Override
    public void generationEnded(GAEvent e) {
        GeneticAlgorithm<SnakeIndividual, SnakeProblem> source = e.getSource();
        bestIndividualPanel.textArea.setText(source.getBestInRun().toString());
        seriesBestIndividual.add(source.getGeneration(), source.getBestInRun().getFitness());
        seriesAverage.add(source.getGeneration(), source.getAverageFitness());
        if (worker.isCancelled()) {
            e.setStopped(true);
        }
    }

    @Override
    public void runEnded(GAEvent e) {
    }

    public void jButtonStop_actionPerformed(ActionEvent e) {
        worker.cancel(true);
        manageButtons(true, true, false, true, false, true, false, true);

    }

    public void buttonExperiments_actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser(new java.io.File("."));
        int returnVal = fc.showOpenDialog(this);

        try {
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                experimentsFactory = new SnakeExperimentsFactory(fc.getSelectedFile());
                manageButtons(true, problem != null, false, true, false, true, true, false);
            }
        } catch (IOException e1) {
            e1.printStackTrace(System.err);
        } catch (java.util.NoSuchElementException e2) {
            JOptionPane.showMessageDialog(this, "File format not valid", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void buttonRunExperiments_actionPerformed(ActionEvent e) {

        manageButtons(false, false, false, false, false, true, false, false);
        textFieldExperimentsStatus.setText("Running");

        worker = new SwingWorker<Void, Void>() {
            @Override
            public Void doInBackground() {
                try {
                    while (experimentsFactory.hasMoreExperiments()) {
                        try {

                            Experiment experiment = experimentsFactory.nextExperiment(panelParameters.getAlgorithmSelected());
                            experiment.run();

                        } catch (IOException e1) {
                            e1.printStackTrace(System.err);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
                return null;
            }

            @Override
            public void done() {
                manageButtons(true, problem != null, false, true, false,true, false, false);
                textFieldExperimentsStatus.setText("Finished");
            }
        };
        worker.execute();
    }

    @Override
    public void experimentEnded(ExperimentEvent e) {
    }

    public void manageButtons(boolean dataSet, boolean run, boolean stopRun,
            boolean saveRun,
            boolean loadRun,
            boolean experiments,
            boolean runExperiments,
            boolean runEnvironment) {

        buttonDataSet.setEnabled(dataSet);
        buttonRun.setEnabled(run);
        buttonStop.setEnabled(stopRun);
        buttonSave.setEnabled(saveRun);
        buttonLoad.setEnabled(loadRun);
        buttonExperiments.setEnabled(experiments);
        buttonRunExperiments.setEnabled(runExperiments);
        simulationPanel.setJButtonSimulateEnabled(runEnvironment);
    }
}

class PanelTextArea extends JPanel {

    JTextArea textArea;

    public PanelTextArea(String title, int rows, int columns) {
        textArea = new JTextArea(rows, columns);
        setLayout(new BorderLayout());
        add(new JLabel(title), java.awt.BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        add(scrollPane);
    }
}

class ButtonDataSet_actionAdapter implements ActionListener {

    final private MainFrame adaptee;

    ButtonDataSet_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adaptee.buttonDataSet_actionPerformed(e);
    }
}

class ButtonRun_actionAdapter implements ActionListener {

    final private MainFrame adaptee;

    ButtonRun_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adaptee.jButtonRun_actionPerformed(e);
    }
}

class ButtonStop_actionAdapter implements ActionListener {

    final private MainFrame adaptee;

    ButtonStop_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adaptee.jButtonStop_actionPerformed(e);
    }
}

class ButtonSave_actionAdapter implements ActionListener {

    final private MainFrame adaptee;

    ButtonSave_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adaptee.jButtonSave_actionPerformed(e);
    }
}

class ButtonLoad_actionAdapter implements ActionListener {

    final private MainFrame adaptee;

    ButtonLoad_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adaptee.jButtonLoad_actionPerformed(e);
    }
}

class ButtonExperiments_actionAdapter implements ActionListener {

    final private MainFrame adaptee;

    ButtonExperiments_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adaptee.buttonExperiments_actionPerformed(e);
    }
}

class ButtonRunExperiments_actionAdapter implements ActionListener {

    final private MainFrame adaptee;

    ButtonRunExperiments_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adaptee.buttonRunExperiments_actionPerformed(e);
    }
}
