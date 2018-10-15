package itesm.mx.apislecturaapp.behavior;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import itesm.mx.apislecturaapp.R;
import itesm.mx.apislecturaapp.fragments.BooksIndexFragment;
import itesm.mx.apislecturaapp.fragments.DrawerFragment;
import itesm.mx.apislecturaapp.fragments.NewBookFragment;

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
            FragmentTransaction ft = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    ft = getSupportFragmentManager().beginTransaction();
//                    ft.replace(R.id.your_placeholder, new BooksIndexFragment());
                    ft.commit();
                    return true;
                case R.id.navigation_dashboard:
                    ft = getSupportFragmentManager().beginTransaction();
//                    ft.replace(R.id.your_placeholder, new NewBookFragment());
                    ft.commit();
                    return true;
                case R.id.navigation_notifications:
                    // Begin the transaction
                    ft = getSupportFragmentManager().beginTransaction();
                    // Replace the contents of the container with the new fragment
//                    ft.replace(R.id.your_placeholder, new DrawerFragment());
                    // or ft.add(R.id.your_placeholder, new FooFragment());
                    // Complete the changes added above
                    ft.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_graph);
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupWithNavController(navigationView, navController);

        // Begin the transaction
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
//        ft.replace(R.id.your_placeholder, new BooksIndexFragment());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added above
//        ft.commit();

//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.nav_host_fragment).navigateUp();
    }

}
