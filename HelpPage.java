import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.text.*;
import java.awt.event.*;
/**
 * Mahrshi Patel
 * June 5/ 2018
 * The Help Page
 * Mahrshi = helpage, print receipt, writing to file, sorting
 * Devarsh = menu, homepage, reading file, sorting  
 */
public class HelpPage extends JFrame implements ActionListener{
  JLabel lblTitle, lblInfo;
  JButton btnBack;
  JTextArea outputArea = new JTextArea();
  JScrollPane scroller = new JScrollPane(outputArea); //create scroller
  HomePage homePage;
  
  public HelpPage() { 
    super ("Help Page");
    
    setSize(600,400); //set size of window
    setLayout(null);
    
    String helpInfo[], list = "";
    try{
      
      //open the file
      FileReader fileR = new FileReader("HelpPage.txt");
      BufferedReader input = new BufferedReader(fileR);
      
      helpInfo = new String [7];
      //read the file
      for (int i=0;i<helpInfo.length;i++){
        helpInfo[i] = input.readLine();
      }
      fileR.close();
      
      
      for (int k = 0; k < helpInfo.length; k++){
        list = list + helpInfo[k]+ "\n";
      }
      
      
      lblTitle = new JLabel("Help Page");
      
      btnBack = new JButton("Back");
      
      outputArea.setText(list);
      outputArea.setEditable(false);
      
      scroller.setBounds(25,40,525,250); //set location
      add(scroller);
      
      lblTitle.setBounds(260,10,100,25);
      add(lblTitle);
      
      btnBack.setBounds(250,300,100,25);
      add(btnBack);
      
      btnBack.addActionListener (this);
      
      setVisible(true);
    }
    catch (FileNotFoundException e){ //display error
      JOptionPane.showMessageDialog(null,"Bad File"); 
    }
    catch (NullPointerException e){
      JOptionPane.showMessageDialog(null,"Cancelled");
    }
    catch (IOException e){
      JOptionPane.showMessageDialog(null,"Unknown Error"); 
    }
    catch (Exception e){
      JOptionPane.showMessageDialog(null,"File contains wrong data"); 
    }
    
  }
  
  
  public void actionPerformed(ActionEvent e){
    if (e.getSource()==btnBack)
    {
      homePage = new HomePage(); //open homepage
      dispose(); //close this window
    }
    
  }
  
  public static void main(String[] args)throws IOException { 
    new HelpPage();
  }
  
}