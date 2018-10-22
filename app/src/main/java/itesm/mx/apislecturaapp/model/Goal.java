package itesm.mx.apislecturaapp.model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static java.lang.Math.max;

public class Goal {private String mTitle;
    private LocalDate mGoalCreationDate;
    private LocalDate mTargetDate;
    private Book mBook;
    private int mRemainingPages;

    public Goal(LocalDate targetDate, Book book) {
        mTitle = book.getTitle();
        mGoalCreationDate = LocalDate.now();
        mTargetDate = targetDate;
        mBook = book;
        mRemainingPages = book.getNumPages();
    }

    public String getTitle() {
        return mTitle;
    }

    public LocalDate getGoalCreationDate() {
        return mGoalCreationDate;
    }

    public void setGoalCreationDate(LocalDate goalCreationDate) {
        mGoalCreationDate = goalCreationDate;
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

    public Book getBook() {
        return mBook;
    }

    public void setBook(Book book) {
        mBook = book;
    }

    public int getRemainingPages() {
        return mRemainingPages;
    }

    public int getProgress() {
        // Percent of pages read.
        return mBook.getNumPages() - getRemainingPages();
    }

    public void decreaseRemainingPages(int pagesToDecrease) {
        mRemainingPages -= max(pagesToDecrease, 0);
    }

    public Boolean isFinished() {
        return mRemainingPages == 0;
    }
}
