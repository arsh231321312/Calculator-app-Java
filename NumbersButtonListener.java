package controller;

import android.annotation.SuppressLint;
import android.view.View;

import model.MainController;
import model.Stack;
import model.State;
import view.TextViewView;

public class NumbersButtonListener implements View.OnClickListener {
    long number;
    static Stack s;
    @SuppressLint("StaticFieldLeak")
    static TextViewView textViewView;
    static OperandBuffer operandBuffer;
    static MainController mainController;

    public static void setMainController(MainController mainController) {
        NumbersButtonListener.mainController = mainController;
    }

    public static void setTextViewView(TextViewView textViewView ){
        NumbersButtonListener.textViewView=textViewView;
    }
    public static void setOperandBuffer(OperandBuffer operandBuffer){NumbersButtonListener.operandBuffer=operandBuffer;}
    public static void setS(Stack s){
        NumbersButtonListener.s=s;
    }
    public NumbersButtonListener(long number){
        this.number=number;
    }
    @Override
    public void onClick(View v) {
        if(mainController.getState() ==State.EQUALS){
            operandBuffer.setBase(10);
            operandBuffer.setMagnitude();
            textViewView.displayResult("0");
            s.clear();
        }
        operandBuffer.extend((int) this.number);
        long num = operandBuffer.toLong();
        String str= Long.toString(num);
        textViewView.displayResult(str);
        mainController.setState(State.NUMBER);
    }
}
