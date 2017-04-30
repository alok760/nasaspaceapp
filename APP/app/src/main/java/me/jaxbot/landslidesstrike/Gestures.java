package me.jaxbot.landslidesstrike;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Set;

public class Gestures extends AppCompatActivity {
    RelativeLayout relativeLayout;
    View newView1;
    View newView2;
    String TAG = "ppppp";
    HashMap hashmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures);
//        relativeLayout = (RelativeLayout) findViewById(R.id.activity_gestures);
//        hashmap = new HashMap();
//        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if (motionEvent.getActionMasked() == MotionEvent.ACTION_DOWN) {

//                    Toast.makeText(Gestures.this,"Message send to database",Toast.LENGTH_SHORT).show();
//                } else if (motionEvent.getActionMasked() == MotionEvent.ACTION_POINTER_DOWN) {


//                    Toast.makeText(Gestures.this,"Message send to database",Toast.LENGTH_SHORT).show();//                    Log.d(TAG, "action pointer down");
//                    int pointerIndex = motionEvent.getActionIndex();
//                    newView2 = new View(Gestures.this);
//                    newView2.setLayoutParams(new LinearLayoutCompat.LayoutParams(200, 200));
//                    newView2.setBackgroundColor(Color.MAGENTA);
//                    float x = motionEvent.getX(pointerIndex);
//                    float y = motionEvent.getY(pointerIndex);
//                    newView2.setX(x - 100);
//                    newView2.setY(y - 100);
//                    int id = motionEvent.getPointerId(pointerIndex);
//                    hashmap.put(id,newView2);
//                    relativeLayout.addView(newView2);
//                } else if (motionEvent.getActionMasked() == MotionEvent.ACTION_POINTER_UP)
//                {
//                    relativeLayout.removeView(newView2);
//                    hashmap.remove(motionEvent.getPointerId(motionEvent.getActionIndex()));
//                }
//                else if (motionEvent.getActionMasked() == MotionEvent.ACTION_MOVE)
//                {
//
//
//                    Toast.makeText(Gestures.this,"Message send to database",Toast.LENGTH_SHORT).show();
//                    Set<Integer> ids = hashmap.keySet();
//                    for(int i : ids)
//                   {
//                        int pointerindex = motionEvent.findPointerIndex(i);
//                        View newView= (View) hashmap.get(i);
//
//                        relativeLayout.removeView(newView);
//                        float x = motionEvent.getX(pointerindex);
//                        float y = motionEvent.getY(pointerindex);
//                        newView.setX(x - 100);
//                        newView.setY(y - 100);
//                        relativeLayout.addView(newView);


//                    }
//                    newView1 = new View(Gestures.this);
//                    newView1.setLayoutParams(new LinearLayoutCompat.LayoutParams(10, 10));
//                    newView1.setBackgroundColor(Color.BLUE);
//                    float x = motionEvent.getX();
//                    float y = motionEvent.getY();
//                    newView1.setX(x - 100);
//                    newView1.setY(y - 100);
//                    relativeLayout.addView(newView1);
//               / }
//                else if (motionEvent.getActionMasked() == MotionEvent.ACTION_UP) {

//                    relativeLayout.removeAllViews();
//                    relativeLayout.removeView(newView1);
//                    hashmap.remove(motionEvent.getPointerId(motionEvent.getActionIndex()));
//                }
//                return true;
//            }
//        });
//
//    }
    }

}
