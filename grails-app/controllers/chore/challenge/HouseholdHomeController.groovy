package chore.challenge

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_USER')
class HouseholdHomeController {
    HouseholdService householdService
    def index() {
        [household:householdService.get(params.householdId)]
    }
}
