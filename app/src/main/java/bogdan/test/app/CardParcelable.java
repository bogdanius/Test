package bogdan.test.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by Bogdan on 19.07.2015.
 */
public class CardParcelable implements Parcelable {

    private String name;
    private int age;

    @Override
    public int describeContents() {
        return 0;
    }

    public CardParcelable() {

    }

    private CardParcelable (Parcel sourse) {
        name = sourse.readString();
        age = sourse.readInt();
    }

    public static final Parcelable.Creator<CardParcelable> CREATOR = new Parcelable.Creator<CardParcelable>() {
        public CardParcelable createFromParcel(Parcel in) {
            return new CardParcelable(in);
        }

        public CardParcelable[] newArray(int size) {
            return new CardParcelable[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        Log.d("writeToParcel", "xz");
        parcel.writeString(name);
        parcel.writeInt(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
