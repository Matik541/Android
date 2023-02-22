package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ProductsViewHolder>
    // 1 suggestion: "generate class ProductsViewHolder"
    // 3 suggestion: "implement methods"
{
    private final LayoutInflater inflater; // add inflater
    private final LinkedList<Product> products;
//    private ProductsViewHolder holder;

    // constructor, without inflater
    public ShoppingAdapter(Context context, LinkedList<Product> products) {
        inflater = LayoutInflater.from(context);
        this.products = products;
    }

    public static class ProductsViewHolder extends RecyclerView.ViewHolder {
        // 2 suggestion: "generate constructor matching super"
        public final CheckBox productItemView;
        public final ShoppingAdapter shoppingAdapter;

        public ProductsViewHolder(@NonNull View itemView, ShoppingAdapter adapter) {
            super(itemView);

            productItemView = itemView.findViewById(R.id.itemCheckBox);
            shoppingAdapter = adapter;
        }
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.product_item, parent, false);
        return new ProductsViewHolder(itemView, this); // new ProductHolder
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.productItemView.setText(products.get(position).getName());
        holder.productItemView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                products.get(getItemViewType(position)).setChecked(isChecked);

                if(isChecked)
                    compoundButton.setPaintFlags(compoundButton.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                else
                    compoundButton.setPaintFlags(compoundButton.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public int getItemViewType(int position) {
        return position;
    }

    public void selectedItemsRemove() {
        products.removeIf(Product::isChecked);
        notifyDataSetChanged();
    }
}




















