package com.design.pattern.HLD;

public class NetworkProtocol {
    /*
        1) 7 layers in Networking . Application and Transport Layer is most important
        2) Application layer have 2 protocols -
            - Client Server Protocol = HTTP (1 connection), FTP (2 connection) , SMTP (IMAP or POP3) , WebSockets
            - Peer2Peer Protocol     = WebRTC (UDP connection)

        3) Transport Layer used 2 protocols :-
            Data is divided into small packets called datagram / data packets
            TCP - ordering/sequencing is maintained + Acknowledgment of each packet is sent ,
                  if acknowledgment is not received back then packet is again sent
                  Used :-
            UDP - no ordering of data packets + no acknowledgment of packets - Very Fast wrt TCP
                  Used :- Live Streaming

        4) Websocket - Response can be sent even without a request from server to client . but client1 and client 2
                        can't talk with each other . Better than standard HTTP protocol .
        5) Peer2Peer - In this all server , client1 , client2 can talk to each other .
        6) FTP - have 2 connections - Control and Data connection . File transferred from Data connection is not
                 encrypted , hence FTP is not widely used & instead we use HTTPS .

        7) Mostly HTTPs is used in APIs , Websockets in ChatApps , WebRTC is video call app /live steaming

        8) SMTP is used for sending the mail and IMAP is used for receive/read mail . POP3 after reading mail deletes
           from source . POP3 is not used , only IMAP is used widely .
           user1 (send mails) -> MTA client -> MTA server -> user2 (receive) . MTA = Message transfer agent

        9) HTTPS vs HTTP

        10) TLS handshake `

     */
}
