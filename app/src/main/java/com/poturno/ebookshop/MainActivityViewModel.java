package com.poturno.ebookshop;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.poturno.ebookshop.model.Book;
import com.poturno.ebookshop.model.Category;
import com.poturno.ebookshop.persistence.EBookShopRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private String TAG = "MainActivityViewModel";
    private EBookShopRepository eBookShopRepository;
    private LiveData<List<Category>> allCategories;
    private LiveData<List<Book>> booksOfASelectedCategory;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        eBookShopRepository = new EBookShopRepository(application);
    }

    public LiveData<List<Category>> getAllCategories() {
        Log.d(TAG,"before");
        allCategories=eBookShopRepository.getCategories();
        Log.d(TAG,"after");
        return allCategories;
    }

    public LiveData<List<Book>> getBooksOfASelectedCategory(int categoryId) {

        booksOfASelectedCategory=eBookShopRepository.getBooks(categoryId);
        return booksOfASelectedCategory;
    }

    public void addNewBook(Book book){
        eBookShopRepository.insertBook(book);
    }

    public void updateBook(Book book){
        eBookShopRepository.updateBook(book);
    }

    public void deleteBook(Book book){
        eBookShopRepository.deleteBook(book);
    }


}
