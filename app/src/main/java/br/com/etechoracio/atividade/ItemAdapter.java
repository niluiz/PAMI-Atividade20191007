package br.com.etechoracio.atividade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends BaseAdapter {

    private List<String> items = new ArrayList<>();
    private LayoutInflater inflater;

    public ItemAdapter(Context context) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        items.add("Darth Plagueis");
        items.add("Darth Sidious");
        items.add("Darth Maul");
        items.add("Darth Tyranus");
        items.add("Darth Vader");

    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.text = convertView.findViewById(R.id.text);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.text.setText(items.get(position));

        return convertView;
    }

    public int insertItem(String item) {
        items.add(item);
        notifyDataSetChanged();
        return items.size() - 1;
    }


    public void updateItem(int pos, String item) {
        items.set(pos, item);
        notifyDataSetChanged();
    }


    public void removeItem(int pos) {
        items.remove(pos);
        notifyDataSetChanged();
    }

    private static class ViewHolder {
        TextView text;
    }
}
