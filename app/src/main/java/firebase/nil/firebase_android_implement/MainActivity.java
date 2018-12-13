package firebase.nil.firebase_android_implement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Firebase url;
    TextView tview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(this);

        url = new Firebase("https://fir-android-implement.firebaseio.com/Disc_List/0/Sub_Disc/5/sdName");


        tview = (TextView) findViewById(R.id.textView);



        url.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                tview.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



    }
}
