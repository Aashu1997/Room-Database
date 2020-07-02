package com.ashu.roomdatabase.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ashu.roomdatabase.Model.Record;
import com.ashu.roomdatabase.R;

import java.util.ArrayList;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder>
{
    Context context;
    ArrayList<Record> arrayList;

    public RecordAdapter(Context context, ArrayList<Record> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_layout,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Record record = arrayList.get(i);

        viewHolder.id.setText("ID"+record.getId());
        viewHolder.name.setText(record.getUser_name());
        viewHolder.email.setText(record.getUser_email());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView id,name,email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id=itemView.findViewById(R.id.textView);
            name=itemView.findViewById(R.id.textView2);
            email=itemView.findViewById(R.id.textView3);
        }
    }
}
