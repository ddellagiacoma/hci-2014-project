package it.unitn.hci.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import it.unitn.hci.R;
import it.unitn.hci.adapters.ChatAdapter;
import it.unitn.hci.support.Message;

/**
 * Created by Franco on 15/12/13.
 */
public class ChatFragment extends Fragment {

    private ArrayAdapter<Message> adapter;
    private EditText edit;
    private Button send;
    private ListView listView;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy 'at' hh:mm:ss");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.chat, container, false);

        listView = (ListView) rootView.findViewById(R.id.chat_list);

        List<Message> list = new ArrayList<Message>();
        list.add(new Message(R.drawable.user, "Ci troviamo questo pomeriggio allora?:)", "(Mattia) 17.12.13 at 02:16:09"));
        list.add(new Message(R.drawable.user, "Per me va bene, a che ora?", "(Paolo) 17.12.13 at 03:17:19"));
        list.add(new Message(R.drawable.user, "Ok, in che aula?", "(Mattia) 17.12.13 at 03:17:37"));
        list.add(new Message(R.drawable.user, "Studio direi", "(Paolo) 17.12.13 at 04:19:15"));
        list.add(new Message(R.drawable.user, "Ok ci sono anche io, a dopo! :D", "(Giulio) 17.12.13 at 04:21:07"));

        adapter = new ChatAdapter(getActivity(), R.layout.row_chat, list);
        listView.setAdapter(adapter);

        send = (Button) rootView.findViewById(R.id.chat_send);
        edit = (EditText) rootView.findViewById(R.id.chat_edit_text);

        //editText listener. Disable button if 0-length string is in edit-text
        edit.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                //nothing to do
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int charCount = charSequence.length();

                if (charCount > 0){
                    send.setEnabled(true);
                } else {
                    send.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //nothing to do
            }
        });

        //button click listener. Add message to the adapter
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = formatter.format(new Date(Calendar.getInstance().getTimeInMillis()));

                Message toAdd = new Message(R.drawable.user, edit.getText().toString(), "(Tuo nome) " + time);
                adapter.add(toAdd);

                edit.setText("");
                adapter.notifyDataSetChanged();

                //retract soft keyboard
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

                //scroll down list
                listView.setSelection(adapter.getCount() - 1);
            }
        });

        return rootView;
    }

}
