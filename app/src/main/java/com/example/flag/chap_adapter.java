package com.example.flag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class chap_adapter  extends RecyclerView.Adapter<chap_adapter.chap_ViewHolder> {
    private List<chap_model> chap_list=new ArrayList<>();
    private OnItemClickListener listener;

    public chap_adapter(List<chap_model> chap_list){
        this.chap_list=chap_list;
    }
    public void miseajour(List<chap_model> model){
        /*this.chap_list.clear();
        this.chap_list.addAll(model);
        notifyDataSetChanged();*/
        for(chap_model item :model){
            this.chap_list.add(item);
            notifyItemInserted(chap_list.size()-1);
        }
    }
    public void setChap_list(List<chap_model> chap_list){this.chap_list=chap_list;}

    @NonNull
    @Override
    public chap_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.chap_model,parent,false);
        return new chap_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull chap_ViewHolder holder, int position) {
        chap_model item=chap_list.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return chap_list.size();
    }
    public static class chap_ViewHolder extends RecyclerView.ViewHolder{
        public TextView chap;
        public TextView titre;
        public TextView resume;

        public chap_ViewHolder(@NonNull View itemView){
            super(itemView);
            chap=itemView.findViewById(R.id.chap);
            titre=itemView.findViewById(R.id.titre);
            resume=itemView.findViewById(R.id.resume);
        }
        public void bind(chap_model model){
            chap.setText(model.getChapName());
            titre.setText(model.getChapTitle());
            resume.setText(model.getChapResume());
        }
    }
    public interface OnItemClickListener{
        void onItemClick(int Position);
    }
    public void setOnItemClickListener(chap_adapter.OnItemClickListener listener1){
        listener=listener1;
    }
}
