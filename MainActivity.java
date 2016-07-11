package nichetech.com.employeefullcrudwithlogin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class MainActivity extends FragmentActivity {

    private Handler handler;
    Runnable callback;
    Animation animFadein;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView= (TextView) findViewById(R.id.tv_database);
        getWindow().setBackgroundDrawableResource(R.drawable.andd);

        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blinking);

        textView.startAnimation(animFadein);

        handler=new Handler();
        callback=new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent();
                intent.setClass(MainActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        };
        handler.postDelayed(callback,4000);

    }

    @Override
    protected void onPause() {
        super.onPause();

        handler.removeCallbacks(callback);
    }
}
