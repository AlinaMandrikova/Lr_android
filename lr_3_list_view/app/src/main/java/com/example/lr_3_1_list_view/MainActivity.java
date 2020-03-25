package com.example.lr_3_1_list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private List<Book> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = createList();
        ListView list = findViewById(R.id.main_list);

        // Создаем объект адаптера
        BookAdapter adapter = new BookAdapter(this, data);

        // Передаем его виджету списка
        list.setAdapter(adapter);

        list.setOnItemClickListener(this);
    }

    private List<Book> createList() {

        List<Book> list = new ArrayList<>();
        //заполняем
        Book book = new Book(R.drawable.image1,"Профессия: Ведьма", "Ольга Громыко","Роман, первая книга цикла «Ведьма» Ольги Громыко.\n" +
                "Представьте, что вы — правитель небольшого государства, в котором около двух тысяч жителей. На вас глядят, если не как на воплотившееся божество, то по крайней мере, как на последнюю надежду всего своего рода. Ваше слово для них закон в первой и последней инстанции. Представили?\n" +
                "Идиллию портит только некое чудо-юдо, которое никто не может поймать, и которое весьма неплохо колдует и питается как вашими подданными, так и заезжими колдунами. А какова же будет ваша реакция, когда на запрос о помощи квалифицированного мага, чародеи, словно в насмешку, присылают молодую и неопытную девчонку? Верно — просто расслабиться и получать удовольствие. Уж с ней-то вы точно не соскучитесь. ");

        Book book1 = new Book(R.drawable.image2,"Ведьма-хранительница","Ольга Громыко","Роман, вторая книга цикла «Ведьма» Ольги Громыко.\n"+
                "Кто сказал: \"Тяжело в учении, легко в бою\"? А подать его сюда, в бой! Школа Чародеев, Пифий и Травниц закончена, но проблемы молодой дипломированной ведьмы только начинаются. Захотелось ей, видите ли, приключений, легендарных подвигов и разгадок великих тайн! Что ж, хлебная должность королевского мага побоку, и пожалуйста - теперь Вольхе Редной будет о чем рассказать внукам... если, конечно, удастся любезно подкинутых судьбой испытаний...\n"
                );

        Book book2 = new Book(R.drawable.image3,"Верховная ведьма","Ольга Громыко","Роман, третья книга цикла «Ведьма» Ольги Громыко.\n"+
                "Что нужно для счастья Верховной Ведьме самой обычной долины, населенной самыми обычными вампирами? Любимая работа? Успешная карьера? Степень архимага? Или… Друзья бессильны дать верный ответ, зато враги живо помогут во всем разобраться! Итак, черная кобыла оседлана, волшебный меч заточен — и Вольха Редная снова отправляется портить настроение нежити, а заодно конкурентам, рыцарям и даже святым…\n"
                );

        Book book3 = new Book(R.drawable.image4_11,"Верные враги","Ольга Громыко","Это - сказка, рассказанная зимней ночью. Веселое и грустное повествование о вражде и дружбе, магии и смекалке, благородстве и предательстве, любви и ненависти, между которыми один шаг по глубокому снегу. Это - кусочек белорской истории, не попавший в летописи, но воспетый в легендах. А что в ней ложь и что правда - пусть останется на совести автора…");

        list.add(book);
        list.add(book1);
        list.add(book2);
        list.add(book3);
        return list;

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, BookActivity.class);
        intent.putExtra("book", data.get(position));
        //Переходм в другое активити
        startActivity(intent);
    }
}
