package me.zeljeznica.redvoznje;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "vozovi";
    private static final int DATABASE_VERSION = 1;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Cursor getBar() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"_id", "polazakiz", "vrijemepolaska"};  //GRE�KA U BAZI TREBALO BI DA PI�E polazakza

        String sqlTables = "bar";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        c.moveToFirst();
        return c;

    }

    public Cursor getNiksic() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"_id", "polazakiz", "vrijemepolaska"};

        String sqlTables = "niksic";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);
        c.moveToFirst();
        return c;

    }

    public Cursor getPodgorica() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();


        String[] sqlSelect = {"_id", "polazakiz", "vrijemepolaska"};

        String sqlTables = "podgorica";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        c.moveToFirst();
        return c;
    }

    public ArrayList<TrainItem> getBijeloPolje() {

        ArrayList<TrainItem> values = new ArrayList<TrainItem>();

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"_id", "polazakiz", "vrijemepolaska"};
        String sqlTables = "bijelopolje";

        qb.setTables(sqlTables);
        Cursor cursor = qb.query(db, sqlSelect, null, null,
                null, null, null);
            if (cursor.moveToFirst()) {
                while (cursor.isAfterLast() == false) {
                    TrainItem item = new TrainItem(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
                    values.add(item);
                    cursor.moveToNext();
                }
            }
        cursor.close();
        return values;
    }
}
