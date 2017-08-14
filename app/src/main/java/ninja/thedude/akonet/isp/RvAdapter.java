package ninja.thedude.akonet.isp;

/**
 * Created by thedude61636 on 7/23/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import ninja.thedude.akonet.data.model.Isp;
import ninja.thedude.akonet.databinding.ItemIspBinding;


class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    private static final String TAG = "RvAdapter";
    private Context context;
    private ArrayList<Isp> isp;
    private IspViewModel viewModel;

    RvAdapter(Context context, IspViewModel viewModel) {
        this.context = context;
        isp = new ArrayList<>();
        this.viewModel = viewModel;
    }

    public void addItems(ArrayList<Isp> isp) {
        int pre = this.isp.size() - 1;
        this.isp.addAll(isp);
        notifyItemRangeInserted(pre, this.isp.size()-1);
    }

    void changeItems(ArrayList<Isp> isp) {

        Log.d(TAG, "changeItems() called with: isp = [" + isp + "]");
        this.isp = isp;
        notifyDataSetChanged();
    }

    public void clear() {
        isp.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemIspBinding binding = ItemIspBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setViewModel(viewModel);
        holder.bindIsp(isp.get(position));
    }

    @Override
    public int getItemCount() {
        return isp.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ItemIspBinding binding;

        ViewHolder(ItemIspBinding binding) {
            super(binding.getRoot());

            this.binding = binding;

        }

        void bindIsp(Isp isp) {
            binding.setIsp(isp);
            binding.executePendingBindings();
        }

        public void setViewModel(IspViewModel viewModel) {
            binding.setViewModel(viewModel);
            binding.executePendingBindings();
        }

    }
}
