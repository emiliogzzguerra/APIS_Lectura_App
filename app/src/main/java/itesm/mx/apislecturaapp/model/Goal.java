package itesm.mx.apislecturaapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.time.temporal.ChronoUnit.DAYS;

public class Goal {
    private int mId;
    private int mBookId;
    private LocalDate mCreationDate;
    private LocalDate mTargetDate;
    private String mBookIsbn;
    private int mRemainingPages;

    public Goal(int id, LocalDate creationDate, LocalDate targetDate, int bookId, int remainingPages) {
        mId = id;
        mCreationDate = creationDate;
        mTargetDate = targetDate;
        mBookId = bookId;
        mRemainingPages = remainingPages;
    }

    public Goal(int id, int bookId, LocalDate targetDate, int remainingPages) {
        mId = id;
        mBookId = bookId;
        mTargetDate = targetDate;
        mRemainingPages = remainingPages;
        mCreationDate = LocalDate.now();
    }

    public int getId() {
        return mId;
    }

    public int getBookId() {
        return mBookId;
    }

    public void setBookId(int bookId) {
        mBookId = bookId;
    }

    public LocalDate getCreationDate() {
        return mCreationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        mCreationDate = creationDate;
    }

    public int getPagesPerDay() {
        Period period = Period.between(LocalDate.now(), mTargetDate);
        return abs(mRemainingPages / period.getDays());
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

    public int getRemainingPages() {
        return mRemainingPages;
    }

    public int getProgress() {
        int totalPages = 312;
        int readedPages = totalPages - mRemainingPages;
        return readedPages * 100 / totalPages;
    }

    public void decreaseRemainingPages(int pagesToDecrease) {
        mRemainingPages -= max(pagesToDecrease, 0);
    }

    public Boolean isFinished() {
        return mRemainingPages == 0;
    }
}
