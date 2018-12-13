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
import company.danhy.clothesuit.activity.activity.adapter.AoAdapter;
import company.danhy.clothesuit.activity.activity.model.Sanpham;
import company.danhy.clothesuit.activity.activity.ultil.Server;
import company.danhy.clothesuit.activity.activity.ultil.checkconnect;

public class AoActivity extends AppCompatActivity {
    Toolbar tbao;
    ListView lvao;
    AoAdapter aoAdapter;
    ArrayList<Sanpham> mangao;
    int idao=0;
    int page=1;
    View footerview;
    boolean limitdata=false;
    boolean Loading=false;
    AoActivity.mHandler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ao);

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
        lvao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),ChiTietSanPham.class);
                intent.putExtra("thongtinsanpham",mangao.get(position));
                startActivity(intent);
            }
        });
        lvao.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(firstVisibleItem+visibleItemCount==totalItemCount &&totalItemCount!=0 && Loading ==false && limitdata ==false){
                    Loading=true;
                    AoActivity.ThreadData threadData=new AoActivity.ThreadData();
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
                String tenao="";
                int giaao=0;
                String hinhanhao="";
                String motaao="";
                int idspao=0;
                if(response!=null && response.length()!=2){
                    lvao.removeFooterView(footerview);
                    try {
                        JSONArray jsonArray =new JSONArray(response);
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            id=jsonObject.getInt("id");
                            tenao=jsonObject.getString("tensp");
                            giaao=jsonObject.getInt("giasp");
                            hinhanhao=jsonObject.getString("hinhanhsp");
                            motaao=jsonObject.getString("motasp");
                            idspao=jsonObject.getInt("idsanpham");
                            mangao.add(new Sanpham(id,tenao,giaao,hinhanhao,motaao,idspao));
                            aoAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    limitdata=true;
                    lvao.removeFooterView(footerview);
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
                param.put("idLoaiSanPham",String.valueOf(idao));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void ActionToolbar() {

        setSupportActionBar(tbao);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        tbao.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void GetIdloaisp() {
        idao=getIntent().getIntExtra("idLoaiSanPham",-1);
        Log.d("giatriloaisanpham",idao + "");
    }

    private void anhxa(){
        tbao =findViewById(R.id.toolbarao);
        lvao=findViewById(R.id.listviewao);
        mangao=new ArrayList<>();
        aoAdapter=new AoAdapter(getApplicationContext(),mangao);
        lvao.setAdapter(aoAdapter);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerview =inflater.inflate(R.layout.projectbar,null);
        mHandler=new AoActivity.mHandler();
    }
    public class mHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    lvao.addFooterView(footerview);
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
