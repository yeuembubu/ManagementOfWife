package vn.com.hn.management.wife.huy_dq.managementofwife;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class PlanItemAdapter extends BaseAdapter {

    private List<String> objects;

    private Context context;
    private LayoutInflater layoutInflater;

    public PlanItemAdapter(Context context, List<String> objects) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public String getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.plan_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag(), position);
        return convertView;
    }

    private void initializeViews(String object, ViewHolder holder, int position) {
        holder.tvTitlePlanChild.setText(objects.get(position));
        holder.btnEditPlanChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Ok", Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected class ViewHolder {
        private TextView tvTitlePlanChild;
        private Button btnEditPlanChild;

        public ViewHolder(View view) {
            tvTitlePlanChild = view.findViewById(R.id.tvTitlePlanChild);
            btnEditPlanChild = view.findViewById(R.id.btnEditPlanChild);
        }
    }
}
