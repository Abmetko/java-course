package com.compare.comparator;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
В случае, если класс, объекты которого нам надо сравнивать,
недоступен для редактирования(имплементации интерфейса Comparable)
 */
class Device {

    public final Double osVersion;
    public final String osName;
    public final Integer apiVersion;

    public Device(double osVersion, String osName, int apiVersion) {
        this.osVersion = osVersion;
        this.osName = osName;
        this.apiVersion = apiVersion;
    }

    @Override
    public String toString() {
        return "Device{" +
                "osVersion=" + osVersion +
                ", osName='" + osName + '\'' +
                ", apiVersion=" + apiVersion +
                '}';
    }
}

class CompareDevices implements Comparator<Device> {

    @Override
    public int compare(Device o1, Device o2) {
        int api = o1.apiVersion - o2.apiVersion;
        if (api != 0) {
            return api;
        } else return o1.osVersion.compareTo(o2.osVersion);
    }
}

public class ComparatorTest {

    public static void main(String[] args) {
        Device device1 = new Device(11.0, "Android 11", 29);//30
        Device device2 = new Device(8.1, "Oreo", 27);
        Device device3 = new Device(9.0, "Pie", 28);
        Device device4 = new Device(10.0, "Android 10", 29);
        Device device5 = new Device(8.0, "Oreo", 26);

        Set<Device> set = new TreeSet<>(new CompareDevices());
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