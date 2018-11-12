package itesm.mx.apislecturaapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.time.LocalDate;

import itesm.mx.apislecturaapp.Database.LibraryOperations;
import itesm.mx.apislecturaapp.R;
import itesm.mx.apislecturaapp.model.Book;
import itesm.mx.apislecturaapp.model.Goal;

public class NewGoalFragment extends Fragment {

    private Button registerGoalBtn;
    private CalendarView registerGoalCalendar;
    private String targetDate;
    public LibraryOperations dao;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.new_goal_fragment, container, false);
        super.onCreate(savedInstanceState);

        dao = new LibraryOperations(getContext());

        registerGoalBtn = layout.findViewById(R.id.register_goal_btn);
        registerGoalCalendar = layout.findViewById(R.id.register_goal_calendar);

        registerGoalCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                month++;
                targetDate = year + "-" + month + "-" + day;
            }
        });

        registerGoalBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                dao.open();

                Goal new_goal = new Goal(0, 4, LocalDate.parse(targetDate), 312);
                long res = dao.createGoal(new_goal);
                Toast.makeText(getActivity(), "Creado en: " + res, Toast.LENGTH_SHORT).show();

                dao.close();
                // TODO: Cambiar pantalla a index de libros o index de metas
            }
        });
        return layout;
    }
}
