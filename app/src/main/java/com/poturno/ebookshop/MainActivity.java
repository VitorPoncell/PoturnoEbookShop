package com.poturno.ebookshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.poturno.ebookshop.model.Book;
import com.poturno.ebookshop.model.Category;
import com.poturno.ebookshop.persistence.EBookShopRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EBookShopRepository eBookShopRepository = new EBookShopRepository(getApplication());

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        Log.d(TAG,"before");
        mainActivityViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                Log.d(TAG,"onChanged");
            }
        });
        Log.d(TAG,"after");

        mainActivityViewModel.getBooksOfASelectedCategory(3).observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> books) {
                 for (Book book : books){
                     Log.d(TAG,book.getBookName());
                 }
            }
        });
    }
}
