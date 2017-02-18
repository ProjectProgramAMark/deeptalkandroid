package markmoussa.me.deeptalkandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        // Getting references to view
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
        EditText phoneEditText = (EditText) findViewById(R.id.phoneEditText);
        EditText emailEditText = (EditText) findViewById(R.id.emailEditText);
        String name = nameEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String email = emailEditText.getText().toString();

        Button registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Do some shit here

            }
        });

    }
}
