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

import java.util.ArrayList;
import java.util.Map;

import androidx.navigation.Navigation;
import itesm.mx.apislecturaapp.Database.LibraryOperations;
import itesm.mx.apislecturaapp.R;
import itesm.mx.apislecturaapp.behavior.BookCoverAdapter;
import itesm.mx.apislecturaapp.model.Book;

public class BooksIndexFragment extends Fragment {

    public LibraryOperations dao;
    private Map<Integer, String> mPositionToBookId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.books_index_fragment, container, false);
        super.onCreate(savedInstanceState);

        dao = new LibraryOperations(getContext());
        dao.open();

        ArrayList<Book> arrayList = dao.getAllBooks();

        GridView gridview = (GridView) layout.findViewById(R.id.books_index_gridview);
        gridview.setAdapter(new BookCoverAdapter(getActivity()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                BooksIndexFragmentDirections.ActionBooksIndexFragmentToBookDetailsFragment action =
                        BooksIndexFragmentDirections.actionBooksIndexFragmentToBookDetailsFragment();
                action.setBookid(position);
                Toast.makeText(getActivity(), "" + position,
                        Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(action);
                dao.close();
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
