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
import co.ke.bsl.data.model.CoffeeNurseryCert;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;
import co.ke.bsl.ui.viewmodels.CoffeeNurseryCertificateViewModel;
import co.ke.bsl.ui.viewmodels.TeaPackerViewModel;
import co.ke.bsl.ui.views.widgets.CoffeeNurseryRecyclerAdapter;
import co.ke.bsl.ui.views.widgets.TeaPackerRecyclerAdapter;

public class CoffeeNurseryCertificateList extends AppCompatActivity {
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private CoffeeNurseryCertificateViewModel recordViewModel;
    private Total total;
    private StaggeredGridLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_nursery_inspection_list);
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


        final CoffeeNurseryRecyclerAdapter coffeeNurseryRecyclerAdapter =new CoffeeNurseryRecyclerAdapter(this);
        mRecyclerView.setAdapter(coffeeNurseryRecyclerAdapter);

        recordViewModel = ViewModelProviders.of(this).get(CoffeeNurseryCertificateViewModel.class);
        total = recordViewModel.countCoffeeNursery();

        recordViewModel.getAllCoffeeNurseries().observe(this, new Observer<List<CoffeeNurseryCert>>() {
            @Override
            public void onChanged(List<CoffeeNurseryCert> coffeeNurseryCertList) {
                coffeeNurseryRecyclerAdapter.setItems(coffeeNurseryCertList);
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