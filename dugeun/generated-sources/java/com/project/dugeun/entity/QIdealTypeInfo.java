package com.project.dugeun.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QIdealTypeInfo is a Querydsl query type for IdealTypeInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QIdealTypeInfo extends EntityPathBase<IdealTypeInfo> {

    private static final long serialVersionUID = -1757757834L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QIdealTypeInfo idealTypeInfo = new QIdealTypeInfo("idealTypeInfo");

    public final NumberPath<Long> idealTypeInfoId = createNumber("idealTypeInfoId", Long.class);

    public final QUser user;

    public QIdealTypeInfo(String variable) {
        this(IdealTypeInfo.class, forVariable(variable), INITS);
    }

    public QIdealTypeInfo(Path<? extends IdealTypeInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QIdealTypeInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QIdealTypeInfo(PathMetadata metadata, PathInits inits) {
        this(IdealTypeInfo.class, metadata, inits);
    }

    public QIdealTypeInfo(Class<? extends IdealTypeInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

