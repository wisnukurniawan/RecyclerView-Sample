package com.wisnu.recycleviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	RecyclerView recyclerView;
	List<MyModel> myModelList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		myModelList = new ArrayList<>();

		recyclerView = (RecyclerView) findViewById(R.id.rv);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setItemAnimator(new DefaultItemAnimator());

		for (int i = 0; i < 200; i++) {
			myModelList.add(new MyModel("Wisnu" + i));
		}

		MyAdapter adapter = new MyAdapter(myModelList, this, new MyViewHolder.OnItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				Toast.makeText(MainActivity.this, "Aha " + myModelList.get(position).getName(),
						Toast.LENGTH_SHORT).show();
			}
		});

		recyclerView.setAdapter(adapter);

	}
}
