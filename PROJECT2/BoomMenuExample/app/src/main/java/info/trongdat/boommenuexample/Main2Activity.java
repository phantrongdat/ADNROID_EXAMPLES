package info.trongdat.boommenuexample;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.Types.BoomType;
import com.nightonke.boommenu.Types.ButtonType;
import com.nightonke.boommenu.Types.ClickEffectType;
import com.nightonke.boommenu.Types.DimType;
import com.nightonke.boommenu.Types.OrderType;
import com.nightonke.boommenu.Types.PlaceType;
import com.nightonke.boommenu.Util;

import java.util.Random;

public class Main2Activity extends AppCompatActivity implements
        BoomMenuButton.OnSubButtonClickListener,
        BoomMenuButton.AnimatorListener,
        View.OnClickListener  {
    private BoomMenuButton boomMenuButton;
    private BoomMenuButton boomMenuButtonInActionBar;
//    private BoomMenuButton boomInfo;

    private Context mContext;
    private View mCustomView;


    private int[] CirclePlaceTypes = new int[]{1, 2, 4, 2, 4, 6, 4, 3, 2};
    private int[] HamPlaceTypes = new int[]{1, 1, 1, 1};


    private boolean isInit = false;

    private ProgressBar animationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        mContext = this;


        mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        mTitleTextView.setText(R.string.app_name);


        boomMenuButtonInActionBar = (BoomMenuButton) mCustomView.findViewById(R.id.boom);

        boomMenuButton = (BoomMenuButton) findViewById(R.id.boom);

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

        ((Toolbar) mCustomView.getParent()).setContentInsetsAbsolute(0, 0);



        initViews();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (!isInit) {
            initViews();
        }
        isInit = true;
    }
    public void initViews()
    {

        Drawable[] drawables = new Drawable[9];
        int[] drawablesResource = new int[]{
                R.drawable.mark,
                R.drawable.refresh,
                R.drawable.copy,
                R.drawable.heart,
                R.drawable.info,
                R.drawable.like,
                R.drawable.record,
                R.drawable.search,
                R.drawable.settings
        };
        for (int i = 0; i < 9; i++)
            drawables[i] = ContextCompat.getDrawable(mContext, drawablesResource[i]);

        String[] STRINGS = new String[]{
                "MyCloud",
                "Songs",
                "Help",
                "Offline",
                "Playlists",
                "About",
                "Online",
                "Favorite",
                "Rate"
        };

        String[] strings = new String[9];
        for (int i = 0; i < 9; i++)
            strings[i] = STRINGS[i];

        int[][] colors = new int[9][2];
        for (int i = 0; i < 9; i++) {
            colors[i][1] = GetRandomColor();
            colors[i][0] = Util.getInstance().getPressedColor(colors[i][1]);
        }

        // Now with Builder, you can init BMB more convenient
        new BoomMenuButton.Builder()
                .subButtons(drawables, colors, strings)
                .button(ButtonType.CIRCLE)
                .boom(BoomType.PARABOLA_2)
                .place(PlaceType.CIRCLE_9_1)
                .boomButtonShadow(Util.getInstance().dp2px(5), Util.getInstance().dp2px(5))
                .subButtonsShadow(Util.getInstance().dp2px(8), Util.getInstance().dp2px(8))
                .onSubButtonClick(this)
                .animator(this)
                .dim(DimType.DIM_0)
                .init(boomMenuButton);

        // Now with Builder, you can init BMB more convenient
        new BoomMenuButton.Builder()
                .subButtons(drawables, colors, strings)
                .button(ButtonType.CIRCLE)
                .boom(BoomType.PARABOLA_2)
                .place(PlaceType.CIRCLE_9_1)
                .boomButtonShadow(Util.getInstance().dp2px(5), Util.getInstance().dp2px(5))
                .subButtonsShadow(Util.getInstance().dp2px(8), Util.getInstance().dp2px(8))
                .onSubButtonClick(this)
                .animator(this)
                .dim(DimType.DIM_0)
                .init(boomMenuButtonInActionBar);


        boomMenuButtonInActionBar.setDuration(500);
        boomMenuButtonInActionBar.setDelay(100);
        boomMenuButtonInActionBar.setRotateDegree(360);
        boomMenuButtonInActionBar.setAutoDismiss(true);
        boomMenuButtonInActionBar.setShowOrderType(OrderType.REVERSE);
        boomMenuButtonInActionBar.setHideOrderType(OrderType.REVERSE);
        boomMenuButtonInActionBar.setClickEffectType(ClickEffectType.RIPPLE);


        boomMenuButton.setDuration(500);
        boomMenuButton.setDelay(100);
        boomMenuButton.setRotateDegree(360);
        boomMenuButton.setAutoDismiss(true);
        boomMenuButton.setShowOrderType(OrderType.REVERSE);
        boomMenuButton.setHideOrderType(OrderType.REVERSE);
        boomMenuButton.setClickEffectType(ClickEffectType.RIPPLE);


        animationListener = (ProgressBar)findViewById(R.id.animation_listener);


    }

    private String[] Colors = {
            "#F44336",
            "#E91E63",
            "#9C27B0",
            "#2196F3",
            "#03A9F4",
            "#00BCD4",
            "#009688",
            "#4CAF50",
            "#8BC34A",
            "#CDDC39",
            "#FFEB3B",
            "#FFC107",
            "#FF9800",
            "#FF5722",
            "#795548",
            "#9E9E9E",
            "#607D8B"};

    public int GetRandomColor() {
        Random random = new Random();
        int p = random.nextInt(Colors.length);
        return Color.parseColor(Colors[p]);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onClick(int buttonIndex) {
        if (boomMenuButtonInActionBar.isOpen()) {
            Toast.makeText(this, "On click " +
                    boomMenuButtonInActionBar.getTextViews()[buttonIndex].getText().toString() +
                    " button", Toast.LENGTH_SHORT).show();
        }
        if (boomMenuButton.isOpen()) {
            Toast.makeText(this, "On click " +
                    boomMenuButton.getTextViews()[buttonIndex].getText().toString() +
                    " button", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void toShow() {
        animationListener.setProgress(0);
    }

    @Override
    public void showing(float fraction) {
        animationListener.setProgress((int) (fraction * 100));
    }

    @Override
    public void showed() {
        animationListener.setProgress(100);
    }

    @Override
    public void toHide() {
        animationListener.setProgress(100);
    }

    @Override
    public void hiding(float fraction) {
        animationListener.setProgress((int) ((1 - fraction) * 100));
    }

    @Override
    public void hided() {
        animationListener.setProgress(0);
    }

    @Override
    public void onBackPressed() {
        if (boomMenuButton.isClosed()
                && boomMenuButtonInActionBar.isClosed()) {
            super.onBackPressed();
        } else {
            boomMenuButton.dismiss();
            boomMenuButtonInActionBar.dismiss();
        }
    }

}
