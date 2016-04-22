package dhbk.android.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RageComicDetailsFragment extends Fragment {
    private static final String ARGUMENT_IMAGE_RES_ID = "imageResId";
    private static final String ARGUMENT_NAME = "name";
    private static final String ARGUMENT_DESCRIPTION = "description";
    private static final String ARGUMENT_URL = "url";

    public static final String TAG = RageComicDetailsFragment.class.getName();

    public static RageComicDetailsFragment newInstance(int imageResId, String name,
                                                       String description, String url) {
        Log.i(TAG, MainActivity.LIFE_CYCLE + "newInstance: ");
        final Bundle args = new Bundle();
        args.putInt(ARGUMENT_IMAGE_RES_ID, imageResId);
        args.putString(ARGUMENT_NAME, name);
        args.putString(ARGUMENT_DESCRIPTION, description);
        args.putString(ARGUMENT_URL, url);
        final RageComicDetailsFragment fragment = new RageComicDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public RageComicDetailsFragment() {
        Log.i(TAG, MainActivity.LIFE_CYCLE + "RageComicDetailsFragment: ");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, MainActivity.LIFE_CYCLE + "onCreateView: ");
        final View view = inflater.inflate(R.layout.fragment_rage_comic_details, container, false);
        final ImageView imageView = (ImageView) view.findViewById(R.id.comic_image);
        final TextView nameTextView = (TextView) view.findViewById(R.id.name);
        final TextView descriptionTextView = (TextView) view.findViewById(R.id.description);

        // show content when click an item in list
        final Bundle args = getArguments();
        imageView.setImageResource(args.getInt(ARGUMENT_IMAGE_RES_ID));
        nameTextView.setText(args.getString(ARGUMENT_NAME));
        final String text = String.format(getString(R.string.description_format), args.getString
                (ARGUMENT_DESCRIPTION), args.getString(ARGUMENT_URL));
        descriptionTextView.setText(text);
        return view;
    }

    @Override
    public void onPause() {
        Log.i(TAG, MainActivity.LIFE_CYCLE + "newInstance: ");

        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG, MainActivity.LIFE_CYCLE + "onStop: ");

        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, MainActivity.LIFE_CYCLE + "onDestroyView: ");

        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, MainActivity.LIFE_CYCLE + "onDestroy: ");

        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i(TAG, MainActivity.LIFE_CYCLE + "onDetach: ");

        super.onDetach();
    }
}
