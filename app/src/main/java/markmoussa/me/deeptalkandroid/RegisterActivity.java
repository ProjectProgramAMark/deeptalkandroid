package markmoussa.me.deeptalkandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    protected EditText nameEditText;
    protected EditText phoneEditText;
    protected EditText emailEditText;
    protected Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        /* grab components */
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        phoneEditText = (EditText) findViewById(R.id.phoneEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        registerButton = (Button) findViewById(R.id.registerButton);

        String name = nameEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String email = emailEditText.getText().toString();

        final JSONObject req = new JSONObject();
        try {
            req.put("username", name);
            req.put("phone", phone);
            req.put("email", email);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        // Instantiate the RequestQueue.
        final RequestQueue queue = Volley.newRequestQueue(this);
        final String url ="http://localhost:6001/register";


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Request a string response from the provided URL.
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, req,
                        new Response.Listener<JSONObject>(){
                            public void onResponse(JSONObject response) {
                                // read response to see if it was succcessful
                                System.out.println("We got a response!");
                                try {
                                    JSONArray jsonArray = response.getJSONArray("re");
                                }
                                catch(JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }
                );
                queue.add(jsonObjectRequest);

            }
        });



        Button testVeriButton = (Button) findViewById(R.id.testVeriButton);
        testVeriButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchToRegisterActivity = new Intent(RegisterActivity.this, VerificationActivity.class);
                switchToRegisterActivity.putExtra("phone_number", phoneEditText.getText().toString());
                startActivity(switchToRegisterActivity);
            }
        });
    }
}