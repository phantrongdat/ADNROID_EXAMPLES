package vn.dat.databasecreate;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteHandler db;
    Button btnCreateDB;
    EditText edtName;
    String path = "/data/data/vn.dat.databasecreate/databases/";
    ArrayList<String> dbList;
    ArrayAdapter adapter;
    ListView lstDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        edtName = (EditText) findViewById(R.id.edtDatabaseName);

        btnCreateDB = (Button) findViewById(R.id.btnCreateDatabase);
        btnCreateDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDatabase(edtName.getText().toString());
            }
        });

        lstDatabase = (ListView) findViewById(R.id.lstDatabase);
        loadDatabase();
    }

    public void createDatabase(String name) {
        db = new SQLiteHandler(this, name, null, 2);

        loadDatabase();
    }

    public void loadDatabase() {
        File dbFile = new File(path);
        String[] list = dbFile.list();

        dbList = new ArrayList<String>();
        if (list != null)
            for (String dbname : list)
                dbList.add(dbname);

        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, dbList);

        lstDatabase.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
