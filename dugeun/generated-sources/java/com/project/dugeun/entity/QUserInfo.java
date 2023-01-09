package com.project.dugeun.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserInfo is a Querydsl query type for UserInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserInfo extends EntityPathBase<UserInfo> {

    private static final long serialVersionUID = 395897728L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserInfo userInfo = new QUserInfo("userInfo");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath department = createString("department");

    public final StringPath description = createString("description");

    public final EnumPath<com.project.dugeun.constant.DrinkStatus> drink = createEnum("drink", com.project.dugeun.constant.DrinkStatus.class);

    public final StringPath firstPriority = createString("firstPriority");

    public final EnumPath<com.project.dugeun.constant.GenderStatus> gender = createEnum("gender", com.project.dugeun.constant.GenderStatus.class);

    public final StringPath height = createString("height");

    public final EnumPath<com.project.dugeun.constant.PhysicalStatus> physical = createEnum("physical", com.project.dugeun.constant.PhysicalStatus.class);

    public final StringPath secondPriority = createString("secondPriority");

    public final BooleanPath smoke = createBoolean("smoke");

    public final StringPath thirdPriority = createString("thirdPriority");

    public final QUser user;

    public final NumberPath<Long> userInfoId = createNumber("userInfoId", Long.class);

    public QUserInfo(String variable) {
        this(UserInfo.class, forVariable(variable), INITS);
    }

    public QUserInfo(Path<? extends UserInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserInfo(PathMetadata metadata, PathInits inits) {
        this(UserInfo.class, metadata, inits);
    }

    public QUserInfo(Class<? extends UserInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

