package it.unitn.hci.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import it.unitn.hci.R;
import it.unitn.hci.support.ListItem;
import it.unitn.hci.support.Message;

/**
 * Created by Franco on 16/12/13.
 */
public class ChatAdapter extends ArrayAdapter<Message> {

    List<Message> list;

    public ChatAdapter(Context context, int textViewResourceId, List<Message> list){
        super(context, textViewResourceId, list);

        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.row_chat, null);

        TextView text = (TextView) convertView.findViewById(R.id.chat_text);
        TextView time = (TextView) convertView.findViewById(R.id.chat_time);
        ImageView img = (ImageView) convertView.findViewById(R.id.chat_image);

        Message mess = this.getItem(position);
        text.setText(mess.getText());
        time.setText(mess.getTime());
        img.setImageResource(mess.getId_image());

        return convertView;
    }

    public int getCount(){
        return list.size();
    }

}
