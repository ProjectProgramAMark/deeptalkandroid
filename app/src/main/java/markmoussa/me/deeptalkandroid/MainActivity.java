package markmoussa.me.deeptalkandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switchToChooseActivity = new Intent(MainActivity.this, ChoiceActivity.class);
                startActivity(switchToChooseActivity);
            }
        });

        Button registerButtonMain = (Button) findViewById(R.id.registerButtonMain);
        registerButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Do some shit
                Intent switchToRegisterActivity = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(switchToRegisterActivity);
            }
        });
    }
}
