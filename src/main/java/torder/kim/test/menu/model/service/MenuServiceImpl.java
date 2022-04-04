package torder.kim.test.menu.model.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import torder.kim.test.menu.model.entity.Menu;
import torder.kim.test.menu.model.repository.MenuRepository;

@Service("MenuService")
@Transactional
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{
	
	private final MenuRepository menuRepository;

	@Override
	public List<Menu> selectMenuList() {
		
		return menuRepository.findAll((Sort.by(Sort.Direction.ASC, "id")));
	}

	@Override
	public int orderMenu(Long[] menuId, Long[] menuNum) {

		int result = checkStock(menuId, menuNum);
		
		if(result != 0) {
			for(int i = 0; i < menuId.length; i++) {
				Menu menu = menuRepository.findById((int)(long)menuId[i]).get();
				menu.setMenuStock(menu.getMenuStock() - ((int)(long)menuNum[i]));
				menuRepository.save(menu);
			}
		} 
		return result;
	}

	private int checkStock(Long[] menuId, Long[] menuNum) {
		
		int result = 1;
		for(int i = 0; i < menuId.length; i++) {
			Menu menu = menuRepository.findById((int)(long)menuId[i]).get();
			if(menu.getMenuStock() - ((int)(long)menuNum[i]) < 0) {			
				result = 0;
			}
		}
		return result;
	}


}
