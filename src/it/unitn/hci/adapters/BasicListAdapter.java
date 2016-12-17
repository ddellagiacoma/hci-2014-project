package it.unitn.hci.adapters;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import it.unitn.hci.R;
import it.unitn.hci.support.ListItem;

/**
 * Created by Franco on 16/12/13.
 */
public class BasicListAdapter extends ArrayAdapter<ListItem> {

    List<ListItem> list;

    private final ForegroundColorSpan fcsRed = new ForegroundColorSpan(Color.RED);
    private final ForegroundColorSpan fcsGreen = new ForegroundColorSpan(Color.parseColor("#3FBF00"));

    public BasicListAdapter(Context context, int textViewResourceId, List<ListItem> list){
        super(context, textViewResourceId, list);

        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.row_double, null);

        TextView text = (TextView) convertView.findViewById(R.id.text_list_double);
        TextView inserted = (TextView) convertView.findViewById(R.id.desc_list_double);

        ListItem avv = getItem(position);

        SpannableStringBuilder sbText = new SpannableStringBuilder(avv.getText());
        SpannableStringBuilder sbInserted = new SpannableStringBuilder(avv.getInserted());

        //add color to the text
        if (avv.getText().startsWith("+")){
            sbText.setSpan(fcsGreen, 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        } else if (avv.getText().startsWith("-")){
            sbText.setSpan(fcsRed, 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        }

        text.setText(sbText);
        inserted.setText(sbInserted);

        return convertView;
    }

    public int getCount(){
        return list.size();
    }
}
