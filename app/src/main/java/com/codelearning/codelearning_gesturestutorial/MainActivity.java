package com.codelearning.codelearning_gesturestutorial;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private GestureDetectorCompat mDetector;
    TextView touchIndicator;
    TextView gestureDetectorIndicator;
    AnalogClock clock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        touchIndicator = (TextView) findViewById(R.id.touchIndicator);
        gestureDetectorIndicator = (TextView) findViewById(R.id.gestureDetector);
        clock = (AnalogClock) findViewById(R.id.analogClock);

        clock.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                int action = MotionEventCompat.getActionMasked(motionEvent);
                String touchXY = "( X = " + motionEvent.getX() + " -- Y = " + motionEvent.getY() + " )";
                switch (action) {
                    case (MotionEvent.ACTION_DOWN):
                        touchIndicator.setText("\n action clock DOWN : " + touchXY);
                        return true;
                    case (MotionEvent.ACTION_MOVE):
                        touchIndicator.setText("\n action clock MOVE : " + touchXY);
                        return true;
                    case (MotionEvent.ACTION_UP):
                        touchIndicator.setText("\n action clock UP : " + touchXY);
                        return true;
                    default:
                }

                return false;
            }
        });


        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this, gestureDetectorListener);
        // Set the gesture detector as the double tap
        // listener.
        mDetector.setOnDoubleTapListener(doubleTapListener);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDetector.onTouchEvent(event);
        int action = MotionEventCompat.getActionMasked(event);
        String touchXY = "( " + event.getX() + " -- " + event.getY() + " )";
        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                touchIndicator.setText("\n action DOWN : " + touchXY);
                return true;
            case (MotionEvent.ACTION_MOVE):
                touchIndicator.setText("\n action MOVE : " + touchXY);
                return true;
            case (MotionEvent.ACTION_UP):
                touchIndicator.setText("\n action UP : " + touchXY);
                return true;
            default:
                return super.onTouchEvent(event);
        }

    }

    private android.view.GestureDetector.OnGestureListener gestureDetectorListener = new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent motionEvent) {
            String motion = "( X = " + motionEvent.getX() + " -- Y = " + motionEvent.getY() + " )";
            gestureDetectorIndicator.setText("\n gesture onDown : " + motion);
            return false;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {
            String motion = "( X = " + motionEvent.getX() + " -- Y = " + motionEvent.getY() + " )";
            gestureDetectorIndicator.setText("\n gesture onShowPress : " + motion);
        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            String motion = "( X = " + motionEvent.getX() + " -- Y = " + motionEvent.getY() + " )";
            gestureDetectorIndicator.setText("\n gesture onSingleTapUp : " + motion);
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            String motion = "( X = " + motionEvent.getX() + " -- Y = " + motionEvent.getY() + " )";
            gestureDetectorIndicator.setText("\n gesture onScroll : " + motion);
            return false;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {
            String motion = "( X = " + motionEvent.getX() + " -- Y = " + motionEvent.getY() + " )";
            gestureDetectorIndicator.setText("\n gesture onLongPress : " + motion);
        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            String motion = "( X = " + motionEvent.getX() + " -- Y = " + motionEvent.getY() + " )";
            gestureDetectorIndicator.setText("\n gesture onFling : " + motion);
            return false;
        }
    };

    private GestureDetector.OnDoubleTapListener doubleTapListener = new GestureDetector.OnDoubleTapListener() {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            String motion = "( X = " + motionEvent.getX() + " -- Y = " + motionEvent.getY() + " )";
            gestureDetectorIndicator.setText("\n gesture onSingleTapConfirmed : " + motion);
            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent motionEvent) {
            String motion = "( X = " + motionEvent.getX() + " -- Y = " + motionEvent.getY() + " )";
            gestureDetectorIndicator.setText("\n gesture onDoubleTap : " + motion);
            return false;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            String motion = "( X = " + motionEvent.getX() + " -- Y = " + motionEvent.getY() + " )";
            gestureDetectorIndicator.setText("\n gesture onDoubleTapEvent : " + motion);
            Toast.makeText(MainActivity.this, "Double Tapped", Toast.LENGTH_SHORT).show();
            return false;
        }
    };
}
