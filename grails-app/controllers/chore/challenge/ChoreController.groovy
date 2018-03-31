package chore.challenge

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_USER')
class ChoreController {
    static scaffold = Chore
}
