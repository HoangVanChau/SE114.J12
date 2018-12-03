package company.danhy.clothesuit.activity.activity.activity;

import android.annotation.SuppressLint;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import company.danhy.clothesuit.R;
import company.danhy.clothesuit.activity.activity.adapter.LoaispAdapter;
import company.danhy.clothesuit.activity.activity.model.Loaisp;
import company.danhy.clothesuit.activity.activity.ultil.CheckConnect;
import company.danhy.clothesuit.activity.activity.ultil.Server;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar ;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewHotItems,recyclerViewNewItems;
    NavigationView navigationView;
    ListView listViewManHinhChinh;
    ImageView imageViewHotItems;
    DrawerLayout drawerLayout;
    ArrayList <Loaisp> mangloaisanpham;
    LoaispAdapter loaispAdapter;
    int id=0;
    String tenloaisp="";
    String hinhanhloaisp="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        if(CheckConnect.haveNetworkConnection(getApplicationContext())){
            ActionBar();
            ActionViewFlipper();
            getDuLieuLoaiSanPham();
        }else{
            CheckConnect.ShowToast_Short(getApplicationContext(),"Vui lòng kiểm tra lại kết nối của bạn");
            finish();
        }


    }

    private void getDuLieuLoaiSanPham() {
        RequestQueue requestQueue =Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Server.duongDanLoaiSanPham, new Response.Listener<JSONArray>() {
            @Override

            public void onResponse(JSONArray response) {
               if(response != null){
                 for(int i = 0;i < response.length();i++){
                     try {
                         JSONObject jsonObject =response.getJSONObject(i);
                         id =jsonObject.getInt("id");
                         tenloaisp=jsonObject.getString("tenLoaiSanPham");
                         hinhanhloaisp =jsonObject.getString("hinhAnhLoaiSanPham");
                         mangloaisanpham.add(new Loaisp(id,tenloaisp,hinhanhloaisp));
                         loaispAdapter.notifyDataSetChanged();
                     } catch (JSONException e) {
                         e.printStackTrace();
                     }
                 }
                 mangloaisanpham.add( 6,new Loaisp(0,"Liên hệ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpCeVuVWGdIbeB88vj6moAw0vSEt5dPuRFN0FZqy5UdS5wN1wp"));
                 mangloaisanpham.add(7,new Loaisp(0,"Thông tin","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSynBh4ywTCWrkfmGUUKvbhd7ahU-tm2iyTQPnLQixfOr7q-9QzKQ"));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnect.ShowToast_Short(getApplicationContext(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
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
        recyclerViewHotItems =  findViewById(R.id.recyclerViewHotItems);
        recyclerViewNewItems = findViewById(R.id.recyclerViewNewItems);
        navigationView = findViewById(R.id.navigationView);
        listViewManHinhChinh = findViewById(R.id.listViewManHinhChinh);
        imageViewHotItems = findViewById(R.id.imageViewHotItems);
        drawerLayout = findViewById(R.id.drawerLayout);
        mangloaisanpham =new ArrayList<>();

        mangloaisanpham.add(0,new Loaisp(0,"Trang Chính","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyyPFbxER9CaziwnRh9UgBFqauaA2DOR_ZTCXFkK9iLmFdeoPE5w"));
        loaispAdapter=new LoaispAdapter(mangloaisanpham,getApplicationContext());
        listViewManHinhChinh.setAdapter(loaispAdapter);

    }
}
