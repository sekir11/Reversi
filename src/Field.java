public class Field {

    static final String EMPTY = "×";
    static final String BLACK = "●";
    static final String WHITE = "◎";

    private String[][] board = new String[8][8];

    private int countBlack;
    private int countWhite;
    private boolean judge;


    public Field() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = EMPTY;
            }
        }

        board[3][3] = BLACK;
        board[4][4] = BLACK;
        board[4][3] = WHITE;
        board[3][4] = WHITE;

        judge();
        Reversi.message1 = "黒の番です";
        countBlack = 0;
        countWhite = 0;
        judge = true;
    }

    public int getCountBlack() {
        return this.countBlack;
    }

    public int getCountWhite() {
        return this.countWhite;
    }

    public boolean getJudge() {
        return this.judge;
    }

    public void setJudge(boolean judge) {
        this.judge = judge;
    }

    public String[][] getBoard() {
        return this.board;
    }

    public void setKoma(int y, int x, String koma) {
        this.board[y][x] = koma;
    }


    public void judge() {
        countBlack = 0;
        countWhite = 0;
        for (String[] element : board) {
            for (String ele : element) {
                if (ele == EMPTY) {
                    judge = true;
                } else if (ele == BLACK) {
                    countBlack++;
                } else {
                    countWhite++;
                }
            }
        }
    }
}
