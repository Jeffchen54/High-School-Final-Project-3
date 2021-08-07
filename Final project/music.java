import javax.sound.sampled.*;
import java.io.*;

public class music{
   public music(String name){
      try {
         File file = new File(name + ".wav");
         Clip clip = AudioSystem.getClip();
         clip.open(AudioSystem.getAudioInputStream(file));
         clip.start();
         clip.stop();
         //Thread.sleep(195000);
      } catch (Exception e) {
         System.err.println(e.getMessage());
      }
   }
}
