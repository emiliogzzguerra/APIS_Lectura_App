package itesm.mx.apislecturaapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.time.LocalDate;
import java.util.UUID;

import static java.lang.Math.max;

@Entity(tableName = "goals",
        foreignKeys = @ForeignKey(entity = Book.class,
                                  parentColumns = "isbn",
                                  childColumns = "book_isbn"))
public class Goal {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private String mId;

    @ColumnInfo(name = "creation_date")
    private LocalDate mCreationDate;

    @ColumnInfo(name = "creation_date")
    private LocalDate mTargetDate;

    @ColumnInfo(name = "book_isbn")
    private String mBookIsbn;

    @ColumnInfo(name = "remaining_pages")
    private int mRemainingPages;

    public Goal(String id, LocalDate creationDate, LocalDate targetDate, String bookIsbn, int remainingPages) {
        mId = id;
        mCreationDate = creationDate;
        mTargetDate = targetDate;
        mBookIsbn = bookIsbn;
        mRemainingPages = remainingPages;
    }

    @Ignore
    public Goal(LocalDate targetDate, String bookIsbn) {
        mId = UUID.randomUUID().toString();
        mCreationDate = LocalDate.now();
        mTargetDate = targetDate;
        mBookIsbn = bookIsbn;
        // TODO: Fix the retrieval of a book reference
        mRemainingPages = 300;
//        mRemainingPages = book.getNumPages();
    }

    public String getId() {
        return mId;
    }

    public LocalDate getCreationDate() {
        return mCreationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        mCreationDate = creationDate;
    }

    public int getPagesPerDay() {
        // TODO: Compute Pages per day based on target date - now.
        LocalDate now = LocalDate.now();
//        LocalDate timeDelta = mTargetDate.compareTo(()now);
        return 10;
    }

    public LocalDate getTargetDate() {
        return mTargetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        mTargetDate = targetDate;
    }

    public void setTargetPagesPerDay(int targetPagesPerDay) {
        // TODO: Convert pages per day into a target date.
        LocalDate targetDate = LocalDate.now().plusMonths(1);
        mTargetDate = targetDate;
    }

//    public Book getBook() {
//        return mBook;
//    }

//    public void setBook(Book book) {
//        mBook = book;
//    }

    public int getRemainingPages() {
        return mRemainingPages;
    }

    public int getProgress() {
        // Percent of pages read.
//        return mBook.getNumPages() - getRemainingPages();
        // TODO: Fix the retrieval of a book reference
        return 10;
    }

    public void decreaseRemainingPages(int pagesToDecrease) {
        mRemainingPages -= max(pagesToDecrease, 0);
    }

    public Boolean isFinished() {
        return mRemainingPages == 0;
    }
}
