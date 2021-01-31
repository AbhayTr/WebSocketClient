package com.abhaytr.tools;

/*

Welcome to WebSocketClient

Java Module for connecting to TCP-IP WebSockets
without any other external dependencies
(this module uses javax.websocket module which is
included in this package jar file).

For usgae, kindly read the instructions in README.md
available at https://github.com/AbhayTr/WebSocketClient.

@params

WebSocket URL (Required):

  Specifies the Web Socket URL to which the client wants to connect.

  Parameter Value Type: String.

MessageListener (Optional):

  Attaches a listener (java interface) which handles events such as onOpen(), onClose(String error) and onMessage(String message).
  Explained in detail in "@Ovveride MessageListener Functions".

@WebSocketClient Class Functions

addMessageListener(MessageListener msglistener):

  Attaches a listener (java interface) which handles events such as onOpen(), onClose(String error) and onMessage(String message).
  Explained in detail in "@Ovveride MessageListener Functions".

sendMessage(String message):

  Sends Client's message to the Web Socket Server.

@Ovveride MessageListener Functions

onOpen():

  Called when connection is established between Web Socket Server and Client.

onClose(String error):

  Called when connection is disrupted/failed between Web Socket Server and Client.
  "error" is the reason for connection disruption/failiure.

onMessage(String message):

  Called when Web Socket Server sends a message to the client.
  "message" contains the message sent from the Web Socket Server.

Useful for realtime connections using TCP-IP Web Sockets in Java.

© Abhay Tripathi

*/

public interface MessageListener
{
    public void onMessage(String message);
    public void onOpen();
    public void onClose(String reason);
}