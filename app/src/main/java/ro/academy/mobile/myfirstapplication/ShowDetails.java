package ro.academy.mobile.myfirstapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialog;
import android.widget.TextView;

/**
 * Created by Alex on 9/28/2016.
 */
public class ShowDetails extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_details);

        Intent intent = getIntent();
        String descr = intent.getStringExtra("Description");
        String place = intent.getStringExtra("Where");
        TextView description = (TextView) findViewById(R.id.note_description);
        TextView where = (TextView) findViewById(R.id.note_where);

        description.setText(descr);
        where.setText(place);
    }
}
