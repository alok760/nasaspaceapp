package me.jaxbot.landslidesstrike;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pc on 4/29/2017.
 */

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context mContext;
    ArrayList<Webclass> mtimeline = new ArrayList<>();
    public MyAdapter(ArrayList<Webclass> mtimeline)
    {
        this.mtimeline=mtimeline;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.my_item_look, parent, false);


        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    public MyAdapter(Context context,ArrayList<Webclass> timeline)
    {
        this.mContext=context;
        this.mtimeline=timeline;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.date.setText(mtimeline.get(position).date);
        holder.injuries.setText(mtimeline.get(position).injuries);
        holder.countryname.setText(mtimeline.get(position).countryname);


        //    Log.d("mmm",mtimeline.get(position).created_at+" "+mtimeline.get(position).created_at);

    }

    @Override
    public int getItemCount() {
        return mtimeline.size();

    }
    public static class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView countryname,injuries,date;

        public ViewHolder(View itemView) {
            super(itemView);
           countryname=(TextView)itemView.findViewById(R.id.countryname);
           injuries = (TextView)itemView.findViewById(R.id.injuries);
            date=(TextView)itemView.findViewById(R.id.date);

        }
    }
}
