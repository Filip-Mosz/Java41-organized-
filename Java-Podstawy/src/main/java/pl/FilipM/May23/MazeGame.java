package pl.FilipM.May23;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Scanner;

public class MazeGame implements KeyListener {
    public static void main(String[] args) {
        char wall = '*';
        char space = ' ';
        char user = 'X';
        char finish = 'F';
        char up = '\u2191';
        //user starting position markers
        int row = 7;
        int column = 1;

//filling arrays
        char[][] maze = new char[9][];


        maze[0] = new char[]{'*', '*', '*', '*', '*', '*', '*', '*', '*'};
        maze[1] = new char[]{'*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*'};
        maze[2] = new char[]{'*', ' ', '*', ' ', '*', '*', '*', ' ', '*'};
        maze[3] = new char[]{'*', ' ', '*', ' ', '*', ' ', '*', ' ', '*'};
        maze[4] = new char[]{'*', ' ', '*', ' ', '*', ' ', '*', ' ', '*'};
        maze[5] = new char[]{'*', ' ', '*', ' ', '*', ' ', ' ', ' ', '*'};
        maze[6] = new char[]{'*', ' ', '*', ' ', '*', ' ', '*', '*', '*'};
        maze[7] = new char[]{'*', ' ', ' ', ' ', '*', ' ', ' ', ' ', finish};
        maze[8] = maze[0];

//user starting point: maze 7,1
        //maze[7][1] = user;
        maze[row][column] = user;
        while (true) {
            //printing maze
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze.length; j++) {
                    System.out.print(maze[i][j]);
                }
                System.out.println();
            }

            //moving through the maze


            System.out.println("Your move...? (8\u2191[up] 2\u2193[down] 4\u2190[left] 6\u2192[right] + Enter)");
            int move = new Scanner(System.in).nextInt();


            if (move == 2 || move == 4 || move == 6 || move == 8){
                maze[row][column] = ' ';
            } else {
                System.out.println("Wrong input");
            continue;
            }
            switch (move) {

                case 8: {
                    if(maze[row - 1][column] == finish){
                        System.out.println("You WON!!! \n Congratulations");
                        return;
                    }
                    if (maze[row - 1][column] == ' ') {
                        --row;
                        if(maze[row][column] == 'F'){
                            System.out.println("You WON!!! \b Congratulations");
                            break;
                        }
                        maze[row][column] = user;
                        continue;
                    }
                }
                case 4:{
                    if(maze[row][column - 1] == finish){
                        System.out.println("You WON!!! \n Congratulations");
                        return;
                    }
                    if (maze[row][column - 1] == ' ') {
                        --column;
                        maze[row][column] = user;
                        continue;
                    }
                }
                case 6:{
                    if(maze[row][column + 1] == finish){
                        System.out.println("You WON!!! \n Congratulations");
                        return;
                    }
                    if (maze[row][column + 1] == ' ') {
                        ++column;
                        maze[row][column] = user;
                        continue;
                    }
                }
                case 2:{
                    if(maze[row + 1][column] == finish){
                        System.out.println("You WON!!! \n Congratulations");
                        return;
                    }
                    if (maze[row + 1][column] == ' ') {
                        ++row;
                        maze[row][column] = user;
                        continue;
                    }
                }
                System.out.println(row + " " + column);
            }


        //test of clearing the terminal
        System.out.println("Kuper");

//        try {
//            Runtime.getRuntime().exec("clear");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
                System.out.println("windows");
            } else {
                Runtime.getRuntime().exec("clear");
                System.out.println("Linuks");
            }
        } catch (final Exception e) {
            System.out.println("obslugujemy wyjatek?");//  Handle any exceptions.
        }

        System.out.println("now what?!");
        }

    }

    // TODO: 2020-06-02 handle this
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    //copied from stackOverflow: https://stackoverflow.com/questions/2979383/java-clear-the-console
//    To solve this problem, we have to invoke the command line interpreter (cmd) and tell it to execute a command (/c cls) which allows invoking builtin commands. Further we have to directly connect its output channel to the Java process’ output channel, which works starting with Java 7, using inheritIO():
//
//            import java.io.IOException;
//
//    public class CLS {
//        public static void main(String... arg) throws IOException, InterruptedException {
//            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//        }
//    }
//
//    Now when the Java process is connected to a console, i.e. has been started from a command line without output redirection, it will clear the console.

}

// TODO: 2020-05-30 nie czyści konsoli, poznać obsługę wyjątków