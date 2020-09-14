package co.ke.bsl.view.validation.textview;

import android.content.Context;

import co.ke.bsl.R;
import co.ke.bsl.view.validation.ViewValidator;


/**
 * Validates that the <code>EditText</code> contains a valid email address.
 */
// reviewed
public class EmailValidator extends RegexValidator implements
		ViewValidator {
	private final static String REGEX = "[.\\w-]+@([\\w-]+\\.)+[\\w-]+";
	
	public EmailValidator(Context context) {
		super(context, REGEX);
	}

	@Override
	public String getErrorMessage(String caption) {
		return context.getString(R.string.validation_email,
				caption);
	}
}
