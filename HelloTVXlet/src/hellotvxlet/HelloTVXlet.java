package hellotvxlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.ui.DVBColor;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet, HActionListener {

    HScene scene;
    
    HStaticText Title;
    HStaticText Question;
    HStaticText LiveCount;
    
    HTextButton buttonPlay;
    HTextButton buttonNo;
    HTextButton Answer1;
    HTextButton Answer2;
    HTextButton Answer3;
    HTextButton Answer4;
    
    int Lives;
    boolean noExists = false;
    
    public void destroyXlet(boolean unconditional) {
     
    }

    public void initXlet(XletContext context) {
        
      scene=HSceneFactory.getInstance().getDefaultHScene();  
      scene.setBackgroundMode(HVisible.BACKGROUND_FILL);
      scene.setBackground(new DVBColor(207,107,169,255));
      
      
      Title=new HStaticText("The Imposible Quiz",50,20,620,100);
      Title.setForeground(Color.BLACK);
      Title.setFont(new Font("SansSerif",0,75));
      scene.add(Title);
      
      buttonPlay=new HTextButton("Play",250,250,220,100);
      buttonPlay.setBackgroundMode(HVisible.BACKGROUND_FILL);
      buttonPlay.setBackground(Color.PINK);
      buttonPlay.setForeground(Color.BLACK);
      scene.add(buttonPlay);
      
      buttonPlay.setActionCommand("play");
      
      buttonPlay.addHActionListener(this);
      
      buttonPlay.requestFocus();

    }

    public void startXlet() {
              
      scene.validate();
      scene.setVisible(true);
    }

    public void pauseXlet() {
     
    }

    public void actionPerformed(ActionEvent arg0) {
        //System.out.println(arg0.getActionCommand());
        
        if(arg0.getActionCommand().equals("play"))
        {
          Lives = 3;
          scene.remove(Title);
          scene.remove(buttonPlay);
          if(noExists)
          {
          scene.remove(buttonNo);
          }
          
          Question=new HStaticText("Where would you find the Sea of Tranquility?",50,20,620,100);
          Question.setForeground(Color.BLACK);
          Question.setFont(new Font("SansSerif",0,35));
          scene.add(Question);
          
          LiveCount = new HStaticText("Lives = " + Lives,50,460,620,100);
          LiveCount.setForeground(Color.BLACK);
          LiveCount.setFont(new Font("SansSerif",0,50));
          scene.add(LiveCount);
          
          Answer1=new HTextButton("Canada",50,120,290,150);
          Answer1.setBackgroundMode(HVisible.BACKGROUND_FILL);
          Answer1.setBackground(Color.PINK);
          Answer1.setForeground(Color.BLACK);
          scene.add(Answer1);
          
          Answer2=new HTextButton("Moon",360,120,290,150);
          Answer2.setBackgroundMode(HVisible.BACKGROUND_FILL);
          Answer2.setForeground(Color.BLACK);
          Answer2.setBackground(Color.PINK);
          scene.add(Answer2);
          
          Answer3=new HTextButton("Uranus",50,300,290,150);
          Answer3.setBackgroundMode(HVisible.BACKGROUND_FILL);
          Answer3.setForeground(Color.BLACK);
          Answer3.setBackground(Color.PINK);
          scene.add(Answer3);
          
          Answer4=new HTextButton("Norway",360,300,290,150);
          Answer4.setBackgroundMode(HVisible.BACKGROUND_FILL);
          Answer4.setForeground(Color.BLACK);
          Answer4.setBackground(Color.PINK);
          scene.add(Answer4);
          
          Answer1.setFocusTraversal(null,Answer3,null,Answer2);
          Answer2.setFocusTraversal(null,Answer4,Answer1,null);
          Answer3.setFocusTraversal(Answer1,null,null,Answer4);
          Answer4.setFocusTraversal(Answer2,null,Answer3,null);
          
          Answer1.setActionCommand("Wrong");
          Answer2.setActionCommand("1Right");
          Answer3.setActionCommand("Wrong");
          Answer4.setActionCommand("Wrong");
      
          Answer1.addHActionListener(this);
          Answer2.addHActionListener(this);
          Answer3.addHActionListener(this);
          Answer4.addHActionListener(this);
      
          Answer1.requestFocus();
          
          scene.repaint();
        }
        
        if(arg0.getActionCommand().equals("1Right"))
        {
          Question.setTextContent("The answer is really big.", HVisible.NORMAL_STATE);
          
          Answer1.setTextContent("THE ANSWER",HVisible.NORMAL_STATE);
          Answer2.setTextContent("Really big",HVisible.NORMAL_STATE);
          Answer3.setTextContent("An elephant",HVisible.NORMAL_STATE);
          Answer4.setTextContent("big",HVisible.NORMAL_STATE);
          
          Answer1.setActionCommand("2Right");
          Answer2.setActionCommand("Wrong");
          Answer3.setActionCommand("Wrong");
          Answer4.setActionCommand("Wrong");
      
          Answer1.requestFocus();
          
          scene.repaint();
        }
        
        if(arg0.getActionCommand().equals("2Right"))
        {
          Question.setTextContent("How many months have 28 days?", HVisible.NORMAL_STATE);
          
          Answer1.setTextContent("1",HVisible.NORMAL_STATE);
          Answer2.setTextContent("All of them",HVisible.NORMAL_STATE);
          Answer3.setTextContent("2",HVisible.NORMAL_STATE);
          Answer4.setTextContent("0",HVisible.NORMAL_STATE);
          
          Answer1.setActionCommand("Wrong");
          Answer2.setActionCommand("Wrong");
          Answer3.setActionCommand("3Right");
          Answer4.setActionCommand("Wrong");
      
          Answer1.requestFocus();
          
          scene.repaint();
        }
        
        if(arg0.getActionCommand().equals("3Right"))
        {
          Question.setTextContent("Do you like this quiz?", HVisible.NORMAL_STATE);
          
          Answer1.setTextContent("Yaaas",HVisible.NORMAL_STATE);
          Answer2.setTextContent("No",HVisible.NORMAL_STATE);
          Answer3.setTextContent("Yes",HVisible.NORMAL_STATE);
          Answer4.setTextContent("Of course",HVisible.NORMAL_STATE);
          
          Answer1.setActionCommand("Wrong");
          Answer2.setActionCommand("4Right");
          Answer3.setActionCommand("Wrong");
          Answer4.setActionCommand("Wrong");
      
          Answer1.requestFocus();
          
          scene.repaint();
        }
        
        if(arg0.getActionCommand().equals("4Right"))
        {
          Question.setTextContent("Is this the real life?", HVisible.NORMAL_STATE);
          
          Answer1.setTextContent("Why are we still here?",HVisible.NORMAL_STATE);
          Answer2.setTextContent("Just to suffer",HVisible.NORMAL_STATE);
          Answer3.setTextContent("Is this just fantasy?",HVisible.NORMAL_STATE);
          Answer4.setTextContent("next question please!",HVisible.NORMAL_STATE);
          
          Answer1.setActionCommand("Wrong");
          Answer2.setActionCommand("Wrong");
          Answer3.setActionCommand("5Right");
          Answer4.setActionCommand("Wrong");
      
          Answer1.requestFocus();
          
          scene.repaint();
        }
        
        if(arg0.getActionCommand().equals("5Right"))
        {
          Question.setTextContent("How long is a chinese man.", HVisible.NORMAL_STATE);
          
          Answer1.setTextContent("False",HVisible.NORMAL_STATE);
          Answer2.setTextContent("Falsen'tn't",HVisible.NORMAL_STATE);
          Answer3.setTextContent("Truen't",HVisible.NORMAL_STATE);
          Answer4.setTextContent("Falsen't",HVisible.NORMAL_STATE);
          
          Answer1.setActionCommand("Wrong");
          Answer2.setActionCommand("Wrong");
          Answer3.setActionCommand("Wrong");
          Answer4.setActionCommand("6Right");
      
          Answer1.requestFocus();
          
          scene.repaint();
        }      
        
        if(arg0.getActionCommand().equals("6Right"))
        {
            scene.remove(Question);
            scene.remove(Answer1);
            scene.remove(Answer2);
            scene.remove(Answer3);
            scene.remove(Answer4);
            scene.remove(LiveCount);
            
            noExists = true;
            
            Title=new HStaticText("Congats!! Thanks for wasting your time!",50,20,620,100);
            Title.setForeground(Color.BLACK);
            Title.setFont(new Font("SansSerif",0,25));
            scene.add(Title);
      
            buttonPlay=new HTextButton("Want to waste your time again?",150,150,420,100);
            buttonPlay.setBackgroundMode(HVisible.BACKGROUND_FILL);
            buttonPlay.setBackground(Color.PINK);
            buttonPlay.setForeground(Color.BLACK);
            scene.add(buttonPlay);
      
            buttonNo=new HTextButton("No.",150,270,420,100);
            buttonNo.setBackgroundMode(HVisible.BACKGROUND_FILL);
            buttonNo.setBackground(Color.PINK);
            buttonNo.setForeground(Color.BLACK);
            scene.add(buttonNo);
            
            buttonPlay.setActionCommand("play");
            buttonNo.setActionCommand("1no");
      
            buttonPlay.addHActionListener(this);
            buttonNo.addHActionListener(this);
            
            buttonPlay.setFocusTraversal(null,buttonNo,null,null);
            buttonNo.setFocusTraversal(buttonPlay,null,null,null);
      
            buttonPlay.requestFocus();
            
            scene.repaint();
        }
        
        if(arg0.getActionCommand().equals("1no"))
        {
          System.out.println("Debug no");
          Title.setTextContent("Are you sure?", HVisible.NORMAL_STATE);
          Title.setFont(new Font("SansSerif",0,50));
          
          buttonPlay.setTextContent("No",HVisible.NORMAL_STATE);
          buttonNo.setTextContent("Yes",HVisible.NORMAL_STATE);
          
          buttonPlay.setActionCommand("play");
          buttonNo.setActionCommand("2no");
          
          buttonPlay.requestFocus();
          
          scene.repaint();
        }
        
        if (arg0.getActionCommand().equals("2no"))
        {
            //scene.remove(buttonNo);
            //scene.remove(Title);
            
           // buttonPlay.requestFocus();
            
            //buttonPlay.setTextContent("Play Again...", HVisible.NORMAL_STATE);
            scene.setVisible(false);
            destroyXlet(true);
            
        }
        
        if(arg0.getActionCommand().equals("Wrong"))
        {
            Lives--;
            LiveCount.setTextContent("Lives = " + Lives,HVisible.NORMAL_STATE);
            scene.repaint();
        }
        
        if(Lives==0)
        {
            scene.remove(Question);
            scene.remove(Answer1);
            scene.remove(Answer2);
            scene.remove(Answer3);
            scene.remove(Answer4);
            scene.remove(LiveCount);
            
            Title=new HStaticText("Game Over!! You suck!",50,20,620,100);
            Title.setForeground(Color.BLACK);
            Title.setFont(new Font("SansSerif",0,75));
            scene.add(Title);
      
            buttonPlay=new HTextButton("Play Again?",250,250,220,100);
            buttonPlay.setBackgroundMode(HVisible.BACKGROUND_FILL);
            buttonPlay.setBackground(Color.PINK);
            buttonPlay.setForeground(Color.BLACK);
            scene.add(buttonPlay);
      
            buttonPlay.setActionCommand("play");
      
            buttonPlay.addHActionListener(this);
      
            buttonPlay.requestFocus();
            
            scene.repaint();
        }
      }    
    }
