#Snake AI

## What you need?
* At least JDK 8.

## How to run
* Execute Main class in package ovh.ladon.gui

## AI snakes
* This snakes uses genetics algorithms and neural networks to learn.


## Configurations
* Once the project has been executed, you will be presented with an interface.
* Main Configurations:
    * **Selection Algorithm:** you can select type of snake you want to execute.
        * **AdDhoc snake:** is a simple snake that follows rules implemented by us. It does not improve over time.
        * **Random Snake:** is a snake that chooses the next step in a random way
        * **AI1 Snake:** Snake that uses 13 inputs, 5 hidden units and 2 outputs. (this can be changed changing the Data Set)
        * **AI2 Snake:** Snake that uses 17 inputs, 8 hidden units and 4 outputs. (this can be changed changing the Data Set)
        * **Two AI2 Snake:** Two snakes of type AI2 on field.
        * **Two Different snakes:** AI1+AI2 on the field.
    * **Note:** When there are 2 snakes on the field any snake can be dominant over the other, otherwise it would be too easy. (One snake would play dumb and the other eat everything)
    * After setting the Dataset for the snake you can click on run and the snake will learn playing the game with options selected 
    in painel. After that you can click simulate and see result of the learning.
    
    * To test the best combination of configuration, experiments can be run. Another readme explaining on resources.
    
    

## Authors
* **Kevin Baptista**
* **Tomás Honório**
* Work developed under the guidance and coordination of Professor **Anabela Bernardino**