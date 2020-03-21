package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //создаем переменную для кнопкоп
    private Button story;
    private Button producer;

    public static int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Находим по id
        story = findViewById(R.id.button_story);
        producer = findViewById(R.id.button_producer);

        //обработка клика
        story.setOnClickListener(this);
        producer.setOnClickListener(this);

        Button button = findViewById(R.id.button_add);
        //обработка клика
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button_story :
                //Создаем намерение
                Intent intent = new Intent(this, StoryActivity.class);
                //Переходм в другое активити
                startActivity(intent);
                break;

            case R.id.button_producer :
                //Создаем намерение
                Intent intent2 = new Intent(this, ProducerActivity.class);
                //Переходм в другое активити
                startActivity(intent2);
                break;
            case R.id.button_add :
                //Переходим в другое активити с ожиданием на результат
                Intent intent3 = new Intent(this, NameActivity.class);
                startActivityForResult(intent3, REQUEST_CODE);
                break;

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Пользователь вышел из Activity", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_OK) {

                //есди данне не пустые
                if (data != null) {
                    String text = data.getStringExtra("result");
                    if (text != null) {
                        //вставляем в поле с id textView5
                        TextView tv = findViewById(R.id.textView5);
                        tv.setText(text);
                    }
                }
            }
        }
    }
}
