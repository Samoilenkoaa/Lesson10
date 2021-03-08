package com.example.lesson10.notedetails;

import androidx.annotation.NonNull;

import com.example.lesson10.NoteDataClass;

public interface NoteRepository {

    void setNote(NoteDataClass note);

    void onDeleteClicked(@NonNull String id);
}
