package com.java_course.collections;

import java.util.TreeSet;

/**
TreeSet is collection which contains sorted unique objects
 */
public class TreeSetTest {

    private static final TreeSet<User> userTreeSet = new TreeSet<>();

    public static void main(String[] args) {
        userTreeSet.add(new User("QWERTY-0002", 20));
        userTreeSet.add(new User("QWERTY-0001", 25));
        userTreeSet.add(new User("QWERTY-0001", 25));//will not be added to set
        userTreeSet.add(new User("QWERTY-0002", 20));//will not be added to set
        userTreeSet.add(new User("QWERTY-0001", 30));

        for (User u : userTreeSet) {
            System.out.println(u);
        }
    }
}

class User implements Comparable<User> {
    private final String uuid;
    private final Integer age;

    public User(String uuid, int age) {
        this.uuid = uuid;
        this.age = age;
    }

    public String getUuid() {
        return uuid;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public int compareTo(User o) {
        int compare = this.uuid.compareTo(o.uuid);
        if (compare != 0) {
            return compare;
        } else return this.age.compareTo(o.age);
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid='" + uuid + '\'' +
                ", age=" + age +
                '}';
    }
}