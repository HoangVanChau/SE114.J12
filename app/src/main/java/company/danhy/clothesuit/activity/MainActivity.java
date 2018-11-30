package company.danhy.clothesuit.activity;

import android.annotation.SuppressLint;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;

import java.util.ArrayList;

import company.danhy.clothesuit.R;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar ;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewHotItems,recyclerViewNewItems;
    NavigationView navigationView;
    ListView listViewManHinhChinh;
    ImageView imageViewHotItems;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        ActionBar();
        ActionViewFlipper();

    }

    private ArrayList<String> mangQuangCao(){
        ArrayList<String> mangQuangCao = new ArrayList<>();
        mangQuangCao.add(getString(R.string.anhQuangCao1));
        mangQuangCao.add(getString(R.string.anhQuangCao2));
        mangQuangCao.add(getString(R.string.anhQuangCao3));
        mangQuangCao.add(getString(R.string.anhQuangCao4));
        mangQuangCao.add(getString(R.string.anhQuangCao5));
        return mangQuangCao;
    }

    private void SetAnimationForViewFlipper(ViewFlipper viewFlipper){
        Animation slide_in_right = AnimationUtils.loadAnimation(this,R.anim.slide_in_right);
        Animation slide_out_right = AnimationUtils.loadAnimation(this,R.anim.slide_out_right);
        viewFlipper.setOutAnimation(slide_out_right);
        viewFlipper.setInAnimation(slide_in_right);
    }


    private float oldX,newX;
    private boolean checkTouch = false;
    @SuppressLint("ClickableViewAccessibility")
    private void TouchMoveForViewFlipper(final ViewFlipper viewFlipper){
        viewFlipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    oldX=event.getX();
                    Log.d("touch", "down");
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    newX=event.getX();
                    Log.d("touch", "up");
                    checkTouch=true;
                }
                if(checkTouch==true){
                    if(oldX<newX ){
                        if(viewFlipper.isAutoStart()){
                            viewFlipper.stopFlipping();
                            viewFlipper.showPrevious();
                            viewFlipper.startFlipping();
                            viewFlipper.setAutoStart(true);

                        }

                    }else{
                        viewFlipper.stopFlipping();
                        viewFlipper.showNext();
                        viewFlipper.startFlipping();
                        viewFlipper.setAutoStart(true);
                    }
                    checkTouch=false;
                    oldX = 0;
                    newX = 0;
                }
                return true;
            }

        });

    }

    private void ActionViewFlipper() {
        for(int i=0;i<this.mangQuangCao().size();i++){
            ImageView imageView = new ImageView(this);
            Picasso.get().load(this.mangQuangCao().get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(7000);
        viewFlipper.setAutoStart(true);
        this.SetAnimationForViewFlipper(viewFlipper);
        this.TouchMoveForViewFlipper(viewFlipper);

    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    void AnhXa(){
        toolbar = findViewById(R.id.toolbar);
        viewFlipper = findViewById(R.id.viewFlipper);
        recyclerViewHotItems = findViewById(R.id.recyclerViewHotItems);
        recyclerViewNewItems = findViewById(R.id.recyclerViewNewItems);
        navigationView = findViewById(R.id.navigationView);
        listViewManHinhChinh = findViewById(R.id.listViewManHinhChinh);
        imageViewHotItems = findViewById(R.id.imageViewHotItems);
        drawerLayout = findViewById(R.id.drawerLayout);
    }
}
