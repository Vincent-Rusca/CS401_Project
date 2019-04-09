package cs401.menu.gui.customer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cs401.Customers.Customer;
import cs401.Customers.CustomerList;
import cs401.R;

public class CustomerListRecyclerViewActivity extends RecyclerView.Adapter<CustomerListRecyclerViewActivity.ViewHolder> {
    private CustomerList mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public CustomerListRecyclerViewActivity(Context context, CustomerList data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.customerlist_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.customerNameView.setText(mData.getCustomerList().get(position).getCustomerName());
        holder.customerIDView.setText("ID: " + mData.getCustomerList().get(position).getCustomerID());
        holder.customerAddressView.setText(mData.getCustomerList().get(position).getAddress().toString());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.getCustomerList().size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView customerNameView, customerIDView, customerAddressView;

        ViewHolder(View itemView) {
            super(itemView);
            customerNameView = itemView.findViewById(R.id.custListNames);
            customerIDView = itemView.findViewById(R.id.custListID);
            customerAddressView = itemView.findViewById(R.id.custListAddress);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public Customer getItem(int id) {
        return mData.getCustomerList().get(id);
    }

    /**
     * delete an item from the customer list
     * @param location index of the list
     */
    public void removeItem(int location) {
        mData.remove(location);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}



