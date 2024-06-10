package controller;

import android.annotation.SuppressLint;
import android.view.View;

import model.MainController;
import model.Stack;
import model.State;
import view.TextViewView;

public class ArithButtonListener implements View.OnClickListener{
    String arith;
    static Stack s;
    static MainController mainController;

    public static void setMainController(MainController mainController) {
        ArithButtonListener.mainController = mainController;
    }

    public static void setS(Stack s){
        ArithButtonListener.s=s;
    }
    static OperandBuffer operandBuffer;
    @SuppressLint("StaticFieldLeak")
    static TextViewView textViewView;
    public static void setTextViewView(TextViewView textViewView ){
        ArithButtonListener.textViewView=textViewView;
    }
    public static void setOperandBuffer(OperandBuffer operandBuffer){ArithButtonListener.operandBuffer=operandBuffer;}
    public ArithButtonListener(String arith){
        this.arith=arith;
    }
    @Override
    public void onClick(View v) {
        if(s.isEmpty()) {
            if(operandBuffer.getBase()==2){
                System.out.println("hello");
            }
            long num = operandBuffer.toLong();
            String str = Long.toString(num);
            if (s.isEmpty())
                s.push(str);
            s.push(arith);

            operandBuffer.setBase(10);
            operandBuffer.setMagnitude();
            mainController.setState(State.OPERATOR);
        }
    }
}
