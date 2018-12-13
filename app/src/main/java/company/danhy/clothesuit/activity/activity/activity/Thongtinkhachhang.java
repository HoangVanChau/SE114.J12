package company.danhy.clothesuit.activity.activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import company.danhy.clothesuit.R;
import company.danhy.clothesuit.activity.activity.ultil.Server;
import company.danhy.clothesuit.activity.activity.ultil.checkconnect;

public class Thongtinkhachhang extends AppCompatActivity {
   EditText edtenkhachhang,edsdt,edemail, eddiachi;
   Button btxacnhan,bttrove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinkhachhang);
        anhxa();
        bttrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if(checkconnect.isNetworkAvailable(getApplicationContext())){
            eventButton();
        }
        else{
            checkconnect.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
        }
    }

    private void eventButton() {
        btxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ten=edtenkhachhang.getText().toString().trim();
                final String sdt=edsdt.getText().toString().trim();
                final String email=edemail.getText().toString().trim();
                final String diachi=eddiachi.getText().toString().trim();
                if(ten.length()>0&&sdt.length()>0&& email.length()>0&& diachi.length()>0){
                    RequestQueue requestQueue =Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest =new StringRequest(Request.Method.POST, Server.duongThongTinKhachHang, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("madonhang",response);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            HashMap<String,String> hashMap=new HashMap<String,String>();
                            hashMap.put("tenkhachhang",ten);
                            hashMap.put("sodienthoai",sdt);
                            hashMap.put("email",email);
                            hashMap.put("diachi",diachi);
                            return hashMap;
                        }
                    };
                    requestQueue.add(stringRequest);
                }else{
                    checkconnect.ShowToast_Short(getApplicationContext(),"Bạn kiểm tra lại dữ liệu");
                }
            }
        });
    }

    private void anhxa() {
        edtenkhachhang=findViewById(R.id.edittexttenkhachhang);
        edsdt=findViewById(R.id.edittextsodienthoai);
        edemail=findViewById(R.id.edittextemail);
        eddiachi=findViewById(R.id.edittexdiachi);
        btxacnhan=findViewById(R.id.buttonxacnhan);
        bttrove=findViewById(R.id.buttontrove);

    }
}
