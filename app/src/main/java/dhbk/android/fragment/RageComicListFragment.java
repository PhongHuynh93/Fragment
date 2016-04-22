package dhbk.android.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RageComicListFragment extends Fragment {
    private OnRageComicSelected mListener;

    private int[] mImageResIds;
    private String[] mNames;
    private String[] mDescriptions;
    private String[] mUrls;

    public static final String TAG = RageComicListFragment.class.getName();

    public static RageComicListFragment newInstance() {
        Log.i(TAG, MainActivity.LIFE_CYCLE + "newInstance: ");
        return new RageComicListFragment();
    }

    public RageComicListFragment() {
        Log.i(TAG, MainActivity.LIFE_CYCLE + "RageComicListFragment: ");

        // Required empty public constructor
    }

    // access the resource, make activity implement listener
    @Override
    public void onAttach(Context context) {
        Log.i(TAG, MainActivity.LIFE_CYCLE + "onAttach: ");

        super.onAttach(context);

        if (context instanceof OnRageComicSelected) {
            mListener = (OnRageComicSelected) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnRageComicSelected.");
        }

        // Get rage face names and descriptions.
        final Resources resources = context.getResources();
        mNames = resources.getStringArray(R.array.names);
        mDescriptions = resources.getStringArray(R.array.descriptions);
        mUrls = resources.getStringArray(R.array.urls);

        // Get rage face images.
        final TypedArray typedArray = resources.obtainTypedArray(R.array.images);
        final int imageCount = mNames.length;
        mImageResIds = new int[imageCount];
        for (int i = 0; i < imageCount; i++) {
            mImageResIds[i] = typedArray.getResourceId(i, 0);
        }
        typedArray.recycle();
    }

    // make layout
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, MainActivity.LIFE_CYCLE + "onCreateView: ");

        final View view = inflater.inflate(R.layout.fragment_rage_comic_list, container, false);

        final Activity activity = getActivity();
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(activity, 2));
        recyclerView.setAdapter(new RageComicAdapter(activity));
        return view;
    }

    class RageComicAdapter extends RecyclerView.Adapter<ViewHolder> {

        private LayoutInflater mLayoutInflater;

        public RageComicAdapter(Context context) {
            Log.i(TAG, MainActivity.LIFE_CYCLE + "RageComicAdapter: ");

            mLayoutInflater = LayoutInflater.from(context);
        }

        // inflate a view in a list
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            Log.i(TAG, MainActivity.LIFE_CYCLE + "onCreateViewHolder: ");

            return new ViewHolder(mLayoutInflater
                    .inflate(R.layout.recycler_item_rage_comic, viewGroup, false));
        }

        // set content for a view
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {
            Log.i(TAG, MainActivity.LIFE_CYCLE + "onBindViewHolder: ");

            final int imageResId = mImageResIds[position];
            final String name = mNames[position];
            final String description = mDescriptions[position];
            final String url = mUrls[position];
            viewHolder.setData(imageResId, name);

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onRageComicSelected(imageResId, name, description, url);
                }
            });
        }

        @Override
        public int getItemCount() {
            Log.i(TAG, MainActivity.LIFE_CYCLE + "getItemCount: ");

            return mNames.length;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        // Views
        private ImageView mImageView;
        private TextView mNameTextView;

        private ViewHolder(View itemView) {
            super(itemView);
            Log.i(TAG, MainActivity.LIFE_CYCLE + "ViewHolder: ");


            // Get references to image and name.
            mImageView = (ImageView) itemView.findViewById(R.id.comic_image);
            mNameTextView = (TextView) itemView.findViewById(R.id.name);
        }

        private void setData(int imageResId, String name) {
            Log.i(TAG, MainActivity.LIFE_CYCLE + "setData: ");

            mImageView.setImageResource(imageResId);
            mNameTextView.setText(name);
        }
    }

    // needed so that fragment can talk to each other via activity.
    public interface OnRageComicSelected {
        void onRageComicSelected(int imageResId, String name, String description, String url);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, MainActivity.LIFE_CYCLE + "onPause: ");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, MainActivity.LIFE_CYCLE + "onStop: ");

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
