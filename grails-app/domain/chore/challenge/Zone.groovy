package chore.challenge

class Zone {

    Household household
    String name

    static constraints = {
        name unique:true
    }
}
