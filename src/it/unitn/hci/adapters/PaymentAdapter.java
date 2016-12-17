package it.unitn.hci.adapters;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import it.unitn.hci.R;
import it.unitn.hci.support.ListItem;
import it.unitn.hci.support.Payment;

/**
 * Created by Franco on 17/12/13.
 */
public class PaymentAdapter extends ArrayAdapter<Payment>{

    List<Payment> list;

    private final ForegroundColorSpan fcsRed = new ForegroundColorSpan(Color.RED);
    private final ForegroundColorSpan fcsGreen = new ForegroundColorSpan(Color.parseColor("#3FBF00"));

    public PaymentAdapter(Context context, int textViewResourceId, List<Payment> list){
        super(context, textViewResourceId, list);

        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.row_chat, null);

        TextView text = (TextView) convertView.findViewById(R.id.chat_text);
        TextView inserted = (TextView) convertView.findViewById(R.id.chat_time);
        ImageView img = (ImageView) convertView.findViewById(R.id.chat_image);

        Payment payment = getItem(position);

        text.setText(payment.getText());
        inserted.setText(payment.getInserted());

        if (payment.getType() == Payment.MINUS){
            img.setImageResource(R.drawable.minus);
        } else {
            img.setImageResource(R.drawable.plus);
        }

        return convertView;
    }

    public int getCount(){
        return list.size();
    }
}
