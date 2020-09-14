package co.ke.bsl.view.validation.spinner;

import android.view.View;
import android.widget.Spinner;

import co.ke.bsl.view.validation.ViewValidator;

// reviewed
public class OptionalSelectionSpinnerValidator implements ViewValidator {

	@Override
	public boolean validate(View view) {
		Spinner spinner = (Spinner) view;
		return spinner.getSelectedItemPosition() > 0;
	}

	@Override
	public String getErrorMessage(String caption) {
		throw new UnsupportedOperationException(
				"Cannot assign an error message to a Spinner, "
						+ "thus we don't provide it here.");
	}
}
