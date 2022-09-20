package com.project103.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textInput, textOutput;
    private String input, output, newOutput;
    private Button btnClear, btnPower, btnPercent, btnDivisiion, btn7, btn8, btn9, btn1, btn2, btn3, btn4, btn5, btn6, btnMultiple,
    btnSubstruction, btnAddition,btnEquels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInput = findViewById(R.id.input);
        textOutput = findViewById(R.id.output);

        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btnClear = findViewById(R.id.btn_clear);
        btnDivisiion = findViewById(R.id.btn_division);
        btnPercent = findViewById(R.id.btn_percent);
        btnPower = findViewById(R.id.btn_power);
        btnSubstruction = findViewById(R.id.btn_substruction);
        btnAddition = findViewById(R.id.btn_addition);
        btnEquels = findViewById(R.id.btn_equels);
        btnMultiple = findViewById(R.id.btn_mutiple);

    }
    public void onButtonClicked(View view){
        Button button = (Button) view;
        String data = button.getText().toString();

        switch (data){
            case "C":
                input = null;
                output = null;
                newOutput = null;
                textOutput.setText("");
                break;
            case "^":
                solve();
                input+="^";
                break;
            case "*":
                solve();
                input+="*";
                break;
            case "=":
                solve();
                break;
            case "%":
                input+="%";
                double d = Double.parseDouble(textInput.getText().toString())/100;
                textOutput.setText(String.valueOf(d));
                break;
            default:
                if (input==null){
                    input = "";
                }
                if (data.equals("+")||data.equals("-")||data.equals("/")){
                    solve();
                }
                input+=data;
        }
        textInput.setText(input);
    }

    private void solve() {
        if(input.split("\\+").length==2){
            String numbers [] = input.split("\\+");
            try {
                double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                textOutput.setText(newOutput);
                input = d+"";
            }catch (Exception e){
                textOutput.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\*").length==2){
            String numbers [] = input.split("\\*");
            try {
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                textOutput.setText(newOutput);
                input = d+"";
            }catch (Exception e){
                textOutput.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\/").length==2){
            String numbers [] = input.split("\\/");
            try {
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                textOutput.setText(newOutput);
                input = d+"";
            }catch (Exception e){
                textOutput.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\^").length==2){
            String numbers [] = input.split("\\^");
            try {
                double d =Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                textOutput.setText(newOutput);
                input = d+"";
            }catch (Exception e){
                textOutput.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\-").length==2){
            String numbers [] = input.split("\\-");
            try {
                if (Double.parseDouble(numbers[0])<Double.parseDouble(numbers[1])){
                    double d = Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[0]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    textOutput.setText("-"+newOutput);
                    input = d+"";
                }else{
                    double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    textOutput.setText(newOutput);
                    input = d+"";
                }

            }catch (Exception e){
                textOutput.setError(e.getMessage().toString());
            }
        }
    }
    private String cutDecimal(String number){
        String n [] = number.split("\\.");
        if (n.length>1){
            if (n[1].equals("0")){
                number = n[0];
            }
        }
        return number;
    }
}