package danilk.algorithms;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

/**
 * Created by dan on 1/24/16.
 */
public class ImageDecode {


    public static Bitmap decodeResource(Resources res, int id) {
        Bitmap bitmap = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        String TAG = new Integer(id).toString();



        for (options.inSampleSize = 1; options.inSampleSize <= 32; options.inSampleSize++) {
            try {
                bitmap = BitmapFactory.decodeResource(res, id, options);
                Log.d(TAG, "Decoded successfully for sampleSize " + options.inSampleSize);
                break;
            } catch (OutOfMemoryError outOfMemoryError) {
// If an OutOfMemoryError occurred, we continue with for loop and next inSampleSize value
                Log.e(TAG, "outOfMemoryError while reading file for sampleSize " + options.inSampleSize
                        + " retrying with higher value");
            }
        }
        return bitmap;
    }

}
