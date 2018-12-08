package company.danhy.clothesuit.activity.activity.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dep);
        if(checkconnect.isNetworkAvailable(getApplicationContext())){
            anhxa();
            GetIdloaisp();
            ActionToolbar();
            getData(page);
        }
        else{
            checkconnect.ShowToast_Short(getApplicationContext(),"Bạn vui lòng kiểm tra lại Internet");
            finish();
        }
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
    }
}
