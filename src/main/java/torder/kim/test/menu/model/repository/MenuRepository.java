package torder.kim.test.menu.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import torder.kim.test.menu.model.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
