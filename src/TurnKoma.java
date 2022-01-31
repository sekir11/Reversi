public class TurnKoma {


    private int x;
    private int y;
    private String putKoma;
    private String reputKoma;
    private Field field;

    public TurnKoma(int y, int x, String putKoma, String reputKoma, Field field) {
        this.x = x;
        this.y = y;
        this.putKoma = putKoma;
        this.reputKoma = reputKoma;
        this.field = field;
    }

    public void judge() {
        turnDown();
        turnUp();
        turnLeft();
        turnRight();
        turnRightUp();
        turnRightDown();
        turnLeftDown();
        turnLeftUp();
    }


    /**
     * 駒を置いた場所から下方向にひっくり返す駒を判定しひっくり返す
     */
    public void turnDown() {
        if (y < 6) {
            String next = field.getBoard()[y + 1][x];

            if (next.equals(reputKoma)) {

                for (int i = 2; true; i++) {

                    if (y + i > 7 || field.getBoard()[y + i][x].equals(Field.EMPTY)) {
                        break;
                    } else if (field.getBoard()[y + i][x].equals(putKoma)) {

                        for (int j = 1; j < i; j++) {
                            field.getBoard()[y + j][x] = putKoma;
                        }
                        Reversi.canPut = true;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 駒を置いた場所から上方向にひっくり返す駒を判定しひっくり返す
     */
    public void turnUp() {
        if (y > 0) {
            String next = field.getBoard()[y - 1][x];

            if (next.equals(reputKoma)) {

                for (int i = 2; true; i++) {

                    if (y - i < 0 || field.getBoard()[y - i][x].equals(Field.EMPTY)) {
                        break;
                    } else if (field.getBoard()[y - i][x].equals(putKoma)) {
                        for (int j = 1; j < i; j++) {
                            field.getBoard()[y - j][x] = putKoma;
                        }
                        Reversi.canPut = true;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 駒を置いた場所から左方向にひっくり返す駒を判定してひっくり返す
     */
    public void turnLeft() {
        if (x > 1) {
            String next = field.getBoard()[y][x - 1];

            if (next.equals(reputKoma)) {
                for (int i = 2; true; i++) {
                    if (x - i < 0 || field.getBoard()[y][x - i].equals(Field.EMPTY)) {
                        break;
                    } else if (field.getBoard()[y][x - i].equals(putKoma)) {
                        for (int j = 1; j < i; j++) {
                            field.getBoard()[y][x - j] = putKoma;
                        }
                        Reversi.canPut = true;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 駒を置いた場所から右方向にひっくり返す駒を判定してひっくり返す
     */
    public void turnRight() {
        if (x < 6) {
            String next = field.getBoard()[y][x + 1];

            if (next.equals(reputKoma)) {
                for (int i = 2; true; i++) {
                    if (x + i > 7 || field.getBoard()[y][x + i].equals(Field.EMPTY)) {
                        break;
                    } else if (field.getBoard()[y][x + i].equals(putKoma)) {
                        for (int j = 1; j < i; j++) {
                            field.getBoard()[y][x + j] = putKoma;
                        }
                        Reversi.canPut = true;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 駒を置いた場所から右斜め上方向にひっくり返す駒を判定してひっくり返す
     */
    public void turnRightUp() {
        if (x < 6 && y > 1) {
            String next = field.getBoard()[y - 1][x + 1];

            if (next.equals(reputKoma)) {
                for (int i = 2; true; i++) {
                    if (x + i > 7 || y - i < 0 || field.getBoard()[y - i][x + i].equals(Field.EMPTY)) {
                        break;
                    } else if (field.getBoard()[y - i][x + i].equals(putKoma)) {
                        for (int j = 1; j < i; j++) {
                            field.getBoard()[y - j][x + j] = putKoma;
                        }
                        Reversi.canPut = true;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 駒を置いた場所から右斜め下方向にひっくり返す駒を判定してひっくり返す
     */
    public void turnRightDown() {
        if (x < 6 && y < 6) {
            String next = field.getBoard()[y + 1][x + 1];

            if (next.equals(reputKoma)) {
                for (int i = 2; true; i++) {
                    if (x + i > 7 || y + i > 7 || field.getBoard()[y + i][x + i].equals(Field.EMPTY)) {
                        break;
                    } else if (field.getBoard()[y + i][x + i].equals(putKoma)) {
                        for (int j = 1; j < i; j++) {
                            field.getBoard()[y + j][x + j] = putKoma;
                        }
                        Reversi.canPut = true;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 駒を置いた場所から左斜め下方向にひっくり返す駒を判定してひっくり返す
     */
    public void turnLeftDown() {
        if (x > 1 && y < 6) {
            String next = field.getBoard()[y + 1][x - 1];

            if (next.equals(reputKoma)) {
                for (int i = 2; true; i++) {
                    if (x - i < 0 || y + i > 7 || field.getBoard()[y + i][x - i].equals(Field.EMPTY)) {
                        break;
                    } else if (field.getBoard()[y + i][x - i].equals(putKoma)) {
                        for (int j = 1; j < i; j++) {
                            field.getBoard()[y + j][x - j] = putKoma;
                        }
                        Reversi.canPut = true;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 駒を置いた場所から左斜め上方向にひっくり返す駒を判定してひっくり返す
     */
    public void turnLeftUp() {
        if (x > 1 && y > 1) {
            String next = field.getBoard()[y - 1][x - 1];

            if (next.equals(reputKoma)) {
                for (int i = 2; true; i++) {
                    if (x - i < 0 || y - i < 0 || field.getBoard()[y - i][x - i].equals(Field.EMPTY)) {
                        break;
                    } else if (field.getBoard()[y - i][x - i].equals(putKoma)) {
                        for (int j = 1; j < i; j++) {
                            field.getBoard()[y - j][x - j] = putKoma;
                        }
                        Reversi.canPut = true;
                        break;
                    }
                }
            }
        }
    }


}