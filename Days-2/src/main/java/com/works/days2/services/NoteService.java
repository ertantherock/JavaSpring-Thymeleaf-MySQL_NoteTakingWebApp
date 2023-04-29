package com.works.days2.services;

import com.works.days2.props.Notes;
import com.works.days2.props.User;
import com.works.days2.utils.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NoteService {

    public List<Notes> getNotes(){

        List<Notes> notes = new ArrayList<>();
        DB db = new DB();

        try {
          String sql = "select * from notes order by nid desc ";
          PreparedStatement pre = db.connect().prepareStatement(sql);
          ResultSet rs = pre.executeQuery();

          while (rs.next()){
              Notes notes1 = new Notes();
              notes1.setNid(rs.getInt("nid"));
              notes1.setNote(rs.getString("note"));
              notes1.setNoteTitle(rs.getString("noteTitle"));
              notes.add(notes1);
          }


        }catch (Exception ex){
            System.err.println("getNotes Error" + ex);

        }finally {
            db.close();
        }



        return notes;
    }

    public int noteSave(Notes notes) {
        int status = 0;
        DB db = new DB();
        try {
            String sql = "INSERT INTO notes (nid,note,noteTitle) VALUES (NULL, ?, ?)";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setString(1, notes.getNote());
            pre.setString(2, notes.getNoteTitle());

            status = pre.executeUpdate();
        } catch (Exception ex) {
            System.err.println("noteSave Error : " + ex);
        } finally {
            db.close();
        }
        return status;
    }

    public boolean deleteNote(int nid){
        DB db = new DB();
        boolean success = false;
        try {
            String sql = "delete from notes where nid = ?";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setInt(1,nid);
            int rowsAffected = pre.executeUpdate();

            if (rowsAffected > 0){
                success = true;
            }

        }catch (Exception ex){
            System.err.println("deleteNote" + ex);
        }finally {
            db.close();
        }


        return success;

    }
}
