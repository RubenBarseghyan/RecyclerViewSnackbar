package com.example.ruben.recyclerview;

import android.support.annotation.NonNull;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;



public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder>{
    private List<String> data;

    public  SimpleAdapter(List<String> data){
        this.data = data;
    }

    @NonNull
    @Override
    public SimpleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.recycle_view_item, viewGroup, false);
        return  new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final SimpleAdapter.ViewHolder viewHolder, int position) {
        final int pos = viewHolder.getAdapterPosition();

        viewHolder.name.setText(data.get(viewHolder.getAdapterPosition()));
        viewHolder.deleteBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(viewHolder.getAdapterPosition()!=RecyclerView.NO_POSITION){

                   final int k = viewHolder.getAdapterPosition();
                   final String p = data.get(k);
                     data.remove(viewHolder.getAdapterPosition());
                    notifyItemRemoved(viewHolder.getAdapterPosition());
                     Snackbar snackbar = Snackbar.make(v, "Delete", Snackbar.LENGTH_INDEFINITE);
                     snackbar.show();
                    snackbar.setAction("Undo", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            data.add(k, p);
                            notifyDataSetChanged();


                        }
                    });
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public Button deleteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameTextView);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);

        }
    }

}
