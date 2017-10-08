package info.hungmanh.readbook.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

import info.hungmanh.readbook.BookDetail;
import info.hungmanh.readbook.Entities.Book;
import info.hungmanh.readbook.R;

/**
 * Created by Qui96hy on 10/2/2016.
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    Context mContext;
    ArrayList<Book> books = new ArrayList<>();
    private LayoutInflater mInflater;

    public BookAdapter(Context context, ArrayList<Book> books) {
        this.mContext = context;
        this.books = books;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_book_1, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Book current = books.get(position);
        holder.bookName.setText(books.get(position).getBookName());
        final String img = books.get(position).getImageName();
//        Uri uri=Uri.parse(img);
        if (img.contains("http")) {
            Picasso.with(mContext).load(img).
                    placeholder(R.drawable.book_placeholder).
                    error(R.drawable.book_error).
                    into(holder.bookImage);
        } else {
            Picasso.with(mContext).load(new File(img)).
                    placeholder(R.drawable.book_placeholder).
                    error(R.drawable.book_error).
                    into(holder.bookImage);
        }


        holder.bookImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(mContext, BookDetail.class);
                in.putExtra("Book", current);
                if (img.contains("http"))
                    in.putExtra("online",true);
                else
                    in.putExtra("online",false);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(in);

            }
        });
        holder.bookName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(mContext, BookDetail.class);
                in.putExtra("Book", current);
                if (img.contains("http"))
                    in.putExtra("online",true);
                else
                    in.putExtra("online",false);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(in);
            }
        });

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

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView bookName;
        public ImageView bookImage;


        public ViewHolder(View itemView) {
            super(itemView);

            bookName = (TextView) itemView.findViewById(R.id.placeName);

            bookImage = (ImageView) itemView.findViewById(R.id.placeImage);

        }


    }
}

