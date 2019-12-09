package org.academiadecodigo.cheguei.persistence.dao.jpa;

import org.academiadecodigo.cheguei.persistence.dao.EventsDao;
import org.academiadecodigo.cheguei.persistence.model.Events.Events;
import org.springframework.stereotype.Repository;

@Repository
public class JpaEventsDao extends GenericJpaDao<Events> implements EventsDao {

    public JpaEventsDao() {
        super(Events.class);
    }
}
