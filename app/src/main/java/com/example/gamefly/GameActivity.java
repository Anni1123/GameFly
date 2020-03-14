package com.example.gamefly;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {

    private GameView gameView;
    private Handler handler=new Handler();
    private final static long interval=30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Point point=new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        gameView=new GameView(this,point.x,point.y);
        setContentView(gameView);
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run()
                    {
                        gameView.invalidate();
                    }
                });
            }
        },0,interval);
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }
}
