package bogdan.test.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Bogdan on 19.07.2015.
 */
public class CardParcebleReadActivity extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("intentParcelable", "onCreate");
        setContentView(R.layout.activity_card_parceble_read);
        textView = (TextView) findViewById(R.id.text_view_card_parcelable);
        CardParcelable cardParcelable = (CardParcelable) getIntent().getParcelableExtra("intentParcelable");
        textView.setText(cardParcelable.getName());
    }
}
