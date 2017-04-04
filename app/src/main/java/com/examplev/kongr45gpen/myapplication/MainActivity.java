package com.examplev.kongr45gpen.myapplication;

// All our class's imports, they should be automatically added by Android Studio
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
    // A tag that identifies our activity and will be shown in our app's logs
    private static final String TAG = "MainActivity";

    // Whether the button was pressed or not, used to store the information so that our selection
    // doesn't get lost when the activity pauses (e.g. when our phone is rotated)
    private boolean buttonPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add an [e]rror message to the logs
        Log.e(TAG, "Activity was created!");

        // Get the button and the textView from our layout
        // `final` means that these variables will not point to a different object in the future,
        // and it's necessary for the listeners below, otherwise Java will complain
        final Button button = (Button) findViewById(R.id.button);
        final TextView text = (TextView) findViewById(R.id.textViewAbove);

        // If we have a saved instance state, use it to restore our textView's value
        if (savedInstanceState != null) {
            boolean pressed = savedInstanceState.getBoolean("button_pressed");

            if (pressed) {
                buttonPressed = true;
                text.setText("App Wars (again)");
            }
        }

        // When the button is pressed:
        // 1. Change the content of the textView
        // 2. Show a toast
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPressed = true;
                text.setText("App Wars");

                Toast bread = Toast.makeText(getApplicationContext(), "Congrats! You pressed the button!", Toast.LENGTH_SHORT);
                bread.show();
            }
        });

        // Show a dialog with two buttons to the user
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
                // Do nothing
            }
        });

        // Build our dialog and show it
        AlertDialog dialog = builder.create();
        dialog.show();

        // Use the same process to build a notification and show it to the user
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.ic_something_else); // To create a new image: File > New > Image Asset > Icon Type: Notification icons
        mBuilder.setContentTitle("WARNING!");
        mBuilder.setContentText("Card thieves are active right now!");

        Notification notification = mBuilder.build();

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, notification);

        // Store the activity button as a variable
        Button activityButton = (Button) findViewById(R.id.buttonActivity);
        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and move to a different activity
                Intent intent = new Intent(getApplicationContext(), YesNameActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Log an [i]nfo message each time our activity pauses
        Log.i(TAG, "MainActivity Paused");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Store whether the button was pressed or not, so that this can be restored when
        // our activity is opened again.
        outState.putBoolean("button_pressed", buttonPressed);
    }
}

// Useful links:
//         https://developer.android.com/
//         https://material.io/


