package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello World");
        Main.fizzBuzz();

        System.out.println(Main.isEven(10));
        System.out.println(Main.isEven(7));
        Integer[] numbers ={1, 3,8, -10, 78};
        System.out.println(Main.getMinimum(numbers));
        ArrayList<User> user= Main.getParsedUsers(Data.users);
       // System.out.println(user);

        //Main.printUsers_OMN(user);
        //Main.printUsersSortedByAge(user);
        //Main.printUsersOldest10(user);
        //Main.printUserStateStats(user);
        //Set<String> overlap = Main.getWordOverlap(Data.words_1, Data.words_2);
        //System.out.println(overlap);
        ArrayList<User> usersA= Main.getParsedUsers(Data.users);
        ArrayList<User> usersB= Main.getParsedUsers(Data.otherUsers);
        System.out.println(Main.getUserOverlap(usersA, usersB));
    }

    //Question 1
    public static void fizzBuzz(){
        for (int i = 1; i <= 20; i++) {
            if (i %3==0 && i%5==0){
                System.out.println("FizzBuzz");
            } else if (i%3==0) {
                System.out.println("Fizz");

            } else if (i%5==0) {
                System.out.println("Buzz");
                
            }
            else {
                System.out.println(i);
            }
        }


    }

    //Question 2
    public static boolean isEven(Integer num){

        return (num%2==0);
    }

    //Question 3
    public static Integer getMinimum(Integer[] numbers){
        if(numbers==null || numbers.length ==0){
            return null;
        }
        Integer min =numbers[0];
        for (Integer num:numbers) {
            if(num<min)
            {
               min=num;
            }

        }
        return min;
    }


    public static ArrayList<User> getParsedUsers(String[] strings){
        ArrayList<User> users = new ArrayList<>();
        for (String line:strings) {
            User user =new User(line);
            users.add(user);
        }
     return users;
    }

    public static void printUsers_OMN(ArrayList<User> users){
        for (User user:users
             ) {
            if(user.getFname().startsWith("O") ||user.getFname().startsWith("M")|| user.getFname().startsWith("N")) {
                System.out.println(user.getFname());
            }

        }

    }

    public static void printUsersSortedByAge(ArrayList<User> users){
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {

                return (o1.getAge()-o2.getAge());
            }
        });
        for (User user:users
             ) {
            System.out.println(user.getAge()+" "+user.getFname());

        }
    }

    public static void printUsersOldest10(ArrayList<User> users){
        Collections.sort(users, new Comparator<User>() {

            @Override
            public int compare(User o1, User o2) {
                return (-1*(o1.getAge()-o2.getAge()));
            }
        });
        for (int i = 0; i <Math.min(10, users.size()) ; i++) {
            User user =users.get(i);
            System.out.println(user.getAge()+" "+ user.getFname());
        }
    }

    public static void printUserStateStats(ArrayList<User> users){
        HashMap<String, Integer> counts =new HashMap<>();
        for (User user:users
             ) {
            if(counts.containsKey(user.getState())){
                Integer currentCounts =counts.get(user.getState());
                counts.put(user.getState(), currentCounts+1);
            }else {
                counts.put(user.getState(), 1);
            }

        }
        for (String key:counts.keySet()
             ) {
            System.out.println(key +": "+ counts.get(key));
            
        }

    }

    public static Set<String> getWordOverlap(String[] listA, String[] listB){
        HashSet<String> overlap =new HashSet<>();
        HashSet<String> setA =new HashSet<>();
        for (String word:listA
             ) {
            setA.add(word);

        }
        for (String word:listB
             ) {
            if (setA.contains(word)){
                overlap.add(word);
            }

        }
        return overlap;
    }

    public static ArrayList<User> getUserOverlap(ArrayList<User> usersA, ArrayList<User> usersB){
        HashSet<User> overlap = new HashSet<>();
        HashSet<User> setA = new HashSet<>();
        for (User user:usersA
             ) {
            setA.add(user);

        }
        for (User user:usersB
             ) {
            if(setA.contains(user)){
                overlap.add(user);
            }
        }
   return new ArrayList<>(overlap);
    }
/*
    //Question 4
    public static ArrayList<User> getParsedUsers(String[] strings){

    }

    //Question 5
    public static void printUsers_OMN(ArrayList<User> users){

    }


    //Question 6
    public static void printUsersSortedByAge(ArrayList<User> users){

    }

    //Question 7
    public static void printUsersOldest10(ArrayList<User> users){

    }

    //Question 8
    public static void printUserStateStats(ArrayList<User> users){

    }

    //Question 9
    public static Set<String> getWordOverlap(String[] listA, String[] listB){

    }

    //Question 10
    public static ArrayList<User> getUserOverlap(ArrayList<User> usersA, ArrayList<User> usersB){

    }
*/


}
