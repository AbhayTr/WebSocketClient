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

import java.io.*;
import java.net.*;
import javax.websocket.*;

@ClientEndpoint
public class WebSocketClient
{
    
    Session userSession = null;
    MessageListener msgListener;
    
    public WebSocketClient(String ws_url, MessageListener msgListener)
    {
        try
        {
            this.msgListener = msgListener;
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(WebSocketClient.this, new URI(ws_url));
        }
        catch (URISyntaxException | DeploymentException | IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    public WebSocketClient(String ws_url)
    {
        try
        {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(WebSocketClient.this, new URI(ws_url));
        }
        catch (URISyntaxException | DeploymentException | IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @OnOpen
    public void onOpen(Session userSession)
    {
        this.userSession = userSession;
        try
        {
            this.msgListener.onOpen();
        }
        catch (Exception e)
        {
            //No listener attached. Hence ignore...
        }
    }

    @OnClose
    public void onClose(Session userSession, CloseReason reason)
    {
        this.userSession = null;
        try
        {
            this.msgListener.onClose(reason.getReasonPhrase());
        }
        catch (Exception e)
        {
            //No listener attached. Hence ignore...
        }
    }

    @OnMessage
    public void onMessage(String message)
    {
        try
        {
            this.msgListener.onMessage(message);
        }
        catch (Exception e)
        {
            //No listener attached. Hence ignore...
        }
    }

    public void addMessageListener(MessageListener msgListener)
    {
        this.msgListener = msgListener;
    }

    public void sendMessage(String message)
    {
        this.userSession.getAsyncRemote().sendText(message);
    }
    
}