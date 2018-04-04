package chore.challenge

import grails.gorm.services.Service

@Service(Chore)
interface ChoreService {

    Chore get(Serializable id)

    List<Chore> list(Map args)

    Long count()

    void delete(Serializable id)

    Chore save(Chore chore)

}