package com.hackerrank.daily;

import java.util.Scanner;

/*
Two players are playing a game on a  chessboard. The rules of the game are as follows:

The game starts with a single coin located at some  coordinate. The coordinate of the upper left cell is , and the coordinate of the lower right cell is .
In each move, a player must move the coin from cell  to one of the following locations:

Note: The coin must remain inside the confines of the board.

The players move in alternating turns. The first player who is unable to make a move loses the game.

Given the initial coordinate of the coin, determine which player will win the game. Assume both players always move optimally and the first player always moves first.

Input Format

The first line contains an integer, , denoting the number of test cases. 
Each of the  subsequent lines contains  space-separated integers describing the respective  and  values of the coin's coordinate.

Constraints

Output Format

On a new line for each test case, print  if the first player is the winner; otherwise, print .

Sample Input

3
5 2
5 3
8 8
Sample Output

Second
First
First
 */
public class ChessGame {

    static String chessboardGame(int x, int y) {
    	    x=x%4; 
    	    y=y%4;
    	    if((y==0)||(y==3)||(x==0)||(x==3))
    	    		return "First";
    	    return "Second";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            String result = chessboardGame(x, y);
            System.out.println(result);
        }
        in.close();
    }
}
