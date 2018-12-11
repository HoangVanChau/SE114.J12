package company.danhy.clothesuit.activity.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import company.danhy.clothesuit.R;
import company.danhy.clothesuit.activity.activity.model.Giohang;

public class GiohangAdapter extends BaseAdapter {
    Context context;
    ArrayList<Giohang>arrayListgiohang;

    public GiohangAdapter(Context context, ArrayList<Giohang> arrayListgiohang) {
        this.context = context;
        this.arrayListgiohang = arrayListgiohang;
    }

    @Override
    public int getCount() {
        return arrayListgiohang.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListgiohang.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder{
     public TextView txttengiohang,txtgiagiohang;
     public ImageView imggiohang;
     public Button btleft,btvalue,btright;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      ViewHolder viewHolder=null;
      if(convertView==null){
          viewHolder=new ViewHolder();
          LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          convertView=inflater.inflate(R.layout.dong_giohang,null);
          viewHolder.txttengiohang=convertView.findViewById(R.id.textviewtenmonhang);
          viewHolder.txtgiagiohang=convertView.findViewById(R.id.textviewgiamonhang);
          viewHolder.imggiohang=convertView.findViewById(R.id.imagegiohang);
          viewHolder.btleft=convertView.findViewById(R.id.buttonminusleft);
          viewHolder.btvalue=convertView.findViewById(R.id.buttonvalue);
          viewHolder.btright=convertView.findViewById(R.id.buttonminusright);
          convertView.setTag(viewHolder);
      }else{
          viewHolder= (ViewHolder) convertView.getTag();
      }
      Giohang giohang= (Giohang) getItem(position);
      viewHolder.txttengiohang.setText(giohang.getTensp());
        DecimalFormat decimalFormat =new DecimalFormat("###,###,###");
        viewHolder.txtgiagiohang.setText("Giá: "+ decimalFormat.format(giohang.getGiasp())+"Đ");
        Picasso.get().load(giohang.getHinhanhsp())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(viewHolder.imggiohang);
        viewHolder.btvalue.setText(giohang.getSoluongsp()+"");
        return convertView;
    }
}
