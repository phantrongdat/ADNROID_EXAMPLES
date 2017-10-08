package info.trongdat.getmp3local;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Qui96hy on 8/22/2016.
 */
public class ListSongs extends AppCompatActivity implements AdapterView.OnItemLongClickListener,AdapterView.OnItemClickListener,View.OnClickListener{


    private ArrayList<Itemsong> lstsong;
    SongActivity songview;
    Myaddapter arrayAdapter;
    ListView lvsong;
    TextView txtTitleActivity,txtSingerActiviTy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_song);
        lvsong=(ListView)findViewById(R.id.listView);
        GetFile data=new GetFile();
        lstsong=data.arrayFile(this);
      arrayAdapter=new Myaddapter(this,android.R.layout.simple_list_item_1,lstsong);
        lvsong.setAdapter(arrayAdapter);
        songview=new SongActivity(this,lstsong);
        txtSingerActiviTy=(TextView)findViewById(R.id.txtviewTitleActivity);
        txtTitleActivity=(TextView)findViewById(R.id.txtviewSingerActivity);
        lvsong.setOnItemClickListener(this);
        lvsong.setOnItemLongClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        for
                (Itemsong itemSong : lstsong) {
            itemSong.setSelect(false);
        }
        lstsong.get(position).setSelect(true);
        arrayAdapter.notifyDataSetChanged();

        songview.loadSong(Uri.parse(lstsong.get(position).getData()));
        songview.setCurrentIndex(position );
        songview.startSong();
        txtTitleActivity.setText(lstsong.get(position).getTitle().toString());


    }
    @Override
    public void onClick(View v) {

    }



    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }
}
