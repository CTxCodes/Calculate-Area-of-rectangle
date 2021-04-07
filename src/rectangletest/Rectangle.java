/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangletest;

/**
 *
 * @author cjt1496
 */
import java.util.Scanner;
public class Rectangle {
    Scanner input = new Scanner(System.in);
    private double length;
    private double width;
    private int exit;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if((length < 0.0 ) && (length >= 20.0)){
            throw new IllegalArgumentException ("Length must be greater than 0.0 and less than 20.0"); 
        } else if (length < width){
            throw new IllegalArgumentException("length must be greater than the width for a rectangle");
        }else{ 
         this.length = length;
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if((width < 0.0) && (width >= 20.0)){
            throw new IllegalArgumentException("width must be greater than 0 and less than 20.0");
        } else if (width > length){
            throw new IllegalArgumentException("width must be smaller than length to be a rectangle.");
        } else {
            this.width = width;
        }
    }
    
    public Rectangle(){
        this.length = 1;
        this.width = 1;
    }
    
    public void CalculatePerimeterAndArea(){
      
      do{
            System.out.println("Enter the (length).");
            do{
              length = input.nextDouble();
              if(length < 0.0 || length > 20.0){
                  System.out.println("Enter the length again...Your values must be greater than 0.0 and less than 20.0");
              }
            }while(length < 0.0 || length > 20.0);

              System.out.println("Enter the (width). ");
            do{
              width = input.nextDouble();
              if(width < 0.0 || width > 20.0){
                System.out.println("Enter the length again...Your values must be greater than 0.0 and less than 20.0");
              }
              
               if((width > length)){
                System.out.println("Your length must be greater than your width. Enter your width again...");
            } else if (length == width){
                System.out.println("Your length and width are the same size. That is a SQUARE not a RECTANGLE! \n"
                        +"Enter your width again...");
            }

            }while((width < 0.0 || width > 20.0) || (width > length) || (length == width));

           
          
            System.out.println("press \"0\" to get measurements. or type \"99\" to enter values again.");
            exit = input.nextInt();
            if(exit == 0){
                break;
            } else if (exit == 99) {
                System.out.println("");
                CalculatePerimeterAndArea();
            } else if (exit != 0 || exit != 99){
                throw new IllegalArgumentException("To exit the program and get your values press 0. \nTo go back and enter values again press \"99\".");

            }
            
          

      }while((exit != 0));
          
         System.out.println("");
         System.out.println("The perimeter of this rectangle is : " + width * (length + width) + "cm");
         System.out.println("The area of this rectangle is : " + length * width + "cm" );
    }
}
