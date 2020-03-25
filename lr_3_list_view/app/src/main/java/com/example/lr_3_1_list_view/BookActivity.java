package com.example.lr_3_1_list_view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookActivity extends AppCompatActivity implements View.OnClickListener {

    //Создаем переменные для поиска по ид
    private ImageView image;
    private TextView title;
    private TextView author;
    private TextView text;
    //Переменная для книпки
    private Button back;
    //Переменная для книги, на которую кликнули
    private Book book;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_layout);

        //Находим по ид
        image = findViewById(R.id.imageView2);
        title = findViewById(R.id.title_book);
        author = findViewById(R.id.author);
        text = findViewById(R.id.text2);

        back = findViewById(R.id.button_back);
        //обработка клика
        back.setOnClickListener(this);
        //Передаем сюда книгу с предыдущего окна при клике
        book = (Book) getIntent().getSerializableExtra("book");

        //вставляем картинку
        image.setImageResource(book.getImage());

        title.setText(book.getBookTitle());
        author.setText(book.getAuthor());
        text.setText(book.getTxt());

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        //Переходм в другое активити
        startActivity(intent);
    }
}