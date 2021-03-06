package chore.challenge

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured('ROLE_USER')
class ChoreController {

    ChoreService choreService
    ZoneService zoneService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond choreService.list(params), model:[choreCount: choreService.count()]
    }

    def show(Long id) {
        respond choreService.get(id)
    }

    @Secured('ROLE_HOUSE_ADMIN')
    def create() {
        respond new Chore(params), model:[zones:zoneService.list()]
    }

    @Secured('ROLE_HOUSE_ADMIN')
    def save(Chore chore) {
        if (chore == null) {
            notFound()
            return
        }

        try {
            choreService.save(chore)
        } catch (ValidationException e) {
            respond chore.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'chore.label', default: 'Chore'), chore.id])
                redirect chore
            }
            '*' { respond chore, [status: CREATED] }
        }
    }

    @Secured('ROLE_HOUSE_ADMIN')
    def edit(Long id) {
        respond choreService.get(id)
    }

    @Secured('ROLE_HOUSE_ADMIN')
    def update(Chore chore) {
        if (chore == null) {
            notFound()
            return
        }

        try {
            choreService.save(chore)
        } catch (ValidationException e) {
            respond chore.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'chore.label', default: 'Chore'), chore.id])
                redirect chore
            }
            '*'{ respond chore, [status: OK] }
        }
    }

    @Secured('ROLE_HOUSE_ADMIN')
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        choreService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'chore.label', default: 'Chore'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'chore.label', default: 'Chore'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
