package com.poturno.ebookshop.persistence;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.poturno.ebookshop.model.Book;
import com.poturno.ebookshop.model.Category;

@Database(entities = {Category.class, Book.class}, version = 1)
public abstract class BooksDatabase extends RoomDatabase {

    private static BooksDatabase instance;

    public abstract CategoryDao categoryDao();
    public abstract BookDAO bookDAO();

    public static synchronized BooksDatabase getInstance(Context context) {
        if(instance == null){
            instance = Room.databaseBuilder(context, BooksDatabase.class, "books_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new InitialDataAsyncTask(instance).execute();
        }
    };

    private static class InitialDataAsyncTask extends AsyncTask<Void,Void,Void>{

        private CategoryDao categoryDao;
        private BookDAO bookDAO;

        public InitialDataAsyncTask(BooksDatabase booksDatabase) {
            categoryDao = booksDatabase.categoryDao();
            bookDAO = booksDatabase.bookDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Category category1 = new Category();
            category1.setCategoryName("Text Books");
            category1.setCategoryDescription("Text Books Description");

            Category category2 = new Category();
            category2.setCategoryName("Novels");
            category2.setCategoryDescription("Novels Description");

            Category category3 = new Category();
            category3.setCategoryName("Other");
            category3.setCategoryDescription("Other Description");



            categoryDao.insert(category1);
            categoryDao.insert(category2);
            categoryDao.insert(category3);

            Book book1=new Book();
            book1.setBookName("High school Java ");
            book1.setBookUnitPrice("$150");
            book1.setCategory(1);

            Book book2=new Book();
            book2.setBookName("Mathematics for beginners");
            book2.setBookUnitPrice("$200");
            book2.setCategory(1);

            Book book3=new Book();
            book3.setBookName("Object Oriented Androd App Design");
            book3.setBookUnitPrice("$150");
            book3.setCategory(1);

            Book book4=new Book();
            book4.setBookName("Astrology for beginners");
            book4.setBookUnitPrice("$190");
            book4.setCategory(1);

            Book book5=new Book();
            book5.setBookName("High school Magic Tricks ");
            book5.setBookUnitPrice("$150");
            book5.setCategory(1);

            Book book6=new Book();
            book6.setBookName("Chemistry  for secondary school students");
            book6.setBookUnitPrice("$250");
            book6.setCategory(1);

            Book book7=new Book();
            book7.setBookName("A Game of Cats");
            book7.setBookUnitPrice("$19.99");
            book7.setCategory(2);

            Book book8=new Book();
            book8.setBookName("The Hound of the New York");
            book8.setBookUnitPrice("$16.99");
            book8.setCategory(2);

            Book book9=new Book();
            book9.setBookName("Adventures of Joe Finn");
            book9.setBookUnitPrice("$13");
            book9.setCategory(2);

            Book book10=new Book();
            book10.setBookName("Arc of witches");
            book10.setBookUnitPrice("$19.99");
            book10.setCategory(2);

            Book book11=new Book();
            book11.setBookName("Can I run");
            book11.setBookUnitPrice("$16.99");
            book11.setCategory(2);

            Book book12=new Book();
            book12.setBookName("Story of a joker");
            book12.setBookUnitPrice("$13");
            book12.setCategory(2);

            Book book13=new Book();
            book13.setBookName("Notes of a alien life cycle researcher");
            book13.setBookUnitPrice("$1250");
            book13.setCategory(3);

            Book book14=new Book();
            book14.setBookName("Top 9 myths abut UFOs");
            book14.setBookUnitPrice("$789");
            book14.setCategory(3);

            Book book15=new Book();
            book15.setBookName("How to become a millionaire in 24 hours");
            book15.setBookUnitPrice("$1250");
            book15.setCategory(3);

            Book book16=new Book();
            book16.setBookName("1 hour work month");
            book16.setBookUnitPrice("$199");
            book16.setCategory(3);

            bookDAO.insert(book1);
            bookDAO.insert(book2);
            bookDAO.insert(book3);
            bookDAO.insert(book4);
            bookDAO.insert(book5);
            bookDAO.insert(book6);
            bookDAO.insert(book7);
            bookDAO.insert(book8);
            bookDAO.insert(book9);
            bookDAO.insert(book10);
            bookDAO.insert(book11);
            bookDAO.insert(book12);
            bookDAO.insert(book13);
            bookDAO.insert(book14);
            bookDAO.insert(book15);
            bookDAO.insert(book16);


            return null;
        }
    }
}
