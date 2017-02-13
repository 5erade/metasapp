package danilk.metasapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import io.doorbell.android.Doorbell;

/**
 * Created by dan on 1/25/16.
 */
public class DoorbellDialogActivity extends Activity {

    public DoorbellDialogActivity() {
        // Require/d empty public constructor
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        // Inflate the layout for this fragment
         super.onCreate(savedInstanceState);
        //setContentView(R.layout.doorbell_layout);

        Doorbell doorbellDialog = new Doorbell(this, 3034, "j8YJcxnxjkp8nkg9fjNZfgJyFBKIjwwz51PmBc5rtuI8Al0KcrRROL7YovXXsp2I");

        doorbellDialog.setPoweredByVisibility(View.GONE); // Hide the "Powered by Doorbell.io" text
        doorbellDialog.setMessageHint("What would you like to tell?");
        doorbellDialog.setPositiveButtonText("Send");
        doorbellDialog.setNegativeButtonText("Dismiss");
        doorbellDialog.setEmailHint("E-mail is optional");
        //doorbellDialog.setEmailVisibility(View.GONE); // Hide the email field, since we've filled it in already

        doorbellDialog.setOnFeedbackSentCallback(new io.doorbell.android.callbacks.OnFeedbackSentCallback() {
            @Override
            public void handle(String message) {
                Toast.makeText(getApplicationContext(), "Thanks!", Toast.LENGTH_LONG).show();
            }
        });

        doorbellDialog.show();
    }
}
