package itesm.mx.apislecturaapp.fragments;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;

import itesm.mx.apislecturaapp.Database.LibraryOperations;
import itesm.mx.apislecturaapp.R;
import itesm.mx.apislecturaapp.behavior.GoalsAdapter;
import itesm.mx.apislecturaapp.model.Goal;
import itesm.mx.apislecturaapp.model.Book;

public class GoalsFragment extends Fragment implements GoalsAdapter.ItemClickListener {

    private LibraryOperations lop;
    GoalsAdapter mGoalsAdapter;
    RecyclerView mGoalsRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    private static final int NOTIFY_ID = 100;
    private static final String CHANNEL_ID = "personal_notifications";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View goals_view = inflater.inflate(R.layout.goals_view, container, false);
        super.onCreate(savedInstanceState);

        lop = new LibraryOperations(getContext());
        lop.open();

        ArrayList<Goal> goals = new ArrayList<>();
        goals = lop.selectGoals();

        lop.close();

        // Setup de la lista de metas RecyclerView.
        mGoalsRecyclerView = goals_view.findViewById(R.id.goals_list);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mGoalsRecyclerView.setLayoutManager(mLayoutManager);
        mGoalsAdapter = new GoalsAdapter(getActivity(), goals);
        mGoalsAdapter.setClickListener(this);
        mGoalsRecyclerView.setAdapter(mGoalsAdapter);

        return goals_view;
    }

    @Override
    public void onItemClick(View view, int position) {
        lop = new LibraryOperations(getContext());
        lop.open();

        Goal goal = lop.selectGoal(position + 1);
        Book book = lop.findBook(goal.getBookId());

        lop.close();
        String message = "Libro: " + book.getTitle() + ", Por leer hoy: " + goal.getPagesPerDay();
        showActionButtonsNotification(message);
    }

    private void showActionButtonsNotification(String message) {
        createNotificationChannel();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity(), CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        builder.setContentTitle("Lectura pendiente");
        builder.setContentText(message);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getActivity());
        notificationManagerCompat.notify(NOTIFY_ID, builder.build());
    }

    private void createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name ="Personal Notifications";
            String description = "Include all the personal notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, importance);

            notificationChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
