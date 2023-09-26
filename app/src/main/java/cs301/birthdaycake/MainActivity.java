package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        CakeView cakeView = findViewById(R.id.cakeview);
        CakeController cakeController = new CakeController(cakeView);
        Button blowOutButton = this.findViewById(R.id.blowOutButton);
        blowOutButton.setOnClickListener(cakeController);
        SeekBar pickNumCandles = this.findViewById(R.id.pickNumCandles);
        pickNumCandles.setOnSeekBarChangeListener(cakeController);
    }
    public void goodbye(View button){
        Log.i("button","Goodbye.");
        finishAffinity();
    }

}
