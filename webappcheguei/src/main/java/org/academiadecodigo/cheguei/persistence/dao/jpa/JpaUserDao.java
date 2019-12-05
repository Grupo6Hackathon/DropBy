package org.academiadecodigo.cheguei.persistence.dao.jpa;

import org.academiadecodigo.cheguei.persistence.dao.UserDao;
import org.academiadecodigo.cheguei.persistence.model.User;

public class JpaUserDao extends GenericJpaDao<User> implements UserDao {

    public JpaUserDao() {
        super(User.class);
    }
}
