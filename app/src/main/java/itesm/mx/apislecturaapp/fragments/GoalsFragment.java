package itesm.mx.apislecturaapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import itesm.mx.apislecturaapp.R;
import itesm.mx.apislecturaapp.behavior.GoalsAdapter;

public class GoalsFragment extends Fragment implements GoalsAdapter.ItemClickListener {

    GoalsAdapter mGoalsAdapter;
    RecyclerView mGoalsRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View goals_view = inflater.inflate(R.layout.goals_view, container, false);
        super.onCreate(savedInstanceState);

        // TODO: Substituir estos datos dummy con metas de verdad.
        ArrayList<String> metasDummy = new ArrayList<>();
        metasDummy.add("Manual Guerrero");
        metasDummy.add("La sombra");
        metasDummy.add("El psicoanalista");

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
