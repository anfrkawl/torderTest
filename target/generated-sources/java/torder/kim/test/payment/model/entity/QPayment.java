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

    protected torder.kim.test.order.model.entity.QOrderHistory orderNo;

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
        this.orderNo = inits.isInitialized("orderNo") ? new torder.kim.test.order.model.entity.QOrderHistory(forProperty("orderNo"), inits.get("orderNo")) : null;
    }

    public torder.kim.test.order.model.entity.QOrderHistory orderNo() {
        if (orderNo == null) {
            orderNo = new torder.kim.test.order.model.entity.QOrderHistory(forProperty("orderNo"));
        }
        return orderNo;
    }

}

