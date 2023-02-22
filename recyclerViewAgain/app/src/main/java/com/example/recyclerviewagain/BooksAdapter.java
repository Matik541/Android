package com.example.recyclerviewagain;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder> {
    /*
    add: extends RecyclerView.Adapter(*nazwa*.*object*ViewHolder)
    suggestions: implements methods
    suggestions: add new class (*object*ViewHolder)
    suggestions: make *object*ViewHolder extends ...Recycler.ViewHolder...

    add: inflater
    add: *object*List
    generate: constructor (without inflater)
    */

    private final LayoutInflater inflater;
    private final LinkedList<Book> booksList;

    public BooksAdapter(Context context, LinkedList<Book> booksList) {
        /*
        add: `Context context` to args (import)
        set: inflater to `LayoutInflater.from(context)`
        */
        this.inflater = LayoutInflater.from(context);
        this.booksList = booksList;
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*
        add: View itemView
        set: itemView to inflater.inflate(R.layout.*object*_layout, parent, false);
        return: new *object*ViewHolder(itemView, this)
         */
        Log.d("kys?", "onCreateViewHolder");
        View itemView = inflater.inflate(R.layout.book_layout, parent, false);
        return new BooksViewHolder(itemView, this);
    }

    public class BooksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        /*
        add: *nazwa*Adapter
        if needed:
            add: components form layout (textView here)

        add: implements View.OnClickListener
        suggestions: implement methods
        */

        public final BooksAdapter booksAdapter;
        public final TextView textView;

        public BooksViewHolder(@NonNull View itemView, BooksAdapter adapter) {
            /*
            add: *nazwa*Adapter adapter to agrs
            set: *nazwa*Adapter to adapter
            if needed:
                set: textView to itemView.findViewById(*textViewId*)
                add: itemView.setOnClickListener(this)
            */
            super(itemView);

            booksAdapter = adapter;
            textView = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // books removeinator
            int bookIndex = getLayoutPosition();
            Book book = booksList.get(bookIndex);

            Toast.makeText(inflater.getContext(), "Removed: " + book.toString(), Toast.LENGTH_SHORT).show();
            booksList.remove(book);
            notifyDataSetChanged();
        }


    }

    @Override
    public void onBindViewHolder(@NonNull BooksAdapter.BooksViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        /*
        setup data form list:
            holder.textView = list.get(position)
        make: position final
        suggestions: suppress RecyclerView...
        */
        holder.textView.setText(booksList.get(getItemViewType(position)).toString());
    }

    // add (optional): func(int position) { return position }
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        // ! change this fucking 0 to list.size();
        return booksList.size();
    }

}
