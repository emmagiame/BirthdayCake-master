package cs301.birthdaycake;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener , CompoundButton.OnCheckedChangeListener, View.OnTouchListener{
    private CakeView view;
    private CakeModel model;

    Paint paint = new Paint();

    CakeController(CakeView cakeView) {
        view = cakeView;
        model = view.getCakeModel();
    }

    @Override
    public void onClick(View viewy) {
        Log.d("CakeController", "onClick");
        if(viewy instanceof Button) {
            Button bOB = (Button)viewy;
            if (model.candleLit == true) {
                model.candleLit = false;
                bOB.setText("Relight");
            } else if (model.candleLit == false) {
                model.candleLit = true;
                bOB.setText("Blow Out");
            }
            view.invalidate();
        }
    }

    public void onCheckedChanged(CompoundButton viewy, boolean b) {
        Log.d("CakeController", "onCheckedChanged");
        if (model.hasCandles == true) {
            model.hasCandles = false;
        } else if (model.hasCandles == false) {
            model.hasCandles = true;
        }
        view.invalidate();
    }

    //public void setOnSeekBarChangeListener(View viewy){
    //    Log.d("CakeController", "setOnSeekBarChangeListener");
    //    view.invalidate();
    //}
    @Override
    public void onProgressChanged(SeekBar pickNumCandles, int progress, boolean fromUser) {
        model.numCandles = progress;
        view.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    @Override
    public boolean onTouch(View viewy, MotionEvent motion) {
        Log.d("CakeController", "onTouch");
        model.touch = true;
        view.x = motion.getX();
        view.y = motion.getY();

        view.invalidate();

        return false;
    }
}
