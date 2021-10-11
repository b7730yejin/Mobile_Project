package com.example.lee.movie;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lee on 2018-07-11.
 */

public class CardListAdapter extends BaseAdapter {

    private Context context;

    public CardListAdapter(Context context, List<Card> cardList) {
        this.context = context;
        CardList = cardList;
    }

    private List<Card> CardList;


    @Override
    public int getCount() {
        return CardList.size();
    }

    @Override
    public Object getItem(int position) {
        return CardList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View View, ViewGroup viewGroup) {
        android.view.View v = View.inflate(context, R.layout.activity_card, null);
        ImageView image  = (ImageView) v.findViewById(R.id.card_image);
        TextView nameText = (TextView) v.findViewById(R.id.card_name);
        // TextView titleText =  (TextView) v.findViewById(R.id.card_title);
        TextView messageTExt = (TextView) v.findViewById(R.id.card_message);

        //  titleText.setText(CardList.get(i).getTitle());
        nameText.setText(CardList.get(i).getName());
        messageTExt.setText(CardList.get(i).getMessage());
        image.setImageBitmap(CardList.get(i).getImage());

        v.setTag(CardList.get(i).getName());
        return v;
    }
}
