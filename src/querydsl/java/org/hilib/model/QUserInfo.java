package org.hilib.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QUserInfo is a Querydsl query type for UserInfo
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUserInfo extends EntityPathBase<UserInfo> {

    private static final long serialVersionUID = -1505571214L;

    public static final QUserInfo userInfo = new QUserInfo("userInfo");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath userId = createString("userId");

    public final StringPath userPassword = createString("userPassword");

    public QUserInfo(String variable) {
        super(UserInfo.class, forVariable(variable));
    }

    public QUserInfo(Path<? extends UserInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserInfo(PathMetadata<?> metadata) {
        super(UserInfo.class, metadata);
    }

}

