package com.rakshith.basicLib.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rakshith
 */
//public class DataBaseHelper extends SQLiteOpenHelper {
//
//    private static final int DATABASE_VERSION = 1;
//    private static final String DATABASE_NAME = "Quintype";
//
//    private static final String TABLE_RECENT_SEARCH = "recentSearch";
//
//    private static final String RECENT_SEARCH_ID = "recentSearchId";
//    private static final String RECENT_SEARCH_NAME = "recentSearchName";
//    private static final String RECENT_SEARCH_IMAGE = "recentSearchImage";
//    private static final String RECENT_SEARCH_RELEASED_ON = "recentSearchReleasedOn";
//    private static final String RECENT_SEARCH_RUN_TIME = "recentSearchRunTime";
//    private static final String RECENT_SEARCH_GENRE = "recentSearchGenre";
//    private static final String RECENT_SEARCH_LANGUAGE = "recentSearchLanguage";
//    private static final String RECENT_SEARCH_COUNTRY = "recentSearchCountry";
//    private static final String RECENT_SEARCH_ACTORS = "recentSearchActors";
//    private static final String RECENT_SEARCH_DIRECTOR = "recentSearchDirector";
//    private static final String RECENT_SEARCH_WRITER = "recentSearchWriter";
//    private static final String RECENT_SEARCH_AWARDS = "recentSearchAwards";
//    private static final String RECENT_SEARCH_ABOUT_MOVIE = "recentSearchAbtMovie";
//
//    private static final String CREATE_TABLE_MY_SEARCH = "CREATE TABLE " + TABLE_RECENT_SEARCH + "(" + RECENT_SEARCH_ID + " INTEGER AUTO INCREMENT,"
//            + RECENT_SEARCH_NAME + " TEXT,"
//            + RECENT_SEARCH_RELEASED_ON + " TEXT,"
//            + RECENT_SEARCH_RUN_TIME + " TEXT,"
//            + RECENT_SEARCH_GENRE + " TEXT,"
//            + RECENT_SEARCH_LANGUAGE + " TEXT,"
//            + RECENT_SEARCH_COUNTRY + " TEXT,"
//            + RECENT_SEARCH_ACTORS + " TEXT,"
//            + RECENT_SEARCH_DIRECTOR + " TEXT,"
//            + RECENT_SEARCH_WRITER + " TEXT,"
//            + RECENT_SEARCH_AWARDS + " TEXT,"
//            + RECENT_SEARCH_ABOUT_MOVIE + " TEXT,"
//            + RECENT_SEARCH_IMAGE + " TEXT" + ")";
//
//    public DataBaseHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(CREATE_TABLE_MY_SEARCH);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXIST " + TABLE_RECENT_SEARCH);
//        onCreate(db);
//    }
//
//    public long insertSearchMovie(SearchModel searchModel) {
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(RECENT_SEARCH_NAME, searchModel.getmTitle());
//        contentValues.put(RECENT_SEARCH_IMAGE, searchModel.getmPoster());
//        contentValues.put(RECENT_SEARCH_RELEASED_ON, searchModel.getmReleased());
//        contentValues.put(RECENT_SEARCH_RUN_TIME, searchModel.getmRuntime());
//        contentValues.put(RECENT_SEARCH_GENRE, searchModel.getmGenre());
//        contentValues.put(RECENT_SEARCH_LANGUAGE, searchModel.getmLanguage());
//        contentValues.put(RECENT_SEARCH_COUNTRY, searchModel.getmCountry());
//        contentValues.put(RECENT_SEARCH_ACTORS, searchModel.getmActors());
//        contentValues.put(RECENT_SEARCH_DIRECTOR, searchModel.getmDirector());
//        contentValues.put(RECENT_SEARCH_WRITER, searchModel.getmWriter());
//        contentValues.put(RECENT_SEARCH_AWARDS, searchModel.getmAwards());
//        contentValues.put(RECENT_SEARCH_ABOUT_MOVIE, searchModel.getmDescription());
//
//        long search = sqLiteDatabase.insert(TABLE_RECENT_SEARCH, null, contentValues);
//        return search;
//    }
//
//    public List<SearchModel> getAllSearch() {
//        List<SearchModel> searchMovieList = new ArrayList<SearchModel>();
//        String selectQuery = "SELECT * FROM " + TABLE_RECENT_SEARCH + " ORDER BY " + RECENT_SEARCH_ID + " DESC";
//
//        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
//        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                SearchModel searchModel = new SearchModel();
//                searchModel.setmTitle(cursor.getString(cursor.getColumnIndex(RECENT_SEARCH_NAME)));
//                searchModel.setmPoster(cursor.getString(cursor.getColumnIndex(RECENT_SEARCH_IMAGE)));
//                searchModel.setmReleased(cursor.getString(cursor.getColumnIndex(RECENT_SEARCH_RELEASED_ON)));
//                searchModel.setmRuntime(cursor.getString(cursor.getColumnIndex(RECENT_SEARCH_RUN_TIME)));
//                searchModel.setmGenre(cursor.getString(cursor.getColumnIndex(RECENT_SEARCH_GENRE)));
//                searchModel.setmLanguage(cursor.getString(cursor.getColumnIndex(RECENT_SEARCH_LANGUAGE)));
//                searchModel.setmCountry(cursor.getString(cursor.getColumnIndex(RECENT_SEARCH_COUNTRY)));
//                searchModel.setmActors(cursor.getString(cursor.getColumnIndex(RECENT_SEARCH_ACTORS)));
//                searchModel.setmDirector(cursor.getString(cursor.getColumnIndex(RECENT_SEARCH_DIRECTOR)));
//                searchModel.setmWriter(cursor.getString(cursor.getColumnIndex(RECENT_SEARCH_WRITER)));
//                searchModel.setmAwards(cursor.getString(cursor.getColumnIndex(RECENT_SEARCH_AWARDS)));
//                searchModel.setmDescription(cursor.getString(cursor.getColumnIndex(RECENT_SEARCH_ABOUT_MOVIE)));
//
//                searchMovieList.add(searchModel);
//            } while (cursor.moveToNext());
//        }
//        return searchMovieList;
//    }
//}