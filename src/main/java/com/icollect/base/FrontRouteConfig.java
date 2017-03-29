package com.icollect.base;

import com.icollect.controller.IndexController;
import com.jfinal.config.Routes;

/**
 * Created by Administrator on 2017/3/27 0027.
 */
public class FrontRouteConfig extends Routes {
	public void config() {
		setBaseViewPath("/_view");
		this.add("/", IndexController.class);//首页

	}
}
