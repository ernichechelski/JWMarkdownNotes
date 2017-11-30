package com.example.ernestchechelski.jwmarkdownnotes.storage.database.notes;


import com.example.ernestchechelski.jwmarkdownnotes.storage.database.notes.domain.Note;

import java.util.List;

/**
 * Created by ErnestChechelski on 09.09.2017.
 */

public interface NotesRepository {

    public Note getNote(Long id);

    public Note createBlankNote();

    public void deleteNote(Note note);

    public void saveNote(Note note);


    public List<Note> getNotes();

}
