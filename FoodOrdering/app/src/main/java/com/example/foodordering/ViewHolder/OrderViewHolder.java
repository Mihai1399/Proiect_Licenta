package com.example.foodordering.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering.Interface.ItemClickListener;
import com.example.foodordering.R;

import org.w3c.dom.Text;

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView textOrderId, textOrderStatus, textOrderPhone, textOrderAddress;

    private ItemClickListener itemClickListener;



    public OrderViewHolder(View itemView) {
        super(itemView);

        textOrderId = (TextView) itemView.findViewById(R.id.order_id);
        textOrderStatus = (TextView) itemView.findViewById(R.id.order_status);
        textOrderPhone = (TextView) itemView.findViewById(R.id.order_phone);
        textOrderAddress = (TextView) itemView.findViewById(R.id.order_address);



    }

    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener=itemClickListener;
    }

    @Override
    public void onClick(View view) {

    }
}
