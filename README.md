Go Simulator

--------------------------------------------

This was another project done in my Java class. This one simulates a game of Go against the computer. User's play as black and the computer plays as white. After each turn the player is shown the current board, score, and prompted to keep playing until there is a winner. 
There are several error messages if a rule is broken, a player chooses an occupied spot, or an invalid command is given. 


>taken from the command line

Example: 

javac Go.java

java Go.java

 --------------------------------
 
Black's turn


What column would you like to place your piece at Black (or -1 to pass) ?

3

What row would you like to place your piece at Black (or -1 to pass) ?

5

Black you placed your piece at: 

3,5


White score: 0

Black score: 0

```
0  1 2 3 4 5 6 7 8 9
1 -|-|-|-|-|-|-|-|-|
2 -|-|-|-|-|-|-|-|-|
3 -|-|-|-|-|-|-|-|-|
4 -|-|-|-|-|-|-|-|-|
5 -|-|-B-|-|-|-|-|-|
6 -|-|-|-|-|-|-|-|-|
7 -|-|-|-|-|-|-|-|-|
8 -|-|-|-|-|-|-|-|-|
9 -|-|-|-|-|-|-|-|-|
```

White's turn


What column would you like to place your piece at White (or -1 to pass) ?

5

What row would you like to place your piece at White (or -1 to pass) ?

6

White you placed your piece at: 

5,6


White score: 0

Black score: 0
```
0  1 2 3 4 5 6 7 8 9
1 -|-|-|-|-|-|-|-|-|
2 -|-|-|-|-|-|-|-|-|
3 -|-|-|-|-|-|-|-|-|
4 -|-|-|-|-|-|-|-|-|
5 -|-|-B-|-|-|-|-|-|
6 -|-|-|-|-W-|-|-|-|
7 -|-|-|-|-|-|-|-|-|
8 -|-|-|-|-|-|-|-|-|
9 -|-|-|-|-|-|-|-|-|
```
Black's turn


What column would you like to place your piece at Black (or -1 to pass) ?

...
