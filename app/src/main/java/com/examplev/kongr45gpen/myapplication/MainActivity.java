package com.examplev.kongr45gpen.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private boolean buttonPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG, "Activity was created!");

        final Button button = (Button) findViewById(R.id.button);
        final TextView text = (TextView) findViewById(R.id.textViewAbove);

        if (savedInstanceState != null) {
            boolean pressed = savedInstanceState.getBoolean("button_pressed");

            if (pressed) {
                buttonPressed = true;
                text.setText("App Wars (again)");
            }
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPressed = true;
                text.setText("App Wars");

                Toast bread = Toast.makeText(getApplicationContext(), "Congrats! You pressed the button!", Toast.LENGTH_SHORT);
                bread.show();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Beware!");
        builder.setMessage("Cards are getting stolen! Be sure yours is safe!");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast yes = Toast.makeText(getApplicationContext(), "You are now secure!", Toast.LENGTH_SHORT);
                yes.show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // ???
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.ic_something_else);
        mBuilder.setContentTitle("WARNING!");
        mBuilder.setContentText("Card thieves are active right now!");

        Notification notification = mBuilder.build();

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, notification);

        Button activityButton = (Button) findViewById(R.id.buttonActivity);
        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), YesNameActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.e(TAG, "MainActivity Paused");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean("button_pressed", buttonPressed);
    }
}







