package chore.challenge

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ChoreServiceSpec extends Specification {

    ChoreService choreService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Chore(...).save(flush: true, failOnError: true)
        //new Chore(...).save(flush: true, failOnError: true)
        //Chore chore = new Chore(...).save(flush: true, failOnError: true)
        //new Chore(...).save(flush: true, failOnError: true)
        //new Chore(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //chore.id
    }

    void "test get"() {
        setupData()

        expect:
        choreService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Chore> choreList = choreService.list(max: 2, offset: 2)

        then:
        choreList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        choreService.count() == 5
    }

    void "test delete"() {
        Long choreId = setupData()

        expect:
        choreService.count() == 5

        when:
        choreService.delete(choreId)
        sessionFactory.currentSession.flush()

        then:
        choreService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Chore chore = new Chore()
        choreService.save(chore)

        then:
        chore.id != null
    }
}
