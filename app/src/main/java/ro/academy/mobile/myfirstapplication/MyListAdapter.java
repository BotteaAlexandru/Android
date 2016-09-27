package ro.academy.mobile.myfirstapplication;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Alex on 9/27/2016.
 */

public class MyListAdapter extends ArrayAdapter<Note> {

    private final Context context;
    private final ArrayList<Note> myNotes;


    public MyListAdapter(Context context, int resource, List<Note> objects) {
        super(context, resource, objects);
        this.context = context;
        this.myNotes = (ArrayList<Note>) objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.note_view, parent, false);
        }

        Note currentNote = myNotes.get(position);

        TextView title = (TextView) view.findViewById(R.id.list_view_title);
        title.setText(currentNote.getTitle());

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("yyyy / MM / dd ");
        String strDate = "Current Date : " + mdformat.format(calendar.getTime());

        TextView date = (TextView) view.findViewById(R.id.list_view_date);
        date.setText(strDate);

        return view;
    }


}
