package ninja.thedude.akonet.isp;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import ninja.thedude.akonet.R;
import ninja.thedude.akonet.Utils.SnackbarMessage;
import ninja.thedude.akonet.Utils.ViewModelFactory;
import ninja.thedude.akonet.baseActivity.LifecycleAppCompatActivity;
import ninja.thedude.akonet.databinding.ActivityMainBinding;

public class MainActivity extends LifecycleAppCompatActivity {
    ActivityMainBinding binding;
    IspViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);
        viewModel = provideViewModel();
        binding.contentMain.setViewModel(viewModel);
        final RvAdapter rvAdapter = new RvAdapter(this, viewModel);
        binding.contentMain.recycler.setAdapter(rvAdapter);
        binding.contentMain.recycler.setLayoutManager(new LinearLayoutManager(this));

        viewModel.snackbarMessage.observe(this, new SnackbarMessage.SnackbarObserver() {
            @Override
            public void onNewMessage(@StringRes int snackbarMessageResourceId) {
                Snackbar.make(binding.getRoot(), snackbarMessageResourceId, Snackbar.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.start();

    }

    IspViewModel provideViewModel() {
        ViewModelFactory v = ViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, v).get(IspViewModel.class);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
