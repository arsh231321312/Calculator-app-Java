package controller;

import android.annotation.SuppressLint;
import android.graphics.Path;
import android.view.View;

import model.Stack;
import view.TextViewView;

public class ClearButtonListener implements View.OnClickListener {
    static OperandBuffer operandBuffer;
    static Stack s;

    @SuppressLint("StaticFieldLeak")
    static TextViewView textViewView;
    public static void setS(Stack s) {
        ClearButtonListener.s = s;
    }

    public static void setTextViewView(TextViewView textViewView) {
        ClearButtonListener.textViewView = textViewView;
    }

    public static void setOperandBuffer(OperandBuffer operandBuffer){ClearButtonListener.operandBuffer=operandBuffer;}
    public void onClick(View v) {
        operandBuffer.setBase(10);
        operandBuffer.setMagnitude();
        textViewView.displayResult("0");
        s.clear();

    }
}
