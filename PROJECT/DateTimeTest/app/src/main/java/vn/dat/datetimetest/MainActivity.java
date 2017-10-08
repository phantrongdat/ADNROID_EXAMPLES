package vn.dat.datetimetest;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    NoteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new NoteDatabase(this);
        TextView txtDisplay=(TextView)findViewById(R.id.text);
//        db.execute("INSERT INTO datetime VALUES('04/25/2016','17:50','Men do')");
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy, hh:mm a");
        String date = sdf.format(new Date());

        txtDisplay.setText(date);
        db.execute("INSERT INTO datetime VALUES('" + date + "')");


        Cursor c=db.rawQuery("SELECT * FROM datetime");
        c.moveToFirst();
        Date d=new Date(c.getLong(0));
        Toast.makeText(MainActivity.this, d + "", Toast.LENGTH_SHORT).show();
//        while (c.moveToNext())
//        {
//
//        }
    }

}
