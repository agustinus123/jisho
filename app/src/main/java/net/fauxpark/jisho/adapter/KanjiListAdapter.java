package net.fauxpark.jisho.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.fauxpark.jisho.R;
import net.fauxpark.jisho.model.Kanji;
import net.fauxpark.jisho.model.viewholder.KanjiViewHolder;

public class KanjiListAdapter extends ArrayAdapter<Kanji> {
    public KanjiListAdapter(Context context, ArrayList<Kanji> objects) {
        super(context, R.layout.list_item_kanji, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        KanjiViewHolder viewHolder;

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_kanji, parent, false);
            viewHolder = new KanjiViewHolder();
            viewHolder.literal = (TextView) convertView.findViewById(R.id.kanjiListLiteral);
            viewHolder.components = (TextView) convertView.findViewById(R.id.kanjiListComponents);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (KanjiViewHolder) convertView.getTag();
        }

        Kanji kanji = getItem(position);

        if(kanji != null) {
            viewHolder.literal.setText(kanji.getLiteral());
            viewHolder.components.setText(kanji.getComponents());
        }

        return convertView;
    }
}
