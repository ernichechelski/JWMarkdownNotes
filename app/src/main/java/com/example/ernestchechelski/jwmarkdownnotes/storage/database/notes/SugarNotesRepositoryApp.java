package com.example.ernestchechelski.jwmarkdownnotes.storage.database.notes;


import com.example.ernestchechelski.jwmarkdownnotes.storage.database.notes.domain.Note;
import com.orm.SugarApp;

/**
 * Created by ErnestChechelski on 09.09.2017.
 */

public class SugarNotesRepositoryApp extends SugarApp {
    @Override
    public void onCreate() {
        super.onCreate();

        Note.findById(Note.class, (long) 1);
    }
}