package info.trongdat.getmp3local;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Qui96hy on 8/22/2016.
 */
public class Myaddapter extends ArrayAdapter<Itemsong> {
    private ArrayList<Itemsong> arrData;
    private LayoutInflater inflater;

    public Myaddapter(Context context, int resource, ArrayList<Itemsong> data) {
        super(context, resource, data);
        arrData = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null) {
            convertView = inflater.inflate(R.layout.adapterview, parent, false);
            TextView txttitle = (TextView) convertView.findViewById(R.id.txtTile);
            TextView txtsinger = (TextView) convertView.findViewById(R.id.txtsinger);

            txttitle.setEnabled(true);
            ViewHoder viewHoder = new ViewHoder();
            viewHoder.tvTitle = txttitle;
            viewHoder.tvArtist = txtsinger;

            convertView.setTag(viewHoder);
            viewHoder.tvTitle.setText(arrData.get(position).getTitle());
            viewHoder.tvArtist.setText(arrData.get(position).getArtist());

        }

        return convertView;
    }

}
