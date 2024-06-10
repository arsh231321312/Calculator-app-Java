package controller;

import android.annotation.SuppressLint;
import android.view.View;

import model.MainController;
import model.Stack;
import model.State;
import view.TextViewView;

public class SignButtonListener implements View.OnClickListener {
    static Stack s;
    @SuppressLint("StaticFieldLeak")
    static TextViewView textViewView;
    static OperandBuffer operandBuffer;
    static MainController mainController;

    public static void setMainController(MainController mainController) {
        SignButtonListener.mainController = mainController;
    }

    public static void setTextViewView(TextViewView textViewView) {
        SignButtonListener.textViewView = textViewView;
    }

    public static void setS(Stack s) {
        SignButtonListener.s = s;
    }

    public static void setOperandBuffer(OperandBuffer operandBuffer) {
        SignButtonListener.operandBuffer = operandBuffer;
    }

    public void onClick(View v) {
        if(mainController.getState() != State.EQUALS) {
            operandBuffer.negate();
            long num = operandBuffer.toLong();
            String str = Long.toString(num);
            textViewView.displayResult(str);
        }else{
            long num=Long.parseLong(s.pop());
            operandBuffer.setMagnitude();
            operandBuffer.extend((int)num);
            operandBuffer.negate();
            s.clear();
            num=operandBuffer.toLong();
            String str=Long.toString(num);
            s.push(str);
            StringBuilder newS= new StringBuilder();
            newS.append("Stack\n");
            for(String strings : s){
                newS.append(strings).append("\n");
            }
            textViewView.displayStack(newS.toString());
            textViewView.displayResult(str);


        }
    }
}
