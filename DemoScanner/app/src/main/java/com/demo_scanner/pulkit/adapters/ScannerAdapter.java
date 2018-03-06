package com.demo_scanner.pulkit.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo_scanner.pulkit.R;

import java.util.List;

public class ScannerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> productList;
    private onClickListener onClickListener;

    public interface onClickListener {
        void onClickButton(int position, int view, String product);
    }

    public ScannerAdapter(List<String> productList, onClickListener onClickListener) {
        this.productList = productList;
        this.onClickListener = onClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_scan_list_tems, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        ViewHolder holder = (ViewHolder) viewHolder;

        holder.tv_name.setText(productList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_name;

        public ViewHolder(View itemView) {
            super(itemView);


            tv_name = (TextView) itemView.findViewById(R.id.tv_name);

        }

        @Override
        public void onClick(View view) {
            onClickListener.onClickButton(getLayoutPosition(), view.getId(), productList.get(getLayoutPosition()));
        }
    }


}
