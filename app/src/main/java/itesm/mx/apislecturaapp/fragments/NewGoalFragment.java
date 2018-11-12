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
import java.util.concurrent.ThreadLocalRandom;

import androidx.navigation.Navigation;
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

        NewGoalFragmentArgs args = NewGoalFragmentArgs.fromBundle(getArguments());
        final int bookid = args.getBookid();

        registerGoalBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                dao.open();
                Book book = dao.findBook(bookid);
                int numPages = 312;
                if (book == null) {
                    Toast.makeText(getActivity(),
                            "Book id" + bookid + " is null",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    numPages = book.getNumPages();
                }
                int randomId = ThreadLocalRandom.current().nextInt( 0 , 19001 );
                Goal new_goal = new Goal(randomId,
                                         bookid,
                                         LocalDate.parse(targetDate),
                                         numPages);
                long res = dao.createGoal(new_goal);
//                Toast.makeText(getActivity(), "Creado en: " + res, Toast.LENGTH_SHORT).show();

                dao.close();
                NewGoalFragmentDirections.ActionNewGoalFragmentToNavigationGoals action =
                        NewGoalFragmentDirections.actionNewGoalFragmentToNavigationGoals();
                Navigation.findNavController(view).navigate(action);
            }
        });
        return layout;
    }
}
