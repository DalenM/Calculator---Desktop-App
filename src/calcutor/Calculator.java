package calcutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {
	private JFrame calcFrame;
	
	private JPanel keypad;
	private JPanel operatorPanel;
	private JPanel displayPanel;
	
	private JButton buttonOne;
	private JButton buttonTwo;
	private JButton buttonThree;
	private JButton buttonFour;
	private JButton buttonFive;
	private JButton buttonSix;
	private JButton buttonSeven;
	private JButton buttonEight;
	private JButton buttonNine;
	private JButton buttonZero;
	
	private JButton addButton;
	private JButton subtractButton;
	private JButton multiplyButton;
	private JButton divideButton;
	private JButton equalsButton;
	private JButton clearButton;
	
	private int termOne;
	private int termTwo;
	private JTextField jText;
	private String display;
	
	private boolean solveAdd;
	private boolean solveSubtract;
	private boolean solveMultiply;
	private boolean solveDivide;
	
	public Calculator() {
		calcFrame = new JFrame();
		
		solveAdd = false;
		solveSubtract = false;
		solveMultiply = false;
		solveDivide = false;
		
		this.display = "";
		
		keypad = new JPanel();
		keypad.setBackground(Color.LIGHT_GRAY);
		keypad.setLayout(new GridLayout(4, 3, 5, 5));
		
		buttonOne = new JButton("1");
		buttonTwo = new JButton("2");
		buttonThree = new JButton("3");
		buttonFour = new JButton("4");
		buttonFive = new JButton("5");
		buttonSix = new JButton("6");
		buttonSeven = new JButton("7");
		buttonEight = new JButton("8");
		buttonNine = new JButton("9");
		buttonZero = new JButton("0");
		equalsButton = new JButton("=");
		clearButton = new JButton("c");
		
		keypad.add(buttonOne);
		keypad.add(buttonTwo);
		keypad.add(buttonThree);
		keypad.add(buttonFour);
		keypad.add(buttonFive);
		keypad.add(buttonSix);
		keypad.add(buttonSeven);
		keypad.add(buttonEight);
		keypad.add(buttonNine);
		keypad.add(buttonZero);
		keypad.add(equalsButton);
		keypad.add(clearButton);
		
		operatorPanel = new JPanel();
		operatorPanel.setLayout(new GridLayout(4, 1, 5, 5));
		operatorPanel.setBackground(Color.LIGHT_GRAY);
		
		addButton = new JButton("+");
		subtractButton = new JButton("-");
		multiplyButton = new JButton("*");
		divideButton = new JButton("/");
		
		
		operatorPanel.add(addButton);
		operatorPanel.add(subtractButton);
		operatorPanel.add(multiplyButton);
		operatorPanel.add(divideButton);
		
		displayPanel = new JPanel();
		displayPanel.setLayout(new FlowLayout());
		jText = new JTextField();
		displayPanel.add(jText);
		jText.setHorizontalAlignment(JTextField.RIGHT);
		jText.setEditable(false);
		
		buttonOne.addActionListener(new onePressed());
		buttonTwo.addActionListener(new twoPressed());
		buttonThree.addActionListener(new threePressed());
		buttonFour.addActionListener(new fourPressed());
		buttonFive.addActionListener(new fivePressed());
		buttonSix.addActionListener(new sixPressed());
		buttonSeven.addActionListener(new sevenPressed());
		buttonEight.addActionListener(new eightPressed());
		buttonNine.addActionListener(new ninePressed());
		buttonZero.addActionListener(new zeroPressed());
		equalsButton.addActionListener(new equalsPressed());
		clearButton.addActionListener(new clearPressed());
		
		addButton.addActionListener(new addPressed());
		subtractButton.addActionListener(new subtractPressed());
		multiplyButton.addActionListener(new multiplyPressed());
		divideButton.addActionListener(new dividePressed());
		
		calcFrame.setLayout(new BorderLayout());
		calcFrame.add(displayPanel, BorderLayout.NORTH);
		calcFrame.add(keypad, BorderLayout.CENTER);
		calcFrame.add(operatorPanel, BorderLayout.WEST);
		
		calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calcFrame.setTitle("Calculator");
		calcFrame.pack();
		calcFrame.setVisible(true);
	}
	
	class onePressed implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			display = jText.getText();
			jText.setText(display + "1");
		}
	}
	
	class twoPressed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			display = jText.getText();
			jText.setText(display + "2");
		}
	}
	
	class threePressed implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			display = jText.getText();
			jText.setText(display + "3");
		}
	}
	
	class fourPressed implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			display = jText.getText();
			jText.setText(display + "4");
		}
	}
	
	class fivePressed implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			display = jText.getText();
			jText.setText(display + "5");
		}
	}
	
	class sixPressed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			display = jText.getText();
			jText.setText(display + "6");
		}
	}
	
	class sevenPressed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			display = jText.getText();
			jText.setText(display + "7");
		}
	}
	
	class eightPressed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			display = jText.getText();
			jText.setText(display + "8");
		}
	}
	
	class ninePressed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			display = jText.getText();
			jText.setText(display + "9");
		}
	}
	
	class zeroPressed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			display = jText.getText();
			jText.setText(display + "0");
		}
	}
	
	class equalsPressed implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(jText.getText().isEmpty()){
				termTwo = 0;
			} else {
				termTwo = Integer.parseInt(jText.getText());
			}
			
			if(solveAdd){
				display += add(termOne, termTwo);
				jText.setText(display);
			} else if(solveSubtract){
				display += subtract(termOne, termTwo);
				jText.setText(display);
			} else if(solveMultiply){
				display += multiply(termOne, termTwo);
				jText.setText(display);
			} else if(solveDivide){
				display += divide(termOne, termTwo);
				jText.setText(display);
			} else {
				return;
			}
			
			termOne = 0;
			termTwo = 0;
			
			solveAdd = false;
			solveSubtract = false;
			solveMultiply = false;
			solveDivide = false;
		}
	}
	
	class clearPressed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			jText.setText("");
			solveAdd = false;
			solveSubtract = false;
			solveMultiply = false;
			solveDivide = false;
		}
	}
	
	class addPressed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			termOne = Integer.parseInt(jText.getText());
			jText.setText("");
			solveAdd = true;
		}
	}
	
	class subtractPressed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			termOne = Integer.parseInt(jText.getText());
			jText.setText("");
			solveSubtract = true;
		}
	}
	
	class multiplyPressed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			termOne = Integer.parseInt(jText.getText());
			jText.setText("");
			solveMultiply = true;
		}
	}
	
	class dividePressed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			termOne = Integer.parseInt(jText.getText());
			jText.setText("");
			solveDivide = true;
		}
	}
	
	public static int add(int a, int b) {
		return Math.addExact(a, b);
	}
	
	public static int subtract(int a, int b) {
		return Math.subtractExact(a, b);
	}
	
	public static int multiply(int a, int b) {
		return Math.multiplyExact(a, b);
	}
	
	public static int divide(int a, int b) {
		return Math.floorDiv(a, b);
	}
	
	public static void main(String[] args) {
		new Calculator();
	}
	
	

}
