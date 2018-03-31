package chore.challenge

class Zone {

    RoleGroup group
    String name

    static constraints = {
        name unique:true
    }
}
