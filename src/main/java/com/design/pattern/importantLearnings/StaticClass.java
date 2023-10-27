package com.design.pattern.importantLearnings;

/*
    Outer class cannot be static , only inner class can be made static
    Use Case :-
    Static nested classes are often used when you want to group related data with the outer class
    but don't need to access the instance members of the outer class.
    Here's an example of a common use case for a static nested class: representing a constant set

    Some Conclusion :-
    1) Static variables/functions can be only be used inside static functions
    2) you can call static variables/funtions inside non static methods but not vice versa
    3) Define inner static variable :- Network.Constants constants  = new Network.Constants();
 */

class Network{
    public final String outerNonStaticVariable = "outerNonStaticVariable";
    public static final int outerStaticVariable = 10;

    public void outerNonStaticFunction(){
//        outerStaticFunction();  Allowed
        System.out.println("Outer NonStatic Function " + outerNonStaticVariable + " " + outerStaticVariable);
    }

    public static void outerStaticFunction(){
//        outerNonStaticFunction();  Not Allowed
        System.out.println("Outer Static Function " + outerStaticVariable);
    }

    public static class Constants {
        public final String innerNonStaticVariable = "innerNonStaticVariable";
        public static final int innerStaticVariable = 10;

        public void innerNonStaticFunction(){
//            innerStaticFunction(); Allowed
            System.out.println("Inner NonStatic Function" + innerNonStaticVariable);
        }

        public static void innerStaticFunction(){
//            innerNonStaticFunction(); Not Allowed
            System.out.println("Inner Static Function " + innerStaticVariable);
        }

    }

    public void f(){
        //OuterClass
        Network network = new Network();
        System.out.println(Network.outerStaticVariable + " " + network.outerNonStaticVariable);
        Network.outerStaticFunction();
        network.outerNonStaticFunction();

        //InnerClass
        Network.Constants constants = new Network.Constants();
        System.out.println(constants.innerNonStaticVariable + " " + Network.Constants.innerStaticVariable);
        constants.innerNonStaticFunction();
        Network.Constants.innerStaticFunction();
    }

    public static void main(String[] args) {
        //OuterClass
        Network network = new Network();
        System.out.println(Network.outerStaticVariable + " " + network.outerNonStaticVariable);
        Network.outerStaticFunction();
        network.outerNonStaticFunction();

        //InnerClass
        Network.Constants constants = new Network.Constants();
        System.out.println(constants.innerNonStaticVariable + " " + Network.Constants.innerStaticVariable);
        constants.innerNonStaticFunction();
        Network.Constants.innerStaticFunction();
    }
}

class StaticClass {
    public static void f(){
        //OuterClass
        Network network = new Network();
        System.out.println(Network.outerStaticVariable + " " + network.outerNonStaticVariable);
        Network.outerStaticFunction();
        network.outerNonStaticFunction();

        //InnerClass
        Network.Constants constants = new Network.Constants();
        System.out.println(constants.innerNonStaticVariable + " " + Network.Constants.innerStaticVariable);
        constants.innerNonStaticFunction();
        Network.Constants.innerStaticFunction();
    }

    public static void main(String[] args) {
        //OuterClass
        Network network = new Network();
        System.out.println(Network.outerStaticVariable + " " + network.outerNonStaticVariable);
        Network.outerStaticFunction();
        network.outerNonStaticFunction();

        //InnerClass
        Network.Constants constants = new Network.Constants();
        System.out.println(constants.innerNonStaticVariable + " " + Network.Constants.innerStaticVariable);
        constants.innerNonStaticFunction();
        Network.Constants.innerStaticFunction();


    }
}
