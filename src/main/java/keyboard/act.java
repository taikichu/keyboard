package keyboard;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

//キーボードとパネルの対応は成功　//次は音の対応
public class act extends JFrame{
    ArrayList<JLabel> bListup;
    ArrayList<JLabel> bListdown;
    String[] downlist={"S","D","F","G","H","J","K","L"};
    String[] namelist={"c3_S","c#3_E","d3_D","d#3_R","e3_F","f3_G","f#3_Y","g3_H","g#3_U","a3_J","a#3_I","b3_K","c4_L","c#4_P"};
    private int[] notRenda={0,0,0,0,0,0,0,0,0,0,0,0,0,0};//14つ
    public act(ArrayList<JLabel> bListup,ArrayList<JLabel> bListdown){
        this.bListup=bListup;
        this.bListdown=bListdown;
    }
    public void retset(String keyText) throws IOException, UnsupportedAudioFileException, LineUnavailableException {//colorは全てgray、upは0~13、downは0~7まで
            for(int i=0;i<14;i++){
                if(namelist[i].contains(keyText)&&notRenda[i]==0){
                    bListup.get(i).setBackground(Color.GRAY);
                    
                    File file = new File("src\\main\\java\\keyboard\\aiff\\"+namelist[i]+".aiff");
                    player player = new player(file.getAbsolutePath());//C:\Users\nyasu\IdeaProjects\netpro2022_java17\src\wav\c3.wav
                    notRenda[i]=1;
                    break;
                }
            }
            for(int i=0;i<8;i++){
                if(downlist[i].contains(keyText)){
                    bListdown.get(i).setBackground(Color.GRAY);
                }
            }
    }
    public void retreset(String keyText){
        for(int i=0;i<14;i++){
            if(namelist[i].contains(keyText)){
                notRenda[i]=0;
                if(i==1||i==3||i==6||i==8||i==10||i==13){
                    bListup.get(i).setBackground(Color.BLACK);
                }else{
                    bListup.get(i).setBackground(Color.WHITE);
                }
            }
        }
        for(int i=0;i<8;i++){
            if(downlist[i].contains(keyText)){
                bListdown.get(i).setBackground(Color.WHITE);
            }
        }
    }
}
