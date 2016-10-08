package com.example.hp.firstandroidapp_afternoonclass;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ontouchlistener extends Activity {
    public ImageView rc;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView picture;
        picture = (ImageView) findViewById(R.id.rc);

        final TextView tv1 = (TextView) findViewById(R.id.textView7);
        final TextView tv2 = (TextView) findViewById(R.id.textView8);
        final TextView tv3 = (TextView) findViewById(R.id.textView9);
        final TextView tv4 = (TextView) findViewById(R.id.textView10);
        final TextView tv5 = (TextView) findViewById(R.id.textView11);
        final TextView tv6 = (TextView) findViewById(R.id.textView12);

        picture.setOnTouchListener(new View.OnTouchListener() {
            float x,y,x1,y1;
            @Override
            public boolean onTouch(View v, MotionEvent e) {

                String actionX = "", actionY = "";
                String quadrant = "";

                switch (e.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = e.getX();
                        y = e.getY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        float X = picture.getRight()/2;
                        float Y = picture.getBottom()/2;

                        x1=e.getX();
                        y1=e.getY();

                        actionX = "";
                        actionY = "";
                        quadrant = "";

                        if (x<x1){
                            actionX = "Swiped right. ";
                        }
                        if (x>x1){
                            actionX = "Swiped left. ";
                        }
                        if (y<y1){
                            actionY = "Swiped down. ";
                        }
                        if (y>y1)
                        {
                            actionY = "Swiped up. ";
                        }

                        if(x1>X && y1>Y){
                            quadrant = "Quadrant 4";
                        }
                        if(x1<X && y1>Y){
                            quadrant = "Quadrant 3";
                        }
                        if(x1<X && y1<Y){
                            quadrant = "Quadrant 2";
                        }
                        if(x1>X && y1<Y){
                            quadrant = "Quadrant 1";
                        }

                        tv1.setText("X1, X2: " + x + ", " + x1);
                        tv2.setText("Y1, Y2: " + y + ", " + y1);
                        tv3.setText("X1-X2: " + (Math.abs(x1-x)));
                        tv4.setText("Y1-Y2:" + (Math.abs(y1-y)));
                        tv5.setText("ACTION: " + actionX + actionY);
                        tv6.setText("QUADRANT: " + quadrant );

                }
                return  true;
            }

        });


    }
    @Override
    protected  void onPause(){
        super.onPause();
      //  finish();
    }
}


/** final TextView txt1 = (TextView) findViewById(R.id.textView7);
 final TextView txt2 = (TextView) findViewById(R.id.textView8);
 final TextView txt3 = (TextView) findViewById(R.id.textView9);
 final TextView txt4 = (TextView) findViewById(R.id.textView10);
 final TextView txt5 = (TextView) findViewById(R.id.textView11);
 final TextView txt6 = (TextView) findViewById(R.id.textView12);


 rc.setOnTouchListener(new View.OnTouchListener() {

     float x1, x2;
     float y1, y2;

     @Override
     public boolean onTouch(View v, MotionEvent motionEvent) {
         String quadrant = "";
         String X1 = "", Y2 = "";

         switch (motionEvent.getAction()) {
             case MotionEvent.ACTION_DOWN: {
                 x1 = motionEvent.getX();
                 y1 = motionEvent.getY();
                 Toast.makeText(getBaseContext(), "x1=" + x1 + "y1=" + y1, Toast.LENGTH_SHORT).show();
                 break;
             }

             case MotionEvent.ACTION_UP: {
                 float xx= rc.getRight()/2;
                 float yy= rc.getBottom()/2;
                 x2 = motionEvent.getX();
                 y2 = motionEvent.getX();

                 if (x1 < x2) {
                     Toast.makeText(getBaseContext(), "SWIPE LEFT to Right x2=" + x2 + "y2=" + y2, Toast.LENGTH_SHORT).show();
                 }
                 if (x1 > x2) {
                     Toast.makeText(getBaseContext(), "SWIPE RIGHT to Left=" + x2 + "y2=" + y2, Toast.LENGTH_SHORT).show();
                 }
                 if (y1 < y2) {
                     Toast.makeText(getBaseContext(), "SWIPE UP to Bottom=" + x2 + "y2=" + y2, Toast.LENGTH_SHORT).show();
                 }
                 if (y1 > y2) {
                     Toast.makeText(getBaseContext(), "SWIPE BOTTOM to UP=" + x2 + "y2=" + y2, Toast.LENGTH_SHORT).show();
                 }



                 if(x2<xx && y2>yy){
                     quadrant = "Quadrant III";
                 }
                 if(x2<xx && y2<yy){
                     quadrant = "Quadrant II";
                 }
                 if(x2>xx && y2<yy){
                     quadrant = "Quadrant I";
                 }
                 if(x2>xx && y2>yy){
                     quadrant = "Quadrant IV";

                 }
                 txt1.setText("x1, x2: " + x1 + ", " + x2);
                 txt2.setText("y1, y2: " + y1 + ", " + y2);
                 txt3.setText("x1-x2: " + (Math.abs(x2-x1)));
                 txt4.setText("Y1-Y2:" + (Math.abs(y2-y1)));
                 txt5.setText("ACTION: " + X1 + Y2);
                 txt6.setText("QUADRANT: " + quadrant );
             }

         }
         return false;
     }

 });
}


}


*/

