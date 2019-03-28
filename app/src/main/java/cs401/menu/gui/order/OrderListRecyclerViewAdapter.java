package cs401.menu.gui.order;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cs401.Orders.Order;
import cs401.Orders.OrderList;
import cs401.R;
import cs401.menu.gui.CustomerListRVA;

public class OrderListRecyclerViewAdapter extends RecyclerView.Adapter<OrderListRecyclerViewAdapter.ViewHolder> {
    private OrderList mData;
    private LayoutInflater mInflater;
    private OrderListRecyclerViewAdapter.ItemClickListener mClickListener;

    public OrderListRecyclerViewAdapter(Context context, OrderList data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public OrderListRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.customerlist_row, parent, false);
        return new OrderListRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderListRecyclerViewAdapter.ViewHolder holder, int position) {
        String text = mData.getOrderByIndex(position).getItemName();
        holder.myTextView.setText(text);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.custListNames);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public Order getItem(int id) {
        return mData.getOrderByIndex(id);
    }

    /**
     * delete an item from the order list
     * @param location index of the list
     */
    public void removeItem(int location) {
        mData.removeOrderByIndex(location);
    }

    // allows clicks events to be caught
    public void setClickListener(OrderListRecyclerViewAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
