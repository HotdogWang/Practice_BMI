package hotdogstation.bmi;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityInfo extends AppCompatActivity {

    private Context context;
    private String name;
    private int age;
    private boolean gender;

    public static String INTENT_NAME="name";
    public static String INTENT_AGE="age";
    public static String INTENT_GENDER= "gender";


    private TextView tvHeight;
    private TextView tvWeight;
    private SeekBar sbHeight;
    private SeekBar sbWeight;
    private Button btnNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        initIntent();
        init();
        initUi();
        initAction();
    }

    private void init() {
        this.context = this;
    }

    private void initUi() {

        tvHeight = (TextView) findViewById(R.id.tvHeight);
        tvWeight = (TextView) findViewById(R.id.tvWeight);
        sbHeight = (SeekBar) findViewById(R.id.sbHeight);
        sbWeight = (SeekBar) findViewById(R.id.sbWeight);
        btnNext = (Button) findViewById(R.id.btn_Next);
    }

    private void initIntent() {
        Intent intent = getIntent();
        name = intent.getStringExtra(INTENT_NAME);
        age = intent.getIntExtra(INTENT_AGE, 0);
        gender = intent.getBooleanExtra(INTENT_GENDER, false);
    }

    private void initAction() {

        sbHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvHeight.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvWeight.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Check();
            }
        });

    }

    private void Check() {

        if (sbHeight.getProgress()==0 || sbWeight.getProgress() == 0)
        {
            Toast.makeText(context, getString(R.string.error_height_weight),Toast.LENGTH_SHORT).show();
            return;
        }
        Intent i =new Intent(context, ActivityResult.class);
        i.putExtra(ActivityResult.INTENT_NAME,name);
        i.putExtra(ActivityResult.INTENT_AGE, age);
        i.putExtra(ActivityResult.INTENT_GENDER, gender);
        i.putExtra(ActivityResult.INTENT_HEIGHT, sbHeight.getProgress());
        i.putExtra(ActivityResult.INTENT_WEIGHT, sbWeight.getProgress());

        startActivity(i);
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);

    }
}
