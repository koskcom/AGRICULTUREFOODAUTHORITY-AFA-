package co.ke.bsl.view.validation.textview;

import android.content.Context;

import co.ke.bsl.R;
import co.ke.bsl.view.validation.ViewValidator;

/**
 * Validates that the <code>EditText</code> contains a valid ZIP code, that
 * consists of exactly 5 digits.
 */
//reviewed
public class ZipCodeValidator extends RegexValidator implements
		ViewValidator {
	private final static String REGEX = "[0-9]{5}";

	public ZipCodeValidator(Context context) {
		super(context, REGEX);
	}

	@Override
	public String getErrorMessage(String caption) {
		return context.getString(R.string.validation_zipCode, caption);
	}
}
