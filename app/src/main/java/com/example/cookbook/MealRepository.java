package com.example.cookbook;

import android.app.Application;

import java.util.List;

class MealRepository {

    private MealDao mMealDao;
    private List<DbItem> mAllMeals;

    MealRepository(Application application) {
        MealRoomDatabase db = MealRoomDatabase.getDatabase(application);
        mMealDao = db.mealDao();
        mAllMeals = mMealDao.getAlphabetizedWords();
    }

    List<DbItem> getAllWords() {
        return mAllMeals;
    }

    void insert(DbItem meal) {
        MealRoomDatabase.databaseWriteExecutor.execute(() -> {
            mMealDao.insert(meal);
        });

    }

    void deleteAll(){
        MealRoomDatabase.databaseWriteExecutor.execute(() -> {
            mMealDao.deleteAll();
        });
    }
}