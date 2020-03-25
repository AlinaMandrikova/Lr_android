package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> list;

    public BookAdapter(List<Book> list, Context context) {
        this.list = list;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);
        BookViewHolder holder = new BookViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder bookViewHolder, int i) {
        bookViewHolder.image.setImageResource(list.get(i).getImage());
        bookViewHolder.author.setText(list.get(i).getAuthor());
        bookViewHolder.bookTitle.setText(list.get(i).getBookTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {

        //Обьявляем переменнные для картинки, автора и заголовка
        public ImageView image;
        public TextView author;
        public TextView bookTitle;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            //Поиск по id
            image = itemView.findViewById(R.id.imageView);
            author = itemView.findViewById(R.id.author);
            bookTitle = itemView.findViewById(R.id.book_title);
        }
    }
}