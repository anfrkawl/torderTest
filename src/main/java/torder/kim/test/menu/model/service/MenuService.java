package torder.kim.test.menu.model.service;

import java.util.List;

import org.json.simple.JSONArray;

import torder.kim.test.menu.model.entity.Menu;

public interface MenuService {

	List<Menu> selectMenuList();

	int orderMenu(Long[] menuId, Long[] menuNum);

}
