package com.univ_amu.food_scanner.ui;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.univ_amu.food_scanner.data.Quantity;
import com.univ_amu.food_scanner.databinding.QuantityItemBinding;




public class QuantityListAdapter extends ListAdapter<Quantity, QuantityListAdapter.ViewHolder> {

    QuantityListAdapter() {
        super(diffUtilCallback);
    }

    @Override
    public QuantityListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView textView = new TextView(parent.getContext());
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        QuantityItemBinding binding= QuantityItemBinding.inflate(layoutInflater,parent,false);
        return new QuantityListAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(QuantityListAdapter.ViewHolder holder, int position) {
        Quantity quantity = getItem(position);
        holder.bind(quantity);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        QuantityItemBinding binding;
        public Quantity quantity;
        public ViewHolder( QuantityItemBinding  binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.setViewHolder(this);

        }

        void bind(Quantity quantity) {
            this.quantity = quantity;
            this.binding.invalidateAll();
        }


    }
    private static final DiffUtil.ItemCallback<Quantity> diffUtilCallback =
            new DiffUtil.ItemCallback<Quantity>() {
                @Override
                public boolean areItemsTheSame(Quantity oldQuantity, Quantity newQuantity) {
                    return oldQuantity.name.equals(newQuantity.name);
                }
                @Override
                public boolean areContentsTheSame(Quantity oldQuantity, Quantity newQuantity) {
                    return this.areItemsTheSame(oldQuantity, newQuantity);
                }
            };

}