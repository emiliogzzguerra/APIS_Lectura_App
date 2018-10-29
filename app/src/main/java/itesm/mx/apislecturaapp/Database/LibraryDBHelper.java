package itesm.mx.apislecturaapp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import itesm.mx.apislecturaapp.R;

/**
 * Created by emiliogonzalez on 3/19/18.
 */

public class LibraryDBHelper extends SQLiteOpenHelper {
    private static final String DATABSE_NAME = "LibraryDB.db";
    private static final int DATABASE_VERSION = 9;

    public LibraryDBHelper(Context context){
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_LIBRARY_TABLE = "CREATE TABLE " +
                DataBaseSchema.LibraryTable.TABLE_NAME +
                "(" +
                DataBaseSchema.LibraryTable._ID + " INTEGER PRIMARY KEY," +
                DataBaseSchema.LibraryTable.COLUMN_NAME_TITLE + " TEXT," +
                DataBaseSchema.LibraryTable.COLUMN_NAME_AUTHOR + " TEXT," +
                DataBaseSchema.LibraryTable.COLUMN_NAME_PAGES + " INTEGER," +
                DataBaseSchema.LibraryTable.COLUMN_NAME_COVER  + " INTEGER " +
                ")";
        Log.i("LobraryHelper onCreate", CREATE_LIBRARY_TABLE);

        String ADD_INITIAL_BOOKS1 = "INSERT INTO " +
                DataBaseSchema.LibraryTable.TABLE_NAME +
                " (" + DataBaseSchema.LibraryTable.COLUMN_NAME_TITLE + ", " +
                DataBaseSchema.LibraryTable.COLUMN_NAME_AUTHOR + ", " +
                DataBaseSchema.LibraryTable.COLUMN_NAME_PAGES + ", " +
                DataBaseSchema.LibraryTable.COLUMN_NAME_COVER + ") VALUES (" +
                "'Manual del guerrero de la luz', "+
                "'Paulo Coelho'," +
                392 + "," +
                R.drawable.guerrero +
                ")";

        String ADD_INITIAL_BOOKS2 = "INSERT INTO " +
                DataBaseSchema.LibraryTable.TABLE_NAME +
                " (" + DataBaseSchema.LibraryTable.COLUMN_NAME_TITLE + ", " +
                DataBaseSchema.LibraryTable.COLUMN_NAME_AUTHOR + ", " +
                DataBaseSchema.LibraryTable.COLUMN_NAME_PAGES + ", " +
                DataBaseSchema.LibraryTable.COLUMN_NAME_COVER + ") VALUES (" +
                "'El monje que vendio su ferrari', "+
                "'Robin S. Sharma'," +
                441 + "," +
                R.drawable.monje +
                ")";


        String ADD_INITIAL_BOOKS3 = "INSERT INTO " +
                DataBaseSchema.LibraryTable.TABLE_NAME +
                " (" + DataBaseSchema.LibraryTable.COLUMN_NAME_TITLE + ", " +
                DataBaseSchema.LibraryTable.COLUMN_NAME_AUTHOR + ", " +
                DataBaseSchema.LibraryTable.COLUMN_NAME_PAGES + ", " +
                DataBaseSchema.LibraryTable.COLUMN_NAME_COVER + ") VALUES (" +
                "'El Psicoanalista', "+
                "'John Katzenbach'," +
                519 + "," +
                R.drawable.psicoanalista +
                ")";

        String ADD_INITIAL_BOOKS4 = "INSERT INTO " +
                DataBaseSchema.LibraryTable.TABLE_NAME +
                " (" + DataBaseSchema.LibraryTable.COLUMN_NAME_TITLE + ", " +
                DataBaseSchema.LibraryTable.COLUMN_NAME_AUTHOR + ", " +
                DataBaseSchema.LibraryTable.COLUMN_NAME_PAGES + ", " +
                DataBaseSchema.LibraryTable.COLUMN_NAME_COVER + ") VALUES (" +
                "'La sombra', "+
                "'John Katzenbach'," +
                312 + "," +
                R.drawable.sombra +
                ")";
        sqLiteDatabase.execSQL(CREATE_LIBRARY_TABLE);

        sqLiteDatabase.execSQL(ADD_INITIAL_BOOKS1);
        sqLiteDatabase.execSQL(ADD_INITIAL_BOOKS2);
        sqLiteDatabase.execSQL(ADD_INITIAL_BOOKS3);
        sqLiteDatabase.execSQL(ADD_INITIAL_BOOKS4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String DELETE_LIBRARY_TABLE = "DROP TABLE IF EXISTS " + DataBaseSchema.LibraryTable.TABLE_NAME;
        sqLiteDatabase.execSQL(DELETE_LIBRARY_TABLE);
        onCreate(sqLiteDatabase);
    }
}
