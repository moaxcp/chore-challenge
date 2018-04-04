package chore.challenge

import grails.gorm.services.Service

@Service(Zone)
interface ZoneService {

    Zone get(Serializable id)

    List<Zone> list(Map args)

    Long count()

    void delete(Serializable id)

    Zone save(Zone zone)

}