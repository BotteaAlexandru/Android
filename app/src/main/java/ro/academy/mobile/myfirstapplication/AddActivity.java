package ro.academy.mobile.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Alex on 9/25/2016.
 */

public class AddActivity extends AppCompatActivity implements View.OnClickListener{

    private Button saveNote;
    private TextView title;
    private TextView description;
    private TextView where;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        saveNote = (Button) findViewById(R.id.save_note_btn);
        saveNote.setOnClickListener(this);

        title = (TextView) findViewById(R.id.edit_title);
        description = (TextView) findViewById(R.id.edit_description);
        where = (TextView) findViewById(R.id.edit_where);

    }


    @Override
    public void onClick(View view) {

        if (title.getText().toString().length() == 0) {
            Toast.makeText(AddActivity.this,"Ouch! Title cannot be empty!",Toast.LENGTH_LONG).show();
            return;
        }

        openMainActivity();
    }

    private void openMainActivity() {
        Intent intent = new Intent();
        intent.putExtra("Title",title.getText().toString());
        intent.putExtra("Description",description.getText().toString());
        intent.putExtra("Where",where.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
