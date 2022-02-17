MineField Navigator
==========================
***Created by Sarah Choi and Anthony Palma***

<img width="435" alt="Screen Shot 2021-12-10 at 12 41 21 PM" src="https://user-images.githubusercontent.com/89939471/145632453-9243f35b-323d-4fa4-86d3-9c4235562a39.png"><img width="435" alt="Screen Shot 2021-12-10 at 12 43 33 PM" src="https://user-images.githubusercontent.com/89939471/145632498-dec37ffa-14cd-43af-9856-17330f6ecb9f.png">

The program allows you to play the game of "MineField Navigator." A 10 x 10 grid with mines is generated and the user must find a path to the top of the grid without hitting a mine. The mines are visible and randomly placed, increasing in number as the player advances in round. A new grid is generated every time the user hits a mine or advances a round. The number of lives and round can be found on the right side of the canvas. 

## How to Play
Our code is seperated in three classes: MineFieldNavigator, Player, and Mine. To run the game, run the MineFieldNavigator.class (main). This will generate a canvas for the game.

The user is able to navigate through the grid using arrow keys (up, down, left, right). At the start, the user is randomly placed anywhere on the bottom row and their goal is to get to the top of the grid, without hitting any mines. The user is given 3 lives total and loses a life when it hits a mine. The user advances a round every time they successfully reach the top of the grid. 

### How to Win
The user wins the game when they successfully beat 10 rounds with at least 1 life left. 

### How to Lose
The user loses the game when they lose all 3 lives (hitting a mine 3 times). 

### Features
- The game features allows for user interaction using keyboard arrow keys 
- The design of the game canvas is simple yet easy to navigate 
- The number of lives left and current round is updated and displayed on the canvas throughout the game

## Challenges
We found the biggest challenge to be simply setting up the canvas with a grid. We spent over one whole class period simply trying to place a grid. Eventually, we discovered we would have to perform much more manual work than desired by placing a series of crossing horizontal and vertical lines, using a for loop, and manually looping through each row when we desired to place mines and players.  It was more effort than expected, but once we figured it out we hit the ground running. 

## Attributions
We would like to acknoweldge COMP 127 Preceptors Nam and Izzy for helping with debugging and code writing and Professor Peña for giving us guidace and feedback throughout the project.
