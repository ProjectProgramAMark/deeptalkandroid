package markmoussa.me.deeptalkandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.support.v7.app.*;
import android.content.*;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VerificationActivity extends AppCompatActivity {

    /* Declare components */
    protected EditText verificationCodeText;
    protected Button verificationButton;

    protected String passedPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        passedPhoneNumber = getIntent().getStringExtra("phone_number");

        /* grab components */
        verificationCodeText = (EditText) findViewById(R.id.codeText);
        verificationButton = (Button) findViewById(R.id.verificationButton);

        /* verification button click */
        verificationButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                /* Send JSON request to Authy */

                String codeTextString = verificationCodeText.getText().toString();
                if(codeTextString.equalsIgnoreCase("123")) {
                    Toast.makeText(getApplicationContext(),
                            "You have been verified! Thank you for registering :)", Toast.LENGTH_SHORT)
                            .show();
                    Intent myIntent = new Intent(view.getContext(), ChoiceActivity.class);
                    startActivity(myIntent);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Incorrect verification code", Toast.LENGTH_SHORT)
                            .show();
                }
            }

        });
    }

    public void sendVerification() {
        // Request a string response from the provided URL.

        String authyUrl = "https://api.authy.com/protected/json/phones/verification/start";
        final String apiKey = "ulLF6H51SrIMjMtgD3F1RfhG9JG08ejk";

        JSONObject req = new JSONObject();
        try {
            req.put("api_key", apiKey);
            req.put("via", "sms");
            req.put("country_code", "+1");
            req.put("phone_number", passedPhoneNumber);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, authyUrl, req,
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
    }

    /*
    @Override
    public void onBackPressed() {
        // Should we even override this? Maybe only allow the user to resend the code from this screen.
    }
    */

}
