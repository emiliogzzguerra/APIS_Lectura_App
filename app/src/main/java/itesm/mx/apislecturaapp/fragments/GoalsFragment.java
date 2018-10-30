package itesm.mx.apislecturaapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.time.LocalDate;
import java.util.ArrayList;

import itesm.mx.apislecturaapp.Database.LibraryOperations;
import itesm.mx.apislecturaapp.R;
import itesm.mx.apislecturaapp.behavior.GoalsAdapter;
import itesm.mx.apislecturaapp.model.Goal;

public class GoalsFragment extends Fragment implements GoalsAdapter.ItemClickListener {

    private LibraryOperations dao;
    GoalsAdapter mGoalsAdapter;
    RecyclerView mGoalsRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View goals_view = inflater.inflate(R.layout.goals_view, container, false);
        super.onCreate(savedInstanceState);

        dao = new LibraryOperations(getContext());
        dao.open();

        // TODO: Substituir estos datos dummy con metas de verdad.
        ArrayList<Goal> metasDummy = new ArrayList<>();
        metasDummy.add(new Goal(LocalDate.now().plusMonths(2), dao.findBook(1)));

        dao.close();
        metasDummy.get(0).decreaseRemainingPages(89);
        // Setup de la lista de metas RecyclerView.
        mGoalsRecyclerView = goals_view.findViewById(R.id.goals_list);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mGoalsRecyclerView.setLayoutManager(mLayoutManager);
        mGoalsAdapter = new GoalsAdapter(getActivity(), metasDummy);
        mGoalsAdapter.setClickListener(this);
        mGoalsRecyclerView.setAdapter(mGoalsAdapter);

        return goals_view;
    }

    @Override
    public void onItemClick(View view, int position) {
        // TODO: Go to goal details view when item clicked
//        Toast.makeText(this, "Meta: " + mGoalsAdapter.getItem(position) + " on row " + position, Toast.LENGTH_SHORT).show();
    }
}
