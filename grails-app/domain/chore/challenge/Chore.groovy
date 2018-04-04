package chore.challenge

class Chore {
    Household household

    String summary
    String description
    int points
    String schedule
    Zone zone
    Period finishBy = Period.ANYTIME
    List<User> includeUsers
    List<User> excludeUsers

    enum Period {
        MORNING,
        AFTERNOON,
        EVENING,
        ANYTIME
    }

    static constraints = {
        summary unique:true
        description nullable:true
    }
}
