package me.zeljeznica.redvoznje;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class MyDatabase extends SQLiteAssetHelper {
	
	private static final String DATABASE_NAME = "vozovi" ;
	//private static final String DATABASE_NAME = "northwind" ;
	
	private static final int DATABASE_VERSION = 1;
	
    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
    
    public Cursor getBar() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        //Neophodan je _id u SELECT
        
      //  String [] sqlSelect = {"0 _id", "FirstName", "LastName"}; 
        String [] sqlSelect = {"_id", "polazakiz", "vrijemepolaska"};  //GREŠKA U BAZI TREBALO BI DA PIŠE polazakza

//        String sqlTables = "Employees";
        String sqlTables="bar";
        
        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                        null, null, null);

        c.moveToFirst();
        return c;

}
    
    public Cursor getNiksic() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        
        String [] sqlSelect = {"_id", "polazakiz", "vrijemepolaska"}; 

        String sqlTables="niksic";
        
        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                        null, null, null);
        c.moveToFirst();
        return c;

}
    public Cursor getPodgorica() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        
        //Neophodan je _id u SELECT
        
      //  String [] sqlSelect = {"0 _id", "FirstName", "LastName"}; 
        String [] sqlSelect = {"_id", "polazakiz", "vrijemepolaska"}; 

//        String sqlTables = "Employees";
        String sqlTables="podgorica";
        
        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                        null, null, null);

        c.moveToFirst();
        return c;
}
 
    public Cursor getBijeloPolje() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        
        String [] sqlSelect = {"_id", "polazakiz", "vrijemepolaska"}; 

        String sqlTables="bijelopolje";
        
        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                        null, null, null);

        c.moveToFirst();
        return c;

}   
    
}