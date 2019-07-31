package com.poturno.ebookshop.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.poturno.ebookshop.BR;


@Entity(tableName = "categories_table")
public class Category extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "category_id")
    private int categoryId;
    @ColumnInfo(name = "category_name")
    private String categoryName;
    @ColumnInfo(name = "category_description")
    private String categoryDescription;

    public Category(int id, String categoryName, String categoryDescription) {
        this.categoryId = id;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public Category() {

    }

    @Bindable
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        notifyPropertyChanged(BR.categoryId);
    }

    @Bindable
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        notifyPropertyChanged(BR.categoryName);
    }

    @Bindable
    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
        notifyPropertyChanged(BR.categoryDescription);
    }
}
