package com.github.jaydeepw.recyclerview.type1;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class CardsListFragment extends Fragment {

    private SuperRecyclerView mRecyclerView;
    private StringAdapter mAdapter;

    public CardsListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<String> list = new ArrayList<>();
        list.add("Card1");
        list.add("Card2");
        list.add("Card3");
        list.add("Card4");
        list.add("Card5");
        list.add("Card6");
        list.add("Card7");
        list.add("Card8");
        list.add("Card9");
        list.add("Card10");
        list.add("Card11");
        list.add("Card12");
        mAdapter = new StringAdapter(list);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (SuperRecyclerView) view.findViewById(R.id.scanned_cards_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // TODO: make API call here.
            }
        });
    }
}
