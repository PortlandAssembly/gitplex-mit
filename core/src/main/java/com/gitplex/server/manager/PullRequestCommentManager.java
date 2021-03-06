package com.gitplex.server.manager;

import com.gitplex.server.model.PullRequestComment;
import com.gitplex.server.persistence.dao.EntityManager;

public interface PullRequestCommentManager extends EntityManager<PullRequestComment> {

	void save(PullRequestComment comment, boolean notifyListeners);

}
