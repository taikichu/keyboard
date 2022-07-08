package keyboard;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;


public class kenbanMain extends JFrame {
    private final act instan;
    private ArrayList<JLabel> bListup;//14
    private ArrayList<JLabel> bListdown;//8
    private JPanel pane=(JPanel)getContentPane();
    public kenbanMain(String title){
        super(title);
        enableEvents( AWTEvent.KEY_EVENT_MASK ); // キーイベントを有効に
        FlowLayout layout=new FlowLayout();
        layout.setHgap(0);
        layout.setVgap(0);
        pane.setLayout(layout);
        JPanel panelup=new JPanel();
        JPanel paneldown=new JPanel();

        panelup.setLayout(layout);
        paneldown.setLayout(layout);

        
        bListup= new ArrayList<>();//14
        bListdown= new ArrayList<>();//8
        instan=new act(bListup,bListdown);
        for(int i=0;i<14;i++){
            JLabel label=new JLabel();
            label.setOpaque(true);
            if(i==13)label.setPreferredSize(new Dimension(95/5,100));//9.5
            else if(i==5||i==7||i==9||i==11)label.setPreferredSize(new Dimension(120/5,100));//12
            else if(i==0||i==2||i==12) label.setPreferredSize(new Dimension(130/5,100));//13
            else if(i==4) label.setPreferredSize(new Dimension(135/5,100));//13.5
            else label.setPreferredSize(new Dimension(140/5,100));//14
            if(i==1||i==3||i==6||i==8||i==10||i==13){
                label.setBackground(Color.BLACK);
            }
            else{
                label.setBackground(Color.WHITE);
            }
            label.setBorder(new Border1());
            bListup.add(label);
            panelup.add(label);
        }
        for(int i=0;i<8;i++){
            JLabel label=new JLabel();
            label.setOpaque(true);
            label.setPreferredSize(new Dimension(225/5,100));
            label.setBackground(Color.WHITE);
            label.setBorder(new Border2());
            bListdown.add(label);
            paneldown.add(label);
        }

        pane.add(panelup);
        pane.add(paneldown);

    }
    protected void processKeyEvent( KeyEvent e ) { // キーイベントを扱うメソッドをオーバライド
        int id = e.getID(); // キーイベントの種類を特定
        int keyCode = e.getKeyCode();
        String keyText = KeyEvent.getKeyText( keyCode );//配列の位置、色、downの有無
        if( id == KeyEvent.KEY_PRESSED ){ // キーイベントの種類を判定
            try {
                instan.retset(keyText);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            }
        }
        if( id == KeyEvent.KEY_RELEASED ){
            instan.retreset(keyText);
        }

    }
    public ArrayList<JLabel> getJListup(){return bListup;}
    public ArrayList<JLabel> getJListdown(){
        return bListdown;
    }
    public static void main(String[] args) {
        kenbanMain kenban = new kenbanMain("maingui");
        kenban.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kenban.setLocation(250, 250);
        kenban.setSize(360, 400);
        kenban.setIconImage(null);
        kenban.setResizable(false);
        kenban.setVisible(true);
//        kenban.setkenban(kenban);
    }
}





























