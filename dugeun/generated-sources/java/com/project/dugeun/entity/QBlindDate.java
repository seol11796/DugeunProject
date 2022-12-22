package com.project.dugeun.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBlindDate is a Querydsl query type for BlindDate
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBlindDate extends EntityPathBase<BlindDate> {

    private static final long serialVersionUID = -780736228L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBlindDate blindDate = new QBlindDate("blindDate");

    public final NumberPath<Long> another_user_id = createNumber("another_user_id", Long.class);

    public final NumberPath<Long> another_user_score = createNumber("another_user_score", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> introducedDate = createDateTime("introducedDate", java.util.Date.class);

    public final QUser user;

    public final NumberPath<Long> user_score = createNumber("user_score", Long.class);

    public QBlindDate(String variable) {
        this(BlindDate.class, forVariable(variable), INITS);
    }

    public QBlindDate(Path<? extends BlindDate> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBlindDate(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBlindDate(PathMetadata metadata, PathInits inits) {
        this(BlindDate.class, metadata, inits);
    }

    public QBlindDate(Class<? extends BlindDate> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

