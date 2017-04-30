package me.jaxbot.landslidesstrike;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pc on 4/30/2017.
 */

public class MyFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Webclass> user;
    ArrayList<Webclass> user2;
    //    ItemClickListener listener;
    MyAdapter myAdapter;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragmentxml,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
//        listView = (ListView)v.findViewById(R.id.tweets);

        user = new ArrayList<Webclass>();


        myAdapter=new MyAdapter(getActivity(),user);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setAdapter(myAdapter);

//        listView.setAdapter(myAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                listener.onUserItemClicked(user.get(i));
//            }
//        });
        Log.i("yy", "onCreate: ");
        fetchUsers();
        return v;
    }

    private void fetchUsers() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://data.nasa.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<ArrayList<Webclass>> call = apiInterface.getcourses();
        call.enqueue(new Callback<ArrayList<Webclass>>() {
            @Override
            public void onResponse(Call<ArrayList<Webclass>> call, retrofit2.Response<ArrayList<Webclass>> response) {
              ArrayList<Webclass> aray = response.body();
//                Toast.makeText(getActivity(),"hello",Toast.LENGTH_LONG).show();
                user.clear();
                user=aray;
//                for(int i=0; i<user.size(); i++)
//                {
//                    user2.add(user.get(i).getDate());
//                    user2.add(user.get(i).getInjuries());
//                    user2.add(user.get(i).getDate());
////                    Log.d("mmm", response2.get(i).getName());
//                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Webclass>> call, Throwable t) {

            }
        });
    }

}
