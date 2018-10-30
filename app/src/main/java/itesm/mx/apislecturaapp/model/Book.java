package itesm.mx.apislecturaapp.model;

public class Book {

    private String mIsbn;

    private int mId;

    private String mTitle;

    private String mAuthor;

    private int mNumPages;

    private int mCoverThumbId;

    public Book(int mId, String title, String author, int numPages, int coverThumbId) {
        this.mId = mId;
        this.mTitle = title;
        this.mAuthor = author;
        this.mNumPages = numPages;
        this.mCoverThumbId = coverThumbId;
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
