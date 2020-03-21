package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StoryActivity  extends AppCompatActivity implements View.OnClickListener {

    //создаем переменную для кнопки
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //Находим по id
        back = findViewById(R.id.button_back);

        //обработка клика
        back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_back:
                //Создаем намерение
                Intent intent = new Intent(this, MainActivity.class);
                //Переходм в другое активити
                startActivity(intent);
                break;
        }

    }
}
