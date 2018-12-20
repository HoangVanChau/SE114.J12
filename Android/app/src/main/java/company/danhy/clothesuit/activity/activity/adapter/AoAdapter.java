package company.danhy.clothesuit.activity.activity.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import company.danhy.clothesuit.R;
import company.danhy.clothesuit.activity.activity.model.Sanpham;

public class AoAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> arrayListao;

    public AoAdapter(Context context, ArrayList<Sanpham> arrayListao) {
        this.context = context;
        this.arrayListao = arrayListao;
    }

    @Override
    public int getCount() {
        return arrayListao.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListao.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder {
        public TextView txttenao,txtgiaao,txtmotaao;
        public ImageView imgao;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       AoAdapter.ViewHolder viewHolder =null;
        if (convertView==null){
            viewHolder=new AoAdapter.ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.dong_ao,null);
            viewHolder.txttenao=convertView.findViewById(R.id.textviewtenao);
            viewHolder.txtgiaao=convertView.findViewById(R.id.textviewgiaao);
            viewHolder.txtmotaao=convertView.findViewById(R.id.textviewmotaao);
            viewHolder.imgao=convertView.findViewById(R.id.imageao);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (AoAdapter.ViewHolder) convertView.getTag();
        }
        Sanpham sanpham= (Sanpham) getItem(position);
        viewHolder.txttenao.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat =new DecimalFormat("###,###,###");
        viewHolder.txtgiaao.setText("Giá: "+ decimalFormat.format(sanpham.getGiasanpham())+"Đ");
        viewHolder.txtmotaao.setMaxLines(2);
        viewHolder.txtmotaao.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtmotaao.setText(sanpham.getMotasanpham());
        Picasso.get().load(sanpham.getHinhanhsanpham())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(viewHolder.imgao);
        return convertView;
    }
}
