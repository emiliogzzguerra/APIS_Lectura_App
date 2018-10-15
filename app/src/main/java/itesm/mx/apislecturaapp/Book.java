package itesm.mx.apislecturaapp;

public class Book {
    private String mTitle;
    private String mAuthor;
    private int mNumPages;
    private int mCoverThumbId;

    public Book(String mTitle, String mAuthor, int mNumPages, int mCoverThumbId) {
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
        this.mNumPages = mNumPages;
        this.mCoverThumbId = mCoverThumbId;
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
