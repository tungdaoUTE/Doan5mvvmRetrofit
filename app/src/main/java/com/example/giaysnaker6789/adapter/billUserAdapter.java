package com.example.giaysnaker6789.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.giaysnaker6789.R;
import com.example.giaysnaker6789.config.Progressdialog;
import com.example.giaysnaker6789.models.bills2;
import com.example.giaysnaker6789.models.billuser;
import com.example.giaysnaker6789.network.RetrofitService;
import com.example.giaysnaker6789.viewModels.BillViewModel;
import com.shuhart.stepview.StepView;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;


public class billUserAdapter extends BaseAdapter {
    ArrayList<bills2> list;
    Context context;
    private BillViewModel billViewModel;

    Progressdialog progressdialog = new Progressdialog();

    public billUserAdapter(ArrayList<bills2> list, Context context) {
        this.list = list;
        this.context = context;
        billViewModel = ViewModelProviders.of((FragmentActivity) context).get(BillViewModel.class);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class viewholder {  // tạo 1 class viewholder đầy đủ các thuộc tính của file dongkhach.xml
        StepView stepview;
        TextView txtname;
        TextView txtaddress;
        TextView txtphone;
        TextView txtcount;
        TextView txtprice;
        TextView txtdate;
    }

    @Override
    public View getView(int position, View itemView, ViewGroup parent) {

        viewholder holder;

        if (itemView == null) {
            holder = new viewholder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.item_danggiao, null);
           // holder.stepview = itemView.findViewById(R.id.step_view);
            holder.txtname = itemView.findViewById(R.id.txtnameuser1);
            holder.txtaddress = itemView.findViewById(R.id.txtaddress);
            holder.txtphone = itemView.findViewById(R.id.txtphone);
            holder.txtcount = itemView.findViewById(R.id.txtcount);
            holder.txtprice = itemView.findViewById(R.id.txtprice);
            holder.txtdate = itemView.findViewById(R.id.txtdate);
            itemView.setTag(holder);
        } else {
            holder = (viewholder) itemView.getTag();
        }

        bills2 currentpro = list.get(position);
        holder.txtname.setText(""+currentpro.getName());
        holder.txtaddress.setText(""+currentpro.getAddress());
        holder.txtphone.setText("" + currentpro.getPhone());
        holder.txtcount.setText("" + currentpro.getCount());
        holder.txtprice.setText("" + currentpro.getPrice());

//        holder.stepview.getState()
//                .animationType(StepView.ANIMATION_CIRCLE)
//                .steps(new ArrayList<String>() {{
//                    add("chờ xác nhận");
//                    add("đang giao");
//                    add("đã giao");
//                }})
//                .stepsNumber(4)
//                .animationDuration(2000)
//                .commit();
//        String stt = currentpro.getStatus();
//        switch (stt) {
//            case "b2":
//                 holder.stepview.go(0,true);
//                break;
//            case "b3":
//                holder.stepview.go(1,true);
//                break;
//            case "b4":
//                holder.stepview.go(2,true);
//                break;
//        }

        return itemView;
    }

    public String format(double number) {
        NumberFormat formatter = new DecimalFormat("#,###,###");
        return formatter.format(number);
    }
}
