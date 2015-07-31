package bogdan.test.app.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Bogdan on 31.07.2015.
 */
public class MyObject implements Parcelable{
    private ArrayList<String> strings = new ArrayList<>();
    {
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("6");
    }

    private ArrayList<String> strings2 = new ArrayList<>();
    {
        strings2.add("1");
        strings2.add("2");
        strings2.add("3");
        strings2.add("4");
        strings2.add("5");
        strings2.add("6");
    }

    public MyObject() {
    }

    public static final Creator<MyObject> CREATOR = new Creator<MyObject>() {
        @Override
        public MyObject createFromParcel(Parcel parcel) {
            return new MyObject(parcel);
        }

        @Override
        public MyObject[] newArray(int i) {
            return new MyObject[i];
        }
    };

    public MyObject(Parcel parcel) {
        parcel.readStringList(strings);
        parcel.readStringList(strings2);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(strings);
        parcel.writeStringList(strings2);
    }

    public ArrayList<String> getStrings() {
        return strings;
    }

    public ArrayList<String> getStrings2() {
        return strings2;
    }
}
