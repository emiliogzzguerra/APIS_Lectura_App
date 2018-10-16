package itesm.mx.apislecturaapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import itesm.mx.apislecturaapp.Book;
import itesm.mx.apislecturaapp.Library;
import itesm.mx.apislecturaapp.R;
import itesm.mx.apislecturaapp.behavior.BookCoverAdapter;

public class BookDetailsFragment extends Fragment {
    private Library mLibrary;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.book_details_fragment, container, false);
        super.onCreate(savedInstanceState);
        mLibrary = new Library();

        ImageView imageView = (ImageView) layout.findViewById(R.id.book_cover_img);
        TextView titleTextView = (TextView) layout.findViewById(R.id.book_title);
        TextView authorTextView = (TextView) layout.findViewById(R.id.book_author);
        TextView numPagesTextView = (TextView) layout.findViewById(R.id.book_pagenum);

        BookDetailsFragmentArgs args = BookDetailsFragmentArgs.fromBundle(getArguments());
        String bookid = args.getBookid();
        Book book = mLibrary.getBook(bookid);
        imageView.setImageResource(book.getCoverThumbId());
        imageView.setImageDrawable((getResources().getDrawable(book.getCoverThumbId())));
        titleTextView.setText(book.getTitle());
        authorTextView.setText(book.getAuthor());
        numPagesTextView.setText("" + book.getNumPages());

//        gridview.setAdapter(new BookCoverAdapter(getActivity()));
//
//        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v,
//                                    int position, long id) {
//                Toast.makeText(getActivity(), "" + position,
//                        Toast.LENGTH_SHORT).show();
//            }
//        });

        return layout;
    }
}
