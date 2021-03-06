import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.*;

public class GUI extends JFrame{
	private JFrame frame; // top level frame
	private JPanel panel; // panel for buttons and misc
	private JPanel bgPanel; // panel for monopoly board
	private JButton roll; // roll button
	private DefaultListModel listModel; // list
	private JList list; // list holder
	private JTextArea action;
	
	public GUI() {
		display();
	}
	
	private void display(){
		//create initial top-level frame
		frame = new JFrame("Monopoly by Pennybags");
		frame.setLayout(new BorderLayout(25,25));
		
		//create button panel
		panel = new JPanel();
		//panel.setPreferredSize(new Dimension(200,600));
		panel.setLayout(new GridLayout(5,0,0,15)); // first number is number of elements(buttons) allowed
		
		//MENU CREATION
		//========================================================================================================
				//create menu
				JMenuBar menu = new JMenuBar();
				
				//create option in menu
				JMenu dropDown = new JMenu("Menu");
				dropDown.setMnemonic(KeyEvent.VK_M);
				dropDown.setToolTipText("ALT + M");
				
				//create options inside dropDown
				JMenuItem start = new JMenuItem("Start"); // Start button
				start.setMnemonic(KeyEvent.VK_S);
				start.setToolTipText("Start a new game! (ALT + S)");
				
				JMenuItem exit = new JMenuItem("Exit"); // Exit button
				exit.setMnemonic(KeyEvent.VK_E);
				exit.setToolTipText("Close this program. (ALT + E)");
				
				JMenuItem credit = new JMenuItem("Credits"); // Credits
				
				//add functionality to Exit
				exit.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent event) {
						int result = JOptionPane.showConfirmDialog(panel, "Are you sure you want to quit?", "Exit", JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.YES_OPTION) { 
							System.exit(0);
						}
				  }
				 });
				 
				//add functionality to credit
				credit.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent event) {
					   JOptionPane.showMessageDialog(panel, "<html><center><b>Hyunwoo Jeung, Johnathan Yan, Joey Zeng\nPeriod 9", "Credits", JOptionPane.INFORMATION_MESSAGE);
				  }
				 });
				
				//add options
				dropDown.add(start);
				dropDown.add(credit);
				dropDown.add(exit);
				
				//add dropdown
				menu.add(dropDown);
				
				frame.setJMenuBar(menu);// frame is the top level container.
				
		//========================================================================================================
		
		//CREATES MONOPOLY BOARD(bgPanel)
		//========================================================================================================
				//create background panel
				bgPanel = new JPanel();
				bgPanel.setLayout(new BorderLayout(0,0));
				
				//create tiles on the top
				JPanel north = new JPanel();
				JButton b20 = new JButton("<html><center>20<br><b>Free<br>Parking</html>");
				JButton b21 = new JButton("<html><center>21<br><b>Kentucky<br>Avenue<br>$220</html>");
				b21.setForeground(Color.red);
				JButton b22 = new JButton("<html><center>22<br><b>Chance</html>");
				b22.setToolTipText("Draw a card!");
				JButton b23 = new JButton("<html><center>23<br><b>Indiana<br>Avenue<br>$220</html>");
				b23.setForeground(Color.red);
				JButton b24 = new JButton("<html><center>24<br><b>Illinois<br>Avenue<br>$240</html>");
				b24.setForeground(Color.red);
				JButton b25 = new JButton("<html><center>25<br><b>B&O<br>RR<br>$200</html>");
				JButton b26 = new JButton("<html><center>26<br><b>Atlantic<br>Avenue<br>$260</html>");
				b26.setForeground(Color.yellow);
				JButton b27 = new JButton("<html><center>27<br><b>Ventnor<br>Avenue<br>$260</html>");
				b27.setForeground(Color.yellow);
				JButton b28 = new JButton("<html><center>28<br><b>Water<br>Works<br>$150</html>");
				JButton b29 = new JButton("<html><center>29<br><b>Marvin<br>Gardens<br>$280</html>");
				b29.setForeground(Color.yellow);
				JButton b30 = new JButton("<html><center>30<br><b>Go To<br>Jail</html>");
				b30.setToolTipText("How unfortunate. GO TO JAIL!");
				b20.setPreferredSize(new Dimension(85,110));
				b21.setPreferredSize(new Dimension(85,110));
				b22.setPreferredSize(new Dimension(85,110));
				b23.setPreferredSize(new Dimension(85,110));
				b24.setPreferredSize(new Dimension(85,110));
				b25.setPreferredSize(new Dimension(85,110));
				b26.setPreferredSize(new Dimension(85,110));
				b27.setPreferredSize(new Dimension(85,110));
				b28.setPreferredSize(new Dimension(85,110));
				b29.setPreferredSize(new Dimension(85,110));
				b30.setPreferredSize(new Dimension(85,110));
				north.add(b20);
				north.add(b21);
				north.add(b22);
				north.add(b23);
				north.add(b24);
				north.add(b25);
				north.add(b26);
				north.add(b27);
				north.add(b28);
				north.add(b29);
				north.add(b30);
				
				//create tiles on the bottom
				JPanel south = new JPanel();
				JButton b0 = new JButton("<html><center>0<br><b>GO</b></center></html>");
				JButton b1 = new JButton("<html><center>1<br />Medi.<br />Avenue<br>$60</center></html>");
				b1.setForeground(Color.blue);
				b1.setIcon(new ImageIcon("shoe.jpg"));
				b1.setHorizontalTextPosition(SwingConstants.CENTER);
				JButton b2 = new JButton("<html><center>2<br><b>Commun.<br>Chest</html>");
				b2.setToolTipText("Draw a card!");
				JButton b3 = new JButton("<html><center>3<br><b>Baltic<br>Avenue<br>$60</html>");
				b3.setForeground(Color.blue);
				JButton b4 = new JButton("<html><center>4<br><b>Income<br>Tax</html>");
				b4.setToolTipText("Pay $200");
				JButton b5 = new JButton("<html><center>5<br><b>Reading<br>R.R.<br>$200</html>");
				JButton b6 = new JButton("<html><center>6<br><b>Oriental<br>Avenue<br>$100</html>");
				b6.setForeground(Color.cyan);
				JButton b7 = new JButton("<html><center>7<br><b>Chance</html>");
				b7.setToolTipText("Draw a card!");
				JButton b8 = new JButton("<html><center>8<br><b>Vermont<br>Avenue<br>$100</html>");
				b8.setForeground(Color.cyan);
				JButton b9 = new JButton("<html><center>9<br><b>Connnect.<br>Avenue<br>$120</html>");
				b9.setForeground(Color.cyan);
				JButton b10 = new JButton("<html><center>10<br><b>Jail<br>or<br>Visiting</html>");
				b0.setPreferredSize(new Dimension(85,110));
				b1.setPreferredSize(new Dimension(85,110));
				b2.setPreferredSize(new Dimension(85,110));
				b3.setPreferredSize(new Dimension(85,110));
				b4.setPreferredSize(new Dimension(85,110));
				b5.setPreferredSize(new Dimension(85,110));
				b6.setPreferredSize(new Dimension(85,110));
				b7.setPreferredSize(new Dimension(85,110));
				b8.setPreferredSize(new Dimension(85,110));
				b9.setPreferredSize(new Dimension(85,110));
				b10.setPreferredSize(new Dimension(85,110));
				south.add(b10);
				south.add(b9);
				south.add(b8);
				south.add(b7);
				south.add(b6);
				south.add(b5);
				south.add(b4);
				south.add(b3);
				south.add(b2);
				south.add(b1);
				south.add(b0);
				
				//create tiles on the right
				JPanel east = new JPanel();
				east.setLayout(new GridLayout(9,0));
				JButton b31 = new JButton("<html><center>31<br><b>Pacific<br>Avenue<br>$300</html>");
				b31.setForeground(Color.green);
				JButton b32 = new JButton("<html><center>32<br><b>N.C.<br>Avenue<br>$300</html>");
				b32.setForeground(Color.green);
				JButton b33 = new JButton("<html><center>33<br><b>Commun.<br>Chest</html>");
				b33.setToolTipText("Draw a card!");
				JButton b34 = new JButton("<html><center>34<br><b>Penn.<br>Avenue<br>$320</html>");
				b34.setForeground(Color.green);
				JButton b35 = new JButton("<html><center>35<br><b>Short<br>Line<br>$200</html>");
				JButton b36 = new JButton("<html><center>36<br><b>Chance</html>");
				b36.setToolTipText("Draw a card!");
				JButton b37 = new JButton("<html><center>37<br><b>Park<br>Place<br>$350</html>");
				b37.setForeground(Color.blue);
				JButton b38 = new JButton("<html><center>38<br><b>Luxury<br>Tax</html>");
				b38.setToolTipText("Pay $75.");
				JButton b39 = new JButton("<html><center>39<br><b>Board<br>walk<br>$400</html>");
				b39.setForeground(Color.blue);
				b31.setPreferredSize(new Dimension(90,70));
				b32.setPreferredSize(new Dimension(90,70));
				b33.setPreferredSize(new Dimension(90,70));
				b34.setPreferredSize(new Dimension(90,70));
				b35.setPreferredSize(new Dimension(90,70));
				b36.setPreferredSize(new Dimension(90,70));
				b37.setPreferredSize(new Dimension(90,70));
				b38.setPreferredSize(new Dimension(90,70));
				b39.setPreferredSize(new Dimension(90,70));
				east.add(b31);
				east.add(b32);
				east.add(b33);
				east.add(b34);
				east.add(b35);
				east.add(b36);
				east.add(b37);
				east.add(b38);
				east.add(b39);
				
				//create tiles on the left
				JPanel west = new JPanel();
				west.setLayout(new GridLayout(9,0));
				JButton b11 = new JButton("<html><center>11<br><b>St. Charles<br>Place<br>$140</html>");
				b11.setForeground(Color.magenta);
				JButton b12 = new JButton("<html><center>12<br><b>Elec.<br>Company<br>$150</html>");
				JButton b13 = new JButton("<html><center>13<br><b>States<br>Avenue<br>$140</html>");
				b13.setForeground(Color.magenta);
				JButton b14 = new JButton("<html><center>14<br><b>Virginia<br>Avenue<br>$160</html>");
				b14.setForeground(Color.blue);
				JButton b15 = new JButton("<html><center>15<br><b>Penn.<br>R.R.<br>$200</html>");
				JButton b16 = new JButton("<html><center>16<br><b>St. James<br>Place<br>$180</html>");
				b16.setForeground(Color.orange);
				JButton b17 = new JButton("<html><center>17<br><b>Commun.<br>Chest</html>");
				b17.setToolTipText("Draw a card!");
				JButton b18 = new JButton("<html><center>18<br><b>Tennessee<br>Avenue<br>$180</html>");
				b18.setForeground(Color.orange);
				JButton b19 = new JButton("<html><center>19<br><b>New York<br>Avenue<br>$200</html>");
				b19.setForeground(Color.orange);
				b11.setPreferredSize(new Dimension(90,70));
				b12.setPreferredSize(new Dimension(90,70));
				b13.setPreferredSize(new Dimension(90,70));
				b14.setPreferredSize(new Dimension(90,70));
				b15.setPreferredSize(new Dimension(90,70));
				b16.setPreferredSize(new Dimension(90,70));
				b17.setPreferredSize(new Dimension(90,70));
				b18.setPreferredSize(new Dimension(90,70));
				b19.setPreferredSize(new Dimension(90,70));
				west.add(b19);
				west.add(b18);
				west.add(b17);
				west.add(b16);
				west.add(b15);
				west.add(b14);
				west.add(b13);
				west.add(b12);
				west.add(b11);
				
				//creates center monopoly image
				JPanel bg = new JPanel();
				JLabel background=new JLabel(new ImageIcon("monopoly.jpg"));
                bg.add(background);
				
				//sets background of bgPanel to monopoly board
				bgPanel.setLayout(new BorderLayout()); // allows for division of content
				bgPanel.add(north, BorderLayout.NORTH);
				bgPanel.add(south, BorderLayout.SOUTH);
				bgPanel.add(east, BorderLayout.EAST);
				bgPanel.add(west, BorderLayout.WEST);
				bgPanel.add(bg, BorderLayout.CENTER);

		//========================================================================================================
	
		//CREATES BUTTONS
		//========================================================================================================
				//create roll button
				roll = new JButton("Roll!");
				//roll.setPreferredSize(new Dimension(100,100));
				roll.setToolTipText("Roll the dice. Is only enabled during your turn.");
				roll.setEnabled(false);
				
				//create roll button
				/* testing function
				JButton test = new JButton("test!");
				test.setPreferredSize(new Dimension(100,100));
				test.setEnabled(true);
				test.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent event) {
					   action.append("test\n");
				  }
				 });
				 */
				
				//create space for aesthetic purpose
				JButton space = new JButton("");
				//space.setPreferredSize(new Dimension(100,100));
				space.setVisible(false);
				
				//create roll button
				JButton newGame = new JButton("Start Game!");
				//newGame.setPreferredSize(new Dimension(100,100));
				newGame.setToolTipText("Starts new game.");
				newGame.setEnabled(false);
				
				//adds roll button
				panel.add(newGame);	
				panel.add(roll);	
				panel.add(space);
				//panel.add(test);	
		//========================================================================================================
		
		//CREATES TEXTFIELD & ACTION LIST
		//========================================================================================================
				//create player list
				Font font = new Font("Verdana", Font.BOLD, 12);
				listModel = new DefaultListModel(); // actual list
				
				//adds to list
				listModel.addElement("Player List");
				listModel.addElement("=================================");
				listModel.addElement("Player 1 : $1500 dollars");
				
				//adds list to listHolder
				list = new JList(listModel); // holds list
				list.setVisibleRowCount(5);
				list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				list.setFont(font);
				list.setForeground(Color.BLACK);
				list.setToolTipText("Player list");
				list.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.green));
				list.setEnabled(true);
				
				//create action list
				action = new JTextArea("Action List\n==============\n\n");
				action.setFont(font);
				action.setForeground(Color.BLACK);
				action.setRows(5);
				action.setToolTipText("Recent actions.");
				action.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.green));
				action.setLineWrap(true);
				action.setEditable(false);
				action.setEnabled(true);
				action.setCaretPosition(action.getDocument().getLength());
				JScrollPane actionScroll = new JScrollPane(action);
				actionScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				
				//adds roll button
				panel.add(list);	
				panel.add(actionScroll);
		//========================================================================================================
		
		//ADD PANELS TO FRAME
		//========================================================================================================
				frame.add(panel, BorderLayout.WEST);
				frame.add(bgPanel, BorderLayout.CENTER);
		//========================================================================================================
		
		//SET ATTRIBUTES
		//========================================================================================================
				frame.setTitle("Monopoly by Pennybags");
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.setResizable(true);
				//frame.setSize(1000,1000);
				frame.setVisible(true);
				frame.pack();
		//========================================================================================================
	}
		
	
	public static void main(String[] args){
		GUI tester = new GUI();		
	}
}
	
	
		