package com.example.seekbar_adder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class SeekAdapter extends RecyclerView.Adapter<SeekAdapter.SeekViewHolder> {
    public ArrayList<SeekbarItem> seekList;

   public static class SeekViewHolder extends RecyclerView.ViewHolder{
       TextView max,min;
       SeekBar seekBar;
       ProgressBar pb;

       public SeekViewHolder(View itemView){
           super(itemView);
           min=itemView.findViewById(R.id.min_Value);
           max=itemView.findViewById((R.id.max_Value));
           seekBar=itemView.findViewById(R.id.seekbar);
           pb=itemView.findViewById(R.id.progressBar2);

       }
   }

   public SeekAdapter(ArrayList <SeekbarItem> seeklist){
    seekList=seeklist;
   }
    @NonNull
    @Override
    public SeekViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.seekbar_item,parent,false);
        SeekViewHolder svh=new SeekViewHolder(v);
        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull SeekViewHolder holder, int position) {
       SeekbarItem seekbarItem=new SeekbarItem(holder.min, holder.seekBar, holder.max);
    SeekbarItem si=seekList.get(position);
    holder.max.setText((CharSequence) si.getMax());
        holder.min.setText((CharSequence) si.getMin());
        holder.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                holder.pb.setProgress(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            seekList.add(seekbarItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return seekList.size();
    }
}
