package model;

import java.util.LinkedList;

import controller.OperandBuffer;

public class Stack extends LinkedList<String> {
static OperandBuffer operandBuffer;

    public static void setOperandBuffer(OperandBuffer operandBuffer) {
        Stack.operandBuffer = operandBuffer;
    }

    public void eval(){
        if(this.size() ==3){
            long op1 = Long.parseLong(this.pop());
            String str=pop();
            long op2 = Long.parseLong(this.pop());
            long value = 0;
            switch (str){
                case "+":
                    value = op1 + op2;
                    break;
                case "-":
                    value = op2 - op1;
                    break;
                case "X":
                    value = op1 * op2;
                    break;
                case "/":
                    if (op2 == 0){
                        throw new ArithmeticException("Error: Can not divide by zero.");
                    }
                    value = op2 / op1;


                    break;
                default:
                    System.out.println("error in eval-Stack-Model");
            }
            System.out.println(value);
            operandBuffer.setMagnitude();
            operandBuffer.extend((int)value);
            this.push(Long.toString(value));

        }else if(this.size()<3){
            System.out.println("NOT ENOUUGH IN STACK");

        }else {
            System.out.println("TOO MUCH IN STACK");
        }
    }
}




