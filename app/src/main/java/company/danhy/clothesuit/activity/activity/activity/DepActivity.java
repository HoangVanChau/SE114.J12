package company.danhy.clothesuit.activity.activity.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import company.danhy.clothesuit.R;
import company.danhy.clothesuit.activity.activity.adapter.DepAdapter;
import company.danhy.clothesuit.activity.activity.model.Sanpham;
import company.danhy.clothesuit.activity.activity.ultil.Server;
import company.danhy.clothesuit.activity.activity.ultil.checkconnect;

public class DepActivity extends AppCompatActivity {
    Toolbar tbdep;
    ListView lvdep;
    DepAdapter depAdapter;
    ArrayList<Sanpham> mangdep;
    int iddep=0;
    int page=1;
    View footerview;
    boolean limitdata=false;
    boolean Loading=false;
    DepActivity.mHandler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dep);
        if(checkconnect.isNetworkAvailable(getApplicationContext())){
            anhxa();
            GetIdloaisp();
            ActionToolbar();
            getData(page);
            LoadMoreData();
        }
        else{
            checkconnect.ShowToast_Short(getApplicationContext(),"Bạn vui lòng kiểm tra lại Internet");
            finish();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menugiohang:
                Intent intent=new Intent(getApplicationContext(), company.danhy.clothesuit.activity.activity.activity.Giohang.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    private void LoadMoreData() {
        lvdep.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),ChiTietSanPham.class);
                intent.putExtra("thongtinsanpham",mangdep.get(position));
                startActivity(intent);
            }
        });
        lvdep.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(firstVisibleItem+visibleItemCount==totalItemCount &&totalItemCount!=0 && Loading ==false && limitdata ==false){
                    Loading=true;
                    DepActivity.ThreadData threadData=new DepActivity.ThreadData();
                    threadData.start();
                }
            }
        });
    }

    private void getData(int Page) {
        RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
        String duongdan=Server.duongDanGiay+String.valueOf(Page);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id=0;
                String tendep="";
                int giadep=0;
                String hinhanhdep="";
                String motadep="";
                int idspdep=0;
                if(response!=null && response.length()!=2){
                    lvdep.removeFooterView(footerview);
                    try {
                        JSONArray jsonArray =new JSONArray(response);
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            id=jsonObject.getInt("id");
                            tendep=jsonObject.getString("tensp");
                            giadep=jsonObject.getInt("giasp");
                            hinhanhdep=jsonObject.getString("hinhanhsp");
                            motadep=jsonObject.getString("motasp");
                            idspdep=jsonObject.getInt("idsanpham");
                            mangdep.add(new Sanpham(id,tendep,giadep,hinhanhdep,motadep,idspdep));
                            depAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    limitdata=true;
                    lvdep.removeFooterView(footerview);
                    checkconnect.ShowToast_Short(getApplicationContext(),"Đã hết dữ liệu");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param=new HashMap<String,String>();
                param.put("idLoaiSanPham",String.valueOf(iddep));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void ActionToolbar() {

        setSupportActionBar(tbdep);
        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        tbdep.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void GetIdloaisp() {
        iddep=getIntent().getIntExtra("idLoaiSanPham",-1);
        Log.d("giatriloaisanpham",iddep+ "");
    }

    private void anhxa(){
        tbdep =findViewById(R.id.toolbardep);
        lvdep=findViewById(R.id.listviewdep);
        mangdep=new ArrayList<>();
        depAdapter=new DepAdapter(getApplicationContext(),mangdep);
        lvdep.setAdapter(depAdapter);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerview =inflater.inflate(R.layout.projectbar,null);
        mHandler=new mHandler();
    }
    public class mHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    lvdep.addFooterView(footerview);
                    break;
                case 1:
                    getData(++page);
                    Loading=false;
                    break;
            }
            super.handleMessage(msg);
        }
    }
    public class ThreadData extends Thread{
        @Override
        public void run() {
            mHandler.sendEmptyMessage(0);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message=mHandler.obtainMessage(1);
            mHandler.sendMessage(message);
            super.run();
        }
    }
}
