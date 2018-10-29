package itesm.mx.apislecturaapp.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import androidx.navigation.Navigation;
import itesm.mx.apislecturaapp.R;
import itesm.mx.apislecturaapp.behavior.BookCoverAdapter;
import itesm.mx.apislecturaapp.model.Library;

public class BooksIndexFragment extends Fragment {

    Library mLibrary;
    private Map<Integer, String> mPositionToBookId;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.books_index_fragment, container, false);
        super.onCreate(savedInstanceState);
        mLibrary = new Library();
        mPositionToBookId = new HashMap<>();
        mPositionToBookId.put(0, "guerrero");
        mPositionToBookId.put(1, "monje");
        mPositionToBookId.put(2, "psicoanalista");
        mPositionToBookId.put(3, "sombra");

        GridView gridview = (GridView) layout.findViewById(R.id.books_index_gridview);
        gridview.setAdapter(new BookCoverAdapter(getActivity()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                BooksIndexFragmentDirections.ActionBooksIndexFragmentToBookDetailsFragment action =
                        BooksIndexFragmentDirections.actionBooksIndexFragmentToBookDetailsFragment();
                action.setBookid(mPositionToBookId.get(position));
                Toast.makeText(getActivity(), "" + mPositionToBookId.get(position),
                        Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(action);
            }
        });

        FloatingActionButton myFab = (FloatingActionButton) layout.findViewById(R.id.fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BooksIndexFragmentDirections.ActionBooksIndexFragmentToNewBookFragment action =
                        BooksIndexFragmentDirections.actionBooksIndexFragmentToNewBookFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });

        return layout;
    }
}
