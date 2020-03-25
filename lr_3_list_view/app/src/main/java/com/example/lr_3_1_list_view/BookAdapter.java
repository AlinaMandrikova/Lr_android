package com.example.lr_3_1_list_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends BaseAdapter {

    private List<Book> data;
    private LayoutInflater inflater;

    //создаем конструкотор
    public BookAdapter(Context context, List<Book> data) {
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_item, parent, false);

        // Получаем доступ к виджетам дерева объектов
        TextView author = convertView.findViewById(R.id.author);
        TextView book_title = convertView.findViewById(R.id.book_title);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        // Меняем содержимое виджетов
        author.setText(data.get(position).getAuthor());
        book_title.setText(data.get(position).getBookTitle());
        imageView.setImageResource(data.get(position).getImage());

        // Возвращаем модифицированное дерево объектов
        return convertView;
    }
}