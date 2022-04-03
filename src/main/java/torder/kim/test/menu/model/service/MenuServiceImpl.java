package torder.kim.test.menu.model.service;

import java.util.List;

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
		
		return menuRepository.findAll();
	}

}
