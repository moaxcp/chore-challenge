package chore.challenge

class Chore {

    RoleGroup group

    String name
    String description
    int points
    String schedule
    Zone zone
    Period finishBy
    List<User> includeUsers
    List<User> excludeUsers

    enum Period {
        MORNING,
        AFTERNOON,
        EVENING,
        ANYTIME
    }

    static constraints = {
        name unique:true
    }
}
