package com.poturno.ebookshop.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.poturno.ebookshop.model.Book;

import java.util.List;

@Dao
public interface BookDAO {

    @Insert
    void insert(Book book);

    @Update
    void update(Book book);

    @Delete
    void delete(Book book);

    @Query("SELECT * FROM books_table")
    LiveData<List<Book>> getAll();

    @Query("SELECT * FROM books_table WHERE category==:categoryId")
    LiveData<List<Book>> getAllFrom(int categoryId);
}
