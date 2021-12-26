package com.example.mytryrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    private final ArrayList<Note> notes = new ArrayList<>();
    private NotesAdapter adapter;
//    private NotesDBHelper dbHelper;
//    SQLiteDatabase database;

    private NotesDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = NotesDatabase.getInstance(this);
        recyclerViewNotes = findViewById(R.id.rescyclerViewNotes);
//        dbHelper = new NotesDBHelper(this);
//        database = dbHelper.getWritableDatabase();
//        getData();
                adapter = new NotesAdapter(notes);
        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewNotes.setAdapter(adapter);
        getData();
        adapter.setOnNoteClickListener(new NotesAdapter.OnNoteClickListener() {
            @Override
            public void onNoteClick(int position) {
                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(int position) {
                remove(position);
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                remove(viewHolder.getAdapterPosition());
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerViewNotes);
    }

    private void remove(int position) {
        Note note = notes.get(position);
        database.notesDao().deleteNote(note);

//        int id = notes.get(position).getId();
//        String where = NotesContract.NotesEntry._ID + " = ?";
//        String[] whereArgs = new String[]{Integer.toString(id)};
//        database.delete(NotesContract.NotesEntry.TABLE_NAME, where, whereArgs);
//        getData();
        adapter.notifyDataSetChanged();
    }

    public void onClickAddNote(View view) {
        Intent intent = new Intent(this, AddNoteActivity.class);
        startActivity(intent);
    }

    private void getData(){

        List<Note> notesFromDB = database.notesDao().getAllNotes();
        notes.clear();
        notes.addAll(notesFromDB);
    }




//    private void getData() {
//        notes.clear();
//        String selection = NotesContract.NotesEntry.COLUMN_DAY_OF_WEEK + " == ?";
//        String[] selectionArgs = new String[]{"1"};
//        Cursor cursor = database.query(NotesContract.NotesEntry.TABLE_NAME,null,selection, selectionArgs, null, null, NotesContract.NotesEntry.COLUMN_PRIORITY);
//        while (cursor.moveToNext()) {
//            int id = cursor.getInt(cursor.getColumnIndex(NotesContract.NotesEntry._ID));
//            String title = cursor.getString(cursor.getColumnIndex(NotesContract.NotesEntry.COLUMN_TITLE));
//            String description = cursor.getString(cursor.getColumnIndex(NotesContract.NotesEntry.COLUMN_DESCRIPTION));
//            int dayOfWeek = cursor.getInt(cursor.getColumnIndex(NotesContract.NotesEntry.COLUMN_DAY_OF_WEEK));
//            int priority = cursor.getInt(cursor.getColumnIndex(NotesContract.NotesEntry.COLUMN_PRIORITY));
//            Note note = new Note(id, title, description, dayOfWeek, priority);
//            notes.add(note);
//        }
//        cursor.close();
//    }
}
