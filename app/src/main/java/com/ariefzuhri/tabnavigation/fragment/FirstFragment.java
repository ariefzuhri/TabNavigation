package com.ariefzuhri.tabnavigation.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ariefzuhri.tabnavigation.R;
import com.ariefzuhri.tabnavigation.adapter.ItemAdapter;
import com.ariefzuhri.tabnavigation.model.ItemData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FirstFragment extends Fragment {
    private final ArrayList<ItemData> itemDataList = new ArrayList<>();
    private ItemAdapter adapter;

    public FirstFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Buat data dummy
        for (int i = 1; i <= 10; i++){
            ItemData itemData = new ItemData();
            itemData.itemTitle = "Title Data - " + i;
            itemData.itemSubtitle = "Subtitle Data - " + i;
            itemDataList.add(itemData);
        }

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ItemAdapter(itemDataList);
        recyclerView.setAdapter(adapter);

        FloatingActionButton fabAdd = view.findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
            }
        });
    }

    private void addData(){
        ItemData itemData = new ItemData();
        itemData.itemTitle = "Title Data - Baru";
        itemData.itemSubtitle = "Subtitle Data - Baru";
        itemDataList.add(itemData);
        adapter.notifyDataSetChanged();
    }
}