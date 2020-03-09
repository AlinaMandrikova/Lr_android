package com.example.my_application_lr1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Обьявим переменные для подсчета результата
    EditText text1 = null;
    EditText text2 = null;
    //Обьявим переменную для вывода результата
    TextView text_result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //находим текст по id и присваем, то, что нашли к этим переменным
        text1 = findViewById(R.id.editText1);
        text2 = findViewById(R.id.editText2);
        text_result = findViewById(R.id.textView2);

        //Применияя 2й способ, устанавливаем слушатель для 2х кнопок "/" и "*"
        Button button_division = findViewById(R.id.button_division);
        Button button_multiplication = findViewById(R.id.button_multiplication);

        button_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Присвоим значения, которые были введены в поля editText1 и 2 переменным var1 и 2
                double var1 = Double.parseDouble(text1.getText().toString());
                double var2 = Double.parseDouble(text2.getText().toString());

                //Проверка деления на 0
                if (var2 != 0){
                    //Выполняем расчет
                    double result = var1 / var2;
                    //Результат
                    text_result.setText(String.valueOf(result));
                }
                if (var2 == 0){
                    String message = "Ошибка. Деление на 0 запрещено";
                    //Результат
                    text_result.setText(String.valueOf(message));
                }

            }
        });
        button_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Присвоим значения, которые были введены в поля editText1 и 2 переменным var1 и 2
                double var1 = Double.parseDouble(text1.getText().toString());
                double var2 = Double.parseDouble(text2.getText().toString());

                //Выполняем расчет
                double result = var1 * var2;
                //Результат
                text_result.setText(String.valueOf(result));
            }
        });

    }

    //Применияя 1й способ, устанавливаем слушатель для 2х кнопок "+" и "-"
    public void handleClick(View view) {

        //Примвоим значения, которые были введены в поля editText1 и 2 переменным var1 и 2
        double var1 = Double.parseDouble(text1.getText().toString());
        double var2 = Double.parseDouble(text2.getText().toString());

        //Если нажата кнопка с заданным id, то выполняется заданное действие
        if (view.getId()==R.id.button_minus){
            //Выполняем расчет
            double result = var1 - var2;
            //Результат
            text_result.setText(String.valueOf(result));
        }

        //Если нажата кнопка с заданным id, то выполняется заданное действие
        if (view.getId()==R.id.button_plus){
            //Выполняем расчет
            double result = var1 + var2;
            //Результат
            text_result.setText(String.valueOf(result));
        }

    }
}
