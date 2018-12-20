package company.danhy.clothesuit.activity.activity.activity;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

import company.danhy.clothesuit.R;

import company.danhy.clothesuit.activity.activity.model.Giohang;
import company.danhy.clothesuit.activity.activity.model.Sanpham;

public class ChiTietSanPham extends AppCompatActivity {
   Toolbar toolbarchitiet;
   ImageView imgchitiet;
   TextView txtten,txtgia,txtmota;
   Button buttondatmua;
   Spinner spinner;

    int id=0;
    String Tenchitiet="";
    int Giachitiet=0;
    String Hinhanhchitiet="";
    String Motachitiet="";
    int idsanpham=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        anhxa();
        ActionToolbar();
        getinfomation();
        CatchEventSpiner();
        EventButton();
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

    private void EventButton() {
        buttondatmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.manggiohang.size()>0){
                    int sl=Integer.parseInt(spinner.getSelectedItem().toString());
                    boolean exit =false;
                    for(int i=0;i<MainActivity.manggiohang.size();i++){
                        if(MainActivity.manggiohang.get(i).getIdsp()==id){
                            MainActivity.manggiohang.get(i).setSoluongsp(MainActivity.manggiohang.get(i).getSoluongsp()+sl);
                            if(MainActivity.manggiohang.get(i).getSoluongsp()>=10){
                                MainActivity.manggiohang.get(i).setSoluongsp(10);
                            }
                            MainActivity.manggiohang.get(i).setGiasp(Giachitiet*MainActivity.manggiohang.get(i).getSoluongsp());
                            exit=true;
                        }
                    }
                    if(exit==false){
                        int soluong=Integer.parseInt(spinner.getSelectedItem().toString());
                        long giamoi=Giachitiet*soluong;
                        MainActivity.manggiohang.add(new Giohang(id,Tenchitiet,giamoi,Hinhanhchitiet,soluong));

                    }

                }else{
                    int soluong=Integer.parseInt(spinner.getSelectedItem().toString());
                    long giamoi=Giachitiet*soluong;
                    MainActivity.manggiohang.add(new Giohang(id,Tenchitiet,giamoi,Hinhanhchitiet,soluong));
                }
                Intent intent=new Intent(getApplicationContext(), company.danhy.clothesuit.activity.activity.activity.Giohang.class);
                startActivity(intent);
            }
        });
    }

    private void CatchEventSpiner() {
        Integer[] soluong=new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> arrayAdapter =new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_dropdown_item,soluong );
        spinner.setAdapter(arrayAdapter);
    }

    private void getinfomation() {

        Sanpham sanpham = (Sanpham) getIntent().getSerializableExtra("thongtinsanpham");
        id =sanpham.getID();
        Tenchitiet=sanpham.getTensanpham();
        Giachitiet=sanpham.getGiasanpham();
        Hinhanhchitiet=sanpham.getHinhanhsanpham();
        Motachitiet=sanpham.getMotasanpham();
        idsanpham=sanpham.getIDSanpham();
        txtten.setText(Tenchitiet);
        DecimalFormat decimalFormat =new DecimalFormat("###,###,###");
        txtgia.setText("Giá: "+ decimalFormat.format(Giachitiet)+ "VNĐ");
        txtmota.setText(Motachitiet);
        Picasso.get().load(Hinhanhchitiet)
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(imgchitiet);

    }

    private void ActionToolbar() {
        setSupportActionBar(toolbarchitiet);
        ActionBar actionBar=getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        toolbarchitiet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void anhxa() {
        toolbarchitiet=findViewById(R.id.toolbarchitietsanpham);
        imgchitiet=findViewById(R.id.imagechitietsanpham);
        txtten=findViewById(R.id.textviewtenchitietsanpham);
        txtgia=findViewById(R.id.textviewgiasanpham);
        txtmota=findViewById(R.id.textviewmotachitietsanpham);
        buttondatmua=findViewById(R.id.buttondatmua);
        spinner =findViewById(R.id.spiner);

    }
}
