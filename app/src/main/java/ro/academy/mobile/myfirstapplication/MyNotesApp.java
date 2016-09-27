package ro.academy.mobile.myfirstapplication;

import android.app.Application;

/**
 * Created by Alex on 9/25/2016.
 */

public class MyNotesApp extends Application {

    private int notesNumber;


    public int getNotesNumber() {
        return this.notesNumber;
    }

    public void increaseNotesNumber() {
        this.notesNumber++;
    }


}
