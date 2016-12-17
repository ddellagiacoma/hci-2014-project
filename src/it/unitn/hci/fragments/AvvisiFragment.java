package it.unitn.hci.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import it.unitn.hci.R;
import it.unitn.hci.adapters.BasicListAdapter;
import it.unitn.hci.support.ListItem;

/**
 * Created by Franco on 15/12/13.
 */
public class AvvisiFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list_not_clickable, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.list_not_clickable);

        List<ListItem> list = new ArrayList<ListItem>();
        list.add(new ListItem("Il ritrovo che era stato fissato per giovedi alle 10.30 è stato spostato alle 14, stessa aula!",
                "17.12.13 at 02:16:09"));
        list.add(new ListItem("E' stato fissato un icontro per giovedi alle 10.30. Ci si trova in aula studio :)",
                "16.11.13 at 01:34:19"));
        list.add(new ListItem("Mettete le preferenze per il prossimo incontro sul calendario grazie! :)",
                "14.11.13 at 08:17:09"));
        list.add(new ListItem("Benvenuti a questo gruppo. Sono sicuro che faremo un ottimo lavoro insieme :D",
                "23.09.13 at 07:56:35"));

        ArrayAdapter<ListItem> adapter = new BasicListAdapter(getActivity(), R.layout.row_double, list);
        listView.setAdapter(adapter);

        return rootView;
    }
}
