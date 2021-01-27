package com.example.nhom2_android_project;

import android.view.LayoutInflater;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.nhom2_android_project.Pho;
import com.example.nhom2_android_project.databinding.ItemOderBinding;
import java.util.List;

public class PhoAdapter extends RecyclerView.Adapter<PhoAdapter.ViewHolder> {
    private List<Pho> data;
    private LayoutInflater mInflater;
    private SpinnerListener listener;

    public PhoAdapter(LayoutInflater mInflater) {
        this.mInflater = mInflater;
    }

    public void setListener(SpinnerListener listener) {
        this.listener = listener;
    }

    public List<Pho> getData() {
        return data;
    }

    public void setData(List<Pho> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemOderBinding binding = ItemOderBinding.inflate(mInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.binding.setItemPho(data.get(position));

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
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemOderBinding binding;

        public ViewHolder(@NonNull ItemOderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface SpinnerListener {
        void onSpinnerClicked(int position);

        void onSpinnerLongClicked(int position);
    }
}
