package info.trongdat.readbook.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import info.trongdat.readbook.Entities.Book;
import info.trongdat.readbook.R;

/**
 * Created by Qui96hy on 10/2/2016.
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    Context mContext;
    ArrayList<Book> books = new ArrayList<>();

    public BookAdapter(Context context, ArrayList<Book> books) {
        this.mContext = context;
        this.books = books;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_1, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.bookName.setText(books.get(position).getBookName());
        Picasso.with(mContext).load("http://readbook.somee.com/" + books.get(position).getImageName()).
                into(holder.bookImage);

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void remove(int position) {
        books.remove(position);
        notifyItemRemoved(position);
    }

    public void add(Book book, int position) {
        books.add(position, book);
        notifyItemInserted(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {

        public TextView bookName;
        public ImageView bookImage;


        public ViewHolder(View itemView) {
            super(itemView);

            bookName = (TextView) itemView.findViewById(R.id.placeName);

            bookImage = (ImageView) itemView.findViewById(R.id.placeImage);

        }


    }
}

