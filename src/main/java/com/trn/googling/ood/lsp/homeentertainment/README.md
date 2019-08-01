### Home Entertainment System
[Assignment](https://www.jobreadyprogrammer.com/blog/2611/remote-control-assignment)

Objects :
- Universal Remote Control
- Different controllable devices:

   
    1. Tv
    2. Dvd player
    3. Speakers
    4. Projector
    
- Commands -- Remote issues command and devices execute commands
    commands can be :
    
        1. Switch On
        2. Switch off
        3. Volume up
        4. Volume Down
        5. Mute
        
- Person


##### There can be an Interface/abstract class which can be `CommandExecutor` , which would have a set of methods corresponding to the Commands mentioned above. Those method would accept as input the `Command` object and may return a void or some other return type depending upon what they do. Since every device would have a different way , so every Device class will implement its own version of these methods by implementing the interface  

##### or since there won't be set of commmands combo , and we have to perform say limited commands , then we can just use th interface which says `switch on` , `switch off` and other methods and all those classes implement those . This will eliminate the need to having a command object and command interpreter.