package info.trongdat.recyclecardview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 3/24/15.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<ContactInfo> contactInfoList;

    public ContactAdapter(List<ContactInfo> contactList) {
        this.contactInfoList = contactList;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        ContactInfo contact = contactInfoList.get(position);
        holder.vName.setText(contact.name);
        holder.vSurname.setText(contact.suername);
        holder.vEmail.setText(contact.email);
        holder.vTitle.setText(contact.name + " " + contact.suername);

    }

    @Override
    public int getItemCount() {
        return contactInfoList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        protected TextView vName;
        protected TextView vSurname;
        protected TextView vEmail;
        protected TextView vTitle;

        public ContactViewHolder(View itemView) {
            super(itemView);
            vName = (TextView) itemView.findViewById(R.id.name_textview);
            vSurname = (TextView) itemView.findViewById(R.id.surname_textview);
            vEmail = (TextView) itemView.findViewById(R.id.email_textview);
            vTitle = (TextView) itemView.findViewById(R.id.title_textview);
        }
    }
}
