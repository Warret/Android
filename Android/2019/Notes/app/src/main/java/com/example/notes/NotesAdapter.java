package com.example.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private ArrayList<Note> notes;

    public NotesAdapter(ArrayList<Note> notes)   {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_iteme, parent, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.textViewTitle.setText((note.getTitle()));
        holder.textViewDescription.setText((note.getDescription()));
        holder.textViewOfWeek.setText((note.getDayOfWeek()));
        holder.textViewPriority.setText((String.format("%s",note.getPriority())));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }



    class NotesViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewTitle;
        private TextView textViewDescription;
        private TextView textViewOfWeek;
        private TextView textViewPriority;

        public NotesViewHolder(@NonNull View itemView) {   //NotesViewHolder содержит все видимые части (Заметки)
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewOfWeek = itemView.findViewById(R.id.textViewOfWeek);
            textViewPriority = itemView.findViewById(R.id.textViewPriority);
        }
    }
}
