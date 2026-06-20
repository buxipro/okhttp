package okhttp3;

import android.content.Context;
import android.content.SharedPreferences;

public class DataApp {
    private static DataApp instance;
    private final Context context;

    private DataApp(Context context) {
        this.context = context.getApplicationContext();
    }

    public static synchronized DataApp getInstance(Context context) {
        if (instance == null) {
            instance = new DataApp(context);
        }
        return instance;
    }

    public boolean isSecurityPassed() {
        SharedPreferences sharedPreferences =
                context.getSharedPreferences("data_cache", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("cache_valid", false);
    }

    public void setSecurityPassed(boolean passed) {
        SharedPreferences sharedPreferences =
                context.getSharedPreferences("data_cache", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("cache_valid", passed);
        editor.apply();
    }
}