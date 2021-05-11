package com.example.myfavoritephotos.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.sql.Blob;
import java.util.ArrayList;

public class ImageDatabase extends SQLiteOpenHelper {

    private  static  final String DB_NAME = "images.sqlite";
    private  static  final int DB_VERSION = 1;
    private  static final String DB_TABLE = "Image";
    private  static final String COL_ID = "Id";
    private  static final String COL_TITLE = "Title";
    private  static final String COL_SOURCE = "Source";

    public ImageDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query;

        query = String.format("CREATE TABLE IF NOT EXISTS %s("+
        " %s INTEGER PRIMARY KEY AUTOINCREMENT, "+
        " %s TEXT, " +
        " %s BLOB NOT NULL)", DB_TABLE, COL_ID, COL_TITLE, COL_SOURCE);

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Integer createImageInDb (Image image) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_TITLE, image.getTitle());
        values.put(COL_SOURCE, image.getImageContent());
        Integer id = Math.toIntExact(database.insert(DB_TABLE, null, values));
        database.close();
        return id;
    }

    public ArrayList<Image> retrieveCitiesFromDb() {
        SQLiteDatabase database = getReadableDatabase();
        ArrayList<Image> images;
        try (Cursor cursor = database.query(DB_TABLE, null, null, null, null, null, null)) {
            images = new ArrayList<>();
            if (cursor.moveToFirst()) {
                do {
                    Integer id = cursor.getInt(cursor.getColumnIndex(COL_ID));
                    String title = cursor.getString(cursor.getColumnIndex(COL_TITLE));
                    String source = cursor.getString(cursor.getColumnIndex(COL_SOURCE));
                    Image image = new Image(id, title, source);
                } while (cursor.moveToNext());
            }
        }
        database.close();
        return images;
    }
}
