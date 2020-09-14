package co.ke.bsl.view.validation.textview;

import android.content.Context;

import co.ke.bsl.R;
import co.ke.bsl.view.validation.ViewValidator;

/**
 * Validates that the <code>EditText</code> contains a valid phone number,
 * consisting of digits and spaces, only.
 */
//reviewed
public class PhoneNumberValidator extends RegexValidator implements
		ViewValidator {
	private final static String REGEX = "[0-9+\\s+]+";

	public PhoneNumberValidator(Context context) {
		super(context, REGEX);
	}

	@Override
	public String getErrorMessage(String caption) {
		return context.getString(R.string.validation_phone, caption);
	}
}
