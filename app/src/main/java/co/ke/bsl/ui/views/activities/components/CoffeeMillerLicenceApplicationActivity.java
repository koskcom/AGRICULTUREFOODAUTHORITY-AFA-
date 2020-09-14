package co.ke.bsl.ui.views.activities.components;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.stepstone.stepper.StepperLayout;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.R;
import co.ke.bsl.ui.views.adapters.CoffeeMillerLicenseApplicationAdapter;

public class CoffeeMillerLicenceApplicationActivity extends AppCompatActivity {
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.toolbarr)
    Toolbar toolbarr;
    @BindView(R.id.appBarMain)
    AppBarLayout appBarMain;
    @BindView(R.id.stepperLayout)
    StepperLayout stepperLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_miller_licence_application);

        ButterKnife.bind(this);

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_chevron_left_white_24dp);
        toolbarr.setNavigationIcon(upArrow);
        setSupportActionBar(toolbarr);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        stepperLayout.setAdapter(new CoffeeMillerLicenseApplicationAdapter(getSupportFragmentManager(), this));
    }
    private static long back_pressed_time;
    private static long PERIOD = 2000;
    @Override
    public void onBackPressed()
    {
        if (back_pressed_time + PERIOD > System.currentTimeMillis()) super.onBackPressed();
        else
            //Toast.makeText(getBaseContext(), "Press Again To Exit!", Toast.LENGTH_SHORT).show();
            back_pressed_time = System.currentTimeMillis();

    }

    @Override
    public boolean onSupportNavigateUp()
    {

        onBackPressed();

        finish();
        return true;
    }
}
