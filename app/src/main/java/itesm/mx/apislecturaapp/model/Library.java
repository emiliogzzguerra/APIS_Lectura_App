package itesm.mx.apislecturaapp.model;

import java.util.HashMap;
import java.util.Map;

import itesm.mx.apislecturaapp.R;
import itesm.mx.apislecturaapp.model.Book;

public class Library {
    private Map<String, Book> mBooks;

    public Library() {
        this.mBooks = new HashMap<String, Book>();
        this.mBooks.put("guerrero",
                new Book("Manual del guerrero de la luz",
                         "Paulo Coelho",
                         392,
                         R.drawable.guerrero));
        this.mBooks.put("monje",
                new Book("El monje que vendio su ferrari",
                        "Robin S. Sharma",
                        441,
                        R.drawable.monje));
        this.mBooks.put("psicoanalista",
                new Book("El Psicoanalista",
                        "John Katzenbach",
                        519,
                        R.drawable.psicoanalista));
        this.mBooks.put("sombra",
                new Book("La sombra",
                        "John Katzenbach",
                        232,
                        R.drawable.sombra));
    }

    public Book getBook(String bookId){
        return mBooks.get(bookId);
    }
}