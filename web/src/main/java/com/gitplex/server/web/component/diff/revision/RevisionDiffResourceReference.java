package com.gitplex.server.web.component.diff.revision;

import java.util.List;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;

import com.gitplex.server.web.assets.js.cookies.CookiesResourceReference;
import com.gitplex.server.web.assets.js.jqueryui.JQueryUIResourceReference;
import com.gitplex.server.web.page.base.BaseDependentCssResourceReference;
import com.gitplex.server.web.page.base.BaseDependentResourceReference;

public class RevisionDiffResourceReference extends BaseDependentResourceReference {

	private static final long serialVersionUID = 1L;

	public RevisionDiffResourceReference() {
		super(RevisionDiffResourceReference.class, "revision-diff.js");
	}

	@Override
	public List<HeaderItem> getDependencies() {
		List<HeaderItem> dependencies = super.getDependencies();
		dependencies.add(JavaScriptHeaderItem.forReference(new JQueryUIResourceReference()));
		dependencies.add(JavaScriptHeaderItem.forReference(new CookiesResourceReference()));
		dependencies.add(CssHeaderItem.forReference(new BaseDependentCssResourceReference(RevisionDiffResourceReference.class, "revision-diff.css")));
		return dependencies;
	}

}
