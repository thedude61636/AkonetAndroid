package ninja.thedude.akonet.isp;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import ninja.thedude.akonet.data.model.Isp;

/**
 * Created by thedude61636 on 7/27/17.
 */

public class IspsBindingAdapter {

    private static final String TAG = "IspsBindingAdapter";
    @BindingAdapter("app:items")
    public static void items(RecyclerView rv, ObservableArrayList<Isp> observableArrayList) {
        RvAdapter rvAdapter = (RvAdapter) rv.getAdapter();
        Log.d(TAG, "items() called with: rv = [" + rv + "], observableArrayList = [" + observableArrayList + "]");
        if (rvAdapter != null){
            Log.i(TAG, "items: asdf");
            rvAdapter.changeItems(observableArrayList);
        }

    }
}
