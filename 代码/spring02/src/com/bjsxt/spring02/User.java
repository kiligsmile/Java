package com.bjsxt.spring02;

import com.bjsxt.spring01.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {

      private    String []   arr;

      private List<String>   list;

      private Set<String>  set;

      private Map<String ,String>  map;

    public User(String[] arr, List<String> list, Set<String> set, Map<String, String> map) {
        this.arr = arr;
        this.list = list;
        this.set = set;
        this.map = map;
    }

    public User(){}

    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "User{" +
                "arr=" + Arrays.toString(arr) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                '}';
    }
}
