package itesm.mx.apislecturaapp.Database;

import android.provider.BaseColumns;

public final class DataBaseSchema {
    private DataBaseSchema() {}

    public static class LibraryTable implements BaseColumns {
        public static final String TABLE_NAME = "library";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_AUTHOR = "author";
        public static final String COLUMN_NAME_PAGES = "pages";
        public static final String COLUMN_NAME_COVER = "cover";
    }
}
