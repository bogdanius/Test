package bogdan.test.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Bogdan on 16.07.2015.
 */
public class CardReadActivity extends Activity {

    private TextView textViewCardValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_read);
        textViewCardValue = (TextView) findViewById(R.id.tv_card_value);
        Card card = (Card) getIntent().getSerializableExtra("intent");
        textViewCardValue.setText(card.getValue());
    }
}
