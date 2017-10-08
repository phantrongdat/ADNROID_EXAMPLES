package info.trongdat.camnangamthuc.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;

import info.trongdat.camnangamthuc.activities.ChiTietMonAn;
import info.trongdat.camnangamthuc.R;
import info.trongdat.camnangamthuc.model.MonAn;

public class MonAnAdapter extends ArrayAdapter<MonAn> {
    Context context = null;
    ArrayList<MonAn> list = new ArrayList<>();
    int layoutId;


    public MonAnAdapter(Context context, int resource, ArrayList<MonAn> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutId = resource;
        this.list = objects;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        final ViewHolder viewHolder;
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.custom_item_mon_an, null);
            viewHolder = new ViewHolder();
            viewHolder.txtTenMon = (TextView) rowView.findViewById(R.id.txtTenMon);
            viewHolder.txtChiTiet = (TextView) rowView.findViewById(R.id.txtChiTiet);
            viewHolder.imgAnh = (ImageView) rowView.findViewById(R.id.imgAnh);
            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final MonAn monAn = list.get(position);
        viewHolder.txtTenMon.setText(monAn.getTen());
        viewHolder.txtChiTiet.setText(monAn.getChiTiet());
        String image = monAn.getAnh();
        if (monAn.getAnh().indexOf("NULL") == 0)
            image = monAn.getAnh().substring(4, monAn.getAnh().length());
        Picasso.with(context).load(image).resize(500, 500).transform(new RoundedCornersTransformation(100, 0)).into(viewHolder.imgAnh);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, ChiTietMonAn.class);
                in.putExtra("MonAn", monAn);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(in);
            }
        });

        return rowView;

    }

    static class ViewHolder {
        TextView txtTenMon, txtChiTiet;
        ImageView imgAnh;
    }

    public class RoundedCornersTransformation implements Transformation {
        private final int radius;
        private final int margin;

        public RoundedCornersTransformation(final int radius, final int margin) {
            this.radius = radius;
            this.margin = margin;
        }

        @Override
        public Bitmap transform(final Bitmap source) {
            final Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setShader(new BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));

            Bitmap output = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);
            canvas.drawRoundRect(new RectF(margin, margin, source.getWidth() - margin, source.getHeight() - margin), radius, radius, paint);

            if (source != output) {
                source.recycle();
            }

            return output;
        }

        @Override
        public String key() {
            return "rounded(radius=" + radius + ", margin=" + margin + ")";
        }
    }

    public static Bitmap getRoundedCornerImage(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = 100;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;

    }


}
