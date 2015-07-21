package bogdan.test.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.facebook.*;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button buttonSetValue;
    private Button parcelSetValue;
    private Button buttonSetMessage;
    private EditText editTextSetMessage;
    private EditText editTextInputValue;
    private CallbackManager callbackManager;

    private ShareDialog shareDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        buttonSetValue = (Button) findViewById(R.id.bt_set_value);
        parcelSetValue = (Button) findViewById(R.id.bt_parcel_set_value);
        buttonSetMessage = (Button) findViewById(R.id.button_facebook);
        editTextInputValue = (EditText) findViewById(R.id.et_input_value);
        editTextSetMessage = (EditText) findViewById(R.id.edit_text_facebook);

        buttonSetValue.setOnClickListener(this);
        parcelSetValue.setOnClickListener(this);
        buttonSetMessage.setOnClickListener(this);
        callbackManager = CallbackManager.Factory.create();

        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_friends");
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getApplicationContext(), "onSuccess", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "onCancel", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(getApplicationContext(), "onError", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        AppEventsLogger.deactivateApp(this);
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

            case R.id.button_facebook:
                postToFacebook();
                break;
        }
    }

    private void postToFacebook() {
        shareDialog = new ShareDialog(this);
        shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {
            @Override
            public void onSuccess(Sharer.Result result) {
                Toast.makeText(getApplicationContext(), "onSuccessPost", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(getApplicationContext(), "onError", Toast.LENGTH_SHORT).show();
            }
        });
        Log.d("Facebook", "if");
        if (ShareDialog.canShow(ShareLinkContent.class)) {
            ShareContent shareContent = new ShareLinkContent.Builder()
                    .setContentTitle("Hello Facebook")
                    .setContentDescription(
                            "The 'Hello Facebook' sample  showcases simple Facebook integration")
                    .setContentUrl(Uri.parse("http://developers.facebook.com/android"))
                    .build();
            Log.d("Facebook", "if - true");
            shareDialog.show(shareContent);
        }
    }

}
