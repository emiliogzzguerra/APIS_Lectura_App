package itesm.mx.apislecturaapp.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ModelsDao {
    @Query("SELECT * FROM books")
    public List<Book> loadAllBooks();

    @Query("SELECT * FROM goals")
    public List<Goal> loadAllGoals();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertBooks(Book... books);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertGoals(Goal... goals);

    @Delete
    public void deleteBooks(Book... books);

    @Delete
    public void deleteGoals(Goal... goals);

}