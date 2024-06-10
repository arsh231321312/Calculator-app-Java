package controller;

import android.annotation.SuppressLint;
import android.graphics.Path;
import android.view.View;

import model.MainController;
import model.Stack;
import model.State;
import view.TextViewView;

public class EquButtonListener implements View.OnClickListener {
    static Stack s;
    static OperandBuffer operandBuffer;
    static MainController mainController;

    public static void setMainController(MainController mainController) {
        EquButtonListener.mainController = mainController;
    }

    public static void setOperandBuffer(OperandBuffer operandBuffer){EquButtonListener.operandBuffer=operandBuffer;}
    public static void setS(Stack s){
        EquButtonListener.s=s;
    }

    @SuppressLint("StaticFieldLeak")
    static TextViewView textViewView;
    public static void setTextViewView(TextViewView textViewView){
        EquButtonListener.textViewView =textViewView;
    }
    @Override
    public void onClick(View v) {
        if(mainController.getState()!=State.EQUALS) {
            long num = operandBuffer.toLong();
            String str = Long.toString(num);
            s.push(str);
            StringBuilder newS= new StringBuilder();
            newS.append("Stack\n");
            for(String strings : s){
                newS.append(strings).append("\n");
            }
            textViewView.displayStack(newS.toString());
            s.eval();
            textViewView.displayResult(s.getFirst());
            mainController.setState(State.EQUALS);
        }
    }
}
