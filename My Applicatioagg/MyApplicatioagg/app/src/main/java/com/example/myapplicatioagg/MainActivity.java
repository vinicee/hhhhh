package com.example.myapplicatioagg;
import androidx.appcompat.app.AppCompatActivity;import android.os.Bundle;import android.view.Gravity;import android.view.MotionEvent;import android.view.View;import android.widget.Button;import android.widget.ImageView;import android.widget.LinearLayout;import android.widget.TextView;import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private TextView windowSerch;
    private float x;
    private float y;
    private String sDown;
    private String sMove;
    private String sUp;
    private float xCat = 500;
    private float yCat = 500;
    private float deltaCat = 50;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        windowSerch = findViewById(R.id.coordinatesOut);

        windowSerch.setOnTouchListener(listener);
    }

    private View.OnTouchListener listener = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {


            x = motionEvent.getX();
            y = motionEvent.getY();


            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    sDown = "Касание экрана по координатам x = " + x + ", y = " + y;
                    sMove = "";
                    sUp = "";
                    break;
                case MotionEvent.ACTION_MOVE:
                    sMove = "Вождение пальцем по координатам  X = " + x + ", y = " + y;
                    break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    sUp = "Отпускание экрана по координатам X = " + x + ",  y = " + y;
                    if (x < (xCat + deltaCat) && x > (xCat - deltaCat) && y < (yCat + deltaCat) && x > (yCat - deltaCat)) {
                        Toast toast = Toast.makeText(getApplicationContext(), R.string.cat_search, Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.LEFT, (int) xCat - 100, (int) yCat - 250);

                        LinearLayout linearLayout = (LinearLayout) toast.getView();
                        ImageView imageCat = new ImageView(getApplicationContext());
                        imageCat.setImageResource(R.drawable.found_cat);
                        linearLayout.addView(imageCat, 1);

                        toast.show();

                    }
            }
            break;

            windowSerch.setText(sDown + "\n" + sMove + "\n" + sUp);
            return true;
        }
    };
}