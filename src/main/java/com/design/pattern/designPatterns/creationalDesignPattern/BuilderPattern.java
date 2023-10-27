package com.design.pattern.designPatterns.creationalDesignPattern;

/*
    Builder Pattern is used to create a complex object step by step .. conventionally in constructor , you need to remember
    the sequence of fields & you cannot leave them empty . Builder gives this flexibility

    How to achieve :- Make inner static class and return the innerclass while setting field values of inner class
 */

class Person{
    private String name;
    private String address;
    private Integer age;

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.address = personBuilder.address;
        this.age = personBuilder.age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", address='" + address + "'}";
    }

     public static class PersonBuilder{
        private String name;
        private String address;
        private Integer age;

        public PersonBuilder age(Integer ageValue){
            this.age=ageValue;
            return this;
        }

        public PersonBuilder name(String nameValue){
            this.name=nameValue;
            return this;
        }

        public PersonBuilder setAddress(String addressValue){
            this.address=addressValue;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {

        Person.PersonBuilder builder = new Person.PersonBuilder();
        Person p1 = builder.age(19).setAddress("Agra").name("Khyati").build();

        Person p2 = new Person.PersonBuilder().age(12).name("Ayesha").build();

        Person.PersonBuilder build = new Person.PersonBuilder();
        build.age(19).setAddress("Chandigarh").name("Virat").build();
        Person p3 = new Person(build);

        System.out.println(p1 + " " + p2 + " " + p3);
    }

}
