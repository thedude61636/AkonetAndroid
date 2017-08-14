package ninja.thedude.akonet.Utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by thedude61636 on 7/29/17.
 */

public class GeneralBinding {

    @BindingAdapter("app:load")
    public static void loadImage(ImageView view, String url) {

        if (url != null)
            Glide.with(view.getContext()).load(url).into(view);
    }
}
