package itesm.mx.apislecturaapp.fragments;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import itesm.mx.apislecturaapp.Database.LibraryOperations;
import itesm.mx.apislecturaapp.R;
import itesm.mx.apislecturaapp.behavior.MainActivity;
import itesm.mx.apislecturaapp.model.Book;

public class BookDetailsFragment extends Fragment {

    private LibraryOperations dao;
    private Button begin_book_button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.book_details_fragment, container, false);
        super.onCreate(savedInstanceState);

        dao = new LibraryOperations(getContext());
        dao.open();

        ImageView imageView = (ImageView) layout.findViewById(R.id.book_cover_img);
        TextView titleTextView = (TextView) layout.findViewById(R.id.book_title);
        TextView authorTextView = (TextView) layout.findViewById(R.id.book_author);
        TextView numPagesTextView = (TextView) layout.findViewById(R.id.book_pagenum);
        Button begin_book_button = (Button) layout.findViewById(R.id.begin_book_btn);

        BookDetailsFragmentArgs args = BookDetailsFragmentArgs.fromBundle(getArguments());
        int bookid = args.getBookid() + 1;
        System.out.println(bookid);
        Book book = dao.findBook(bookid);
        System.out.println(book.getAuthor());
        dao.close();
        imageView.setImageResource(book.getCoverThumbId());
        imageView.setImageDrawable((getResources().getDrawable(book.getCoverThumbId())));
        titleTextView.setText(book.getTitle());
        authorTextView.setText(book.getAuthor());
        numPagesTextView.setText("" + book.getNumPages());

        begin_book_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(getContext())
                                .setSmallIcon(R.drawable.ic_home_black_24dp)
                                .setContentTitle("My notification")
                                .setContentText("Hello World!");
        // Creates an explicit intent for an Activity in your app
                        Intent resultIntent = new Intent(getContext(), MainActivity.class);

        // The stack builder object will contain an artificial back stack for the
        // started Activity.
        // This ensures that navigating backward from the Activity leads out of
        // your application to the Home screen.
                        TaskStackBuilder stackBuilder = TaskStackBuilder.create(getContext());
        // Adds the back stack for the Intent (but not the Intent itself)
                        stackBuilder.addParentStack(MainActivity.class);
        // Adds the Intent that starts the Activity to the top of the stack
                        stackBuilder.addNextIntent(resultIntent);
                        PendingIntent resultPendingIntent =
                                stackBuilder.getPendingIntent(
                                        0,
                                        PendingIntent.FLAG_UPDATE_CURRENT
                                );
                        mBuilder.setContentIntent(resultPendingIntent);
                        NotificationManager mNotificationManager =
                                (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        // mId allows you to update the notification later on.
                        mNotificationManager.notify(0, mBuilder.build());
            }
        });

//        gridview.setAdapter(new BookCoverAdapter(getActivity()));
//
//        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v,
//                                    int position, long id) {
//                Toast.makeText(getActivity(), "" + position,
//                        Toast.LENGTH_SHORT).show();
//            }
//        });

        return layout;
    }
}
