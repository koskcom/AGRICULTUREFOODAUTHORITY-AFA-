package co.ke.bsl.view.validation.textview;

import android.content.Context;

import co.ke.bsl.R;
import co.ke.bsl.view.validation.ViewValidator;


public class PasswordValidator  extends RegexValidator implements
		ViewValidator {
	private final static String REGEX ="[A-Z]*[a-zA-Z]*[0-9]*.{5}";

	public PasswordValidator(Context context) {
		super(context, REGEX);
	}

	@Override
	public String getErrorMessage(String caption) {
		return context.getString(R.string.validation_password, caption);
	}
	
}