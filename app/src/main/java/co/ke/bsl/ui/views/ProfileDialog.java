package co.ke.bsl.ui.views;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;

import java.util.Objects;

import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.pojo.ADUser;

public class ProfileDialog extends DialogFragment {

    private static MaterialDialog.SingleButtonCallback callback;

    AFA app;
    private AFADatabaseAdapter db;

    public static ProfileDialog newInstance(MaterialDialog.SingleButtonCallback buttonCallback) {
        callback = buttonCallback;
        return new ProfileDialog();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_profile, null, false);


        TextView name = view.findViewById(R.id.text_view_name);
        TextView email = view.findViewById(R.id.text_view_email);
        ImageView imageView = view.findViewById(R.id.image_view_user);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext());

        ADUser adUser = db.getADUser();

        if(null != adUser) {
            name.setText(adUser.getAd_user_name());
            email.setText(adUser.getAd_user_email());
        }
//        name.setText(app.settings.getFullName());
//        email.setText(app.settings.getEmail());

        Glide.with(this)
                .load(R.drawable.logo)
                .into(imageView);

        return new MaterialDialog.Builder(getActivity())
                .customView(view, false)
                .positiveText("Sign out")
                .onPositive(callback)
                .build();
    }
}
