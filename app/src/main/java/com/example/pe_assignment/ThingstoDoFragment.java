package com.example.pe_assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ThingstoDoFragment extends Fragment {

    RecyclerView thingtodo;
    RecyclerView.Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.things_to_do_tab_fragment, container, false);

        thingtodo = root.findViewById(R.id.things_to_do);
        thingtodo();

        return root;
    }

    private void thingtodo() {

        thingtodo.setHasFixedSize(true);
        thingtodo.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

        ArrayList<ThingstoDoHelperClass> thingstoDos = new ArrayList<>();

        thingstoDos.add(new ThingstoDoHelperClass(R.drawable.thingstodo, "Hi, WEP User", "You have no pending tasks, thank you for your cooperation"));

        adapter = new ThingstoDoAdapter(thingstoDos);
        thingtodo.setAdapter(adapter);
    }
}
