import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    JFrame frame;
    JPanel titlePanel, buttonPanel;
    JLabel textField;
    JButton[] buttons;
    JButton restartButton;
    boolean player1Turn;

    TicTacToe() {
        frame = new JFrame();
        titlePanel = new JPanel();
        buttonPanel = new JPanel();
        textField = new JLabel();
        buttons = new JButton[9];
        restartButton = new JButton("Restart");
        player1Turn = true;

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(100, 100, 100));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(75, 75, 75));
        textField.setForeground(new Color(0, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        restartButton.setFont(new Font("MV Boli", Font.BOLD, 30));
        restartButton.setFocusable(false);
        restartButton.addActionListener(this);

        titlePanel.add(textField);
        titlePanel.add(restartButton, BorderLayout.EAST);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == restartButton) {
            restartGame();
        } else {
            for (int i = 0; i < 9; i++) {
                if (e.getSource() == buttons[i]) {
                    if (buttons[i].getText().equals("")) {
                        if (player1Turn) {
                            buttons[i].setForeground(Color.RED);
                            buttons[i].setText("X");
                            textField.setText("O turn");
                            player1Turn = false;
                        } else {
                            buttons[i].setForeground(Color.BLUE);
                            buttons[i].setText("O");
                            textField.setText("X turn");
                            player1Turn = true;
                        }
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (Math.random() < 0.5) {
            player1Turn = true;
            textField.setText("X turn");
        } else {
            player1Turn = false;
            textField.setText("O turn");
        }
    }

    public void check() {
        // Check for X win conditions
        if (buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")) {
            xWins(0, 1, 2);
        } else if (buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X")) {
            xWins(3, 4, 5);
        } else if (buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X")) {
            xWins(6, 7, 8);
        } else if (buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X")) {
            xWins(0, 3, 6);
        } else if (buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")) {
            xWins(1, 4, 7);
        } else if (buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")) {
            xWins(2, 5, 8);
        } else if (buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X")) {
            xWins(0, 4, 8);
        } else if (buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X")) {
            xWins(2, 4, 6);
        }
        // Check for O win conditions
        else if (buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")) {
            oWins(0, 1, 2);
        } else if (buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O")) {
            oWins(3, 4, 5);
        } else if (buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O")) {
            oWins(6, 7, 8);
        } else if (buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O")) {
            oWins(0, 3, 6);
        } else if (buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O")) {
            oWins(1, 4, 7);
        } else if (buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")) {
            oWins(2, 5, 8);
        } else if (buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O")) {
            oWins(0, 4, 8);
        } else if (buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O")) {
            oWins(2, 4, 6);
        }
        // Check for a tie
        else if (!buttons[0].getText().equals("") && !buttons[1].getText().equals("") && !buttons[2].getText().equals("") &&
                !buttons[3].getText().equals("") && !buttons[4].getText().equals("") && !buttons[5].getText().equals("") &&
                !buttons[6].getText().equals("") && !buttons[7].getText().equals("") && !buttons[8].getText().equals("")) {
            tie();
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        textField.setText("X wins");
        restartButton.setEnabled(true);
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        textField.setText("O wins");
        restartButton.setEnabled(true);
    }

    public void tie() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setBackground(Color.YELLOW);
            buttons[i].setEnabled(false);
        }

        textField.setText("It's a tie");
        restartButton.setEnabled(true);
    }

    public void restartGame() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(true);
            buttons[i].setText("");
            buttons[i].setBackground(null);
        }

        restartButton.setEnabled(false);
        firstTurn();
    }
}