package com.example.vuducvuong_2017604374_test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vuducvuong_2017604374_test.databinding.ItemSpinnerBinding;

import java.util.List;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.SpinnerHolder> {
    private List<SinhVien> data;
    private LayoutInflater mInflater;
    private SpinnerListener listener;

    public SinhVienAdapter(LayoutInflater mInflater) {
        this.mInflater = mInflater;
    }

    public void setListener(SpinnerListener listener) {
        this.listener = listener;
    }

    public List<SinhVien> getData() {
        return data;
    }

    public void setData(List<SinhVien> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SpinnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSpinnerBinding binding = ItemSpinnerBinding.inflate(mInflater, parent, false);
        return new SpinnerHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SpinnerHolder holder, final int position) {
        holder.binding.setItemSinhVien(data.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSpinnerClicked(position);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onSpinnerLongClicked(position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class SpinnerHolder extends RecyclerView.ViewHolder {
        private ItemSpinnerBinding binding;

        public SpinnerHolder(@NonNull ItemSpinnerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface SpinnerListener {
        void onSpinnerClicked(int position);

        void onSpinnerLongClicked(int position);
    }
}
