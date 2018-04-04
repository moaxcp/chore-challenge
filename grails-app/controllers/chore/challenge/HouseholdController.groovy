package chore.challenge

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured('ROLE_USER')
class HouseholdController {

    HouseholdService householdService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond householdService.list(params), model:[householdCount: householdService.count()]
    }

    def show(Long id) {
        respond householdService.get(id)
    }

    @Secured('ROLE_HOUSE_ADMIN')
    def create() {
        respond new Household(params)
    }

    @Secured('ROLE_HOUSE_ADMIN')
    def save(Household household) {
        if (household == null) {
            notFound()
            return
        }

        try {
            householdService.save(household)
        } catch (ValidationException e) {
            respond household.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'household.label', default: 'Household'), household.id])
                redirect household
            }
            '*' { respond household, [status: CREATED] }
        }
    }

    @Secured('ROLE_HOUSE_ADMIN')
    def edit(Long id) {
        respond householdService.get(id)
    }

    @Secured('ROLE_HOUSE_ADMIN')
    def update(Household household) {
        if (household == null) {
            notFound()
            return
        }

        try {
            householdService.save(household)
        } catch (ValidationException e) {
            respond household.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'household.label', default: 'Household'), household.id])
                redirect household
            }
            '*'{ respond household, [status: OK] }
        }
    }

    @Secured('ROLE_HOUSE_ADMIN')
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        householdService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'household.label', default: 'Household'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'household.label', default: 'Household'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
