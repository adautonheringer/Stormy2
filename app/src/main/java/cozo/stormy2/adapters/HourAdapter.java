package cozo.stormy2.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cozo.stormy2.R;
import cozo.stormy2.weather.Hour;

/**
 * Created by adaut on 11/21/2017.
 */

public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder> {

    private Context mContext;
    public Hour[] mHours;

    public HourAdapter (Context context, Hour[] hours) {
        mHours = hours;
        mContext = context;
    }

    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hourly_list_item, parent, false);
        HourViewHolder viewHolder = new HourViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HourViewHolder holder, int position) {
        holder.bindHour(mHours[position]);

    }

    @Override
    public int getItemCount() {
        return mHours.length;
    }

    public class HourViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //Views that are going to be on this layout
        public TextView mTimeLabel;
        public ImageView mIconImageView;
        public TextView mTemperatureLabel;
        public TextView mSummaryLabel;


        public HourViewHolder(View itemView) {
            super(itemView);

            mTimeLabel = (TextView) itemView.findViewById(R.id.timeLabel);
            mIconImageView = (ImageView) itemView.findViewById(R.id.iconImageView);
            mTemperatureLabel = (TextView) itemView.findViewById(R.id.temperatureLabel);
            mSummaryLabel = (TextView) itemView.findViewById(R.id.summaryLabel);

            itemView.setOnClickListener(this);
        }

        public void bindHour(Hour hour) {
            mTimeLabel.setText(hour.getHour());
            mIconImageView.setImageResource(hour.getIconId());
            mTemperatureLabel.setText(hour.getTemperature() + "");
            mSummaryLabel.setText(hour.getSummary());


        }

        @Override
        public void onClick(View view) {

            String time = mTimeLabel.getText().toString();
            String message = String.format("It's working for %s!", time);
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();

        }
    }


}
