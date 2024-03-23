package ru.shitikov.com;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private ImageView IVD;
    private TextView TV;
    private float CD = 0f;
    private SensorManager SM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        II();
    }

    private void II() {
        IVD = findViewById(R.id.IVD);
        TV = findViewById(R.id.TV);
        SM = (SensorManager)getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SM.registerListener(
                this,
                SM.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_GAME
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
        SM.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float D = Math.round(event.values[0]);
        TV.setText("Градусов относительно Се" + Float.toString(D));
        RotateAnimation RA = new RotateAnimation(
                CD,
                -D,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
        );
        RA.setDuration(210);
        RA.setFillAfter(true);

        IVD.startAnimation(RA);
        CD = -D;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}






























































































































































































































































































































































































































































































































































































































































































































































































































































































































































//.|.