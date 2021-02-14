import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Devarsh Patwa
 * Main Page of MD Burritos
 * June 2018
 * Mahrshi = helpage, print receipt, writing to file, sorting
 * Devarsh = menu, homepage, reading file, sorting  
 */
public class HomePage extends JFrame implements ActionListener{
  
  JLabel lblMD, lblBurritos, lblWhiteBack; 
  JButton btnExit,btnMenu,btnHelp;
  Menu menu;
  HelpPage helpPage;
  public HomePage() { 
   
    super("MD Burritos");
    //create the labels
    lblWhiteBack = new JLabel(new ImageIcon("whiteback.jpg"));
    lblMD = new JLabel(new ImageIcon("MD.png"));
    lblBurritos = new JLabel (new ImageIcon("Burritos.png"));
    
    btnExit = new JButton ("Exit");
    btnMenu= new JButton("Menu");
    btnHelp = new JButton("Help");
                             
    
    //set size and layout
    setSize(600,600);
    setLayout(null);
    
    //sets the pic on the window
   
    lblMD.setBounds(100,0,350,200);
    add(lblMD);
    lblBurritos.setBounds(-10,200,600,250);
    add(lblBurritos);
    lblWhiteBack.setBounds(0,0,600,450);
    add(lblWhiteBack);
    
    btnExit.setBounds(50,500,100,50);
    add(btnExit);
    btnMenu.setBounds(250,500,100,50);
    add(btnMenu);
    btnHelp.setBounds(450,500,100,50);
    add(btnHelp);
    
    //make buttons listen
    btnExit.addActionListener(this);
    btnMenu.addActionListener(this);
    btnHelp.addActionListener(this);
  
    
    
    
    setVisible(true);
 
    
  }//end constructor
  
   public void actionPerformed(ActionEvent evt){
     if (evt.getSource()==btnExit){
       System.exit(0);
       
     }
     else if (evt.getSource()==btnMenu){
      menu = new Menu(); 
      dispose();
     }
     else if (evt.getSource()==btnHelp){
       helpPage = new HelpPage();
       dispose();
     }
   }
  
  public static void main(String[] args) { 
    new HomePage();
  }

  
}
