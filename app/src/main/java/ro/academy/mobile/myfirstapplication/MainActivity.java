package ro.academy.mobile.myfirstapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * If either the MAIN action or LAUNCHER category are not declared for one of your activities, then your app icon will
 * not appear in the Home screen's list of apps.
 * An application can have one or more activities without any restrictions. Every activity you define for your
 * application must be declared in your AndroidManifest.xml file and the main activity for your app must be declared
 * in the manifest with an <intent-filter> that includes the MAIN action and LAUNCHER category
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button addNote;
    private TextView textView;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs";

    private List<Note> myNotes = new ArrayList<Note>();

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //An activity class loads all the UI component using the XML file available in res/layout folder of the project.
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");

        textView = (TextView) findViewById(R.id.notes);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    }

    private void addNotestoListview() {

        ArrayAdapter<Note> arrayAdapter = new MyListAdapter(MainActivity.this, R.layout.note_view, myNotes);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);
    }

    private void openAddActivity() {
        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1)
            if (resultCode == RESULT_OK) {

                Log.d(TAG, "onActivityResult");
                ((MyNotesApp) this.getApplication()).increaseNotesNumber();

                myNotes.add(new Note(data.getStringExtra("Title"), data.getStringExtra("Description"), data.getStringExtra("Where")));

                SharedPreferences.Editor editor = sharedpreferences.edit();

//                editor.putString(Title, )

            }
    }

    /**
     * Called when the activity is about to become visible.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    /**
     * Called when the activity has become visible.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");

        if (myNotes.size() == 0)
            textView.setText("You have 0 Notes.");
        else
            textView.setText("You have " + myNotes.size() + " notes.");

        addNote = (Button) findViewById(R.id.add_note_btn);
        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onclick");
                openAddActivity();
            }
        });

        addNotestoListview();
        showDetailsOfNote();
    }



    /**
     * Called when another activity is taking focus.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    /**
     * Called when the activity is no longer visible.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    /**
     * Called just before the activity is destroyed.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    private void showDetailsOfNote() {
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Note currentNote = myNotes.get(position);
                //Toast.makeText(MainActivity.this, currentNote.toString(), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, ShowDetails.class);
                intent.putExtra("Description", currentNote.getDescription());
                intent.putExtra("Where", currentNote.getWhere());
                startActivity(intent);
            }
        });
    }


}
