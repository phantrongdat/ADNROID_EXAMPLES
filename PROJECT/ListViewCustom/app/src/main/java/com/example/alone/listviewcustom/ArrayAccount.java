package com.example.alone.listviewcustom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Alone on 03/16/2016.
 */
public class ArrayAccount extends ArrayAdapter {

    public ArrayAccount(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public ArrayAccount(Context context, int resource) {
        super(context, resource);
    }

    public ArrayAccount(Context context, int resource, List<Account> objects) {
        super(context, resource, objects);
    }
    public View getView(int position,View convertView,ViewGroup parent)
    {
        View v=convertView;
        if (v!=null)
        {
            LayoutInflater vi;
            vi=LayoutInflater.from(getContext());
            v=vi.inflate(R.layout.custom_list_account,null);
        }

        Account a= (Account) getItem(position);
        if (a!=null)
        {
            TextView user=(TextView) v.findViewById(R.id.txtUser);
            TextView password=(TextView) v.findViewById(R.id.txtPassword);
            TextView lastModify=(TextView) v.findViewById(R.id.txtLastmodify);

            user.setText(a.user);
            password.setText(a.pass);
            lastModify.setText(a.lastModify);
        }

        return v;
    }
}
