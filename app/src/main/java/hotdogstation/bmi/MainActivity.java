package hotdogstation.bmi;

import android.content.Context;
import android.content.Intent;
import android.opengl.ETC1;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private ImageView iv_Photo;
    private RadioGroup rg_Gender;
    private RadioButton rb_Male, rb_Female;
    private EditText et_Name, et_Age;
    private Button btnNext;

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
        iv_Photo = (ImageView) findViewById(R.id.iv_Photo);
        rg_Gender = (RadioGroup) findViewById(R.id.rg_Gender);
        rb_Male = (RadioButton) findViewById(R.id.rb_Male);
        rb_Female = (RadioButton) findViewById(R.id.rb_Female);
        et_Name = (EditText) findViewById(R.id.et_Name);
        et_Age = (EditText) findViewById(R.id.et_Age);
        btnNext = (Button) findViewById(R.id.btn_Next);
    }

    private void initAction() {

        rg_Gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rb_Male.isChecked())
                {
                    iv_Photo.setImageDrawable(getResources().getDrawable(R.mipmap.male));
                }else{
                    iv_Photo.setImageDrawable(getResources().getDrawable(R.mipmap.female));
                }
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
        if (!rb_Male.isChecked() && !rb_Female.isChecked()){
            Toast.makeText(context, R.string.GenderError,Toast.LENGTH_SHORT).show();
            return;
        }
        if (et_Name.getText().toString().matches("")){
            Toast.makeText(context, R.string.NameError,Toast.LENGTH_SHORT).show();
            return;
        }
        if (et_Age.getText().toString().matches("")){
            Toast.makeText(context, R.string.AvgError,Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(context, ActivityInfo.class);
        intent.putExtra(ActivityInfo.INTENT_NAME,et_Name.getText());
        intent.putExtra(ActivityInfo.INTENT_AGE, et_Age.getText());
        intent.putExtra(ActivityInfo.INTENT_Gender, rb_Female.isChecked() ? false: true);
        startActivity(intent);

    }
}
