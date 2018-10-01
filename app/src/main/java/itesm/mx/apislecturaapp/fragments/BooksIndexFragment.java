package itesm.mx.apislecturaapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import itesm.mx.apislecturaapp.R;
import itesm.mx.apislecturaapp.behavior.BookCoverAdapter;
import itesm.mx.apislecturaapp.behavior.MainActivity;

public class BooksIndexFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        GridView gridview = getView().findViewById(R.id.books_index_gridview);
        gridview.setAdapter(new BookCoverAdapter(getActivity()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(), "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.books_index_fragment, container, false);
    }
}
