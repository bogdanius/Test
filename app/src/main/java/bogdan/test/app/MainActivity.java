package bogdan.test.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import bogdan.test.app.model.MyObject;
import bogdan.test.app.model.MyObject2;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button_go);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_go:
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("myObject", new MyObject2(this));
                startActivity(intent);
                break;
        }
    }

}
