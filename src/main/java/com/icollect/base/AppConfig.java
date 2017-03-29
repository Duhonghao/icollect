package com.icollect.base;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.jfinal.config.*;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

/**
 * Created by Administrator on 2017/3/27 0027.
 */
public class AppConfig extends JFinalConfig {


	public void configConstant(Constants constants) {




		//开发模式设置
		constants.setDevMode(true);

		if (constants.getDevMode())
			PropKit.use("test.properties");
		else
			PropKit.use("config.properties");






	}

	public void configRoute(Routes routes) {

		routes.add(new FrontRouteConfig());

	}

	public void configEngine(Engine engine) {

	}

	public void configPlugin(Plugins plugins) {


		DruidPlugin dp = new DruidPlugin(PropKit.get("db.jdbcurl"), PropKit.get("db.user"), PropKit.get("db.password"));
		dp.addFilter(new StatFilter());
		WallFilter wall = new WallFilter();
		wall.setDbType("mysql");
		dp.addFilter(wall);
		plugins.add(dp);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		arp.setShowSql(true);
//		arp.setBaseSqlTemplatePath(PathKit.getRootClassPath());
//		arp.addSqlTemplate("demo.sql");
		plugins.add(arp);


	}

	public void configInterceptor(Interceptors interceptors) {

	}

	public void configHandler(Handlers handlers) {

	}
}
