/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator;

/**
 *
 * @author wahyu
 */
public class StackClass {
    String []data;
    int top;
    int maxSize;
    
    StackClass(int maxSize){
        this.maxSize = maxSize;
        this.data = new String[maxSize];
        this.top = -1;
    }
    
    boolean isEmpty(){
        if(this.top == -1){
            return true;
        }else return false;
    }
    
    boolean isFull(){
        if(this.top == this.maxSize-1){
            return true;
        }else return false;
    }
    
    void push(String element){
        if(!isFull()){
            this.top++;
            this.data[this.top] = element;
            this.display();
            System.out.println();
        }
    }
    
    String pop(){
        if(!isEmpty()){
            String temp = this.data[this.top];
            top--;
//            this.display();
            System.out.println();
            return temp;
        }else{
            System.out.println(0);
            return null;
        }
    }
    
    void display(){
        if(!isEmpty()){
            for(int i = 0; i <= this.top; i++){
                System.out.print(this.data[i]+" ");
            }
        }
    }
}
