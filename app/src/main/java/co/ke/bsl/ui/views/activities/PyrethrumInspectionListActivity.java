package co.ke.bsl.ui.views.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.R;
import co.ke.bsl.data.model.PyrethrumInspection;
import co.ke.bsl.data.view.Total;
import co.ke.bsl.ui.viewmodels.PyrethrumInspectionViewModel;
import co.ke.bsl.ui.views.widgets.PyrethrumInspectionRecyclerAdapter;

public class PyrethrumInspectionListActivity extends AppCompatActivity {
    @BindView(R.id.pyrethrumRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private PyrethrumInspectionViewModel recordViewModel;
    private Total total;
    private StaggeredGridLayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pyrethrum_inspection_list);
        ButterKnife.bind(this);

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_chevron_left_white_24dp);
        toolbar.setNavigationIcon(upArrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        if (mRecyclerView != null) {
            //to enable optimization of recyclerview
            mRecyclerView.setHasFixedSize(true);
        }
        //using staggered grid pattern in recyclerview
        mLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        final PyrethrumInspectionRecyclerAdapter pyrethrumInspectionRecyclerAdapter = new PyrethrumInspectionRecyclerAdapter(this);
        mRecyclerView.setAdapter(pyrethrumInspectionRecyclerAdapter);

        recordViewModel = ViewModelProviders.of(this).get(PyrethrumInspectionViewModel.class);
        total = recordViewModel.countPyrethrumInspection();

        recordViewModel.getAllPyrethrumInspection().observe(this, new Observer<List<PyrethrumInspection>>() {
            @Override
            public void onChanged(List<PyrethrumInspection> pyrethrumInspectionList) {
                pyrethrumInspectionRecyclerAdapter.setItems(pyrethrumInspectionList);
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        onBackPressed();
        return true;
    }
}
