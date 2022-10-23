/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator;

/**
 *
 * @author wahyu
 */
public class BinaryClass {
    public String []array;
    public int size;
    public int maxSize;

    BinaryClass(int maxSize) {
        this.maxSize = maxSize;
        this.array=new String [this.maxSize];
        this.size=0;
//        for(int i=0; i<this.maxSize; i++){
//            this.array[i]=0;
//        }
    }
    
    void add(String item){
        this.array[this.size]=item;
        this.size++;
    }
    
    String getItem(int i){
        return this.array[i];
    }
    
    public void display(){
        for(int i=0; i<this.maxSize; i++){
            if(this.array[i]!=null){
                System.out.print(this.array[i]+" ");
            }
        }
    }
    
    
}
