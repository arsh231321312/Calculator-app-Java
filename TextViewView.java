package view;

import android.widget.TextView;

import model.MainController;

public class TextViewView {
    TextView state;
    TextView base;
    TextView stack;
    TextView result;

    public void setBase(TextView base) {
        this.base = base;
    }

    public void setResult(TextView result) {
        this.result = result;
    }

    public void setStack(TextView stack) {
        this.stack = stack;
    }

    public void setState(TextView state) {
        this.state = state;
    }
    public void displayBase(String s){base.setText(s);}
    public void displayStack(String s){stack.setText(s);}
    public void displayResult(String s){result.setText(s);}
    public void displayState(String s){state.setText(s);}
}
