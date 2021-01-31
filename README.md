# WebSocketClient

Java Module for connecting to TCP-IP WebSockets without any other external dependencies.
(this module uses javax.websocket module which is included in this package jar file)

## Installation

Simply include the **WebSocketClient.jar** file in your project.

### Special Guide For Android Projects:

- Create **libs** folder in your **app** folder where your **app level build.gradle** file is present.
- Download **WebSocketClient.jar** from here, and place it in the **libs** folder created in previous step.
- In your **app level build.gradle** file, add the following line in **dependencies block**:

```gradle
implementation fileTree(dir: "libs", include: ["*.jar"])
```

- Done!

## Usage

Simply use this code (Modify according to your needs):

```java
import com.abhaytr.tools.*;

class YourClass
{
  
  public static void main(String args[])
  {
    WebSocketClient ws = new WebSocketClient("wss://your-url.com/ws", new MessageListener()    //Replace "wss://your-url.com/ws" with Client's Web Socket URL.
    {
        
	@Ovveride
	public void onOpen()
	{
	    //Called when connection is established between Web Socket Server and Client.
	}

	@Ovveride
	public void onMessage(String message)
	{
	    /*
	    Called when Web Socket Server sends a message to the client.
  	    "message" contains the message sent from the Web Socket Server.
	    */
	}

	@Ovveride
	public void onClose(String error)
	{
	    /*
	    Called when connection is disrupted/failed between Web Socket Server and Client.
  	    "error" is the reason for connection disruption/failiure.
	    */
	}

    });
    //Functions available for module specified below in "Functions" section.
  }

}
```

## Functions

### addMessageListener(MessageListener msgListener)

```java
ws.addMessageListener(new MessageListener()
{
        
    @Ovveride
    public void onOpen()
    {
	//Called when connection is established between Web Socket Server and Client.
    }

    @Ovveride
    public void onMessage(String message)
    {
	/*
	Called when Web Socket Server sends a message to the client.
  	"message" contains the message sent from the Web Socket Server.
	*/
    }

    @Ovveride
    public void onClose(String error)
    {
	/*
	Called when connection is disrupted/failed between Web Socket Server and Client.
  	"error" is the reason for connection disruption/failiure.
	*/
    }

});
```

Attaches a listener (java interface) which handles events such as onOpen(), onClose(String error) and onMessage(String message).

### sendMessage(String message)

```java
ws.sendMessage("Hello Web Socket Server!");   //Replace "Hello Web Socket Server!" with Client's message. 
```

Sends Client's message to the Web Socket Server.

Useful for realtime connections using TCP-IP Web Sockets in Java.
