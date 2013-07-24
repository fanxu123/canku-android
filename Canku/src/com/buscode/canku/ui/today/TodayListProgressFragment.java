package com.buscode.canku.ui.today;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.buscode.canku.storage.Storage;
import com.buscode.canku.storage.Today;
import com.buscode.canku.ui.MainActivity;

import javax.inject.Inject;


public class TodayListProgressFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Today> {

    @Inject
    TodayListAdapter adapter;
    @Inject
    TodayLoader loader;

    @Inject
    Storage storage;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MainActivity activity = (MainActivity) getActivity();
        activity.getObjectGraph().inject(this);

        setListAdapter(adapter);
        setListShown(false);
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Today> onCreateLoader(int i, Bundle bundle) {
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<Today> todayLoader, Today today) {
        setListShown(true);
        storage.today = today;
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(Loader<Today> todayLoader) {

    }
}
