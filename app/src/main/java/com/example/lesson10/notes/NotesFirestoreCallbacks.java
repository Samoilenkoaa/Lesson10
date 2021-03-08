package com.example.lesson10.notes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lesson10.NoteDataClass;

import java.util.List;

public interface NotesFirestoreCallbacks {

    void onSuccessNotes(@NonNull List<NoteDataClass> items);
    void onErrorNotes(@Nullable String message);
}