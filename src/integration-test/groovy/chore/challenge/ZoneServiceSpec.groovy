package chore.challenge

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ZoneServiceSpec extends Specification {

    ZoneService zoneService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Zone(...).save(flush: true, failOnError: true)
        //new Zone(...).save(flush: true, failOnError: true)
        //Zone zone = new Zone(...).save(flush: true, failOnError: true)
        //new Zone(...).save(flush: true, failOnError: true)
        //new Zone(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //zone.id
    }

    void "test get"() {
        setupData()

        expect:
        zoneService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Zone> zoneList = zoneService.list(max: 2, offset: 2)

        then:
        zoneList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        zoneService.count() == 5
    }

    void "test delete"() {
        Long zoneId = setupData()

        expect:
        zoneService.count() == 5

        when:
        zoneService.delete(zoneId)
        sessionFactory.currentSession.flush()

        then:
        zoneService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Zone zone = new Zone()
        zoneService.save(zone)

        then:
        zone.id != null
    }
}
