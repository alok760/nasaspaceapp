package me.jaxbot.landslidesstrike;

import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainPageActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView recyclerView;
    ArrayList<Webclass> user;
    ArrayList<Webclass> user2;
//    ItemClickListener listener;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        user = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);

        myAdapter=new MyAdapter(this,user);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fetchUsers();
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent ii = new Intent();
//                        ii.setAction(Intent.ACTION_VIEW);

                     String mm = user.get(position).getSource_link();
//                        ii.setData(uri);
//                        startActivity(ii);

                        ii.setClass(MainPageActivity.this,Web.class);
                        ii.putExtra("url",mm);
                        startActivity(ii);

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                })
        );

    }

    private void fetchUsers() {

        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("https://data.nasa.gov/")
                .baseUrl("https://api.myjson.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<ArrayList<Webclass>> call = apiInterface.getcourses();
        call.enqueue(new Callback<ArrayList<Webclass>>() {
            @Override
            public void onResponse(Call<ArrayList<Webclass>> call, retrofit2.Response<ArrayList<Webclass>> response) {
                ArrayList<Webclass> aray= response.body();

                user.clear();
                user.addAll(aray);
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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent iy = new Intent();
            iy.setClass(MainPageActivity.this,Gestures.class);
            startActivity(iy);

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.location) {
//            FragmentManager fragmentManager = getFragmentManager();
//            fragmentManager.beginTransaction()
//                    .replace(R.id., Mymap)
//                    .commit();
            Intent i1 = new Intent();
            i1.setClass(this,TestActivity.class);
            startActivity(i1);
            // Handle the camera action
        } else if (id == R.id.map) {
            Intent i1 = new Intent();
            i1.setClass(this,MasWeb.class);
            startActivity(i1);
        } else if (id == R.id.predicition) {

        } else if (id == R.id.rescue) {

        } else if (id == R.id.shareapp) {

        } else if (id == R.id.Settings) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
