package org.example;

import java.util.Scanner;

public class Main {

    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';

    public static void main(String[] args) {


            boardList();
            boardPlayer();

            while(true) {
                playerMove();
                boardPlayer();

                if (checkBoard()){

                    System.out.println("Player "+currentPlayer+" yutdi");
                    break;
                }
                if(checkBoardFull()){
                    System.out.println("Tenglik");
                    break;
                }
                qaysiOyinchi();

            }
    }

    public static void playerMove(){
        Scanner scanner = new Scanner(System.in);
        int row , col;
        while (true){
            System.out.println("Player "+currentPlayer+" Enter row and column (1:3)");
            row=scanner.nextInt()-1;
            col=scanner.nextInt()-1;
            if (row>=0 && row<3 && col>=0 && col<3 && board[row][col]=='-'){
                board[row][col]=currentPlayer;
                break;
            }else {
                System.out.println("This move is not valid. Try again");
            }

        }
    }




    public static void boardList() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public static void boardPlayer() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkBoard() {

        //rows

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }

        //column

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }

        //diaganal

        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }

        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;


//        if (board[0][0]==currentPlayer && board[0][1]==currentPlayer && board[0][2]==currentPlayer){
//            return true;
//        }
//        if (board[1][0]==currentPlayer && board[1][1]==currentPlayer && board[1][2]==currentPlayer){
//            return true;
//        }
//        if (board[2][0]==currentPlayer && board[2][1]==currentPlayer && board[2][2]==currentPlayer){
//            return true;
//        }
//        return false;

    }

    public static void qaysiOyinchi(){
        currentPlayer=(currentPlayer=='X')? 'O' : 'X';
    }

    public static boolean checkBoardFull(){
        for (int i = 0; i <3; i++) {
            for (int j = 0; j <3; j++) {
                if (board[i][j]=='-'){
                    return false;
                }

            }

        }
        return true;
    }




}
