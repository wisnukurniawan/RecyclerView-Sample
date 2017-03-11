package com.wisnu.recycleviewsample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by wisnu on 11/03/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
	private List<MyModel> myModelList;
	private MyViewHolder.OnItemClickListener onItemClickListener;
	private Context context;

	public MyAdapter(List<MyModel> modelList, Context context,
					 MyViewHolder.OnItemClickListener onItemClickListener){

		this.myModelList = modelList;
		this.context = context;
		this.onItemClickListener = onItemClickListener;
		notifyDataSetChanged();

	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view =
				LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false);
		return new MyViewHolder(view, onItemClickListener);
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, int position) {
		MyModel myModel = myModelList.get(position);
		holder.tvName.setText(myModel.getName());
	}

	@Override
	public int getItemCount() {
		return myModelList.size();
	}
}
