/*
Chandler Bullock
CPSC 501 Assignment #1
Bad Version
*/
import java.lang.Math;

public class Sudoku {
     public static void main(String[] args){
         //Take a command line input of either "Easy" or "Hard"
         int[][] board = new int[9][9];
         //Randomly generate a sudoku board that is either easy or hard
         String holder = args[0];
         if(holder.equals("Easy")){
            //will provide a 50 percent chance of placing a number in a square
             for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                   int myRandom = (int) Math.floor(Math.random()*20);
                   if (myRandom < 11){
                       //do nothing
                       continue;
                   } else if (myRandom == 11){
                        board[i][j] = 1;
                   } else if (myRandom == 12){
                        board[i][j] = 2;
                   } else if (myRandom == 13){
                        board[i][j] = 3;
                   } else if (myRandom == 14){
                        board[i][j] = 4;
                   } else if (myRandom == 15){
                        board[i][j] = 5;
                   } else if (myRandom == 16){
                        board[i][j] = 6;
                   } else if (myRandom == 17){
                        board[i][j] = 7;
                   } else if (myRandom == 18){
                        board[i][j] = 8;
                   } else if (myRandom == 19){
                        board[i][j] = 9;
                   }
                   
                   //check to see if is a duplicate of a number in the row/column/block
                   //row
                   boolean failed = false;
                   for (int k = 0; k < j; k++){
                        if (board[i][k] == board[i][j]){
                        //if the row contains this number already, redo the random generation
                            board[i][j] = 0;
                            j--;
                            failed = true;
                       }
                       if (failed) break;
                   }
                   if (failed) continue;
                   //check column
                   for (int a = 0; a < i; a++) {
                        if (board[a][j] == board[i][j]){
                        //if the column contains this number already, redo the random generation
                            board[i][j] = 0;
                            j--;
                            failed = true;
                       }
                       if (failed) break;
                   }
                   if (failed) continue;
                   

                   //now check which block of 9 this square belongs to
                   int verticalStart = (int) (Math.floor(i/3))*3;        //options 0,1,2
                   int horizontalStart = (int) (Math.floor(j/3))*3;

                   for (int b = verticalStart; b < (verticalStart + 3); b++) {
                       for (int c = horizontalStart; c < (horizontalStart + 3); c++) {
                            if (b == i && c == j){
                                continue;
                            } else if (board[b][c] == board[i][j]){
                                board[i][j] = 0;
                                j--;                                
                                failed = true;
                            }
                            if(failed) break;
                       }
                       if (failed) break;
                   }
                   
                   if (failed) continue;
                }
            } 
         } else {
            //will provide 25% chance of a square having a number
             for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                   int myRandom = (int) Math.floor(Math.random()*30);
                   if (myRandom < 21){
                       //do nothing
                       continue;
                   } else if (myRandom == 21){
                        board[i][j] = 1;
                   } else if (myRandom == 22){
                        board[i][j] = 2;
                   } else if (myRandom == 23){
                        board[i][j] = 3;
                   } else if (myRandom == 24){
                        board[i][j] = 4;
                   } else if (myRandom == 25){
                        board[i][j] = 5;
                   } else if (myRandom == 26){
                        board[i][j] = 6;
                   } else if (myRandom == 27){
                        board[i][j] = 7;
                   } else if (myRandom == 28){
                        board[i][j] = 8;
                   } else if (myRandom == 29){
                        board[i][j] = 9;
                   }
                   
                   //check to see if is a duplicate of a number in the row/column/block
                   //row
                   boolean failed = false;
                   for (int k = 0; k < j; k++){
                        if (board[i][k] == board[i][j]){
                        //if the row contains this number already, redo the random generation
                            j--;
                            failed = true;
                       }
                       if (failed) break;
                   }
                   if (failed) break;
                   //check column
                   for (int a = 0; a < i; a++) {
                        if (board[a][j] == board[i][j]){
                        //if the column contains this number already, redo the random generation
                            j--;
                            failed = true;
                       }
                       if (failed) break;
                   }
                   if (failed) break;
                   
                   //now check which block of 9 this square belongs to
                   int verticalStart = (int) (Math.floor(i/3))*3;        //options 0,1,2
                   int horizontalStart = (int) (Math.floor(j/3))*3;

                   for (int b = verticalStart; b < (verticalStart + 3); b++) {
                       for (int c = horizontalStart; c < (horizontalStart + 3); c++) {
                            if (b == i && c == j){
                                continue;
                            } else if (board[b][c] == board[i][j]){
                                j--;
                                failed = true;
                            }
                            if(failed) break;
                       }
                       if (failed) break;
                   }
                   if (failed) break;
                }
            }
         }
         
         //Check that the sudoku board is solvable with given info
         Sudoku mySudoku = new Sudoku();
         if(mySudoku.checkSolvable(board)){
             //if the board is valid then print it
             for (int i = 0; i < 9; i++) {
                 for (int j = 0; j < 9; j++) {
                     System.out.print(board[i][j] + " | ");
                 }
                 System.out.println();
             }

         } else {
             //need to regenerate a new board
             mySudoku.regenBoard(args[1]);
         }
     }

    private void regenBoard(String difficulty) {
        int[][] board = new int[9][9];
         //Randomly generate a sudoku board that is either easy or hard
         if(difficulty == "Easy"){
            //will provide a 50 percent chance of placing a number in a square
            for (int i = 0; i < 9; i++) {
            //row
                for (int j = 0; j < 9; j++) {
                    //column
                   int myRandom = (int) Math.floor(Math.random()*20);
                   if (myRandom < 11){
                       //do nothing
                   } else if (myRandom == 11){
                        board[i][j] = 1;
                   } else if (myRandom == 12){
                        board[i][j] = 2;
                   } else if (myRandom == 13){
                        board[i][j] = 3;
                   } else if (myRandom == 14){
                        board[i][j] = 4;
                   } else if (myRandom == 15){
                        board[i][j] = 5;
                   } else if (myRandom == 16){
                        board[i][j] = 6;
                   } else if (myRandom == 17){
                        board[i][j] = 7;
                   } else if (myRandom == 18){
                        board[i][j] = 8;
                   } else if (myRandom == 19){
                        board[i][j] = 9;
                   }
                   // will never be 20 because random can never generate inclusive 1.0
                   //check if the number already exists in the row/column/block
                   //row
                   for (int k = 0; i < 9; k++) {
                       if (k == j){
                            continue;
                       } else if (board[i][k] == board[i][j]){
                        //if the row contains this number already, redo the random generation
                            j--;
                            continue;
                       }
                   }
                   //check column
                   for (int a = 0; i < 9; a++) {
                       if (a == i){
                            continue;
                       } else if (board[a][j] == board[i][j]){
                        //if the column contains this number already, redo the random generation
                            j--;
                            continue;
                       }
                   }
                   
                   //now check which block of 9 this square belongs to
                   int verticalStart = (int) (Math.floor(i/3))*3;        //options 0,1,2
                   int horizontalStart = (int) (Math.floor(j/3))*3;

                   for (int b = verticalStart; b < (b+3); b++) {
                       for (int c = horizontalStart; i < (c+3); c++) {
                           if (b == i && c == j){
                                continue;
                            } else if (board[b][c] == board[i][j]){
                               j--;
                                continue;
                            }
                       }
                   }
                }
            }

         } else {
            //will provide 25% chance of a square having a number
             for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                   int myRandom = (int) Math.floor(Math.random()*30);
                   if (myRandom < 10){
                       //do nothing
                   } else if (myRandom == 21){
                        board[i][j] = 1;
                   } else if (myRandom == 22){
                        board[i][j] = 2;
                   } else if (myRandom == 23){
                        board[i][j] = 3;
                   } else if (myRandom == 24){
                        board[i][j] = 4;
                   } else if (myRandom == 25){
                        board[i][j] = 5;
                   } else if (myRandom == 26){
                        board[i][j] = 6;
                   } else if (myRandom == 27){
                        board[i][j] = 7;
                   } else if (myRandom == 28){
                        board[i][j] = 8;
                   } else if (myRandom == 29){
                        board[i][j] = 9;
                   }
                   
                   //check to see if is a duplicate of a number in the row/column/block
                   //row
                   for (int k = 0; i < 9; k++) {
                       if (k == j){
                            continue;
                       } else if (board[i][k] == board[i][j]){
                        //if the row contains this number already, redo the random generation
                            j--;
                            continue;
                       }
                   }
                   //check column
                   for (int a = 0; i < 9; a++) {
                       if (a == i){
                            continue;
                       } else if (board[a][j] == board[i][j]){
                        //if the column contains this number already, redo the random generation
                            j--;
                            continue;
                       }
                   }
                   
                   //now check which block of 9 this square belongs to
                   int verticalStart = (int) (Math.floor(i/3))*3;        //options 0,1,2
                   int horizontalStart = (int) (Math.floor(j/3))*3;

                   for (int b = verticalStart; b < (b+3); b++) {
                       for (int c = horizontalStart; i < (c+3); c++) {
                           if (b == i && c == j){
                                continue;
                            } else if (board[b][c] == board[i][j]){
                               j--;
                                continue;
                            }
                       }
                   }
                }
            }
         }
         
         //Check that the sudoku board is solvable with given info
         if(checkSolvable(board)){
             //if the board is valid then print it

         } else {
             //need to regenerate a new board
             regenBoard(difficulty);
         }
    }

    private boolean checkSolvable(int[][] theBoard) {
        return true;
    }

}

/*
------ Notes for changes ------
Error check the command line input more robustly
get rid of obvious duplicate code
clarify names of methods and variables
delegate tasks to other classes
get rid of constants in place of dynamic identifiers
generate a random num 1-9 and then do another random to determine if it stays
then have a function for checking which checks the row, column, and block
*/