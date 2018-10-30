package itesm.mx.apislecturaapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import itesm.mx.apislecturaapp.model.Book;

/**
 * Created by emiliogonzalez on 3/19/18.
 */

public class LibraryOperations {
    private SQLiteDatabase db;
    private LibraryDBHelper dbHelper;
    private Book book;

    public LibraryOperations(Context context) {dbHelper = new LibraryDBHelper(context);}

    public void open() throws SQLException {
        try{
            db = dbHelper.getWritableDatabase();
            System.out.println("Just opened!");
        } catch (SQLException e){
            Log.e("SQLOPEN", e.toString());
        }
    }

    public void close() {db.close();}

    public long addBook(Book book){
        long newRowId = 0;
        try{
            ContentValues values = new ContentValues();
            values.put(DataBaseSchema.LibraryTable.COLUMN_NAME_TITLE, book.getTitle());
            values.put(DataBaseSchema.LibraryTable.COLUMN_NAME_AUTHOR, book.getAuthor());
            values.put(DataBaseSchema.LibraryTable.COLUMN_NAME_PAGES, book.getNumPages());
            values.put(DataBaseSchema.LibraryTable.COLUMN_NAME_COVER, book.getCoverThumbId());

            newRowId = db.insert(DataBaseSchema.LibraryTable.TABLE_NAME, null, values);
        } catch (SQLException e){
            Log.e("SQLOPEN", e.toString());
        }
        return newRowId;
    }

    public Book findBook(int bookId){
        String query = "Select * FROM " + DataBaseSchema.LibraryTable.TABLE_NAME +
                " WHERE " + DataBaseSchema.LibraryTable._ID +
                " =  \"" + bookId + "\"";

        try {
            Cursor cursor = db.rawQuery(query,null);
            book = null;
            if(cursor.moveToFirst()){
                book = new Book(Integer.valueOf(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getInt(4));
            }
            cursor.close();
        } catch (SQLException e){
            Log.e("SQLOPEN", e.toString());
        }
        return book;
    }
    public boolean deleteBook(String bookTitle){
        boolean result = false;

        String query = "Select * FROM " + DataBaseSchema.LibraryTable.TABLE_NAME +
                " WHERE " + DataBaseSchema.LibraryTable.COLUMN_NAME_TITLE +
                " =  \"" + bookTitle + "\"";

        try {
            Cursor cursor = db.rawQuery(query,null);
            if(cursor.moveToFirst()){
                int id = Integer.parseInt(cursor.getString(0));
                db.delete(DataBaseSchema.LibraryTable.TABLE_NAME,
                        DataBaseSchema.LibraryTable._ID + " = ?",
                        new String[]{String.valueOf(id)});
                result = true;
            }
            cursor.close();
        } catch (SQLException e){
            Log.e("SQLOPEN", e.toString());
        }
        return result;
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> listaBooks = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + DataBaseSchema.LibraryTable.TABLE_NAME;

        try {
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    book = new Book(Integer.valueOf(cursor.getString(0)),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getInt(3),
                            cursor.getInt(4));
                    listaBooks.add(book);
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (SQLException e) {
            Log.e("SQLList", e.toString());
        }
        return listaBooks;
    }
}
