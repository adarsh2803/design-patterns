package com.design.pattern.HLD;

public class MicroServiceDesignPattern {
    /*
        1.  Most Important topic in HLD interview - microservices and design patterns
            2 types architecture :- monolithic (legacy code) vs microservices

        2. Monolithic means - all code in 1 from frontend ,backend , inventory management , payments everything
           Downsides : -
           a. such codebase takes GBs space , take time to load in IDE . Continuous Integration (CI) job regression will
              take time due to large code base , even if one line is changed .
           b. scaling is hard - suppose you want order apis to run on multiple pods for scalability but besides that other
              payment , frontend will get scaled which is useless . Cost will increase .
           c. Tightly coupled app , its is possible a piece of function is used by multiple classes , it might break
              due to new change , so you need to test app thoroughly .

        3. Microservices simply means a monolithic system is breakdown into several sub services like billing ,
           product , ordering , login etc .
           Advantage :- Separately you can scale service based on requirement like ordering = 4 pods. Cost cutting
           Disadvantage :-
           1. It is tough to break bigger system properly into subsystem so that they are loosely coupled i.e even after
              breaking into subsystem they shouldn't be calling each other and are dependent on each other .
           2. s1->s2 , s1 is dependent of s2 , if s2 response changes and s1 break . So you need to check client using
              service should also be compatible . Debugging is tough
           3. Transaction management is difficult i.e. Monolithic service have only 1 DB . ordering and messaging - 2 table
              in 1 DB . So , in 1 DB it is easy to stop/place order , but in microservice 2 DB so if transaction fails
              in any 1 DB , then you have to roll back the entire request in both DBs.

        4. Different Phases of Microservices :- ALWAYS THINK IN THIS WAY
           1. Decomposition :- Decompose by Business logic or decompose by subdomain
           2. DataBase :- DataBase per Service or Shared Common DataBase
           3. Communication :- API or Events
           4. Integration :- How to integrate this microservice with UIs ex-> API gateways
           5. Deployment & Monitoring :- Jenkins , Docker , Grafana


     */
}
