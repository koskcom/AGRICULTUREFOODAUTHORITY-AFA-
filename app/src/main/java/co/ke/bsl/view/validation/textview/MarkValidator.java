package co.ke.bsl.view.validation.textview;

import android.content.Context;

import co.ke.bsl.R;
import co.ke.bsl.view.validation.ViewValidator;


public class MarkValidator extends RegexValidator implements
		ViewValidator {
	private final static String REGEX = "[0-9]+";

	public MarkValidator(Context context) {
		super(context, REGEX);
	}

	@Override
	public String getErrorMessage(String caption) {
		return context.getString(R.string.validation_mark, caption);
	}
}
