package itesm.mx.apislecturaapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import itesm.mx.apislecturaapp.R;
import itesm.mx.apislecturaapp.model.Library;

public class NewBookFragment extends Fragment {

    Library mLibrary;
    private EditText TitleField;
    private EditText AuthorField;
    private EditText PagesField;
    private Button AddBookButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.new_book_fragment, container, false);
        super.onCreate(savedInstanceState);

        //mLibrary =

        TitleField = layout.findViewById(R.id.text_title);
        AuthorField = layout.findViewById(R.id.text_author);
        PagesField = layout.findViewById(R.id.number_pages);

        AddBookButton = layout.findViewById(R.id.btn_save);

        AddBookButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "wazabe",
                        Toast.LENGTH_SHORT).show();
                /*
                mLibrary.addBook(new Book(
                        "",
                        "",
                        4,
                        R.drawable.psicoanalista
                ));
                */
            }
        });
        return layout;
    }
}
