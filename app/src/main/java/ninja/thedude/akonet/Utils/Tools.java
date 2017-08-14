package ninja.thedude.akonet.Utils;

/**
 * Created by thedude61636 on 7/12/17.
 */

public class Tools {
    public static <T> T checkNotNull(T refrence) {

        if (refrence == null) {
            throw new NullPointerException();
        } else {
            return refrence;
        }

    }
}
