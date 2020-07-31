import java.io.File;
import javax.sound.sampled.*;
import java.net.URL;
import java.awt.event.*;

public class music{
//LOGIN SUCCESSFUL MUSIC
public static void login()
{
try{
File url = new File("Path for audio file");
AudioInputStream audioinput = AudioSystem.getAudioInputStream(url);
Clip clip = AudioSystem.getClip();
clip.open(audioinput);
clip.start();
}
catch(Exception e)
{
System.out.println(e);
}
}

//STUDENT DATA INSERTION MUSIC
public static void add()
{
try{
File url = new File("Path for audio file");
AudioInputStream audioinput = AudioSystem.getAudioInputStream(url);
Clip clip = AudioSystem.getClip();
clip.open(audioinput);
clip.start();
}
catch(Exception e)
{
System.out.println(e);
}
}

//STUDENT DATA UPDATE MUSIC
public static void update()
{
try{
File url = new File("Path for audio file");
AudioInputStream audioinput = AudioSystem.getAudioInputStream(url);
Clip clip = AudioSystem.getClip();
clip.open(audioinput);
clip.start();
}
catch(Exception e)
{
System.out.println(e);
}
}

//STUDENT DATA DELETION MUSIC
public static void delete()
{
try{
File url = new File("Path for audio file");
AudioInputStream audioinput = AudioSystem.getAudioInputStream(url);
Clip clip = AudioSystem.getClip();
clip.open(audioinput);
clip.start();
}
catch(Exception e)
{
System.out.println(e);
}
}

}