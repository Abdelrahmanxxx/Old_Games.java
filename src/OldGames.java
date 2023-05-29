import Pong.GameFrame;
import Snake.SnakeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class OldGames implements ActionListener {

    //Add WindowListener for each Game to check if game is closed or not
    WindowListener tetris_windowListener = new WindowListener() {
        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosing(WindowEvent e) {
            tetris_button.setEnabled(true);
        }

        @Override
        public void windowClosed(WindowEvent e) {
        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }
    };

    WindowListener pong_windowListener = new WindowListener() {
        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosing(WindowEvent e) {
            pong_button.setEnabled(true);
        }

        @Override
        public void windowClosed(WindowEvent e) {
        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }
    };

    WindowListener rock_windowListener = new WindowListener() {
        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosing(WindowEvent e) {
            rock_paper_scissor_button.setEnabled(true);
        }

        @Override
        public void windowClosed(WindowEvent e) {
        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }
    };

    WindowListener snake_windowListener = new WindowListener() {
        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosing(WindowEvent e) {
            snake_button.setEnabled(true);
        }

        @Override
        public void windowClosed(WindowEvent e) {
        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }
    };

    WindowListener XO_windowListener = new WindowListener() {
        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosing(WindowEvent e) {
            XO_button.setEnabled(true);
        }

        @Override
        public void windowClosed(WindowEvent e) {
        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }
    };

    //Add WindowListener for set timer to check if the timer is closed or not
    WindowListener timer_windowListener = new WindowListener() {
        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosing(WindowEvent e) {
            set_timer_button.setEnabled(true);
        }

        @Override
        public void windowClosed(WindowEvent e) {
        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }
    };


    //Objectives
    String[] objectives = {
            "Win 3 consecutive games of Rock Paper Scissors.",
            "Experiment with different strategies and mind games in Rock Paper Scissors",
            "Achieve a win rate of 80% or higher in Rock Paper Scissors for the day",
            "Clear 4 lines in a single game of Tetris.",
            "Achieve a score of 10,000 points in Tetris.",
            "Reach a level higher than 10 in Tetris.",
            "Complete a Tetris game without using the hold feature.",
            "Achieve a streak of 5 wins in XO.",
            "Complete a game of XO without allowing the opponent to win.",
            "Experiment with different strategies and tactics in XO.",
            "Play a game of XO with a friend or family member.",
            "Score 10 points in a single game of Pong.",
            "Achieve a rally of at least 20 hits in Pong.",
            "Experiment with different paddle sizes or ball speeds in Pong.",
            "Score at least 1000 points in a single game of Snake.",
            "Reach a length of 30 or more segments in the Snake game.",
            "Complete a game of Snake without colliding with any obstacles.",
            "Achieve a new high score in the Snake game.",
            "Experiment with a new control scheme or input method in the Snake game"
    };

    //choose a random objective
    Random random = new Random();
    int random_index = random.nextInt(objectives.length);
    String daily_objective = objectives[random_index];

    //Main Frame
    JFrame frame = new JFrame("Old Games");

    //Button for each game
    JButton tetris_button = new JButton();
    JButton rock_paper_scissor_button = new JButton();
    JButton pong_button = new JButton();
    JButton snake_button = new JButton();
    JButton XO_button = new JButton();
    JButton randomGame_button = new JButton();
    //Button for set Timer
    JButton set_timer_button = new JButton();


    //Label for objectives
    JLabel objective_label = new JLabel("Daily Objective: " + daily_objective);


    //Icon for each game
    ImageIcon tetris_icon = new ImageIcon("Tetris.jpeg");
    ImageIcon rock_paper_scissor_icon = new ImageIcon("rock_paper_scissor.png");
    ImageIcon XO_icon = new ImageIcon("XO.png");
    ImageIcon snake_icon = new ImageIcon("snake.jpeg");
    ImageIcon pong_icon = new ImageIcon("Pong.jpeg");
    ImageIcon old_games_icon = new ImageIcon("old_games_logo.png");
    ImageIcon randomGame_icon = new ImageIcon("random_game.png");
    //Icon for set timer
    ImageIcon set_timer_icon = new ImageIcon("set_timer.png");


    OldGames() {

        //set function for each button
        tetris_button.addActionListener(this);
        rock_paper_scissor_button.addActionListener(this);
        pong_button.addActionListener(this);
        set_timer_button.addActionListener(this);
        snake_button.addActionListener(this);
        XO_button.addActionListener(this);
        randomGame_button.addActionListener(this);

        //set icon for each button
        tetris_button.setIcon(tetris_icon);
        rock_paper_scissor_button.setIcon(rock_paper_scissor_icon);
        pong_button.setIcon(pong_icon);
        snake_button.setIcon(snake_icon);
        XO_button.setIcon(XO_icon);
        set_timer_button.setIcon(set_timer_icon);
        randomGame_button.setIcon(randomGame_icon);

        //Label
        objective_label.setFont(new Font("Roboto", Font.PLAIN, 20));
        objective_label.setHorizontalAlignment(JLabel.CENTER);
        objective_label.setVerticalAlignment(JLabel.CENTER);
        objective_label.setForeground(Color.blue);
        objective_label.setHorizontalAlignment(JLabel.LEFT);


        //add label
        frame.add(objective_label);

        //add Buttons
        frame.add(pong_button);
        frame.add(tetris_button);
        frame.add(rock_paper_scissor_button);
        frame.add(set_timer_button);
        frame.add(snake_button);
        frame.add(XO_button);
        frame.add(randomGame_button);

        //frame specifications
        frame.setIconImage(old_games_icon.getImage());
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 800);
        frame.setLocation(400, 10);
        frame.setLayout(new GridLayout(4, 2, 5, 5));
        frame.setVisible(true);


//        frame.pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ///==============Function of Tetris Button=====================
        if (e.getSource() == tetris_button) {
            tetris_button.setEnabled(false);

            JFrame tetris_frame = new JFrame("Tetris game");
            tetris_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            tetris_frame.setSize(12 * 26 + 10, 26 * 23 + 15);
            tetris_frame.setVisible(true);

            final Tetris tetris = new Tetris();
            tetris.init();
            tetris_frame.add(tetris);
            tetris_frame.addWindowListener(tetris_windowListener);

            //add key listener to move the Pieces
            tetris_frame.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP:
                            tetris.rotate(-1);
                            break;
                        case KeyEvent.VK_DOWN:
                            tetris.rotate(+1);
                            break;
                        case KeyEvent.VK_LEFT:
                            tetris.move(-1);
                            break;
                        case KeyEvent.VK_RIGHT:
                            tetris.move(+1);
                            break;
                        case KeyEvent.VK_SPACE:
                            tetris.drop();
                            tetris.score += 1;
                            break;
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }
            });

            //function to move the Piece down each 1 sec
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                            tetris.drop();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }.start();
        }

        ///==============Function of Rock_Paper Scissor Button=====================
        if (e.getSource() == rock_paper_scissor_button) {
            rock_paper_scissor_button.setEnabled(false);

            RockPaperScissor g = new RockPaperScissor();
            g.setTitle("Rock Paper Scissor");
            g.setBounds(400, 400, 600, 600);
            g.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            g.getContentPane().setBackground(Color.WHITE);
            g.setup();
            g.setResizable(false);
            g.addWindowListener(rock_windowListener);
            g.setVisible(true);
        }

        ///==============Function of Pong Button=====================
        if (e.getSource() == pong_button) {
            pong_button.setEnabled(false);

            GameFrame frame = new GameFrame();
            frame.addWindowListener(pong_windowListener);
        }

        ///==============Function Snake Button=====================
        if (e.getSource() == snake_button) {
            snake_button.setEnabled(false);

            SnakeFrame snake = new SnakeFrame();
            snake.addWindowListener(snake_windowListener);

        }

        ///==============Function of set timer Button=====================
        if (e.getSource() == set_timer_button) {
            set_timer_button.setEnabled(false);

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    SetingTimer timer = new SetingTimer();
                    timer.addWindowListener(timer_windowListener);
                }
            });
        }

        ///==============Function of XO Button=====================
        if (e.getSource() == XO_button) {
            XO_button.setEnabled(false);

            TicTacToe XO = new TicTacToe();
            XO.frame.addWindowListener(XO_windowListener);
        }

        ///==============Function of Tetris Button=====================
        if (e.getSource() == randomGame_button) {

            ArrayList<JButton> buttons = new ArrayList<>();
            buttons.add(tetris_button);
            buttons.add(pong_button);
            buttons.add(XO_button);
            buttons.add(snake_button);
            buttons.add(rock_paper_scissor_button);

            Random random1 = new Random();
            int random_button_index = random1.nextInt(buttons.size());
            JButton selectedButton = buttons.get(random_button_index);
            selectedButton.doClick();
        }


    }


}


