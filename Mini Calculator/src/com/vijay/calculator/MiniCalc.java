package com.vijay.calculator;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MiniCalc extends JFrame{
	
	JButton but1, but2, but3, but4, but5, but6,
		but7, but8, but9, but0, butPlus, butMinus,
		clearAll, butEquals;
	
	JTextField textResult;
	
	int num1 = 0, num2 = 0;
	static int result = 0;
	String operation = null;	
	
	public static void main(String[] args){
		
		new MiniCalc();
		
	}
	
	public MiniCalc(){
		
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Calculator");
		
		JPanel thePanel = new JPanel();
		
		thePanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gridConstraints = new GridBagConstraints();
		
		gridConstraints.gridx = 1;
		
		gridConstraints.gridy = 1;
		
		gridConstraints.gridwidth = 1;

		gridConstraints.gridheight = 1;

		gridConstraints.weightx = 50;

		gridConstraints.weighty = 100;
		
		gridConstraints.insets = new Insets(5,5,5,5);
		
		gridConstraints.anchor = GridBagConstraints.CENTER;
		
		gridConstraints.fill = GridBagConstraints.BOTH;
		
		textResult = new JTextField(null,20);
		
		
		Font font = new Font("Helvetica", Font.PLAIN, 18);
        textResult.setFont(font);
        textResult.setEditable(false);
		
		but1 = new JButton("1");
		but2 = new JButton("2");
		but3 = new JButton("3");
		but4 = new JButton("4");
		but5 = new JButton("5");
		but6 = new JButton("6");
		but7 = new JButton("7");
		but8 = new JButton("8");
		but9 = new JButton("9");
		butPlus = new JButton("+");
		but0 = new JButton("0");
		butMinus = new JButton("-");
		clearAll = new JButton("C");
		butEquals = new JButton("=");
		
		thePanel.add(clearAll,gridConstraints);
		gridConstraints.gridwidth = 20;
		gridConstraints.gridx = 5;
		thePanel.add(textResult,gridConstraints);
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 2;
		thePanel.add(but1,gridConstraints);
		gridConstraints.gridx = 5;
		thePanel.add(but2,gridConstraints);
		gridConstraints.gridx = 9;
		thePanel.add(but3,gridConstraints);
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 3;
		thePanel.add(but4,gridConstraints);
		gridConstraints.gridx = 5;
		thePanel.add(but5,gridConstraints);
		gridConstraints.gridx = 9;
		thePanel.add(but6,gridConstraints);
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 4;
		thePanel.add(but7,gridConstraints);
		gridConstraints.gridx = 5;
		thePanel.add(but8,gridConstraints);
		gridConstraints.gridx = 9;
		thePanel.add(but9,gridConstraints);
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 5;
		thePanel.add(butPlus,gridConstraints);
		gridConstraints.gridx = 5;
		thePanel.add(but0,gridConstraints);
		gridConstraints.gridx = 9;
		thePanel.add(butMinus,gridConstraints);
		gridConstraints.gridx = 5;
		gridConstraints.gridy = 6;
		thePanel.add(butEquals, gridConstraints);

		
		ButtonListener blistener = new ButtonListener();
		OperationListener opListener = new OperationListener();
		
		
		but1.addActionListener(blistener);
		but2.addActionListener(blistener);
		but3.addActionListener(blistener);
		but4.addActionListener(blistener);
		but5.addActionListener(blistener);
		but6.addActionListener(blistener);
		but7.addActionListener(blistener);
		but8.addActionListener(blistener);
		but9.addActionListener(blistener);
		but0.addActionListener(blistener);
		clearAll.addActionListener(blistener);
		butEquals.addActionListener(opListener);
		butPlus.addActionListener(opListener);
		butMinus.addActionListener(opListener);
		
		this.add(thePanel);
		
		this.setVisible(true);
		
	} 
	
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == but1){
				textResult.setText(textResult.getText().concat("1"));
			} 
			if(e.getSource() == but2){
				textResult.setText(textResult.getText().concat("2"));
			} 
			if(e.getSource() == but3){
				textResult.setText(textResult.getText().concat("3"));
			} 
			if(e.getSource() == but4){
				textResult.setText(textResult.getText().concat("4"));
			} 
			if(e.getSource() == but5){
				textResult.setText(textResult.getText().concat("5"));
			} 
			if(e.getSource() == but6){
				textResult.setText(textResult.getText().concat("6"));
			} 
			if(e.getSource() == but7){
				textResult.setText(textResult.getText().concat("7"));
			} 
			if(e.getSource() == but8){
				textResult.setText(textResult.getText().concat("8"));
			} 
			if(e.getSource() == but9){
				textResult.setText(textResult.getText().concat("9"));
			} 
			if(e.getSource() == but0){
				textResult.setText(textResult.getText().concat("0"));
			} 
			if(e.getSource() == clearAll){
				textResult.setText("");
			}
			
		}
	}//end of buttonlistener
	private class OperationListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == butPlus){
				operation = "+";
				num1 = Integer.parseInt(textResult.getText());
				textResult.setText("");
			}
			if (e.getSource() == butMinus){
				operation = "-";
				textResult.setText(textResult.getText());
				num1 = Integer.parseInt(textResult.getText());
				textResult.setText("");
			}
			if (e.getSource() == butEquals){
			
				num2 = Integer.parseInt(textResult.getText());
				switch(operation){
				case "+":
					result = num1 + num2;
					break;
				case "-":
					result = num1 - num2;
					break;
				default: result=0;
					
				}
				
				textResult.setText(""+result);
			}
		}
	}// end for operationListener
} 
