package co.ke.bsl.ui.views.activities.components;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.stepstone.stepper.StepperLayout;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.R;

public class CaneProductionDeliveriesInOutgrowersActivity extends AppCompatActivity {

    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appBarMain)
    AppBarLayout appBarMain;
    @BindView(R.id.stepperLayout)
    StepperLayout stepperLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cane_production_deliveries_in_outgrowers);

        ButterKnife.bind(this);

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_chevron_left_white_24dp);
        toolbar.setNavigationIcon(upArrow);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        stepperLayout.setAdapter(new CaneProductionDeliveriesInOutgrowersAdapter(getSupportFragmentManager(), this));

    }

    @Override
    public boolean onSupportNavigateUp()
    {
        finish();
        onBackPressed();
        return true;
    }
}
