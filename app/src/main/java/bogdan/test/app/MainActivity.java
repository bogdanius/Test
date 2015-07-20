package bogdan.test.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button buttonSetValue;
    private Button parcelSetValue;
    private LoginButton loginButton;
    private EditText editTextInputValue;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSetValue = (Button) findViewById(R.id.bt_set_value);
        parcelSetValue = (Button) findViewById(R.id.bt_parcel_set_value);
        editTextInputValue = (EditText) findViewById(R.id.et_input_value);

        buttonSetValue.setOnClickListener(this);
        parcelSetValue.setOnClickListener(this);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException e) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_set_value:
                Card card = new Card();
                card.setNumber(0);
                card.setValue(editTextInputValue.getText().toString());
                Intent intent = new Intent(this, CardReadActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("intent", card);
                intent.putExtras(bundle);
                Log.d("IntentTest", "startActivity");
                startActivity(intent);
                break;

            case R.id.bt_parcel_set_value:
                CardParcelable cardParcelable = new CardParcelable();
                cardParcelable.setAge(22);
                cardParcelable.setName(editTextInputValue.getText().toString());
                Intent intentParceble = new Intent(this, CardParcebleReadActivity.class);
                intentParceble.putExtra("intentParcelable", cardParcelable);
                startActivity(intentParceble);
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
