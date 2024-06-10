package com.example.a5_gbu472;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import controller.ArithButtonListener;
import controller.BinButtonListener;
import controller.ClearButtonListener;
import controller.EquButtonListener;
import controller.NumbersButtonListener;
import controller.OperandBuffer;
import controller.SignButtonListener;
import model.MainController;
import model.Stack;
import model.State;
import view.TextViewView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Stack s = new Stack();
        NumbersButtonListener.setS(s);
        ArithButtonListener.setS(s);
        EquButtonListener.setS(s);
        ClearButtonListener.setS(s);

        Button button1 = findViewById(R.id.one);
        Button button2 = findViewById(R.id.two);
        Button button3 = findViewById(R.id.three);
        Button button4 = findViewById(R.id.four);
        Button button5 = findViewById(R.id.five);
        Button button6 = findViewById(R.id.six);
        Button button7 = findViewById(R.id.seven);
        Button button8 = findViewById(R.id.eight);
        Button button9 = findViewById(R.id.nine);
        Button button0 = findViewById(R.id.zero);
        button0.setOnClickListener(new NumbersButtonListener(0));
        button1.setOnClickListener(new NumbersButtonListener(1));
        button2.setOnClickListener(new NumbersButtonListener(2));
        button3.setOnClickListener(new NumbersButtonListener(3));
        button4.setOnClickListener(new NumbersButtonListener(4));
        button5.setOnClickListener(new NumbersButtonListener(5));
        button6.setOnClickListener(new NumbersButtonListener(6));
        button7.setOnClickListener(new NumbersButtonListener(7));
        button8.setOnClickListener(new NumbersButtonListener(8));
        button9.setOnClickListener(new NumbersButtonListener(9));

        Button add = findViewById(R.id.add);
        Button sub = findViewById(R.id.sub);
        Button mul = findViewById(R.id.mul);
        Button div = findViewById(R.id.div);
        add.setOnClickListener(new ArithButtonListener("+"));
        sub.setOnClickListener(new ArithButtonListener("-"));
        mul.setOnClickListener(new ArithButtonListener("X"));
        div.setOnClickListener(new ArithButtonListener("/"));

        Button equ = findViewById(R.id.equ);
        equ.setOnClickListener(new EquButtonListener());

        State state=State.NUMBER;
        OperandBuffer op = new OperandBuffer(10,"0",true);
        TextViewView textViewView = new TextViewView();
        TextView resultView = findViewById(R.id.display);
        TextView baseView = findViewById(R.id.base);
        TextView stackView = findViewById(R.id.stack);
        TextView stateView = findViewById(R.id.state);

        textViewView.setResult(resultView);
        textViewView.setBase(baseView);
        textViewView.setState(stateView);
        textViewView.setStack(stackView);

        textViewView.displayBase("Base: 10");
        textViewView.displayResult("0");
        textViewView.displayStack("Stack: Empty");
        textViewView.displayState("State: Number");
        NumbersButtonListener.setTextViewView(textViewView);
        NumbersButtonListener.setOperandBuffer(op);
        ArithButtonListener.setOperandBuffer(op);
        EquButtonListener.setOperandBuffer(op);
        ArithButtonListener.setTextViewView(textViewView);
        EquButtonListener.setTextViewView(textViewView);
        ClearButtonListener.setOperandBuffer(op);
        ClearButtonListener.setTextViewView(textViewView);

        Button clr = findViewById(R.id.clr);
        clr.setOnClickListener(new ClearButtonListener());
        MainController mainController= new MainController();
        mainController.setState(State.NUMBER);
        ArithButtonListener.setMainController(mainController);
        NumbersButtonListener.setMainController(mainController);
        EquButtonListener.setMainController(mainController);

        Button plusminus = findViewById(R.id.plusminus);
        plusminus.setOnClickListener(new SignButtonListener());
        SignButtonListener.setMainController(mainController);
        SignButtonListener.setS(s);
        SignButtonListener.setOperandBuffer(op);
        SignButtonListener.setTextViewView(textViewView);
        Stack.setOperandBuffer(op);

        Button bin = findViewById(R.id.bin);
        bin.setOnClickListener(new BinButtonListener());
        BinButtonListener.setTextViewView(textViewView);
        BinButtonListener.setOperandBuffer(op);
        BinButtonListener.setS(s);
    }
}