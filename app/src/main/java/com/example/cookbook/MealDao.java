package com.example.cookbook;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MealDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(DbItem meal);

    @Query("DELETE FROM item_table")
    void deleteAll();

    @Query("SELECT * FROM item_table")
    List<DbItem> getAlphabetizedWords();
}
