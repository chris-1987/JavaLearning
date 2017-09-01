package com.christian.yi.wu.criminalintent.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.christian.yi.wu.criminalintent.R;
import com.christian.yi.wu.criminalintent.model.Crime;

import java.util.List;

/**
 * Created by Administrator on 2017/8/31.
 */

public class CrimeListFragment extends Fragment {

    private static final String TAG = "CrimeListFragment";
    private static final String SAVED_SUBTITLE_VISIBLE = "subtitle";

    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mCrimeAdapter;
    private boolean mSubtitleVisible;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); // inform fragmentManager to paint the menu

        Log.d(TAG, "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (savedInstanceState != null) {
            mSubtitleVisible = savedInstanceState.getBoolean(SAVED_SUBTITLE_VISIBLE);
        }
        updateUI();

        return view;
    }

    private class CommonCrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTitleTextView;
        private TextView mDateTextView;
        private ImageView mSolvedImageView;

        private Crime mCrime;

        public CommonCrimeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_crime, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.crime_title);
            mDateTextView = (TextView) itemView.findViewById(R.id.crime_date);
            mSolvedImageView = (ImageView) itemView.findViewById(R.id.crime_solved);
        }

        public void onClick(View view) {
            Intent intent = CrimePagerActivity.newIntent(getActivity(), mCrime.getId());
            startActivity(intent);
            //get position of the item in the adapter
            mCrimeAdapter.setClickedItemPosition(getAdapterPosition());
            //         Log.d(TAG, "id:" + mCrime.getId());
        }

        public void bind(Crime crime) {
            mCrime = crime;
            mTitleTextView.setText(mCrime.getTitle());
            String date = (String) DateFormat.format("EEEE, yyyy MM dd, kk:mm", mCrime.getDate());
            mDateTextView.setText(date);
            mSolvedImageView.setVisibility(mCrime.isSolved() ? ImageView.VISIBLE : ImageView.INVISIBLE);
        }
    }

    private class RequirePoliceCrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mRequirePoliceTextView;
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private ImageView mSolvedImageView;
        private Crime mCrime;

        public RequirePoliceCrimeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_require_police_crime, parent, false));
            itemView.setOnClickListener(this);

            mRequirePoliceTextView = (TextView) itemView.findViewById(R.id.crime_require_police);
            mTitleTextView = (TextView) itemView.findViewById(R.id.crime_title);
            mDateTextView = (TextView) itemView.findViewById(R.id.crime_date);
            mSolvedImageView = (ImageView) itemView.findViewById(R.id.crime_solved);
        }

        @Override
        public void onClick(View view) {
            //  Toast.makeText(getActivity(), mCrime.getTitle() + " clicked!", Toast.LENGTH_SHORT).show();
            Intent intent = CrimePagerActivity.newIntent(getActivity(), mCrime.getId());
            startActivity(intent);
            //get position of the item in the adapter
            mCrimeAdapter.setClickedItemPosition(getAdapterPosition());
            //           Log.d(TAG, "id:" + mCrime.getId());
        }

        public void bind(Crime crime) {
            mCrime = crime;
            mTitleTextView.setText(mCrime.getTitle());
            String date = (String) DateFormat.format("EEEE, yyyy MM dd, kk:mm", mCrime.getDate());
            mDateTextView.setText(date);
            mRequirePoliceTextView.setText("require police");
            mSolvedImageView.setVisibility(mCrime.isSolved() ? ImageView.VISIBLE : ImageView.INVISIBLE);
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter {

        private static final int TYPE_COMMON_CRIME = 0;
        private static final int TYPE_REQUIRE_POLICE_CRIME = 1;

        private List<Crime> mCrimes;
        private int mClickedItemPosition;

        public CrimeAdapter(List<Crime> crimes) {
            mCrimes = crimes;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            switch (viewType) {
                case TYPE_COMMON_CRIME:
                    return new CommonCrimeHolder(layoutInflater, parent);
                case TYPE_REQUIRE_POLICE_CRIME:
                    return new RequirePoliceCrimeHolder(layoutInflater, parent);
                default:
                    return null;
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Crime crime = mCrimes.get(position);
            switch (getItemViewType(position)) {
                case TYPE_COMMON_CRIME:
                    CommonCrimeHolder commonCrimeHolder = (CommonCrimeHolder) holder;
                    commonCrimeHolder.bind(crime);
                    break;
                case TYPE_REQUIRE_POLICE_CRIME:
                    RequirePoliceCrimeHolder requirePoliceCrimeHolder = (RequirePoliceCrimeHolder) holder;
                    requirePoliceCrimeHolder.bind(crime);
                    break;
                default:
                    break;
            }
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }

        public void setCrimes(List<Crime> crimes) {
            mCrimes = crimes;
        }

        @Override
        public int getItemViewType(int position) {
            if (mCrimes.get(position).isRequirePolice()) {
                return TYPE_REQUIRE_POLICE_CRIME;
            } else {
                return TYPE_COMMON_CRIME;
            }
        }


        public void setClickedItemPosition(int position) {

            mClickedItemPosition = position;
        }

        public int getClickedItemPosition() {
            return mClickedItemPosition;
        }
    }

    private void updateUI() {

        CrimeLab crimeLab = CrimeLab.getInstance(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();

        if (mCrimeAdapter == null) {
            mCrimeAdapter = new CrimeAdapter(crimes);
            mCrimeRecyclerView.setAdapter(mCrimeAdapter);
        } else {
            mCrimeAdapter.setCrimes(crimes);
            mCrimeAdapter.notifyDataSetChanged();
            getActivity().invalidateOptionsMenu();
            updateSubtitle();
            //  mCrimeAdapter.notifyItemChanged(mCrimeAdapter.getClickedItemPosition());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_crime_list, menu);

        MenuItem subtitleItem = menu.findItem(R.id.show_subtitle);
        if (mSubtitleVisible) {
            subtitleItem.setTitle(R.string.hide_subtitle);
        }
        else {
            subtitleItem.setTitle(R.string.show_subtitle);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_crime:
                Crime crime = new Crime();
                CrimeLab.getInstance(getContext()).addCrime(crime);
                Log.d(TAG, "crime id:" + crime.getId());
                Intent intent = CrimePagerActivity.newIntent(getActivity(), crime.getId());
                startActivity(intent);
                return true;
            case R.id.show_subtitle:
                mSubtitleVisible = !mSubtitleVisible;
                getActivity().invalidateOptionsMenu();
                updateSubtitle();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateSubtitle() {

        CrimeLab crimeLab = CrimeLab.getInstance(getActivity());
        int crimeCount = crimeLab.getCrimes().size();
        String subtitle = getResources().getQuantityString(R.plurals.subtitle_plural, crimeCount, crimeCount);

        if (!mSubtitleVisible) {
            subtitle = null;
        }
        AppCompatActivity activity = (AppCompatActivity)getActivity();
        activity.getSupportActionBar().setSubtitle(subtitle);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(SAVED_SUBTITLE_VISIBLE, mSubtitleVisible);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
