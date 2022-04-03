package torder.kim.test.menu.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMenu is a Querydsl query type for Menu
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMenu extends EntityPathBase<Menu> {

    private static final long serialVersionUID = 1800144447L;

    public static final QMenu menu = new QMenu("menu");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath menuCate = createString("menuCate");

    public final StringPath menuName = createString("menuName");

    public final NumberPath<Integer> menuPrice = createNumber("menuPrice", Integer.class);

    public final NumberPath<Integer> menuStock = createNumber("menuStock", Integer.class);

    public final StringPath menuValuableYn = createString("menuValuableYn");

    public QMenu(String variable) {
        super(Menu.class, forVariable(variable));
    }

    public QMenu(Path<? extends Menu> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMenu(PathMetadata metadata) {
        super(Menu.class, metadata);
    }

}

