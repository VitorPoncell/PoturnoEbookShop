package com.poturno.ebookshop.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.poturno.ebookshop.BR;


@Entity(tableName = "books_table", foreignKeys = @ForeignKey(entity = Category.class, parentColumns = "category_id", childColumns = "category", onDelete = ForeignKey.CASCADE))
public class Book extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "book_id")
    private int bookId;
    @ColumnInfo(name = "book_name")
    private String bookName;
    @ColumnInfo(name = "book_price")
    private String bookUnitPrice;
    @ColumnInfo(name = "category")
    private int category;

    public Book(int bookId, String bookName, String unitPrice, int category) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookUnitPrice = unitPrice;
        this.category = category;
    }

    public Book() {

    }

    @Bindable
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
        notifyPropertyChanged(BR.bookId);
    }

    @Bindable
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
        notifyPropertyChanged(BR.bookName);
    }

    @Bindable
    public String getBookUnitPrice() {
        return bookUnitPrice;
    }

    public void setBookUnitPrice(String bookUnitPrice) {
        this.bookUnitPrice = bookUnitPrice;
        notifyPropertyChanged(BR.bookUnitPrice);
    }

    @Bindable
    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
        notifyPropertyChanged(BR.category);
    }
}
