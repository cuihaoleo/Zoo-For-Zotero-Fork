package me.cvhc.zooforzotero.LibraryActivity.Notes

import me.cvhc.zooforzotero.ZoteroAPI.Model.Note

interface NoteInteractionListener {
    fun deleteNote(note: Note)
    fun editNote(note: Note)
}