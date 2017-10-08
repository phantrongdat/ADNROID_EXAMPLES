package vn.dat.contacts;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alone on 05/06/2016.
 */
public class AdapterContact extends ArrayAdapter<Contact> {
    Activity context;
    ArrayList<Contact> contacts;
    int resource;

    public AdapterContact(Activity context, int resource, ArrayList<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.contacts = objects;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(resource, null);

        ImageView imgContact = (ImageView) view.findViewById(R.id.imgContact);
        TextView txtName = (TextView) view.findViewById(R.id.txtName);

        txtName.setText(contacts.get(position).getName());

        Bitmap bitmap = BitmapFactory.decodeByteArray(contacts.get(position).getImage(), 0, contacts.get(position).getImage().length);
        imgContact.setImageBitmap(bitmap);

        return view;
    }
}
