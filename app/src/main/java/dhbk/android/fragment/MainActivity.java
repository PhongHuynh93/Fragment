package dhbk.android.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements RageComicListFragment.OnRageComicSelected{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            // FragmentManager to add/remove fragment
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.root_layout, RageComicListFragment.newInstance(), "rageComicList")
                    .commit();
        }
    }

    @Override
    public void onRageComicSelected(int imageResId, String name, String description, String url) {
//        Toast.makeText(MainActivity.this, "You selected " + name, Toast.LENGTH_SHORT).show();
        final RageComicDetailsFragment detailsFragment =
                RageComicDetailsFragment.newInstance(imageResId, name, description, url);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root_layout, detailsFragment, "rageComicDetails")
                .addToBackStack(null)
                .commit();
    }
}
