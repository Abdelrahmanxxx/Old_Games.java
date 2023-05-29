import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.math.*;

public class RockPaperScissor extends  JFrame{
//    JFrame frame=new JFrame();
//     creating label for pc choice and result
    JLabel comchoice,result;
    JLabel comscore,playerscore;
    int player_score = 0;
    int com_score = 0;

    ImageIcon image_rock,image_paper,image_scissor;
    public void setup(){
        image_rock = new ImageIcon(new ImageIcon("Rock.png").getImage()
                .getScaledInstance(80,80,Image.SCALE_DEFAULT));

image_paper = new ImageIcon(new ImageIcon("Paper.jpg").getImage()
        .getScaledInstance(80,80,Image.SCALE_DEFAULT));

image_scissor = new ImageIcon(new ImageIcon("Scissor.png").getImage()
        .getScaledInstance(80,80,Image.SCALE_DEFAULT));

JLabel score = new JLabel("Pong.Score");
score.setBounds(500,0,100,100);
comscore = new JLabel();
comscore.setText("Computer : 0");
comscore.setBounds(500,15,100,100);
playerscore = new JLabel();
playerscore.setText("Player : 0");
playerscore.setBounds(500,30,100,100);


comchoice = new JLabel();
comchoice.setHorizontalTextPosition(JLabel.CENTER);
comchoice.setVerticalTextPosition((JLabel.BOTTOM));
comchoice.setBounds(250,90,100,100);

result = new JLabel();
result.setForeground(new Color(0x0008B));
result.setFont(new Font("Serif",Font.ROMAN_BASELINE,20));
result.setBounds(250,450,100,100);


JLabel label_computer = new JLabel();
label_computer.setText("Computer");
label_computer.setBounds(260,180,100,100);
JLabel label_vs = new JLabel();
label_vs.setText("VS");
label_vs.setBounds(280,200,100,100);

JLabel label_player = new JLabel();
label_player.setText("Player");
label_player.setBounds(264,220,100,100);
//Creating the label
        JLabel label_rock = new JLabel();
        label_rock.setText("Rock");
        label_rock.setIcon(image_rock);//setting the icon for the rock and calling it from the variable image_rock
        label_rock.setHorizontalTextPosition(JLabel.CENTER);
        label_rock.setVerticalTextPosition(JLabel.BOTTOM);
        label_rock.setBounds(150,300,100,100);
        label_rock.setPreferredSize(new Dimension(30,80));

        JLabel label_paper = new JLabel();
        label_paper.setText("Paper");
        label_paper.setIcon(image_paper);//setting the icon for the rock and calling it from the variable image_rock
        label_paper.setHorizontalTextPosition(JLabel.CENTER);
        label_paper.setVerticalTextPosition(JLabel.BOTTOM);
        label_paper.setBounds(250,300,100,100);

        JLabel label_scissor = new JLabel();
        label_scissor.setText("Scissors");
        label_scissor.setIcon(image_scissor);//setting the icon for the rock and calling it from the variable image_rock
        label_scissor.setHorizontalTextPosition(JLabel.CENTER);
        label_scissor.setVerticalTextPosition(JLabel.BOTTOM);
        label_scissor.setBounds(350,300,100,100);
        //adding the mouse listener to the labels to be able to click on them
        label_rock.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //call calculating method
                calculate(label_rock.getText());
            }
        });
        label_paper.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //call calculating method
                calculate(label_paper.getText());
            }
        });
        label_scissor.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //call calculating method
                calculate(label_scissor.getText());
            }
        });

      getContentPane().setBackground(Color.ORANGE);
        //adding the components in frame

        add(label_rock);
        add(label_scissor);
        add(label_paper);
        add(comchoice);
        add(result);
        add(score);
        add(comscore);
        add(playerscore);
        add(label_computer);
        add(label_player);
        add(label_vs);
        setLayout(null);
    }
    public void calculate(String player){
    String[] list = {"Rock","Paper","Scissor"};
    int random_choices  = (int)((Math.random()*10)%3);
    String computer = list[random_choices];
    //displaying the computer's choice inside the frame
        comchoice.setText(computer);
        if(random_choices==0){
            comchoice.setIcon(image_rock);
        }
        else if(random_choices ==1){
            comchoice.setIcon(image_paper);
        }
        else{
            comchoice.setIcon(image_scissor);
        }
        String res = "";
        if(player.equals(computer)){
            res = "Draw !";
        }
        else if (player.equals("Rock")){
            if(computer.equals("Paper")){
                res = "You Lose! ";
                com_score++;
            }
            else{
                res = "You Win !";
                player_score++;
            }
        }
        else if(player.equals("Paper")){
            if(computer.equals("Scissor")){
                res = "You Lose!" ;
                com_score++;
            }
            else{
                res = "You Win !";
                player_score++;
            }
        }
        else{
           if(computer.equals("Rock")){
               res = "You Lose!" ;
               com_score++;
           }
           else if(computer.equals("Scissor")){
               res = "Draw !";

           }
           else{
                res = "You Win !";
                player_score++;
            }
        }
        result.setText(res);
        playerscore.setText("Player : "+player_score);
        comscore.setText("Computer : "+com_score);



    }

}
