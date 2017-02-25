package markmoussa.me.deeptalkandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/* for dialog box */
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;


public class CallerFoundActivity extends AppCompatActivity {

    protected Button answerCall;
    protected Button declineCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caller_found);

        answerCall = (Button) findViewById(R.id.answerCall);
        answerCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acceptCall();
            }
        });

        declineCall = (Button) findViewById(R.id.declineCall);
        declineCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                declineCall();
            }
        });
    }

    @Override
    public void onBackPressed() {
        declineCall();
    }

    private void acceptCall() {

    }

    private void declineCall() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Are you sure you want to go back? Leaving will end the call.");
        builder1.setCancelable(false);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent goBackIntent = new Intent(CallerFoundActivity.this, ChoiceActivity.class);
                        startActivity(goBackIntent);
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
