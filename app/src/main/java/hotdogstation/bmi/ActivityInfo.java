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
    private String name;
    private int age;
    private boolean gender;

    private Button btnNext;

    public static String INTENT_NAME="name";
    public static String INTENT_AGE="age";
    public static String INTENT_Gender= "gender";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        init();
        initUi();
        initIntent();
        initAction();
    }

    private void init() {
        this.context = this;
    }

    private void initUi() {
        btnNext = (Button) findViewById(R.id.btn_Next);
    }

    private void initIntent() {
        Intent intent = getIntent();
        name = intent.getStringExtra(INTENT_NAME);
        age = intent.getIntExtra(INTENT_AGE, 0);
        gender = intent.getBooleanExtra(INTENT_Gender, false);
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

        startActivity(i);

    }
}
