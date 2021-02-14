import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
/**
 * Mahrshi Patel & Devarsh Patwa
 * June 16/ 2018
 * Displays the menu for MDBurritos
 * Responsibilities:
 * Mahrshi = helpage, print receipt, writing to file, sorting
 * Devarsh = menu, homepage, reading file, sorting  
 */
public class Menu extends JFrame implements ActionListener {
  
  JLabel lblBurritos,lblQues,lblTacos,lblOrderHere,lblExample, lblYourOrder, lblTotal, lblSubTotal,lblTax, lblSort;
  JTextField txtOrderHere,txtSubTotal,txtTax, txtTotal;
  JButton btnExit, btnClear,btnAdd,btnPrint, btnAscending,btnDescending,btnBack;
  HomePage homePage;
  String order = "",price = "", recipt = "";
  double subtotal, taxPrice,totalPrice=0;
  JTextArea orderArea = new JTextArea();
  JTextArea priceArea = new JTextArea(); //different area for price to make it perfectly parallel
  JTextArea subTotal = new JTextArea();
  JTextArea tax = new JTextArea();
  JTextArea total = new JTextArea();
  JTextArea outputItem = new JTextArea();
  JTextArea outputPrice = new JTextArea();
  
  // creates a text area to display the list  
  JTextArea outputAreaB = new JTextArea();
  JTextArea outputAreaQ = new JTextArea();
  JTextArea outputAreaT = new JTextArea();
  
  NumberFormat money = NumberFormat.getCurrencyInstance(); //format currency
  
  int itemNum = 0;
  double cost[] = new double[20];
  String item[] = new String [20];
  
  String burritos[];
  double priceB[];
  String ques[];
  double priceQ[];
  String tacos[];
  double priceT[];
  String listQ = "";
  String listB = "";
  
  
  
  public Menu()   { 
    super("Menu");
    
    //set size and layout
    setSize(900,650);
    setLayout(null);
    
    
    lblBurritos = new JLabel("Burritos"); //create labels
    lblQues = new JLabel("Quesadillas");
    lblTacos = new JLabel("Tacos");
    lblOrderHere = new JLabel("Order Here:");
    lblExample = new JLabel("Write as it is on the menu");
    lblYourOrder = new JLabel("Check Your Order Here:");
    lblTotal = new JLabel("Total");
    lblSubTotal = new JLabel("SubTotal");
    lblTax = new JLabel("Tax");
    lblSort = new JLabel("Sort By Price");
    
    txtOrderHere = new JTextField();
    
    btnBack = new JButton("Back");
    btnExit = new JButton("Exit");
    btnClear = new JButton("Clear");
    btnAdd = new JButton("Add");
    btnAscending = new JButton("Ascending");
    btnDescending = new JButton("Descending");
    btnPrint = new JButton("Print Receipt");
    
    
    lblBurritos.setFont(new Font("Times New Roman",Font.PLAIN,30)); //change font and size
    lblQues.setFont(new Font("Times New Roman",Font.PLAIN,30));
    lblTacos.setFont(new Font("Times New Roman",Font.PLAIN,30));
    lblTotal.setFont(new Font("Times New Roman",Font.BOLD,20));
    lblSubTotal.setFont(new Font("Times New Roman",Font.PLAIN,15));
    lblTax.setFont(new Font("Times New Roman",Font.PLAIN,15));
    lblOrderHere.setFont(new Font("Times New Roman",Font.BOLD,15));
    lblSort.setFont(new Font("Times New Roman",Font.BOLD,15));
    
    
    outputAreaB.setEditable(false); //make it non editable
    outputAreaQ.setEditable(false);
    outputAreaT.setEditable(false);
    orderArea.setEditable(false);
    priceArea.setEditable(false);
    subTotal.setEditable(false);
    tax.setEditable(false);
    total.setEditable(false);
    outputItem.setEditable(false);
    
    outputAreaB.setTabSize(12); //set tab size
    outputAreaQ.setTabSize(12);
    outputAreaT.setTabSize(12);
    orderArea.setTabSize(10);
    outputItem.setTabSize(5);
    
    orderArea.setBounds(610,90,200,350); //your order
    add(orderArea);
    priceArea.setBounds(810,90,60,350);
    add(priceArea);
    
    outputAreaB.setBounds(20,60,200,320);  // set the location and size for the text area
    add(outputAreaB);   // add the text area to my window
    lblBurritos.setBounds(60,10,100,50);
    add(lblBurritos);
    
    outputAreaQ.setBounds(220,60,200,320);  // set the location and size for the text area
    add(outputAreaQ);   // add the text area to my window
    lblQues.setBounds(250,10,150,50);
    add(lblQues);
    
    outputAreaT.setBounds(420,60,180,320);  // set the location and size for the text area
    add(outputAreaT);   // add the text area to my window
    lblTacos.setBounds(470,10,150,50);
    add(lblTacos);
    
    lblOrderHere.setBounds(50,400,100,40); //order here, Add
    add(lblOrderHere);
    txtOrderHere.setBounds(50,470,200,30);
    add(txtOrderHere);
    btnAdd.setBounds(260,470,60,30);
    add(btnAdd);
    
    lblExample.setBounds(50,430,400,40); //example
    add(lblExample);
    
    lblYourOrder.setBounds(650,50,150,40); //Your Order
    add(lblYourOrder);
    
    
    lblSubTotal.setBounds(650,440,80,40); //Sub Total
    add(lblSubTotal);
    subTotal.setBounds(750,450,80,25);
    add(subTotal);
    
    lblTax.setBounds(650,470,50,40); //Tax
    add(lblTax);
    tax.setBounds(750,480,80,25);
    add(tax);
    
    lblTotal.setBounds(650,510,100,40);//Total
    add(lblTotal);
    total.setBounds(750,520,80,25);
    add(total);
    
    lblSort.setBounds(480,400,100,40); //sort, ascending, descending
    add(lblSort);
    btnAscending.setBounds(480,440,120,30);
    add(btnAscending);
    btnDescending.setBounds(480,480,120,30);
    add(btnDescending);
    
    btnBack.setBounds(750,20,70,30); //back
    add(btnBack);
    btnExit.setBounds(60,550,70,30);
    add(btnExit);
    btnClear.setBounds(630,550,70,30);
    add(btnClear);
    btnPrint.setBounds(720,550,150,30);
    add(btnPrint);
    
    //make buttons listen
    btnExit.addActionListener(this);
    btnBack.addActionListener(this);
    btnClear.addActionListener(this);
    btnAscending.addActionListener(this);
    btnDescending.addActionListener(this);
    btnAdd.addActionListener(this);
    btnPrint.addActionListener(this);
    
    try{
      //open file that contains burrito menu
      FileReader fileBurritos = new FileReader("Burrito.txt");
      BufferedReader inputBurritos = new BufferedReader(fileBurritos);
      
      burritos = new String[10]; //create arrays
      priceB = new double[10];  
      
      //read the file
      for (int i = 0;i<burritos.length;i++){
        burritos[i] = inputBurritos.readLine();
        priceB[i] = Double.parseDouble(inputBurritos.readLine());
      }
      fileBurritos.close();//close file
      
      
      for (int k = 0;k<burritos.length;k++){
        listB = listB + burritos[k]+"\t$"+priceB[k]+"\n\n";
      }
      
      outputAreaB.setText(listB); //display the menu
      
      //open file that contains Quesadillas menu
      FileReader fileQues = new FileReader("Ques.txt");
      BufferedReader inputQues = new BufferedReader(fileQues);
      
      ques = new String[5]; //create arrays
      priceQ = new double[5];
      
      //read the file
      for (int i = 0;i<ques.length;i++){
        ques[i] = inputQues.readLine();
        priceQ[i] = Double.parseDouble(inputQues.readLine());
      }
      
      fileQues.close();//close file
      
      
      for (int k = 0;k<ques.length;k++){
        listQ = listQ + ques[k]+"\t$"+priceQ[k]+"\n\n";
      }
      outputAreaQ.setText(listQ); //display the menu
      
      //open file that contains burrito menu
      FileReader fileTacos= new FileReader("Tacos.txt");
      BufferedReader inputTacos = new BufferedReader(fileTacos);
      
      
      tacos = new String[4]; //create arrays
      priceT = new double[4];
      
      //read the file
      for (int i = 0;i<tacos.length;i++){
        tacos[i] = inputTacos.readLine();
        priceT[i] = Double.parseDouble(inputTacos.readLine());
      }
      
      String listT = "";
      for (int k = 0;k<tacos.length;k++){
        listT = listT + tacos[k]+"\t$"+priceT[k]+"\n\n";
      }
      
      outputAreaT.setText(listT); //display the menu
      
      orderArea.setText("Item");
      priceArea.setText("Price");
      
      
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
  
  public void actionPerformed(ActionEvent evt){
    
    if (evt.getSource()== btnExit){ //Exit button
      System.exit(0); 
    }
    else if (evt.getSource()==btnBack){ //back button
      homePage = new HomePage();
      dispose();
    }
    
    else if (evt.getSource()==btnAdd){ //add button
      itemNum = itemNum + 1;
      
      String order1;
      int loc;
      
      
      order1 = txtOrderHere.getText(); //get the item
      
      loc = findItem(order1, burritos); //use method to find item
      
      if (loc == -1){ //if its not a burrito
        loc = findItem(order1, ques);
        
        if(loc==-1){ //if its not a burrito or a quesidilla
          
          loc = findItem(order1, tacos); //use method to find item
          item[itemNum-1] = tacos[loc] ;
          cost[itemNum-1] = (priceT[loc]); 
          subtotal = subtotal + priceT[loc];
          
        }
        
        else{ //if its a quesadilla
          item[itemNum-1] = ques[loc] + " Quesadilla";
          cost[itemNum-1] = (priceQ[loc]);
          subtotal = subtotal + priceQ[loc];
        }
        
      }
      else{ //if its's a burrito
        item[itemNum-1] = burritos[loc] + " Burrito";
        cost[itemNum-1] = priceB[loc];
        subtotal = subtotal + priceB[loc];
      }
      
      order = order+"\n" + item[itemNum-1]; //make a list of the items
      price = price+"\n$"+cost[itemNum-1]; //make a list of the cost
      recipt = recipt + item[itemNum-1] + "\t" + (money.format(cost[itemNum-1])) + "\n";
      
      orderArea.setText("Item\n"+order); //display order
      priceArea.setText("Price\n"+price); //display price se
      subTotal.setText(money.format(subtotal)); //display subtotal
      
      taxPrice = subtotal*0.13; //calculate text
      tax.setText(money.format(taxPrice));
      
      totalPrice = subtotal + taxPrice;
      total.setText(money.format(totalPrice));
      
      txtOrderHere.setText(""); //clear the order area
      
      
    }
    
    else if (evt.getSource()==btnClear){ //clear everything
      orderArea.setText("Item");
      priceArea.setText("Price");
      subTotal.setText("");
      tax.setText("");
      total.setText("");
      order = "";
      price = "";
      recipt = "";
      subtotal = 0;
      taxPrice = 0;
      totalPrice = 0;
      itemNum = 0;
    }
    
    else if(evt.getSource()==btnAscending){
      ascending(burritos,priceB); //use ascending method for burritos
      listB ="";
      for (int k = 0;k<burritos.length;k++){
        listB = listB + burritos[k]+"\t$"+priceB[k]+"\n\n";
      }
      
      outputAreaB.setText(listB); //display the new menu
      
      ascending(ques,priceQ); //use ascending method for quesadillas
      listQ ="";
      for (int k = 0;k<ques.length;k++){
        listQ = listQ + ques[k]+"\t$"+priceQ[k]+"\n\n";
      }
      
      outputAreaQ.setText(listQ); //display the new menu    
      
    }
    else if(evt.getSource()==btnDescending){
      descending(burritos,priceB); //use descending method for burritos
      listB = "";
      for (int k = 0;k<burritos.length;k++){
        listB = listB + burritos[k]+"\t$"+priceB[k]+"\n\n";
      }
      
      outputAreaB.setText(listB); //display the new menu
      
      
      descending(ques,priceQ); //use descending method for ques
      listQ = "";
      for (int k = 0;k<ques.length;k++){
        listQ = listQ + ques[k]+"\t$"+priceQ[k]+"\n\n";
      }
      
      outputAreaQ.setText(listQ); //display the new menu
      
    }
    
    else if(evt.getSource()==btnPrint){
      String finalRecipt = "\tMD Burritos\n\t10 Gillingham Dr.\n\tBrampton, ON\n===========================\nItem\t\tPrice\n===========================\n\n"+
        recipt+"\n\nSubtotal: \t\t" + (money.format(subtotal)) +"\nTax: \t\t" + 
        money.format(taxPrice)+"\n===========================\nTotal: \t\t" + money.format(totalPrice);
      outputItem.setText(finalRecipt); //create the final receipt and print
      JOptionPane.showMessageDialog(null,outputItem);
      try{
        FileWriter fileW = new FileWriter("Recipt.txt"); //create a new file
        PrintWriter output = new PrintWriter(fileW);
        //write into the new file
        
        output.println("\tMD Burritos");
        output.println("\t10 Gillingham Dr.");
        output.println("\tBrampton, ON");
        output.println("===========================");
        output.println("Item\t\tPrice");
        output.println();
        for(int i = 0; i < itemNum; i++){
          output.println(item[i] + "\t" + cost[i]);
        }
        output.println();
        output.println("Subtotal: \t" + money.format(subtotal));
        output.println("Tax: \t\t" + money.format(taxPrice));
        output.println("===========================");
        output.println("Total: \t\t" + money.format(totalPrice));
        
        fileW.close(); //close file
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
    
  }//end actionperformed
  
  public static void main(String[] args)throws IOException  { 
    new Menu();
  }
  
  public void ascending (String name[], double price[]){ //a method to sort it ascending
    
    for (int j = 0;j<price.length;j++){
      for (int i = 0;i<price.length-1;i++){ 
        if (price[i]>price[i+1]){
          String temp = name[i];
          name[i]=name[i+1];
          name[i+1] = temp;
          
          double tempPrice = price[i];
          price[i] = price[i+1];
          price[i+1] = tempPrice;
        }//end if
      }//end inner loop
    }//end outer loop
    
  }
  
  public void descending (String name[], double price[]){ //a method to sort it descending
    
    for (int j = 0;j<price.length;j++){
      for (int i = 0;i<price.length-1;i++){ 
        if (price[i]<price[i+1]){
          String temp = name[i];
          name[i]=name[i+1];
          name[i+1] = temp;
          
          double tempPrice = price[i];
          price[i] = price[i+1];
          price[i+1] = tempPrice;
        }//end if
      }//end inner loop
    }//end outer loop
    
  }
  
//method to find item
  public static int findItem(String item, String array[]){
    //loop to go through the array
    for (int i = 0;i<array.length;i++){
      //find the array
      if (item.equalsIgnoreCase(array[i])==true){
        return i;
      }
      
    }
    return -1;
  }//end method
  
}//end class
