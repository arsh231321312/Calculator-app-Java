package controller;

import android.annotation.SuppressLint;
import android.view.View;

import model.MainController;
import model.Stack;
import view.TextViewView;

public class BinButtonListener implements View.OnClickListener{
    static Stack s;

    @SuppressLint("StaticFieldLeak")
    static TextViewView textViewView;
    static OperandBuffer operandBuffer;
    static MainController mainController;

    public static void setTextViewView(TextViewView textViewView) {
        BinButtonListener.textViewView = textViewView;
    }

    public static void setOperandBuffer(OperandBuffer operandBuffer) {
        BinButtonListener.operandBuffer = operandBuffer;
    }

    public static void setS(Stack s) {
        BinButtonListener.s = s;
    }

    @Override
    public void onClick(View v) {
        if(operandBuffer.getBase() ==10) {
            operandBuffer.setBase(2);
            long num=operandBuffer.toLong();
            s.clear();
            operandBuffer.setMagnitude();
            operandBuffer.extend((int)num);
            String str = Long.toString(num);
            textViewView.displayResult(str);
        }

    }
}
