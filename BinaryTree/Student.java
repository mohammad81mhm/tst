package com.company;

public class Student implements Comparable<Student> {
    public int id;
    public String name;
    public int age;

    public static void main(String[] args){
        BinarySearchTree<Student> bst= new BinarySearchTree<>();
    }

    @Override
    public int compareTo(Student o) {
        return age-o.age;
    }
}
