package chore.challenge

class BootStrap {

    def init = { servletContext ->
        Role userRole = new Role(authority:'ROLE_USER').save()
        Role adminRole = new Role(authority:'ROLE_ADMIN').save()

        RoleGroup mercier = new RoleGroup(name:'Mercier').save()
        RoleGroup mercierAdmin = new RoleGroup(name:'MercierAdmin').save()

        RoleGroupRole.create(mercier, userRole, true)
        RoleGroupRole.create(mercierAdmin, adminRole, true)

        def john = new User(username:'john', password:'password').save()
        def megan = new User(username:'megan', password:'password').save()
        def elijah = new User(username:'elijah', password:'password', enabled:false).save()
        def caleb = new User(username:'caleb', password:'password', enabled:false).save()
        def lucas = new User(username:'lucas', password:'password', enabled:false).save()

        [john, megan, elijah, caleb, lucas].each {
            UserRoleGroup.create(it, mercier, true)
        }
        [john, megan].each {
            UserRoleGroup.create(it, mercierAdmin, true)
        }


        assert RoleGroup.count() == 2
        assert User.count() == 5
        assert Role.count() == 2
        assert UserRoleGroup.count() == 7
    }
    def destroy = {
    }
}
