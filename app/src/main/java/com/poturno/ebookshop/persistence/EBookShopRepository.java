package com.poturno.ebookshop.persistence;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.poturno.ebookshop.model.Book;
import com.poturno.ebookshop.model.Category;

import java.util.List;

public class EBookShopRepository {

    private String TAG = "EBookShopRepository";
    private CategoryDao categoryDao;
    private BookDAO bookDAO;
    private LiveData<List<Category>> categories;
    private LiveData<List<Book>> books;

    public EBookShopRepository(Application application) {

        BooksDatabase booksDatabase = BooksDatabase.getInstance(application);
        categoryDao=booksDatabase.categoryDao();
        bookDAO=booksDatabase.bookDAO();
    }

    public LiveData<List<Category>> getCategories() {
        Log.d(TAG,"before");
        return categoryDao.getAll();
    }

    public LiveData<List<Book>> getBooks(int categoryId) {
        return bookDAO.getAllFrom(categoryId);
    }

    public void insertCategory(Category category) {
        new insertCategoryAsyncTask(categoryDao).execute(category);
    }

    public void updateCategory(Category category) {
        new updateCategoryAsyncTask(categoryDao).execute(category);
    }

    public void deleteCategory(Category category) {
        new deleteCategoryAsyncTask(categoryDao).execute(category);
    }

    public void insertBook(Book book){
        new insertBookAsyncTask(bookDAO).execute(book);
    }

    public void updateBook(Book book){
        new updateBookAsyncTask(bookDAO).execute(book);
    }

    public void deleteBook(Book book){
        new deleteBookAsyncTask(bookDAO).execute(book);
    }

    private static class insertCategoryAsyncTask extends AsyncTask<Category,Void,Void>{
        private CategoryDao categoryDao;

        public insertCategoryAsyncTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.insert(categories[0]);
            return null;
        }
    }

    private static class updateCategoryAsyncTask extends AsyncTask<Category,Void,Void>{
        private CategoryDao categoryDao;

        public updateCategoryAsyncTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.update(categories[0]);
            return null;
        }
    }

    private static class deleteCategoryAsyncTask extends AsyncTask<Category,Void,Void>{
        private CategoryDao categoryDao;

        public deleteCategoryAsyncTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.delete(categories[0]);
            return null;
        }
    }

    private static class insertBookAsyncTask extends AsyncTask<Book,Void,Void>{
        private BookDAO bookDAO;

        public insertBookAsyncTask(BookDAO bookDAO) {
            this.bookDAO = bookDAO;
        }

        @Override
        protected Void doInBackground(Book... books) {
            bookDAO.insert(books[0]);
            return null;
        }
    }

    private static class updateBookAsyncTask extends AsyncTask<Book,Void,Void>{
        private BookDAO bookDAO;

        public updateBookAsyncTask(BookDAO bookDAO) {
            this.bookDAO = bookDAO;
        }

        @Override
        protected Void doInBackground(Book... books) {
            bookDAO.update(books[0]);
            return null;
        }
    }

    private static class deleteBookAsyncTask extends AsyncTask<Book,Void,Void>{
        private BookDAO bookDAO;

        public deleteBookAsyncTask(BookDAO bookDAO) {
            this.bookDAO = bookDAO;
        }

        @Override
        protected Void doInBackground(Book... books) {
            bookDAO.delete(books[0]);
            return null;
        }
    }
}

