package torder.kim.test.payment.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPayment is a Querydsl query type for Payment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPayment extends EntityPathBase<Payment> {

    private static final long serialVersionUID = 569970705L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPayment payment = new QPayment("payment");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    protected torder.kim.test.member.model.entity.QMember memNo;

    protected torder.kim.test.menu.model.entity.QMenu menuNo;

    public final NumberPath<Integer> menuNum = createNumber("menuNum", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> payDate = createDateTime("payDate", java.time.LocalDateTime.class);

    public QPayment(String variable) {
        this(Payment.class, forVariable(variable), INITS);
    }

    public QPayment(Path<? extends Payment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPayment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPayment(PathMetadata metadata, PathInits inits) {
        this(Payment.class, metadata, inits);
    }

    public QPayment(Class<? extends Payment> type, PathMetadata metadata, PathInits inits) {
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

