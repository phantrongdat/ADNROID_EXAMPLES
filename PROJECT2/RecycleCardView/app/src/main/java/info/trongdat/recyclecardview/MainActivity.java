package info.trongdat.recyclecardview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cardList);
        recyclerView.setHasFixedSize(true);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        ContactAdapter contactAdapter = new ContactAdapter(createList(10));
        recyclerView.setAdapter(contactAdapter);

//        ItemClickSupport.addTo(recyclerView)
//                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
//                    @Override
//                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
//                        // do it
//                        Toast.makeText(MainActivity.this,position+"here!", Toast.LENGTH_LONG).show();
//                    }
//                });

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), new   RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // TODO Handle item click
                        Toast.makeText(MainActivity.this,position+"!", Toast.LENGTH_LONG).show();
                    }
                })
        );
    }

    private List<ContactInfo> createList(int size) {
        List<ContactInfo> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ContactInfo contact = new ContactInfo();
            contact.name = ContactInfo.NAME_PREFIX + i;
            contact.suername = ContactInfo.SUERNAME_PREFIX + i;
            contact.email = ContactInfo.EMAIL_PREFIX + i + "@test.com";

            result.add(contact);
        }
        return result;
    }


}
