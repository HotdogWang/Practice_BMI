package hotdogstation.bmi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ActivityInfo extends AppCompatActivity {

    private Context context;
    private Button btnNext;

    public static String INTENT_NAME="name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initUi();
        initAction();
    }

    private void init() {
        this.context = this;
    }

    private void initUi() {
        btnNext = (Button) findViewById(R.id.btn_Next);
    }

    private void initAction() {

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Check();
            }
        });

    }

    private void Check() {


        Intent i =new Intent(context, android.content.pm.ActivityInfo.class);

    }
}
