import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  

  JLabel firstLabel;
  JLabel secondLabel;

  JTextField fahrenheitText;
  JTextField celsiusText;

  JButton firstButton;
  JButton secondButton;

  JPanel mainPanel;
  


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    // initialize the main mainPanel
    mainPanel = new JPanel();
    
    mainPanel.setLayout(null);


    firstLabel = new JLabel("Degrees Fahrenheit");
    firstLabel.setBounds(200, 200, 300, 40);
    secondLabel = new JLabel("Degrees Celcius");
    secondLabel.setBounds(200, 250, 300, 40);

    firstButton = new JButton("F -> C");
    firstButton.setBounds(450, 210, 80, 20);
    secondButton = new JButton ("C -> F");
    secondButton.setBounds(450, 260, 80, 20);

    fahrenheitText = new JTextField();
    fahrenheitText.setBounds(350, 210, 60, 20);
    celsiusText = new JTextField();
    celsiusText.setBounds(350, 260, 60, 20);

    firstButton.setActionCommand("F -> C");
    secondButton.setActionCommand("C -> F");

    firstButton.addActionListener(this);
    secondButton.addActionListener(this);

    mainPanel.add(firstLabel);
    mainPanel.add(secondLabel);

    mainPanel.add(firstButton);
    mainPanel.add(secondButton);

    mainPanel.add(fahrenheitText);
    mainPanel.add(celsiusText);

    frame.add(mainPanel);

 
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    String fahrenheitFirst = fahrenheitText.getText();
    String celsiusSecond = celsiusText.getText();

    double fahrenheitNum = Integer.parseInt
    (fahrenheitFirst);
    double celsiusNum = Integer.parseInt
    (celsiusSecond);

    if (command.equals("F -> C")){


      celsiusNum = (fahrenheitNum - 32 ) * 5/9;

      celsiusText.setText("" + celsiusNum);

    }else if (command.equals("C -> F")){

      fahrenheitNum = (celsiusNum * 9 ) / 5 + 32;

      fahrenheitText.setText("" + fahrenheitNum);
    }
  }


  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
