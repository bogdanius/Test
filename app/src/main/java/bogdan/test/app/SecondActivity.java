package bogdan.test.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import bogdan.test.app.model.MyObject2;

import java.util.Arrays;

/**
 * Created by Bogdan on 16.07.2015.
 */
public class SecondActivity extends Activity {

    private TextView textView;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        textView = (TextView) findViewById(R.id.tv_card_value);
        imageView = (ImageView) findViewById(R.id.image_view_two_activity);
        MyObject2 myObject = getIntent().getParcelableExtra("myObject");
        imageView.setImageBitmap(myObject.getmBitmap());
        Log.i("####################", Arrays.toString(myObject.getmMyObject().getStrings().toArray()));
        Log.i("####################", Arrays.toString(myObject.getmMyObject().getStrings2().toArray()));
    }
}
