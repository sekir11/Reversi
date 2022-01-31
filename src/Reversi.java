import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Reversi extends JPanel {

    private Field field;

    public Reversi() {
        setPreferredSize(new Dimension(500, 550));
        addMouseListener(new MouseProc());
        field = new Field();
    }

    static boolean canPut = false;
    static boolean judgeBlack = false;
    static boolean judgeWhite = false;

    static int count = 1;

    static String message1="";
    static String message2="";


    public void putJudge() {

        judgeBlack = false;
        judgeWhite = false;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (field.getBoard()[y][x].equals(Field.EMPTY)) {
                    JudgePutKoma judgePutKomaBlack = new JudgePutKoma(y, x, Field.BLACK, Field.WHITE, field);
                    JudgePutKoma judgePutKomaWhite = new JudgePutKoma(y, x, Field.WHITE, Field.BLACK, field);

                    judgePutKomaBlack.judge();
                    judgePutKomaWhite.judge();
                }
            }
        }
    }

    public void showBoard(int x, int y) {
        String putKoma = "";
        String reputKoma = "";

        canPut = false;
        field.setJudge(false);

        if (count % 2 != 0) {
            putKoma = Field.BLACK;
            reputKoma = Field.WHITE;
        } else {
            putKoma = Field.WHITE;
            reputKoma = Field.BLACK;
        }

        TurnKoma turnKoma = new TurnKoma(y, x, putKoma, reputKoma, field);

        if (field.getBoard()[y][x].equals(Field.EMPTY)) {
            turnKoma.judge();
        }

        if (canPut) {
            if (count % 2 != 0) {
                field.setKoma(y, x, putKoma);
            } else {
                field.setKoma(y, x, putKoma);
            }
            count++;
        } else {
            message2="そこに駒を置くことはできません";
        }

        putJudge();
        field.judge();

        if (count % 2 != 0) {
            if (judgeBlack) {
                message1="黒の番です";
            } else if (judgeWhite) {
                count++;
                message2="黒は置くことができません";
                message1="白の番です";
            } else {
                field.setJudge(false);
            }
        } else {
            if (judgeWhite) {
                message1="白の番です";
            } else if (judgeBlack) {
                count++;
                message1="白は置くことができません";
                message2="黒の番です";
            } else {
                field.setJudge(false);
            }
        }

        if(!field.getJudge()) {
            if(field.getCountBlack() > field.getCountWhite()) {
                message1="黒の勝ち！";
            }else if(field.getCountBlack() < field.getCountWhite()) {
                message1="白の勝ち！";
            }else {
                message1="引き分け";
            }
        }

    }

    // 画面描画
    public void paintComponent(Graphics g) {

        // 背景
        g.setColor(Color.black);
        g.fillRect(0, 0, 500, 550);
        //盤面
        g.setColor(new Color(0, 85, 0));
        g.fillRect(50, 100, 400, 400);
        // 横線
        g.setColor(Color.black);
        for (int y = 100; y <= 500; y = y + 50) {
            g.drawLine(50, y, 450, y);
        }
        // 縦線
        for (int x = 50; x <= 450; x = x + 50) {
            g.drawLine(x, 100, x, 500);
        }
        //盤面の四角の点
        g.setColor(Color.black);
        g.fillRect(149, 199, 3, 3);
        g.fillRect(349, 399, 3, 3);
        g.fillRect(149, 399, 3, 3);
        g.fillRect(349, 199, 3, 3);

        //コマ数の表示
        g.setColor(Color.white);
        g.drawString(message1, 50, 50);
        g.drawString(message2, 50, 70);
        g.drawString("●：" + field.getCountWhite(), 400, 50);
        g.drawString("○：" + field.getCountBlack(), 400, 70);

        int y = 50;
        int x = 50;

        for (int i = 0; i < field.getBoard().length; i++) {
            y += 50;
            x = 50;
            for (int j = 0; j < field.getBoard().length; j++) {
                if (field.getBoard()[i][j] == "●") {
                    g.setColor(Color.black);
                    g.fillOval(x + 5, y + 5, 40, 40);
                }
                if (field.getBoard()[i][j] == "◎") {
                    g.setColor(Color.white);
                    g.fillOval(x + 5, y + 5, 40, 40);
                }
                x += 50;
            }
        }

    }

    class MouseProc extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {

            message1="";
            message2="";

            int putX = 0;
            int putY = 0;
            loop1: for (int j = 50; j <= 400; j += 50) {
                putX = 0;
                for (int k = 100; k <= 450; k += 50) {
                    if (e.getX() >= j && e.getX() < j + 50 && e.getY() >= k && e.getY() < k + 50) {
                        break loop1;
                    }
                    putX++;
                }
                putY++;
            }
            showBoard(putY, putX);
            repaint();
        }
    }

    // 起動
    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.getContentPane().setLayout(new FlowLayout());
        f.getContentPane().add(new Reversi());
        f.pack();
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}