package hotdogstation.bmi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityResult extends AppCompatActivity {

    private Context context;
    private String name;
    private int age;
    private boolean gender;
    private int height;
    private int weight;

    public static String INTENT_NAME="name";
    public static String INTENT_AGE="age";
    public static String INTENT_GENDER= "gender";
    public static String INTENT_HEIGHT="height";
    public static String INTENT_WEIGHT= "weight";

    private TextView tvResult;
    private Button btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        initIntent();
        init();
        initUi();
        initAction();
        initResult();
    }


    private void init() {
        this.context = this;
    }

    private void initUi() {

        tvResult = (TextView) findViewById(R.id.tvResult);
        btnFinish = (Button) findViewById(R.id.btnFinish);
    }

    private void initIntent() {
        Intent intent = getIntent();
        name = intent.getStringExtra(INTENT_NAME);
        age = intent.getIntExtra(INTENT_AGE, 0);
        gender = intent.getBooleanExtra(INTENT_GENDER, false);
        height = intent.getIntExtra(INTENT_HEIGHT, 0);
        weight = intent.getIntExtra(INTENT_WEIGHT,0);
    }

    private void initAction() {
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initResult() {
        float w= (float)weight;
        float h= (float)height/100f;
        float bmi = w/(h*h);

        String result ="";
        result +=(name+"\n");
        result +=(getString(R.string.gender)+": " + (gender?getString(R.string.Male):getString(R.string.Female)) + "\n");
        result +=(getString(R.string.age)+": " + age + "\n");
        result +=(getString(R.string.height)+": " + height + "\n");
        result +=(getString(R.string.weight)+": " + weight + "\n");
        result +=(getString(R.string.bmi)+": " + bmi + "\n");

        tvResult.setText(result);

    }

}
