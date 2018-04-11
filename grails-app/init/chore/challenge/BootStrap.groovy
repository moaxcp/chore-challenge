package chore.challenge

class BootStrap {

    def init = { servletContext ->
        Role userRole = new Role(authority:'ROLE_USER').save()
        Role adminRole = new Role(authority:'ROLE_HOUSE_ADMIN').save()
        Role siteAdmin = new Role(authority:'ROLE_SITE_ADMIN').save()

        def john = new User(username:'john', password:'password').save()
        def megan = new User(username:'megan', password:'password').save()
        def elijah = new User(username:'elijah', password:'password', enabled:false).save()
        def caleb = new User(username:'caleb', password:'password', enabled:false).save()
        def lucas = new User(username:'lucas', password:'password', enabled:false).save()

        Household mercier = new Household(name:'mercier', users:[john, megan, elijah, caleb, lucas]).save()

        [john, megan, elijah, caleb, lucas].each {
            UserRole.create(it, userRole, true)
        }

        [john, megan].each {
            UserRole.create(it, adminRole, true)
            UserRole.create(it, siteAdmin, true)
        }

        assert User.count() == 5
        assert Role.count() == 3
        assert UserRole.count() == 9

        Zone zone = new Zone(name:'Living Room', household:mercier).save()
    }
    def destroy = {
    }
}
