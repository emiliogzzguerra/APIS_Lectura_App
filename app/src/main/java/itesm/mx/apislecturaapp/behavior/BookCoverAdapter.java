package itesm.mx.apislecturaapp.behavior;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import itesm.mx.apislecturaapp.Database.LibraryOperations;
import itesm.mx.apislecturaapp.model.Book;

public class BookCoverAdapter extends BaseAdapter {
    private Context mContext;

    public ArrayList<Book> bookList;

    public LibraryOperations dao;

    public BookCoverAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        dao = new LibraryOperations(mContext);
        dao.open();

        bookList = dao.getAllBooks();

        dao.close();
        return bookList.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(445, 585));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 28, 8, 28);
        } else {
            imageView = (ImageView) convertView;
        }

        ArrayList<Integer> mThumbIds = new ArrayList<Integer>();

        for(int i = 0; i<bookList.size(); i++){
            mThumbIds.add(bookList.get(i).getCoverThumbId());
        }

        imageView.setImageResource(mThumbIds.get(position));

        return imageView;
    }
}