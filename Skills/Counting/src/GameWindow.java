import javax.swing.*;
	
public class GameWindow extends JFrame {
		
public GameWindow() {
		setTitle("My Empty Frame");
		setSize(300,200); // default size is 0,0
		setLocation(10,200); // default is 0,0 (top left corner)
		setVisible(true);
	  }
	


public static void main(String[] args) {
	    JFrame f = new GameWindow();
	    GameLogic newGame = new GameLogic();
	    newGame.SetLevel(1);
	    Integer randomNum = newGame.GenerateRandomNumber();
	    JLabel num = new JLabel(randomNum.toString());
	    num.setVisible(true);
	    f.add(num);
	    
	  }
}