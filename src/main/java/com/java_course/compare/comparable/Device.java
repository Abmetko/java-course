package com.java_course.compare.comparable;

import java.util.Set;
import java.util.TreeSet;

public class Device implements Comparable<Device> {

    private final Double osVersion;
    private final String osName;
    private final Integer apiVersion;

    public Device(double osVersion, String osName, int apiVersion) {
        this.osVersion = osVersion;
        this.osName = osName;
        this.apiVersion = apiVersion;
    }

    @Override
    public int compareTo(Device o) {
        int api = this.apiVersion.compareTo(o.apiVersion);
        if (api != 0) {
            return api;
        } else return this.osVersion.compareTo(o.osVersion);
        /*
        В классах обертках типа String, Integer, Double реализован свой метод compareTo().
        Если результат равен 0, значит эти параметры равны и значит необходимо сравнивать следующий параметр,
        чтобы можно было отсортировать объекты.
         */
    }

    @Override
    public String toString() {
        return "Device{" +
                "osVersion=" + osVersion +
                ", osName='" + osName + '\'' +
                ", apiVersion=" + apiVersion +
                '}';
    }

    //TreeSet - это коллекция с автоматической сортировкой. Хранящая уникальные объекты.
    public static void main(String[] args) {
        Device device1 = new Device(11.0, "Android 11", 30);
        Device device2 = new Device(8.1, "Oreo", 27);
        Device device3 = new Device(9.0, "Pie", 28);
        Device device4 = new Device(10.0, "Android 10", 29);
        Device device5 = new Device(8.0, "Oreo", 26);

        Set<Device> set = new TreeSet<>();
        set.add(device1);
        set.add(device2);
        set.add(device3);
        set.add(device4);
        set.add(device5);

        for (Device d : set) {
            System.out.println(d.toString());
        }
    }
}