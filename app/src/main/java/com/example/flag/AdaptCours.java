package com.example.flag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptCours extends RecyclerView.Adapter<AdaptCours.ViewHolder>{
    private List<String> cours;
    private OnItemClickListener listener;
    public AdaptCours(List<String> cours) {
        this.cours = cours;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.exo_model,parent,false);
        return new ViewHolder(view);
    }

    public void setCours(List<String> cours) {
        this.cours = cours;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String cour =cours.get(position);
        holder.coursNom.setText(cour);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null){
                    listener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return cours.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView coursNom;
        public ViewHolder(View view){
            super(view );
            coursNom=view.findViewById(R.id.textViewchap1);
        }
    }
    public interface OnItemClickListener{
        void onItemClick(int Position);
    }
    public void setOnItemClickListener(OnItemClickListener  listener1){
        listener=listener1;
    }
}
