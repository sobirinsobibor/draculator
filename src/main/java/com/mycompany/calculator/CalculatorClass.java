/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator;

/**
 *
 * @author wahyu
 */
// Java program to create a simple calculator
// with basic +, -, /, * using java swing elements

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class CalculatorClass extends JFrame implements ActionListener {
	// create a frame
	static JFrame f;

	// create a textfield
	static JTextField l;

	// store operator and operands
	String s0, s1, s2;
        
        // binary operator
        int max = 3;
        String operandRegex = "\\d+";
        String operandRegexFloat = "^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*$";
        String operatorRegex = "+\\-*/";

	// default constructor
	CalculatorClass()
	{
		s0 = s1 = s2 = "";
                
	}

	// main function
	
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
               
		// if the value is a number
		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
			// if operand is present then add to second no
			if (!s1.equals(""))
				s2 = s2 + s;
			else
				s0 = s0 + s;

			// set the value of text
			l.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0) == 'C') {
			// clear the one letter
			s0 = s1 = s2 = "";

			// set the value of text
			l.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0) == '=') {

			double res;
                        
                        //binary operation 
                        BinaryClass bin = new BinaryClass(max);
                        for(int i = 0; i < max; i++){
                            if(i == 0){
                                bin.add(s0);
                            }else if( i == 1){
                                bin.add(s1);
                            }else bin.add(s2);
                        }       
                        
//                      stack operation  
                        StackClass operand = new StackClass(2);
                        StackClass operator = new StackClass(2);
                        for(int i = max-1; i >= 0; i--){
                            if(bin.getItem(i) == null){
                                operand.push(null);
                            }else if(bin.getItem(i).matches(operandRegex) || bin.getItem(i).matches(operandRegexFloat) ){
                                operand.push(bin.getItem(i));
                            }else if(!bin.getItem(i).matches(operandRegex)){
                                operator.push(bin.getItem(i));
                            }
                        } 
                        
                        String operator1 = bin.getItem(2) ;
                        String mathOperator = operator.pop();
                        res = switch (mathOperator) {
                        case "+" -> Double.parseDouble(operand.pop()) + Double.parseDouble(operand.pop());
                        case "-" -> Double.parseDouble(operand.pop()) - Double.parseDouble(operand.pop());
                        case "/" -> Double.parseDouble(operand.pop()) / Double.parseDouble(operand.pop());
                        default -> Double.parseDouble(operand.pop()) * Double.parseDouble(operand.pop());
                        };
                        
			// set the value of text
			l.setText(s0 + s1 + s2 + "=" + res);
//                        l.setText(operator1);

			// convert it to string
			s0 = Double.toString(res);
                        
//                        l.setText(operator1);

			s1 = s2 = "";
		}
		else { //+ - / *
			// if there was no operand
			if (s1.equals("") || s2.equals(""))
				s1 = s;
			// else evaluate
			else {
                            double res;

                            //binary operation 
                            BinaryClass bin = new BinaryClass(max);
                            for(int i = 0; i < max; i++){
                                if(i == 0){
                                    bin.add(s0);
                                }else if( i == 1){
                                    bin.add(s1);
                                }else bin.add(s2);
                            }       

                            //stack operation  
                            StackClass operand = new StackClass(2);
                            StackClass operator = new StackClass(2);
                            for(int i = max-1; i >= 0; i--){
                                if(bin.getItem(i) == null){
                                    operand.push(null);
                                }else if(bin.getItem(i).matches(operandRegex) || bin.getItem(i).matches(operandRegexFloat) ){
                                    operand.push(bin.getItem(i));
                                }else if(!bin.getItem(i).matches(operandRegex)){
                                    operator.push(bin.getItem(i));
                                }
                            } 

                            String operator1 = bin.getItem(2) ;
                            String mathOperator = operator.pop();
                            res = switch (mathOperator) {
                            case "+" -> Double.parseDouble(operand.pop()) + Double.parseDouble(operand.pop());
                            case "-" -> Double.parseDouble(operand.pop()) - Double.parseDouble(operand.pop());
                            case "/" -> Double.parseDouble(operand.pop()) / Double.parseDouble(operand.pop());
                            default -> Double.parseDouble(operand.pop()) * Double.parseDouble(operand.pop());
                            };
				// convert it to string
				s0 = Double.toString(res);

				// place the operator
				s1 = s;

				// make the operand blank
				s2 = "";
			}

			// set the value of text
			l.setText(s0 + s1 + s2);
		}
	}
}
