package com.example.myapplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ProducerActivity  extends AppCompatActivity implements View.OnClickListener  {

    //создаем переменную для кнопки
    private Button back;
    private Button price_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        //Находим по id
        back = findViewById(R.id.button_back);
        price_list = findViewById(R.id.button_list);

        //обработка клика
        back.setOnClickListener(this);
        price_list.setOnClickListener(this);

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
            case R.id.button_list:
                Intent intent2 = new Intent(Intent.ACTION_SEND);
                //открываем ссылку
                intent2.setAction(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("https://ru.wikipedia.org/wiki/%D0%A1%D0%BF%D0%B8%D1%81%D0%BE%D0%BA_%D1%81%D0%B0%D0%BC%D1%8B%D1%85_%D0%BA%D0%B0%D1%81%D1%81%D0%BE%D0%B2%D1%8B%D1%85_%D0%B0%D0%BD%D0%B8%D0%BC%D0%B5-%D1%84%D0%B8%D0%BB%D1%8C%D0%BC%D0%BE%D0%B2"));

                PackageManager manager = this.getPackageManager();
                // Получаем список обработчиков намерения
                List<ResolveInfo> list = manager.queryIntentActivities(intent2, 0);

                if (list.size() > 0) {
                    startActivity(intent2);
                } else {
                    Toast.makeText(this, "Невозможно обработать намерение!", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
