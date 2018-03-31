package chore.challenge

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_USER')
class ZoneController {
    static scaffold = Zone
}
