package com.app.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.Models.DataModel;
import com.app.smartstreetlight.R;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class Recyclerview_Adapter extends RecyclerView.Adapter<Recyclerview_Adapter.ViewHolder>{
    List<DataModel> poles_list;
    private List<String> list = new ArrayList<>();



    public Recyclerview_Adapter(List<DataModel> poles_list) {
        this.poles_list = poles_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.each_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataModel model = poles_list.get(position);
        holder.mTextView.setText(model.getItemText());

        boolean isExpandable = model.isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

        if (isExpandable){
            holder.mArrowImage.setImageResource(R.drawable.arrow_up);
        }else{
            holder.mArrowImage.setImageResource(R.drawable.arrow_down);
        }

        NestedAdapter adapter = new NestedAdapter(list);
        holder.nestedRecyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        holder.nestedRecyclerView.setHasFixedSize(true);
        holder.nestedRecyclerView.setAdapter(adapter);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setExpandable(!model.isExpandable());
                list = model.getPoles();
                notifyItemChanged(holder.getAdapterPosition());
            }
        });


    }

    @Override
    public int getItemCount() {
        return poles_list.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
         LinearLayout linearLayout;
        RelativeLayout expandableLayout;
         TextView mTextView;
         ImageView mArrowImage;
         RecyclerView nestedRecyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linear_layout);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);
            mTextView = itemView.findViewById(R.id.itemTv);
            mArrowImage = itemView.findViewById(R.id.arro_imageview);
            nestedRecyclerView = itemView.findViewById(R.id.child_rv);

        }
    }
}
