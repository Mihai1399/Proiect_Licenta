package com.example.foodorderingserver.MenuViewHolder;

import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingserver.Interface.ItemClickListener;
import com.example.foodorderingserver.R;

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener{
    public TextView textOrderId, textOrderStatus, textOrderPhone, textOrderAddress;

    private ItemClickListener itemClickListener;



    public OrderViewHolder(View itemView) {
        super(itemView);

        textOrderId = (TextView) itemView.findViewById(R.id.order_id);
        textOrderStatus = (TextView) itemView.findViewById(R.id.order_status);
        textOrderPhone = (TextView) itemView.findViewById(R.id.order_phone);
        textOrderAddress = (TextView) itemView.findViewById(R.id.order_address);

        itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(this);


    }

    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener=itemClickListener;
    }

    @Override
    public void onClick(View view) {

        itemClickListener.onClick(view,getAdapterPosition(),false);
    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {

        contextMenu.setHeaderTitle("Select the action");

        contextMenu.add(0,0,getAdapterPosition(),"Update");
        contextMenu.add(0,1,getAdapterPosition(),"Delete");

    }
}
