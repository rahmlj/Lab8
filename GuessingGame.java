import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
  JTextField userGuess;
  JButton guessButton;
  JButton playAgainButton;
  JLabel promptlbl;
  JLabel highlowlbl;
  JLabel lastguesslbl;
  Random r;
  int randomNum;

  GuessingGame() {

    r = new Random();
    randomNum = r.nextInt(100) + 1;

    JFrame frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240,120);

    userGuess = new JTextField(10);
    userGuess.setActionCommand("myTF");

    guessButton = new JButton("Guess");
    playAgainButton = new JButton("Play Again");

    userGuess.addActionListener(this);
    guessButton.addActionListener(this);
    playAgainButton.addActionListener(this);

    promptlbl = new JLabel("Enter your guess: ");
    highlowlbl = new JLabel("");
    lastguesslbl = new JLabel("");

    frame.add(promptlbl);
    frame.add(userGuess);
    frame.add(guessButton);
    frame.add(highlowlbl);
    frame.add(lastguesslbl);
    frame.add(playAgainButton);

    frame.setVisible(true);

  }
  public void actionPerformed(ActionEvent ae){

    if(ae.getActionCommand().equals("Guess")){

      int guess = Integer.parseInt(userGuess.getText());

      if(guess > randomNum){
        highlowlbl.setText("Too High!");
      }
      else if(guess < randomNum){
        highlowlbl.setText("Too Low!");
      }
      else if(guess == randomNum){
        highlowlbl.setText("You got it!");
      }
      lastguesslbl.setText("Last guess was " + userGuess.getText());

    }
    else if(ae.getActionCommand().equals("Play Again")){
      randomNum = r.nextInt(100) + 1;
      promptlbl.setText("Enter your guess: ");
      highlowlbl.setText("");
      lastguesslbl.setText("");
      userGuess.setText("");
    }
    else{
      highlowlbl.setText("You pressed Enter.  Please press the Guess Button");
    }
  }
}