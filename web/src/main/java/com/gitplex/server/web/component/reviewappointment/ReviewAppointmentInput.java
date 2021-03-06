package com.gitplex.server.web.component.reviewappointment;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.validation.IErrorMessageSource;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidationError;
import org.apache.wicket.validation.IValidator;

import com.gitplex.server.model.Project;
import com.gitplex.server.util.reviewappointment.ReviewAppointment;

@SuppressWarnings("serial")
public class ReviewAppointmentInput extends TextField<String> {

	private final IModel<Project> projectModel;
	
	public ReviewAppointmentInput(String id, IModel<Project> projectModel, IModel<String> exprModel) {
		super(id, exprModel);
		
		this.projectModel = projectModel;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		add(new ReviewAppointmentAssistBehavior(projectModel));
		add(new IValidator<String>() {

			@Override
			public void validate(IValidatable<String> validatable) {
				try {
					ReviewAppointment.parse(validatable.getValue()); 
				} catch (Exception e) {
					validatable.error(new IValidationError() {

						@Override
						public Serializable getErrorMessage(IErrorMessageSource messageSource) {
							if (StringUtils.isNotBlank(e.getMessage()))
								return e.getMessage();
							else
								return "Syntax error";
						}
						
					});
				}
			}
			
		});
	}

	@Override
	protected void onDetach() {
		projectModel.detach();
		super.onDetach();
	}

}
