package info.androidhive.androidanimations;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MoveActivity extends Activity implements AnimationListener {

    public static final int WIDTH = 1048;
    public static final int HEIGHT = 258;

    ImageView city1;
    ImageView city2;
    Button btnStart;

    // Animation
    Animation animMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        city1 = (ImageView) findViewById(R.id.imgCity1);
        city2 = (ImageView) findViewById(R.id.imgCity2);
        // load the animation
        animMove = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.move);

        // set animation listener
        animMove.setAnimationListener(this);
        city1.startAnimation(animMove);
        animMove.setDuration(1500);
//        onAnimationStart(city1.getAnimation());
        animMove.setStartOffset(1000);
        animMove.setRepeatMode(Animation.RESTART);
        animMove.setRepeatCount(Animation.INFINITE);

    }

    @Override
    public void onAnimationEnd(Animation animation) {
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        animMove.setStartOffset(1000);
        animMove.setRepeatMode(Animation.RESTART);
        animMove.setRepeatCount(Animation.INFINITE);

    }

    @Override
    public void onAnimationStart(Animation animation) {
        animMove.setDuration(1500);
        // start the animation
        city1.startAnimation(animMove);
        onAnimationRepeat(city1.getAnimation());

    }

}