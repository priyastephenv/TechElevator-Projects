# Command-Line Exercises



## Make change

Complete the code in the main method to prompt the user for the total bill, and the amount tendered. The program then displays the change required.

```
Please enter the amount of the bill: $23.65
Please enter the amount tendered: $100.00
The change required is $76.35
```

## Martian Weight

In case you've ever pondered how much you weigh on Mars, here's the calculation:

    Wm = We* 0.378

where 'Wm' is the weight on Mars, and 'We' is the weight on Earth

Complete the code in the main method that accepts a series of Earth weights from the user
and displays each Earth weight as itself, and its Martian equivalent.

Use the method `Integer.parseInt()` to convert a string to its int equivalent,
for example: \
`int weightLbs = Integer.parseInt("98");`

```
Enter a series of Earth weights (space-separated): 98 235 185

98 lbs. on Earth is 37 lbs. on Mars.
235 lbs. on Earth is 88 lbs. on Mars.
185 lbs. on Earth is 69 lbs. on Mars.
```

## *Challenge Exercise*: Rock Paper Scissors

The classic game of rock, paper, scissors.
2 players can throw either rock, paper, or scissors.
The rules below determine who wins:
```
    rock beats scissors
    rock loses to scissors

    paper beats rock
    paper loses to scissors

    paper beats rock
    paper loses to scissors

    if both players throw the same thing it's a draw.
```

Create a best-of-3 game of rock, paper, scissors where the user
plays against the computer.

Use the getRandomNumber method to get a random integer of 0, 1, 2\
Hint: Use an if statement and correlate 0 with rock, 1 with paper, 2 with scissors
