package bogdan.test.app.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.File;

/**
 * Created by Bogdan on 31.07.2015.
 */
public class MyObject2 implements Parcelable {

    private MyObject mMyObject;
    private Bitmap mBitmap;

    public MyObject2(Context context) {
        mMyObject = new MyObject();
        File root = Environment.getExternalStorageDirectory();
        Log.i("#################", "Environment :" + root);
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        mBitmap = BitmapFactory.decodeFile(root + "/Robotium/Screenshots/1.png", o2);
        mBitmap = scaleDownBitmap(mBitmap, 100, context);
    }

    public static final Creator<MyObject2> CREATOR = new Creator<MyObject2>() {
        @Override
        public MyObject2 createFromParcel(Parcel parcel) {
            return new MyObject2(parcel);
        }

        @Override
        public MyObject2[] newArray(int i) {
            return new MyObject2[i];
        }
    };

    public MyObject2(Parcel parcel) {
        MyObject[] myObjects = new MyObject[1];
        parcel.readTypedArray(myObjects, MyObject.CREATOR);
        mMyObject = myObjects[0];
        Bitmap[] bitmaps = new Bitmap[1];
        parcel.readTypedArray(bitmaps, Bitmap.CREATOR);
        mBitmap = bitmaps[0];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(new MyObject[]{mMyObject}, i);
        parcel.writeTypedArray(new Bitmap[]{mBitmap}, i);
    }

    public MyObject getmMyObject() {
        return mMyObject;
    }

    public static Bitmap scaleDownBitmap(Bitmap photo, int newHeight, Context context) {
        final float densityMultiplier = context.getResources().getDisplayMetrics().density;
        int h= (int) (newHeight*densityMultiplier);
        int w= (int) (h * photo.getWidth()/((double) photo.getHeight()));

        photo=Bitmap.createScaledBitmap(photo, w, h, true);

        return photo;
    }

    public Bitmap getmBitmap() {
        return mBitmap;
    }
}
