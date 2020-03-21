package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NameActivity extends AppCompatActivity implements View.OnClickListener {

    private  EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_name);

        //поиск по id
        et = findViewById(R.id.editText);

        Button button = findViewById(R.id.button_add);
        //обработка клика
        button.setOnClickListener(this);



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        setResult(RESULT_CANCELED);
    }

    @Override
    public void onClick(View v) {
        // Считываем значение поля
        String text = et.getText().toString();

        // Формируем "пустое" намерение
        Intent intent = new Intent();
        // Добавляем в намерение данные
        intent.putExtra("result",text);

        // Устанавливаем результат
        setResult(RESULT_OK,intent);

        // Закрываем Activity
        finish();
    }
}
