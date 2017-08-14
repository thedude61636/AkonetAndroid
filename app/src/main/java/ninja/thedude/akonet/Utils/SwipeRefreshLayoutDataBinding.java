/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ninja.thedude.akonet.Utils;

import android.databinding.BindingAdapter;
import android.databinding.Observable;
import android.databinding.ObservableBoolean;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;

import ninja.thedude.akonet.isp.IspViewModel;

public class SwipeRefreshLayoutDataBinding {

    /**
     * Reloads the data when the pull-to-refresh is triggered.
     * <p>
     * Creates the {@code android:onRefresh} for a {@link SwipeRefreshLayout}.
     */
    private static final String TAG = "SwipeRefreshLayoutDataB";
    @BindingAdapter("app:onRefresh")
    public static void setSwipeRefreshLayoutOnRefreshListener(ScrollChildSwipeRefreshLayout view,
                                                              final IspViewModel viewModel) {
        Log.d(TAG, "setSwipeRefreshLayoutOnRefreshListener() called with: view = [" + view + "], viewModel = [" + viewModel + "]");
        view.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                viewModel.refresh();
            }
        });
    }
    @BindingAdapter("app:refreshing")
    public static void refreshing(final ScrollChildSwipeRefreshLayout view,
                                  final ObservableBoolean isDataLoading) {
        Log.d(TAG, "setSwipeRefreshLayoutOnRefreshListener() called with: view = [" + view + "], viewModel = [" + isDataLoading + "]");

        isDataLoading.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                view.setRefreshing(isDataLoading.get());

            }
        });
    }


}
