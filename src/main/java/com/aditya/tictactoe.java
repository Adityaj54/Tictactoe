package com.aditya;

import java.util.Random;
import java.util.Scanner;

public class tictactoe {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                        new char[] {'-','-','-'},
                        new char[] {'-','-','-'},
                        new char[] {'-','-','-'}
        };

        int count = 0;
        int[][] positions = {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
        printboard(board);
        while (true) {

            Scanner scanner = new Scanner(System.in);
            playerMove(board, scanner, positions);
            count ++;

            if (checkGameOver(board,count,'X',"you")){
                break;
            }
            printboard(board);
            compMove(board, positions);
            count ++;

            if (checkGameOver(board,count,'O',"computer")){
                break;
            }
            printboard(board);
        }

    }

    private static Boolean checkGameOver(char[][] board,int count,char y,String player){

            for (int i = 0; i < 3; i++) {
                if ( board[i][0] == y && board[i][1] == y && board[i][2] == y ||
                        board[0][i] == y && board[1][i] == y  && board[2][i] == y ){
                    System.out.println(player + "Won Congrats!!!");
                    printboard(board);
                    return true;
                }
            }
       if ( board[0][0] == y &&  board[1][1] == y &&  board[2][2] == y ||
               board[0][2] == y &&  board[1][1] == y &&  board[2][0] == y )

       {
           System.out.println(player + "Won Congrats!!!");
           printboard(board);
           return true;
       }


            if (count == 9) {
                System.out.println("Gave Over with a Tie");
                printboard(board);
                return true;
            }

            return false;


    }

    private static void compMove(char[][] board, int[][] positions) {
        Random rand = new Random();

        while(true) {
            int compPosition = rand.nextInt(9) + 1;
            System.out.println("computer Chose" + compPosition);
            if (isMoveValid(board, positions, compPosition)) {
                board[positions[compPosition-1][0]][positions[compPosition-1][1]] = 'O';
                break;
            }

        }
    }

    private static boolean isMoveValid(char[][] board,int[][] positions, int compPosition){

        return board[positions[compPosition-1][0]][positions[compPosition-1][1]] == '-' ;



    }


    private static void playerMove(char[][] board, Scanner scanner,int[][] positions) {

        int position;
        do {
            System.out.println("enter the spot 1 - 9 ");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next();
            }
            position = scanner.nextInt();
        } while ( (position < 1 || position > 9) ||  !isMoveValid(board,positions,position));

        System.out.println(position);
        board[positions[position - 1][0]][positions[position - 1][1]] = 'X';
    }

    private static void printboard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);

        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);

        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }


}
