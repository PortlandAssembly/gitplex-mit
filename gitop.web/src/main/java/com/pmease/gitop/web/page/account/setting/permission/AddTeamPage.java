package com.pmease.gitop.web.page.account.setting.permission;

import com.pmease.gitop.core.model.Team;

@SuppressWarnings("serial")
public class AddTeamPage extends EditTeamPage {

	public AddTeamPage() {
	}
	
	@Override
	protected Team getTeam() {
		return new Team();
	}
}