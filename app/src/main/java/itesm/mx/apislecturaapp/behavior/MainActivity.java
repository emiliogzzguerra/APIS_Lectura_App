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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        BottomNavigationView bottomNavView = (BottomNavigationView) findViewById(R.id.navigation_bar);
        NavigationUI.setupWithNavController(bottomNavView, navController);

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

//        BottomNavigationView navigation_bar_items = (BottomNavigationView) findViewById(R.id.navigation_bar_items);
//        navigation_bar_items.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.nav_host_fragment).navigateUp();
    }

}
