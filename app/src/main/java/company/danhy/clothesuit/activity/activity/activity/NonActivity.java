package company.danhy.clothesuit.activity.activity.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
import company.danhy.clothesuit.activity.activity.adapter.NonAdapter;
import company.danhy.clothesuit.activity.activity.model.Sanpham;
import company.danhy.clothesuit.activity.activity.ultil.Server;
import company.danhy.clothesuit.activity.activity.ultil.checkconnect;

public class NonActivity extends AppCompatActivity {
    Toolbar tbnon;
    ListView lvnon;
    NonAdapter nonAdapter;
    ArrayList<Sanpham> mangnon;
    int idnon=0;
    int page=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non);
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

    private void anhxa() {
        tbnon =findViewById(R.id.toolbarnon);
        lvnon=findViewById(R.id.listviewnon);
        mangnon=new ArrayList<>();
        nonAdapter=new NonAdapter(getApplicationContext(),mangnon);
        lvnon.setAdapter(nonAdapter);
    }
    private void GetIdloaisp() {
        idnon=getIntent().getIntExtra("idLoaiSanPham",-1);

    }

    private void ActionToolbar() {

        setSupportActionBar(tbnon);
        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        tbnon.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void getData(int Page) {
        RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
        String duongdan=Server.duongDanGiay + String.valueOf(Page);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id=0;
                String tennon="";
                int gianon=0;
                String hinhanhnon="";
                String motanon="";
                int idspnon=0;
                if(response!=null  && response.length()!=2){
                    try {
                        JSONArray jsonArray =new JSONArray(response);
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            id=jsonObject.getInt("id");
                            tennon=jsonObject.getString("tensp");
                            gianon=jsonObject.getInt("giasp");
                            hinhanhnon=jsonObject.getString("hinhanhsp");
                            motanon=jsonObject.getString("motasp");
                            idspnon=jsonObject.getInt("idsanpham");
                            mangnon.add(new Sanpham(id,tennon,gianon,hinhanhnon,motanon,idspnon));
                            nonAdapter.notifyDataSetChanged();
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
                param.put("idLoaiSanPham",String.valueOf(idnon));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }
}
