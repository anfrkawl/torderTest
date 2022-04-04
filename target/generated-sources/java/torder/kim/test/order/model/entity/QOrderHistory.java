package torder.kim.test.order.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderHistory is a Querydsl query type for OrderHistory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrderHistory extends EntityPathBase<OrderHistory> {

    private static final long serialVersionUID = 287145795L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderHistory orderHistory = new QOrderHistory("orderHistory");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    protected torder.kim.test.member.model.entity.QMember memNo;

    protected torder.kim.test.menu.model.entity.QMenu menuNo;

    public final NumberPath<Integer> menuNum = createNumber("menuNum", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> orderDate = createDateTime("orderDate", java.time.LocalDateTime.class);

    public QOrderHistory(String variable) {
        this(OrderHistory.class, forVariable(variable), INITS);
    }

    public QOrderHistory(Path<? extends OrderHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrderHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrderHistory(PathMetadata metadata, PathInits inits) {
        this(OrderHistory.class, metadata, inits);
    }

    public QOrderHistory(Class<? extends OrderHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.memNo = inits.isInitialized("memNo") ? new torder.kim.test.member.model.entity.QMember(forProperty("memNo")) : null;
        this.menuNo = inits.isInitialized("menuNo") ? new torder.kim.test.menu.model.entity.QMenu(forProperty("menuNo")) : null;
    }

    public torder.kim.test.member.model.entity.QMember memNo() {
        if (memNo == null) {
            memNo = new torder.kim.test.member.model.entity.QMember(forProperty("memNo"));
        }
        return memNo;
    }

    public torder.kim.test.menu.model.entity.QMenu menuNo() {
        if (menuNo == null) {
            menuNo = new torder.kim.test.menu.model.entity.QMenu(forProperty("menuNo"));
        }
        return menuNo;
    }

}

