package markmoussa.me.deeptalkandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoiceActivity extends AppCompatActivity {

    protected Button helpButton;
    protected Button beHelpedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        helpButton = (Button) findViewById(R.id.helpButton);
        beHelpedButton = (Button) findViewById(R.id.beHelpedButton);

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent myIntent = new Intent(view.getContext(), LookingForCallerActivity.class); /** Class name here */
                Intent myIntent = new Intent(view.getContext(), CallerFoundActivity.class); /** Class name here */
                startActivity(myIntent);
            }
        });

        beHelpedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class); /** Class name here */
                startActivity(myIntent);
            }
        });


    }
}
