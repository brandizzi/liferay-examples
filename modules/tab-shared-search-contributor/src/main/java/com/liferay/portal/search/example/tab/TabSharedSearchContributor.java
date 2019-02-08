package com.liferay.portal.search.example.tab;

import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.generic.BooleanClauseImpl;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.search.web.portlet.shared.search.PortletSharedSearchContributor;
import com.liferay.portal.search.web.portlet.shared.search.PortletSharedSearchSettings;

import java.util.Optional;

import org.osgi.service.component.annotations.Component;

/**
 * @author adam
 */
@Component(
	immediate = true, property = "javax.portlet.name=tabsportlet",
	service = PortletSharedSearchContributor.class
)
public class TabSharedSearchContributor
	implements PortletSharedSearchContributor {

	@Override
	public void contribute(
		PortletSharedSearchSettings portletSharedSearchSettings) {

		Optional<String> tabOptional = portletSharedSearchSettings.getParameter(
			"tab");

		tabOptional.ifPresent(
			tab -> {
				BooleanQueryImpl booleanQuery = new BooleanQueryImpl();

				booleanQuery.addRequiredTerm(
					Field.ASSET_TAG_NAMES + ".raw", tab);

				portletSharedSearchSettings.addCondition(
					new BooleanClauseImpl<Query>(
						booleanQuery, BooleanClauseOccur.MUST));
			});
	}

}