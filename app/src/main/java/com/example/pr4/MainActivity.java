package com.example.pr4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = findViewById(R.id.textView);
        etInput = findViewById(R.id.editTextText);
        bControl = findViewById(R.id.button);
        guess = (int) (Math.random()*100);
        gameFinished = false;


    }


    public void onClick(View v)
    {

        if(etInput.getText().toString().equals("") && !gameFinished)
        {

            Toast.makeText(getApplicationContext(), "Введите значение в поле для ввода!", Toast.LENGTH_SHORT).show();
        }
        else{
            try {
                int inp = Integer.parseInt(etInput.getText().toString());

                tvInfo.setText(getResources().getString(R.string.ahead));
                if (inp > 100 || inp < 0)
                {
                    Toast.makeText(getApplicationContext(), "Требуется ввести число от 0 до 100!", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(!gameFinished){

                        if(inp > guess)
                            tvInfo.setText(R.string.ahead);
                        if(inp < guess)
                            tvInfo.setText(R.string.behind);
                        if(inp == guess) {
                            tvInfo.setText(R.string.hit);
                            bControl.setText(R.string.play_more);
                            gameFinished = true;
                        }
                    }
                    else
                    {
                        guess = (int) (Math.random()*100);
                        bControl.setText(R.string.input_value);
                        tvInfo.setText(R.string.try_to_guess);
                        gameFinished = false;
                    }
                    etInput.setText("");
                }

            }
            catch (NumberFormatException e)
            {
                if(!gameFinished)
                    Toast.makeText(getApplicationContext(), "Поле ввода принимает лишь числовой тип данных!", Toast.LENGTH_SHORT).show();
                else{
                    guess = (int) (Math.random()*100);
                    bControl.setText(R.string.input_value);
                    tvInfo.setText(R.string.try_to_guess);
                    gameFinished = false;
                }
            }
        }

    }


}