package itesm.mx.apislecturaapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import itesm.mx.apislecturaapp.Database.LibraryOperations;
import itesm.mx.apislecturaapp.R;
import itesm.mx.apislecturaapp.model.Book;

public class NewBookFragment extends Fragment {

    private EditText TitleField;
    private EditText AuthorField;
    private EditText PagesField;
    private Button AddBookButton;

    public LibraryOperations dao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.new_book_fragment, container, false);
        super.onCreate(savedInstanceState);

        dao = new LibraryOperations(getContext());

        TitleField = layout.findViewById(R.id.text_title);
        AuthorField = layout.findViewById(R.id.text_author);
        PagesField = layout.findViewById(R.id.number_pages);

        AddBookButton = layout.findViewById(R.id.btn_save);

        AddBookButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dao.open();

                long res = dao.addBook(new Book(
                        0,
                        TitleField.getText().toString(),
                        AuthorField.getText().toString(),
                        Integer.valueOf(PagesField.getText().toString()),
                        R.drawable.newbook
                ));

                System.out.println("Adding book result = " + res);


                dao.close();
            }
        });
        return layout;
    }
}
