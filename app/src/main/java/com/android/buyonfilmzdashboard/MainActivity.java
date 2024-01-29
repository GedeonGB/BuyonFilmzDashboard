package com.android.buyonfilmzdashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    EditText editLink, editfcb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editLink = findViewById(R.id.editLink);
        editfcb = findViewById(R.id.editLinkfcb);
// ...
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void writeNewUser(String urltxt) {
        User user = new User(urltxt);
        mDatabase.child("Url").setValue(user);
    }

    public void toUplod(View view) {
        try {
            mDatabase.child("Live Games/Football ").setValue(editLink.getText().toString().trim());
            Toast.makeText(this, "Link uploaded for YouTube", Toast.LENGTH_SHORT).show();
            // writeNewUser(editLink.getText().toString().trim());
        } catch (Exception e) {
            Toast.makeText(this, "Error in Uploading... check internet Log", Toast.LENGTH_SHORT).show();
        }
    }

    public void toUplodfcb(View view) {
        try {
            mDatabase.child("Live event").setValue(editfcb.getText().toString().trim());
            Toast.makeText(this, "Link uploaded for BuyonFilmz Functions", Toast.LENGTH_SHORT).show();
            // writeNewUser(editLink.getText().toString().trim());
        } catch (Exception e) {
            Toast.makeText(this, "Error in Uploading... check internet Log", Toast.LENGTH_SHORT).show();
        }
    }

    @IgnoreExtraProperties
    public class User {
        public String username;

        public User() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public User(String username) {
            this.username = username;
        }
    }
}
