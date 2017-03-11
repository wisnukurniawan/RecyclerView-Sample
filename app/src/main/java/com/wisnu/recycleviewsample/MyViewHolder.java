package com.wisnu.recycleviewsample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by wisnu on 11/03/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
	TextView tvName;
	OnItemClickListener onItemClickListener;

	public MyViewHolder(View itemView, OnItemClickListener onItemClickListener) {
		super(itemView);
		tvName = (TextView) itemView.findViewById(R.id.tv_name);

		this.onItemClickListener = onItemClickListener;
		itemView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (onItemClickListener != null){
			onItemClickListener.onItemClick(v, getAdapterPosition());
		}
	}

	interface OnItemClickListener{
		void onItemClick(View view, int position);
	}
}
