package company.danhy.clothesuit.activity.activity.activity;

import android.content.Intent;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
                if(ten.length()>0 && sdt.length()>0 && email.length()>0 && diachi.length()>0){
                    RequestQueue requestQueue =Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest =new StringRequest(Request.Method.POST, Server.duongDanThongTinKhachHang, new Response.Listener<String>() {
                        @Override
                        public void onResponse(final String madonhang) {
                            Log.d("madonhang",madonhang);
                            if(Integer.parseInt(madonhang)>0){
                               RequestQueue queue =Volley.newRequestQueue(getApplicationContext());
                               StringRequest request=new StringRequest(Request.Method.POST, Server.duongDanChiTietDonHang, new Response.Listener<String>() {
                                   @Override
                                   public void onResponse(String response) {
                                     if(response.equals("1")){
                                         MainActivity.manggiohang.clear();
                                         checkconnect.ShowToast_Short(getApplicationContext(),"Bạn đã thêm dữ liệu giỏ hàng thành công");
                                         Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                                         startActivity(intent);
                                         checkconnect.ShowToast_Short(getApplicationContext(),"Mời bạn tiếp tục mua hàng");
                                     }else{
                                         checkconnect.ShowToast_Short(getApplicationContext(),"Dữ liệu giỏ hàng của bạn đã bị lỗi");
                                     }
                                   }
                               }, new Response.ErrorListener() {
                                   @Override
                                   public void onErrorResponse(VolleyError error) {

                                   }
                               }){
                                   @Override
                                   protected Map<String, String> getParams() throws AuthFailureError {
                                       JSONArray jsonArray=new JSONArray();
                                       for(int i=0;i<MainActivity.manggiohang.size();i++){
                                           JSONObject jsonObject=new JSONObject();
                                           try {
                                               jsonObject.put("madonhang",madonhang);
                                               jsonObject.put("masanpham",MainActivity.manggiohang.get(i).getIdsp());
                                               jsonObject.put("tensanpham",MainActivity.manggiohang.get(i).getTensp());
                                               jsonObject.put("giasanpham",MainActivity.manggiohang.get(i).getGiasp());
                                               jsonObject.put("soluongsanpham",MainActivity.manggiohang.get(i).getSoluongsp());
                                           } catch (JSONException e) {
                                               e.printStackTrace();
                                           }
                                           jsonArray.put(jsonObject);
                                       }
                                       HashMap<String,String> hashMap=new HashMap<String,String>();
                                       hashMap.put("json",jsonArray.toString());
                                       return hashMap;
                                   }
                               };
                               queue.add(request);
                            }
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
                    checkconnect.ShowToast_Short(getApplicationContext(),"Bạn chưa nhập đủ thông tin");
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
