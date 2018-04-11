package chore.challenge

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@GrailsCompileStatic
@EqualsAndHashCode(includes=['name', 'users'])
@ToString(includes='name', includeNames=true, includePackage=false)
class Household implements Comparable {
    static hasMany = [users:User]
    String name
    SortedSet<User> users
    static constraints = {
        name nullable: false, blank: false, unique: true
    }

    @Override
    int compareTo(Object o) {
        if(!(o instanceof Household)) {
            return false
        }
        Household other = (Household) o
        name.compareTo(other.name)
    }
}
