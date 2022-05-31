import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;



public class TicTacToe implements ActionListener {


    //to determine whose turn it is first randomly, so we are creating instance of random class
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();  //create a panel to hold the title
    JPanel button_panel = new JPanel();  //another panel to hold all of the buttons
    JLabel textfield = new JLabel();  // we want a label to serve as maybe a text field to display a message of some sort
    JButton[] buttons = new JButton[9];   //want array of J buttons 
    boolean player1_turn;  //this is going to be true if its player1 turns or false if its player2 turn, so it's notnecessary to have boolean for player2 turn coz 1's enough
    
  
  
    TicTacToe(){

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //creating jframe first
    frame.setSize(800,800);
    frame.getContentPane().setBackground(new Color(50,50,50));  //RGB Values for colors (Color.RED)
    frame.setLayout(new BorderLayout());
    frame.setVisible(true); //set the frames visibility to true 

    textfield.setBackground(new Color(25,25,25)); 
    textfield.setForeground(new Color(25,255,0));  //set text color
    textfield.setFont(new Font("Ink Free",Font.BOLD,75));
    textfield.setHorizontalAlignment(JLabel.CENTER);
    textfield.setText("Tic-Tac-Toe");
    textfield.setOpaque(true);

    title_panel.setLayout(new BorderLayout());
    title_panel.setBounds(0,0,800,100);   //we can set the balance for this panel, we place the coordinates of where we want this to start, so if we want to start in top left corner i.e. where x = 0, y = 0 for length, we select 800 to match the size of this frame and then for height may be 100
                 
    button_panel.setLayout(new GridLayout(3,3));
    button_panel.setBackground(new Color(150,150,150));

    for(int i=0;i<9;i++){
        buttons[i] = new JButton();
        button_panel.add(buttons[i]);
        buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
        buttons[i].setFocusable(false);
        buttons[i].addActionListener(this);
    }
    

    //let's add out textfield to our title panel and then add the title panel to our frame
    title_panel.add(textfield);
    frame.add(title_panel,BorderLayout.NORTH);  //this title panel may take up entire frame, so since we're using borderlayout we can specify a border so that title panel can stick to top when we add title panel to our frame we can type in after this ,Borderlayout.NORTH, it's adjustable too we can resize them
    frame.add(button_panel);


    firstTurn();

}


    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textfield.setText("O turn");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textfield.setText("X turn");
                        check();
                }
            }
        }
        
    }

}

    public void firstTurn(){

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }


        if(random.nextInt(2)==0){
            player1_turn = true;
            textfield.setText("X turn");
        }
        else{
            player1_turn = false;
            textfield.setText("O turn");
        }
    }

    public void check(){
   
     //check X win conditions
     if(
         (buttons[0].getText()=="X") &&
         (buttons[1].getText()=="X") &&
         (buttons[2].getText()=="X") 
         ) {
             xWins(0,1,2);
     }  
     if(
         (buttons[3].getText()=="X") &&
         (buttons[4].getText()=="X") &&
         (buttons[5].getText()=="X") 
         ) {
             xWins(3,4,5);
     }  
     if(
         (buttons[6].getText()=="X") &&
         (buttons[7].getText()=="X") &&
         (buttons[8].getText()=="X") 
         ) {
             xWins(6,7,8);
     }  
     if(
         (buttons[0].getText()=="X") &&
         (buttons[3].getText()=="X") &&
         (buttons[6].getText()=="X") 
         ) {
             xWins(0,3,6);
     }  
     if(
         (buttons[1].getText()=="X") &&
         (buttons[4].getText()=="X") &&
         (buttons[7].getText()=="X") 
         ) {
             xWins(1,4,7);
     }  
     if(
         (buttons[2].getText()=="X") &&
         (buttons[5].getText()=="X") &&
         (buttons[8].getText()=="X") 
         ) {
             xWins(2,5,8);
     }  
     if(
         (buttons[0].getText()=="X") &&
         (buttons[4].getText()=="X") &&
         (buttons[8].getText()=="X") 
         ) {
             xWins(0,4,8);
     }  
     if(
         (buttons[2].getText()=="X") &&
         (buttons[4].getText()=="X") &&
         (buttons[6].getText()=="X") 
         ) {
             xWins(2,4,6);
     }  

     //check O win conditions
     if(
        (buttons[0].getText()=="O") &&
        (buttons[1].getText()=="O") &&
        (buttons[2].getText()=="O") 
        ) {
            oWins(0,1,2);
    }  
    if(
        (buttons[3].getText()=="O") &&
        (buttons[4].getText()=="O") &&
        (buttons[5].getText()=="O") 
        ) {
            oWins(3,4,5);
    }  
    if(
        (buttons[6].getText()=="O") &&
        (buttons[7].getText()=="O") &&
        (buttons[8].getText()=="O") 
        ) {
            oWins(6,7,8);
    }  
    if(
        (buttons[0].getText()=="O") &&
        (buttons[3].getText()=="O") &&
        (buttons[6].getText()=="O") 
        ) {
            oWins(0,3,6);
    }  
    if(
        (buttons[1].getText()=="O") &&
        (buttons[4].getText()=="O") &&
        (buttons[7].getText()=="O") 
        ) {
            oWins(1,4,7);
    }  
    if(
        (buttons[2].getText()=="O") &&
        (buttons[5].getText()=="O") &&
        (buttons[8].getText()=="O") 
        ) {
            oWins(2,5,8);
    }  
    if(
        (buttons[0].getText()=="O") &&
        (buttons[4].getText()=="O") &&
        (buttons[8].getText()=="O") 
        ) {
            oWins(0,4,8);
    }  
    if(
        (buttons[2].getText()=="O") &&
        (buttons[4].getText()=="O") &&
        (buttons[6].getText()=="O") 
        ) {
            oWins(2,4,6);
    }  


    }
    public void xWins(int a,int b,int c){
 
     buttons[a].setBackground(Color.GREEN);
     buttons[b].setBackground(Color.GREEN);
     buttons[c].setBackground(Color.GREEN);

     for(int i=0;i<9;i++){
         buttons[i].setEnabled(false);
     }
     textfield.setText("X wins");
    }

    public void oWins(int a,int b,int c){

        buttons[a].setBackground(Color.GREEN);
     buttons[b].setBackground(Color.GREEN);
     buttons[c].setBackground(Color.GREEN);

     for(int i=0;i<9;i++){
         buttons[i].setEnabled(false);
     }
     textfield.setText("O wins");
    }

}
