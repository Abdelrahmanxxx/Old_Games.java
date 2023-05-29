package Snake;/*
This class consists UI, Control, Logic & everything about Game.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;

public class SnakePanel extends JPanel implements ActionListener {
    static final int GameWidth = 700;
    static final int GameHeight = 700;
    static final int UNIT_Size = 35;
    static final int delay = 150;
    final int[] x = new int[50];
    final int[] y = new int[50];
    int bodyParts = 3;
    int fruitX, fruitY;
    Image food = new ImageIcon("apple.png").getImage().getScaledInstance(35, 35, 5);
    Image snake_head = new ImageIcon("snake_head.png").getImage().getScaledInstance(35, 35, 5);
    Image snake_body = new ImageIcon("snake_body.png").getImage().getScaledInstance(35, 35, 5);
    char direction = 'R';
    boolean running;
    int Score = 0;
    boolean dead = false;
    Timer timer;

    SnakePanel() {
        setPreferredSize(new Dimension(GameWidth, GameHeight));
        setBackground(Color.black);
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());
        setLayout(null);
        setBackground(new Color(230, 230, 250));
    }

    public void startGame() {
        newfruit();
        dead = false;
        running = true;
        timer = new Timer(delay, this);
        timer.start();
    }

    public void restartGame() {
        timer.stop();
        Score = 0;
        bodyParts = 3;
        Arrays.fill(x, 0);
        Arrays.fill(y, 0);
        direction = 'R';
        startGame();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gd = (Graphics2D) g;
        for (int i = 0; i < GameWidth / UNIT_Size + 1; i++) {
            for (int j = 0; j < GameHeight / UNIT_Size; j++) {
                if ((i + j) % 2 == 0)
                    gd.setColor(new Color(73, 213, 73));
                else
                    gd.setColor(new Color(51, 176, 51));
                gd.fillRect(i * UNIT_Size, j * UNIT_Size, UNIT_Size, UNIT_Size);
            }
        }
        gd.setColor(Color.black);
        gd.setStroke(new BasicStroke(3));
        for (int i = 0; i < bodyParts; i++) {
            if (i == 0) {
                gd.drawImage(snake_head, x[i], y[i], null);
            } else {
                gd.drawImage(snake_body, x[i], y[i], null);
            }
        }
        gd.drawImage(food, fruitX, fruitY, null);
        if (running && !dead){
            gd.setColor(new Color(0, 70, 0));
            gd.setFont(new Font(Font.SERIF, Font.BOLD, 35));
            FontMetrics metrics = getFontMetrics(g.getFont());
            gd.drawString("Score: " + Score, (GameWidth - metrics.stringWidth("Score:10")) / 2, 30);

        }
        if (!running && !dead) {
            Start(g);
        }
        if (!running && dead) {
            Gameover(g);
        }
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case 'R' -> x[0] = x[0] + UNIT_Size;
            case 'L' -> x[0] = x[0] - UNIT_Size;
            case 'U' -> y[0] = y[0] - UNIT_Size;
            case 'D' -> y[0] = y[0] + UNIT_Size;
        }

    }

    public void newfruit() {
        Random random = new Random();
        fruitX = random.nextInt(GameWidth / UNIT_Size) * UNIT_Size;
        fruitY = random.nextInt(GameHeight / UNIT_Size) * UNIT_Size;
    }

    public void checkApple() {
        if (x[0] == fruitX && y[0] == fruitY) {
            newfruit();
            bodyParts++;
            Score++;
        }

    }

    public void checkCollision() {
        for (int i = bodyParts; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                running = false;
                dead = true;
            }
            if (x[0] > GameWidth) {
                running = false;
                dead = true;
            }
            if (x[0] < 0) {
                running = false;
                dead = true;
            }
            if (y[0] < 0) {
                running = false;
                dead = true;
            }
            if (y[0] > GameHeight) {
                running = false;
                dead = true;
            }
            if (!running) {
                timer.stop();
            }
        }
    }

    public void Gameover(Graphics g) {
        g.setColor(new Color(157, 6, 6));
        g.setFont(new Font("Georgia", Font.BOLD, 40));
        FontMetrics fontMetrics = getFontMetrics(g.getFont());
        g.drawString("Press Space To Restart!", (GameWidth - fontMetrics.stringWidth("Press Space To Restart!")) / 2, (int) ((GameHeight - fontMetrics.stringWidth("Game Over")) / 1.5));
        g.drawString("Game Over!", (GameWidth - fontMetrics.stringWidth("Game Over")) / 2, ((GameHeight - fontMetrics.stringWidth("Game Over")) / 2));
    }
    public void Start(Graphics g) {
        g.setColor(new Color(0, 70, 0));
        g.setFont(new Font("Georgia", Font.BOLD, 40));
        FontMetrics fontMetrics = getFontMetrics(g.getFont());
        g.drawString("Press Space To Start!", (GameWidth - fontMetrics.stringWidth("Press Space To Restart!")) / 2, (int) ((GameHeight - fontMetrics.stringWidth("Game Over")) / 1.5));
        g.drawString("Welcome!", (GameWidth - fontMetrics.stringWidth("Game Over")) / 2, ((GameHeight - fontMetrics.stringWidth("Game Over")) / 2));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkCollision();
            checkApple();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                        break;
                    }
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                        break;
                    }
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                        break;
                    }
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                        break;
                    }
                case KeyEvent.VK_SPACE:
                    if (!dead && !running){
                        startGame();
                        break;
                    }
                    if (dead && !running){
                        restartGame();
                        break;
                    }
            }
        }
    }
}