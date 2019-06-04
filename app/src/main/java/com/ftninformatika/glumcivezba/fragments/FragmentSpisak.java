package com.ftninformatika.glumcivezba.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ftninformatika.glumcivezba.MainActivity;
import com.ftninformatika.glumcivezba.R;
import com.ftninformatika.glumcivezba.providers.GlumacProvider;

import java.util.List;

public class FragmentSpisak extends Fragment {

    public interface OnItemSelectedListener{
        void OnItemSelected(int position);
    }
    OnItemSelectedListener listener;

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "FragmentSpisak.onAttach()", Toast.LENGTH_SHORT).show();

        try {
            listener = (OnItemSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnItemSelectedListener");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "MasterFragment.onCreateView()", Toast.LENGTH_SHORT).show();

        if (container == null) {
            return null;
        }

        // Inflate fragment's layout
        return inflater.inflate(R.layout.fragment_spisak, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        Toast.makeText(getActivity(), "MasterFragment.onActivityCreated()", Toast.LENGTH_SHORT).show();

        final List<String> glumacNames = GlumacProvider.getGlumacNames();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getActivity(), R.layout.list_glumci, glumacNames);
        ListView listView = (ListView) getActivity().findViewById(R.id.list_of_glumci);

        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.OnItemSelected(position);
            }
        });

    }
}
