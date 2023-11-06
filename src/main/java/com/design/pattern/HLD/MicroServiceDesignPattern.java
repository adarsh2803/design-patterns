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

        4.1 Decomposition Pattern :- Challenge is You should know the entire diff function in your business
            4.1.1 Decompose by Business logic :- Break it in like main business logic like Ordering , login then
                  use that as microservice  .
            4.1.2 Decompose by subdomain  :- Ordering is one subdomain then break further into subpart like
                  Refund , payments and make these subparts as microservices
                  Ex- Order management , Product Management , Account Management , Login Service ,Billing , Payments

       5. How to Decompose actually monolithic existing code to microservices :-
            There are many patterns but these 3 are most important and widely used .
            1. Strangler Pattern
            2. SAGA - Related to Transaction (ACID property) in Distributed DataBase
            3. CQRS - Related to Joining of tables in Distributed DataBase

       5.1 Strangler Pattern is used when we are refactoring monolithic legacy code to microservice
           We can't build whole microservice at once , we build some parts and then we make a controller which
           redirect the API traffic of that functionality then gradually as the other microservice get build , we delete
           the monolithic legacy code base .

       6. Data Management in Microservice
           1. DataBase for each individual service
           2. Shared DataBase

           6.2 Why Shared DBs are not successful :- Same as Monolithic vs MicroService Funda
           1. Let suppose 3 service - Order , Inventory , Payment . Inventory only have 2 products , but order
              come in millions . You have to scale only because of 1 , other not need it . Cost increase .
           2. It is possible that one table is used by other table , so if you want to delete column from some
              table then it is possible it might break other table.
           What is good in Shared DBs
           1. Easy to join any no. of tables
           2. Transactional property handling is easy , maintaining DB's ACID properties is easy . If any insertion
              in 1 table get fail then it will roll back insertions in prev transaction .

           6.1 What's good in Shared DB is challenges in Databases for each service
           SAGA solves the combined transaction property over distributed DB . In 1 DB local txn / rollback is easy ,
           but in distributed system  combined txn / rollback is a challenge which SAGA solves .
           CQRS solves the joining of tables in distributed DB system .

       7. SAGA Pattern - Simple API for Global Action .
           It is a event based approach to solve transaction property (ACID) of distributed systems.
           Suppose req1 touch 3 services DB - s1,s2,s3 . So , once s1 DB txn is complete it will give
           event to s2 when s2 DB txn is complete then event is published for s3 . if suppose s3 transaction
           fails then it gives a event to rollback txn in s2 then s2 will send to s1 .
           EX:-SAGA is implemented using choreography - series of events or by orchestrator (who do the same)
           orchestrator is a centralised system .
           ** API is interface (way to interact) for application , it is not limited to req-res interaction ,
           it can be event driven also .

      8. CQRS Pattern- Command (CUD) Query(R) Request Segregation . R= Select Query
          CQRS is used to join table in a separate table called as view , just to read data .
          Main DB is used to Create , Update , Delete the data .
          View is a combined DB with all tables T1 ,T2 of both DBs . Whenever main DB1's table T1 is
          updated then it will send an event or DB trigger to updated View DB's T1 table as well for data
          consistency in select or read query .
     */
}
