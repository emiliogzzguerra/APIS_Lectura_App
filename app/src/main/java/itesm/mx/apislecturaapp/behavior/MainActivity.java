package itesm.mx.apislecturaapp.behavior;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import itesm.mx.apislecturaapp.R;
import itesm.mx.apislecturaapp.fragments.DrawerFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Context context = getApplicationContext();
            CharSequence text;
            Toast toast;
            int duration = Toast.LENGTH_SHORT;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    // Begin the transaction
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    // Replace the contents of the container with the new fragment
                    ft.replace(R.id.your_placeholder, new DrawerFragment());
                    // or ft.add(R.id.your_placeholder, new FooFragment());
                    // Complete the changes added above
                    ft.commit();
                    return true;
                case R.id.navigation_dashboard:
                    text = "DASHBOARD!";

                    toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return true;
                case R.id.navigation_notifications:
                    text = "NOTIFICATIONS!";

                    toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.your_placeholder, new DrawerFragment());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added above
        ft.commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
