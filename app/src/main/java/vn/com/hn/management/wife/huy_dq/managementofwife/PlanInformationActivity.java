package vn.com.hn.management.wife.huy_dq.managementofwife;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlanInformationActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNotePlanInfo;
    private Spinner spTypePlanInfor, spSourcePlanInfor, spPayMethodPlanInfor, spSourceChildPlanInfor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan_infor_layout);

        spTypePlanInfor = findViewById(R.id.spTypePlanInfor);
        spSourcePlanInfor = findViewById(R.id.spSourcePlanInfor);
        spPayMethodPlanInfor = findViewById(R.id.spPayMethodPlanInfor);
        spSourceChildPlanInfor = findViewById(R.id.spSourceChildPlanInfor);
        etNotePlanInfo = findViewById(R.id.etNotePlanInfo);

        spTypePlanInfor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> adapter;
                if (position == 0) {
                    adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, R.id.tvTitleSpinner,
                            convertToList(getResources().getStringArray(R.array.budget_source_entries)));
                } else {
                    adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, R.id.tvTitleSpinner,
                            convertToList(getResources().getStringArray(R.array.budget_category_parent_entries)));
                }
                spSourcePlanInfor.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spSourcePlanInfor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> adapter;
                if (position == 0) {
                    adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, R.id.tvTitleSpinner,
                            convertToList(getResources().getStringArray(R.array.budget_category_living_expense_entries)));
                } else if (position == 1) {
                    adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, R.id.tvTitleSpinner,
                            convertToList(getResources().getStringArray(R.array.budget_category_parents_supporting_entries)));
                } else if (position == 2) {
                    adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, R.id.tvTitleSpinner,
                            convertToList(getResources().getStringArray(R.array.budget_category_for_children_entries)));
                } else if (position == 3) {
                    adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, R.id.tvTitleSpinner,
                            convertToList(getResources().getStringArray(R.array.budget_category_healthy_life_entries)));
                } else if (position == 4) {
                    adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, R.id.tvTitleSpinner,
                            convertToList(getResources().getStringArray(R.array.budget_category_education_entries)));
                } else if (position == 5) {
                    adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, R.id.tvTitleSpinner,
                            convertToList(getResources().getStringArray(R.array.budget_category_appearance_entries)));
                } else {
                    adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, R.id.tvTitleSpinner,
                            convertToList(getResources().getStringArray(R.array.budget_category_social_activities_entries)));
                }
                spSourceChildPlanInfor.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        findViewById(R.id.btnPayReceivePlanInfo).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPayReceivePlanInfo: {
                final String typePlan = spTypePlanInfor.getSelectedItem().toString();
                final String sourcePlan = spSourcePlanInfor.getSelectedItem().toString();
                final String payingMethod = spPayMethodPlanInfor.getSelectedItem().toString();

                final PlanDatabase db = PlanDatabase.instance(getApplicationContext());

                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... voids) {
                        Plan p = new Plan();
                        p.setDetailsNote(etNotePlanInfo.getText().toString());
                        p.setObjective(convertToBoolean(typePlan));
                        p.setType(convertToBoolean(sourcePlan));
                        p.setPayingMethod(payingMethod);

                        // TODO date, update later
                        p.setPayingDate(new Date());

                        db.planDao().insertAll(p);
                        return null;
                    }
                }.execute();

            }
            break;
        }
    }

    private boolean convertToBoolean(String s) {
        if (s.equalsIgnoreCase("In") || s.equalsIgnoreCase("Received")) return true;
        else return false;
    }

    private List<String> convertToList(String[] values) {
        List<String> datas = new ArrayList<>();
        for (String s : values) {
            datas.add(s);
        }
        return datas;
    }
}
