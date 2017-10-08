package com.trongdat.subject2review;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.trongdat.subject2review.Entities.Subject;

import java.util.ArrayList;

public class SubTest1 extends AppCompatActivity {
    ListView lstSubject;
    ArrayList<Subject> subjects;
    ArrayAdapter<Subject> adapter;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_test1);
        db = new DatabaseHandler(this);
        initialize();
        loadSubjects();
    }

    public void initialize() {
        lstSubject = (ListView) findViewById(R.id.lstSubject);
        subjects = new ArrayList<>();
        adapter = new ArrayAdapter<Subject>(this, android.R.layout.simple_list_item_1, subjects);
        lstSubject.setAdapter(adapter);
        lstSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SubTest1.this, SubTest1View.class);
                intent.putExtra("id", subjects.get(i).getId());
                intent.putExtra("name", subjects.get(i).getSubjectName());
                startActivity(intent);
            }
        });
    }

    public void loadSubjects() {
        Cursor cursor = db.rawQuery("SELECT * FROM tblBaiHoc");
        while (cursor.moveToNext()) {
            Subject subject = new Subject();
            subject.setId(cursor.getInt(0)).setSubjectName(cursor.getString(1));
            subjects.add(subject);
        }
        adapter.notifyDataSetChanged();
    }

}
