package itesm.mx.apislecturaapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "books")
public class Book {
    @PrimaryKey
    @ColumnInfo(name = "isbn")
    private String mIsbn;

    @ColumnInfo(name = "title")
    private String mTitle;

    @ColumnInfo(name = "author")
    private String mAuthor;

    @ColumnInfo(name = "num_pages")
    private int mNumPages;

    @ColumnInfo(name = "cover_thumb_id")
    private int mCoverThumbId;

    public Book(String isbn, String title, String author, int numPages, int coverThumbId) {
        this.mIsbn = isbn;
        this.mTitle = title;
        this.mAuthor = author;
        this.mNumPages = numPages;
        this.mCoverThumbId = coverThumbId;
    }

    public String getIsbn() {
        return mIsbn;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public int getNumPages() {
        return mNumPages;
    }

    public void setNumPages(int mNumPages) {
        this.mNumPages = mNumPages;
    }

    public int getCoverThumbId() {
        return mCoverThumbId;
    }

    public void setCoverThumbId(int mCoverThumbId) {
        this.mCoverThumbId = mCoverThumbId;
    }
}
