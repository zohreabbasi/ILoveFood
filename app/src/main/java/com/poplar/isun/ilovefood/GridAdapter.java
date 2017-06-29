package com.poplar.isun.ilovefood;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by isun on 6/29/2017.
 */

public class GridAdapter extends BaseAdapter {

    Context context;
    Integer[] img_item;
    String[] text_item;



    public GridAdapter(Context context,Integer[] img_item,String[] text_item){

        this.context =context;
        this.img_item = img_item;
        this.text_item = text_item;

    }


    @Override
    public int getCount() {
        return text_item.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Holder holder;
        if(convertView == null){
            holder = new Holder();

            convertView = inflater.inflate(R.layout.category_item_grid,null);
            holder.imageView = (ImageView) convertView.findViewById(R.id.img_grid_item);
            holder.textView = (TextView) convertView.findViewById(R.id.txt_grid_item);
            convertView.setTag(holder);

        }
        else{
            holder = (Holder) convertView.getTag();
        }

        holder.imageView.setImageResource(img_item[position]);
        holder.textView.setText(text_item[position]);
        return convertView;
    }

    private class Holder{
        TextView textView;
        ImageView imageView;
    }
}
