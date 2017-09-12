package org.mycompany;

public class TicTacToe {
    private static final int SIZE = 3;
    private char[][] board = {  {'\0', '\0', '\0'},
                                {'\0', '\0', '\0'},
                                {'\0', '\0', '\0'}};
    private char lastPlayer = '\0';
    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y);
        if (isWin(x, y))
            return lastPlayer + " is the winner";
        else if (isDraw())
            return "The result is draw";
        return "No winner";
    }
    private boolean isDraw() {
        for(char[] row: board) {
            for(char box: row) {
                if (box == '\0')
                    return false;
            }
        }
        return true;
    }

    private boolean isWin(int x, int y) {
        int payerTotal = lastPlayer * SIZE;
        char horizontal, vertical, diagonal1, diagonal2;
        horizontal = vertical = diagonal1 = diagonal2 = '\0';
        for (int i=0; i<SIZE; i++) {
            horizontal += board[x - 1][i];
            vertical += board[i][y - 1];
            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];
        }
        if(horizontal == payerTotal || vertical == payerTotal || diagonal1 == payerTotal || diagonal2 == payerTotal)
            return true;

        return false;
    }

    private void setBox(int x, int y) {
        checkOccupied(x, y);
        board[x - 1][y - 1] = lastPlayer;
    }

    private void checkOccupied(int x, int y) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("Box is occupied");
        }
    }

    private void checkAxis(int axis) {
        if (axis < 1 || axis > 3)
            throw new RuntimeException("X is outside boundaries");
    }

    public char nextPlayer() {
        if (lastPlayer == 'X') {
            return '0';
        }
        return 'X';
    }

}
