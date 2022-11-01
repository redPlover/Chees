import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Chess {

    JButton[][] boardSquares = new JButton[8][8];
    GameState state = new GameState();
    Validator val = new Validator();
    JFrame jFrame = new JFrame("Chees");

    private static int x1 = 100;
    private static int y1 = 100;

    public Chess() {}

    public void start(boolean isWhite) throws IOException {
        jFrame.setLayout(new GridLayout(8, 8));
        jFrame.setSize(700, 700);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                JButton b = new JButton();
                if ((x % 2 == 1 && y % 2 == 1) || (x % 2 == 0 && y % 2 == 0)) {
                    b.setBackground(isWhite ? Color.WHITE : Color.ORANGE);
                } else {
                    b.setBackground(isWhite ? Color.ORANGE : Color.WHITE);
                }
                boardSquares[x][y] = b;
                int yy = y;
                int xx = x;
                boardSquares[x][y].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        check(xx, yy);
                    }
                });
                jFrame.add(b);
            }
        }

        if (isWhite) {
            for (int x = 0; x < 8; x++) {
                boardSquares[x][1].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 11 + ".png")))));
                state.putInMap(((x+1)*10)+2, 11);
                boardSquares[x][6].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 10 + ".png")))));
                state.putInMap(((x+1)*10)+7, 10);
            }
            // Black
            boardSquares[0][0].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 21 + ".png")))));
            state.putInMap(11, 21);
            boardSquares[7][0].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 21 + ".png")))));
            state.putInMap(81, 21);
            boardSquares[1][0].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 31 + ".png")))));
            state.putInMap(21, 31);
            boardSquares[6][0].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 31 + ".png")))));
            state.putInMap(71, 31);
            boardSquares[2][0].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 41 + ".png")))));
            state.putInMap(31, 41);
            boardSquares[5][0].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 41 + ".png")))));
            state.putInMap(61, 41);
            boardSquares[3][0].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 51 + ".png")))));
            state.putInMap(41, 51);
            boardSquares[4][0].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 61 + ".png")))));
            state.putInMap(51, 61);

            // White
            boardSquares[0][7].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 20 + ".png")))));
            state.putInMap(18, 20);
            boardSquares[7][7].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 20 + ".png")))));
            state.putInMap(88, 20);
            boardSquares[1][7].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 30 + ".png")))));
            state.putInMap(28, 30);
            boardSquares[6][7].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 30 + ".png")))));
            state.putInMap(78, 30);
            boardSquares[2][7].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 40 + ".png")))));
            state.putInMap(38, 40);
            boardSquares[5][7].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 40 + ".png")))));
            state.putInMap(68, 40);
            boardSquares[3][7].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 50 + ".png")))));
            state.putInMap(48, 50);
            boardSquares[4][7].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 60 + ".png")))));
            state.putInMap(58, 60);
        } else {
            for (int x = 0; x < 8; x++) {
                boardSquares[x][1].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 10 + ".png")))));
                state.putInMap(((x+1)*10)+2, 10);
                boardSquares[x][6].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 11 + ".png")))));
                state.putInMap(((x+1)*10)+7, 11);
            }
            // White
            boardSquares[0][0].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 20 + ".png")))));
            state.putInMap(11, 20);
            boardSquares[7][0].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 20 + ".png")))));
            state.putInMap(81, 20);
            boardSquares[1][0].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 30 + ".png")))));
            state.putInMap(21, 30);
            boardSquares[6][0].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 30 + ".png")))));
            state.putInMap(71, 30);
            boardSquares[2][0].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 40 + ".png")))));
            state.putInMap(31, 40);
            boardSquares[5][0].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 40 + ".png")))));
            state.putInMap(61, 40);
            boardSquares[3][0].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 50 + ".png")))));
            state.putInMap(41, 50);
            boardSquares[4][0].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 60 + ".png")))));
            state.putInMap(51, 60);

            // Black
            boardSquares[0][7].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 21 + ".png")))));
            state.putInMap(18, 21);
            boardSquares[7][7].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 21 + ".png")))));
            state.putInMap(88, 21);
            boardSquares[1][7].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 31 + ".png")))));
            state.putInMap(28, 31);
            boardSquares[6][7].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 31 + ".png")))));
            state.putInMap(78, 31);
            boardSquares[2][7].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 41 + ".png")))));
            state.putInMap(38, 41);
            boardSquares[5][7].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 41 + ".png")))));
            state.putInMap(68, 41);
            boardSquares[3][7].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 51 + ".png")))));
            state.putInMap(48, 51);
            boardSquares[4][7].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + 61 + ".png")))));
            state.putInMap(58, 61);
        }

        for (int y = 3; y < 7; y++) {
            for (int x = 0; x < 9; x++) {
                state.putInMap(((x+1)*10)+y, 0);
            }
        }

        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }

    public void check(int x, int y) {
        x++;
        y++;

        int x2;
        int y2;

        if (x1 == 100) {
            x1 = x;
            y1 = y;
        } else {
            x2 = x;
            y2 = y;

            if (x1 == x2 && y1 == y2) {
                System.out.println("break");
            } else {
                int symb = state.checkPiece(x1, y1);
                int type = symb / 10;
                int color = symb % 10;
                int cond = state.checkPiece(x2, y2);
                System.out.println("x1: " + x1 + "\nx2: " + x2 + "\ny1: " + y1 + "\ny2: " + y2);
                System.out.println(val.validation(type, color, x1, x2, y1, y2));
                if (((Main.whiteTurn == true && state.checkPiece(x1, y1) % 10 == 0) || (Main.whiteTurn == false && state.checkPiece(x1, y1) % 10 == 1)) && val.validation(type, color, x1, x2, y1, y2)) {
                    boardSquares[x1-1][y1-1].removeAll();
                    boardSquares[x2-1][y2-1].removeAll();
                    boardSquares[x1-1][y1-1].setText("");
                    Integer i = state.checkPiece(x1, y1);
                    boardSquares[x2-1][y2-1].setText(i.toString());
                    state.updateMap(x2 * 10 + y2, state.checkPiece(x1, y1));
                    state.updateMap(x1 * 10 + y1, 0);
                    //boardSquares[x2-1][y2-1].add(new JLabel(new ImageIcon(ImageIO.read(new File("images/" + state.checkPiece(x1, y1) + ".png")))));
                    Main.whiteTurn = !Main.whiteTurn;
                    jFrame.repaint();
                    if (cond == 60 || cond == 61) {
                        if (Main.whiteTurn) {
                            JFrame jFrameOth = new JFrame("Black wins");
                            jFrameOth.setSize(200, 200);
                            jFrameOth.setLocationRelativeTo(null);
                            jFrameOth.setResizable(false);
                            jFrameOth.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            jFrameOth.setVisible(true);
                            JLabel wins = new JLabel("Black wins!");
                            jFrameOth.add(wins);
                            jFrame.dispose();
                        } else {
                            JFrame jFrameOth = new JFrame("White wins");
                            jFrameOth.setSize(200, 200);
                            jFrameOth.setLocationRelativeTo(null);
                            jFrameOth.setResizable(false);
                            jFrameOth.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            jFrameOth.setVisible(true);
                            JLabel wins = new JLabel("White wins!");
                            jFrameOth.add(wins);
                            jFrame.dispose();
                        }
                    }
                }
            }
            
            x1 = 100;
            y1 = 100;
        }
    }

        /*
        String piece = "";
        if (symb == 0) {
            piece = "blank";
        } else if (color == 0) {
            if (type == 1) {
                piece = "white pawn";
            } else if (type == 2) {
                piece = "white rook";
            } else if (type == 3) {
                piece = "white knight";
            } else if (type == 4) {
                piece = "white bishop";
            } else if (type == 5) {
                piece = "white queen";
            } else if (type == 6) {
                piece = "white king";
            }
        } else if (color == 1) {
            if (type == 1) {
                piece = "black pawn";
            } else if (type == 2) {
                piece = "black rook";
            } else if (type == 3) {
                piece = "black knight";
            } else if (type == 4) {
                piece = "black bishop";
            } else if (type == 5) {
                piece = "black queen";
            } else if (type == 6) {
                piece = "black king";
            }
        }
        System.out.println("The piece is a " + piece + ".");
        */
    }
