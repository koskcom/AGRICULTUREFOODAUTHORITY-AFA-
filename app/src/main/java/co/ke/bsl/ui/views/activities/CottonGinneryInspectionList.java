package co.ke.bsl.ui.views.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

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
import co.ke.bsl.data.model.FCDCottonGinneryInspection;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;
import co.ke.bsl.ui.viewmodels.CottonGinneryViewModel;
import co.ke.bsl.ui.viewmodels.TeaPackerViewModel;
import co.ke.bsl.ui.views.widgets.CottonGinneryRecyclerAdapter;
import co.ke.bsl.ui.views.widgets.TeaPackerRecyclerAdapter;

public class CottonGinneryInspectionList extends AppCompatActivity {
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private CottonGinneryViewModel recordViewModel;
    private Total total;
    private StaggeredGridLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotton_ginnery_list);
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


        final CottonGinneryRecyclerAdapter cottonGinneryRecyclerAdapter =new CottonGinneryRecyclerAdapter(this);
        mRecyclerView.setAdapter(cottonGinneryRecyclerAdapter);

        recordViewModel = ViewModelProviders.of(this).get(CottonGinneryViewModel.class);
        total = recordViewModel.countCottonGinnery();

        recordViewModel.getAllCottonGinneries().observe(this, new Observer<List<FCDCottonGinneryInspection>>() {
            @Override
            public void onChanged(List<FCDCottonGinneryInspection> cottonGinneryInspectionList) {
                cottonGinneryRecyclerAdapter.setItems(cottonGinneryInspectionList);
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