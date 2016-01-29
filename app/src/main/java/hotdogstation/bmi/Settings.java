package hotdogstation.bmi;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by luke.wang on 2016/1/22.
 */
public class Settings {
    private static Settings settings;

    private Context context;
    private SharedPreferences sharedPreferences;

    public static final String SETTING_NAME = "setting";
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String GENDER = "gender";
    public static final String HEIGHT = "height";
    public static final String WEIGHT = "weight";

    public final String DEFAULT_NAME="name";
    public final int DEFAULT_AGE=0;
    public final boolean DEFAULT_GENDER=false;
    public final int DEFAULT_HEIGHT=0;
    public final int DEFAULT_WEIGHT=0;

    private Settings(Context context) {
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences(SETTING_NAME,Context.MODE_PRIVATE);
    }

    public static Settings getInstance(Context context) {
        if (settings == null) {
            settings = new Settings(context);
            settings.loadDefault();
        }
        return settings;
    }

    public void loadDefault() {
        if(!sharedPreferences.contains(NAME)){
            sharedPreferences.edit().putString(NAME,DEFAULT_NAME).commit();
        }
        if(!sharedPreferences.contains(AGE)){
            sharedPreferences.edit().putInt(AGE, DEFAULT_AGE).commit();
        }
        if(!sharedPreferences.contains(GENDER)) {
            sharedPreferences.edit().putBoolean(GENDER, DEFAULT_GENDER).commit();
        }
        if(!sharedPreferences.contains(HEIGHT)) {
            sharedPreferences.edit().putInt(HEIGHT, DEFAULT_HEIGHT).commit();
        }
        if(!sharedPreferences.contains(WEIGHT)) {
            sharedPreferences.edit().putInt(WEIGHT, DEFAULT_WEIGHT).commit();
        }
    }

    public void setNAME(String name) {
        sharedPreferences.edit().putString(NAME,name).commit();
    }

    public void setAGE(int age) {
        sharedPreferences.edit().putInt(AGE, age).commit();
    }

    public void setGENDER(boolean gender) {
        sharedPreferences.edit().putBoolean(GENDER, gender).commit();
    }

    public void setHEIGHT(int height) {
        sharedPreferences.edit().putInt(HEIGHT, height).commit();
    }
    public void setWEIGHT(int weight) {
        sharedPreferences.edit().putInt(WEIGHT,weight).commit();
    }

    public String getNAME() {
        return sharedPreferences.getString(NAME,DEFAULT_NAME);
    }

    public int getAGE() {
        return sharedPreferences.getInt(AGE, DEFAULT_AGE);
    }

    public boolean getGENDER() {
        return sharedPreferences.getBoolean(GENDER, DEFAULT_GENDER);
    }

    public int getHEIGHT() {
        return sharedPreferences.getInt(HEIGHT, DEFAULT_HEIGHT);
    }

    public int getWEIGHT() {
        return sharedPreferences.getInt(WEIGHT,DEFAULT_WEIGHT);
    }

}
