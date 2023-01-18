package com.example.myrecylerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SingerAdapter extends RecyclerView.Adapter<SingerAdapter.ViewHolder> {
    Context context;


    //각각의 Item을 보관
    ArrayList<SingerItem> items = new ArrayList<SingerItem>();

    OnItemClickListener listener;
    public static interface OnItemClickListener{
        //메서드 생성
        public void onItemClick(ViewHolder holder, View view, int position);
    }

    //생성자
    public SingerAdapter(Context context){
        this.context = context;
    }

    //Generate -> Implement Methods
    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.singer_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SingerItem item = items.get(position);
        holder.setItem(item);

        holder.setOnItemClickListener(listener);
    }

    //Item 추가
    public void addItem(SingerItem item){
        items.add(item);
    }

    //한번에 Item 추가 설정
    public void addItems(ArrayList<SingerItem> items){
        this.items = items;
    }

    public SingerItem getItem(int position){
        return items.get(position);
    }


    //event 처리
    public void setOnItemClickListener(OnItemClickListener listner){
        this.listener = listner;
    }

    //ViewHolder 클래스 정의
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView2;
        OnItemClickListener listener;

        //Generate -> Constructor
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView =(TextView) itemView.findViewById(R.id.textView);
            textView2 =(TextView) itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if(listener != null){
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }

        public void setItem(SingerItem item){
            textView.setText(item.getName());
            textView2.setText(item.getMobile());
        }

        //event 처리
        public void setOnItemClickListener(OnItemClickListener listner){
            this.listener = listner;
        }
    }
}
