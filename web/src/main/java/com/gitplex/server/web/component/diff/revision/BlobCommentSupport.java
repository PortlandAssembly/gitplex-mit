package com.gitplex.server.web.component.diff.revision;

import java.util.Collection;

import javax.annotation.Nullable;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;

import com.gitplex.server.model.CodeComment;
import com.gitplex.server.model.support.MarkPos;

public interface BlobCommentSupport extends MarkSupport {
	
	Collection<CodeComment> getComments();
	
	@Nullable CodeComment getOpenComment();

	void onOpenComment(AjaxRequestTarget target, CodeComment comment);
	
	void onAddComment(AjaxRequestTarget target, MarkPos markPos);
	
	Component getDirtyContainer();
	
}
