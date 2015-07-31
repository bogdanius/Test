package bogdan.test.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

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
    }
}
