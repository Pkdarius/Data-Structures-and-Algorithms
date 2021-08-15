package com.haitd22.dsa._3._1._1;

import java.util.Arrays;
import java.util.Random;

public class Scoreboard {
    private int numEntries = 0;
    private GameEntry[] board;

    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    public static void main(String[] args) {
        Scoreboard sb = new Scoreboard(10);
        Random rd = new Random();
        for (int i = 0; i < 20; i++) {
            sb.add(new GameEntry("A", rd.nextInt(100)));
            System.out.println(Arrays.toString(sb.getBoard()));
        }
    }

    public void add(GameEntry gameEntry) {
        int currentScore = gameEntry.getScore();

        if (numEntries < board.length || currentScore > board[numEntries - 1].getScore()) {
            if (numEntries < board.length) {
                numEntries++;
            }
            int currentPosition = numEntries - 1;
            while (currentPosition > 0 && currentScore > board[currentPosition - 1].getScore()) {
                board[currentPosition] = board[currentPosition - 1];
                currentPosition--;
            }
            board[currentPosition] = gameEntry;
        }
    }

    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i > numEntries) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
        GameEntry removedEntry = board[i];
        System.arraycopy(board, i + 1, board, i, numEntries - i);
        numEntries--;
        return removedEntry;
    }

    public GameEntry[] getBoard() {
        return board;
    }
}
