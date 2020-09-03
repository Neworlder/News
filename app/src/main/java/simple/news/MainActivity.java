package simple.news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
	private NewsFragment newsFragment;
	private CovidFragment covidFragment;
	private UserFragment userFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		newsFragment = new NewsFragment();
		covidFragment = new CovidFragment();
		userFragment = new UserFragment();

		FragmentManager manager =  getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.main_layout, newsFragment).commit();

		BottomNavigationView navigationView = findViewById(R.id.navigationView);
		navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem item) {
				FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
				switch (item.getItemId()) {
					case R.id.item_news:
						transaction.replace(R.id.main_layout, newsFragment).commit(); break;
					case R.id.item_covid:
						transaction.replace(R.id.main_layout, covidFragment).commit(); break;
					case R.id.item_user:
						transaction.replace(R.id.main_layout, userFragment).commit(); break;
				}
				return true;
			}
		});
	}
}