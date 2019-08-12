# How to run experiments

* **Runs**: Different seed that the algorithm is going to use to initialize the weights
* **Population size**: size of each population
* **Max generations**: Maximum number of iterations.
* **Snake type**: can be select by the combobox;

* Below there is an example:
```text
Runs: 10
Population size: 100
Max generations: 1000
//--------------------------------
Selection: tournament, roullette
Tournament size: 2, 4, 10
//--------------------------------
Recombination: one_cut, two_cuts, uniform
Recombination probability: 0.7, 0.8, 0.9
//--------------------------------
Mutation: uniform_distribution, uniform_distribution_limit, gaussian
Mutation probability: 0.7
Mutation limit: 0.5
//--------------------------------
//--------------------------------
Problem file: ./DataSets/DataSet1.txt
//--------------------------------
Statistic: BestIndividual
Statistic: BestAverage

```
