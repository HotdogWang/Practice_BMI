package hotdogstation.bmi;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.SettingInjectorService;
import android.media.audiofx.BassBoost;
import android.text.Html;

/**
 * Created by Hotdog on 1/5/16.
 */
public class Setting {

    private static Setting setting;
    private Context context;
    private SharedPreferences sharedPreferences;

    public static final String SETTING_NAME="setting";
    public static final String NAME="name";
    public static final String AGE="age";
    public static final String GENDER="gender";


    public final String DEFAULT_NAME="name";
    public final int DEFAULT_AGE=0;
    public final boolean DEFAULT_GENGER=false;

    private Setting(Context context) {
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences(SETTING_NAME,Context.MODE_PRIVATE);
    }

    // get setting
    public static Setting getIntance(Context context){
        if (setting == null){
            setting=new Setting(context);
            setting.setDefault();
        }
        return setting;
    }

    private void setDefault() {
        if (!sharedPreferences.contains(NAME))
        {
            sharedPreferences.edit().putString(NAME,"Luke");
        }
        if (!sharedPreferences.contains(NAME))
        {
            sharedPreferences.edit().putString(NAME,"Luke");
        }
        if (!sharedPreferences.contains(NAME))
        {
            sharedPreferences.edit().putString(NAME,"Luke");
        }

    }

}
