package com.example.foodorderingserver.MenuViewHolder;

import android.content.ClipData;
import android.media.Image;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingserver.Common.Common;
import com.example.foodorderingserver.Interface.ItemClickListener;
import com.example.foodorderingserver.R;

public class MenuViewHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener,
        View.OnCreateContextMenuListener
{

        public TextView textMenuName;
        public ImageView imageView;

        private ItemClickListener itemClickListener;

        public MenuViewHolder(View itemView)
        {
            super(itemView);

            textMenuName = (TextView) itemView.findViewById(R.id.menu_name);
            imageView = (ImageView) itemView.findViewById(R.id.menu_image);

            itemView.setOnCreateContextMenuListener(this);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener=itemClickListener;
        }

        public void onClick(View view)
        {
            itemClickListener.onClick(view, getAdapterPosition(),false);
        }


    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.setHeaderTitle("Select the action!");
        contextMenu.add(0,0,getAdapterPosition(), Common.UPDATE);
        contextMenu.add(0,1,getAdapterPosition(), Common.DELTE);
    }
}
