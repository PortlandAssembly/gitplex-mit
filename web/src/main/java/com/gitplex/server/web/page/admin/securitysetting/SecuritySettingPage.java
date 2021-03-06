package com.gitplex.server.web.page.admin.securitysetting;

import org.apache.wicket.markup.html.form.Form;

import com.gitplex.server.GitPlex;
import com.gitplex.server.manager.ConfigManager;
import com.gitplex.server.model.support.setting.SecuritySetting;
import com.gitplex.server.web.editable.BeanContext;
import com.gitplex.server.web.page.admin.AdministrationPage;

@SuppressWarnings("serial")
public class SecuritySettingPage extends AdministrationPage {

	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		SecuritySetting securitySetting = GitPlex.getInstance(ConfigManager.class).getSecuritySetting();

		Form<?> form = new Form<Void>("securitySetting") {

			@Override
			protected void onSubmit() {
				super.onSubmit();
				GitPlex.getInstance(ConfigManager.class).saveSecuritySetting(securitySetting);
				getSession().success("Security setting has been updated");
				
				setResponsePage(SecuritySettingPage.class);
			}
			
		};
		form.add(BeanContext.editBean("editor", securitySetting));
		
		add(form);
	}

}
