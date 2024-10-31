package Util;

import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;

public class JohnTests extends JScrollPane {


    private JPanel pn = new JPanel();

    private JFrame fr = new JFrame();

    private JScrollPane jsp = new JScrollPane(pn);


    private String[] expected;
    private String[] out;
    private int index = 0;
    int length = 100;


    public JohnTests(int len) throws Exception {
        if (!(len > 0)) {
            throw new Exception("Can't have tester with len < 0");
        }
        expected = new String[len];
        out = new String[len];
        length = len;
    }


    public JohnTests(){
        expected = new String[100];
        out = new String[100];
    }




    private void configStuff(){
        //fr.setSize(300, 300);
        fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
        pn.setLayout(new BoxLayout(pn, BoxLayout.Y_AXIS));
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void open(){
        fr.add(jsp);
        fr.setVisible(true);
    }

    public void TestingPurposesFunction(){

        open();
    }

    public String multstring(String str, int n){
        String out = new String();
        for(int i=0; i<n; i++){
            out += str;
        }
        return out;
    }
    public void queue(Object o, Object e){
        expected[index] = "" + e;
        out[index] = "" + o;
        index += 1;
    }


    public void fireWrapped(){
        System.out.println("Test # |Expected:                      | Result:                      | Correct?");
        System.out.println("-------|-------------------------------|------------------------------|---------");
        int c = 0;
        int real = 0;
        for(int i=0; i<expected.length; i++) {if (expected[i]!=null){real+=1;
            int len = 30 - expected[i].length();
            if (len < 0) {

                len = 0;
            }
            int len2 = 30 - out[i].length();
            if (len2 < 0) {

                len2 = 0;
            }//could definitely be written better if needed, however it is not needed.

            String exp = expected[i];
            String o = out[i];
            if (expected[i].length() > 30) {
                exp = expected[i].substring(0, 27) + "...";
            }
            if (out[i].length() > 30){
                o = out[i].substring(0, 27) + "...";
            }


            System.out.println(i + multstring(" ", 7-("" + i).length()) + "| " + exp + multstring(" ", len) + "| " + o + multstring(" ", len2) + "| " + expected[i].equals(out[i]));
            if (expected[i].equals(out[i])) c += 1;
        }}
        System.out.println("       |                               |                              | % Correct: " + 100 * (double)c / real);

        System.out.println("-------|-------------------------------|------------------------------|---------");
    }
    public void fireLong(){
        System.out.println("Test # |Expected:                      | Result:                      | Correct?");
        System.out.println("-------|-------------------------------|------------------------------|---------");
        int c = 0;
        int real = 0;
        for(int i=0; i<expected.length; i++) {if (expected[i]!=null){real+=1;
            int len = 30 - expected[i].length();
            if (len < 0) {

                len = 0;
            }
            int len2 = 30 - out[i].length();
            if (len2 < 0) {

                len2 = 0;
            }//could definitely be written better if needed, however it is not needed.

            String exp = expected[i];
            String o = out[i];



            System.out.println(i + multstring(" ", 7-("" + i).length()) + "| " + exp + multstring(" ", len) + "| " + o + multstring(" ", len2) + "| " + expected[i].equals(out[i]));
            if (expected[i].equals(out[i])) c += 1;
        }}
        System.out.println("       |                               |                              | % Correct: " + 100 * (double)c / real);
        System.out.println("-------|-------------------------------|------------------------------|---------");
    }
    private JLabel iHateThis(String text){
        JLabel why = new JLabel(text);
        why.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        return why;
    }
    public double fireScreen(){
        pn.removeAll();
        configStuff(); // config the JFrame

        pn.add(iHateThis("Test # |Expected:                      | Result:                       | Correct?"));
        pn.add(iHateThis("-------|-------------------------------|-------------------------------|---------"));
        int c = 0;
        int real = 0;
        for(int i=0; i<expected.length; i++) {if (expected[i]!=null){real+=1;
            int len = 30 - expected[i].length();
            if (len < 0) {
                len = 0;
            }
            int len2 = 30 - out[i].length();
            if (len2 < 0) {
                len2 = 0;
            } //could definitely be written better if needed, however it is not needed.

            String exp = expected[i];
            String o = out[i];
            if (expected[i].length() > 30) {
               
                exp = expected[i].substring(0, 27) + "...";
            }
            if (out[i].length() > 30){
                o = out[i].substring(0, 27) + "...";
            }


            pn.add(iHateThis(i + multstring(" ", 7-("" + i).length()) + "| " + exp + multstring(" ", len) + "| " + o + multstring(" ", len2) + "| " + expected[i].equals(out[i])));
            if (expected[i].equals(out[i])) c += 1;
        }}
        double percentcorrect = 100 * (double)c / real;

        pn.add(iHateThis("       |                               |                               | % Correct: " + percentcorrect));

        pn.add(iHateThis("-------|-------------------------------|-------------------------------|---------"));

        if(percentcorrect != 100) {
            //Brainrotlib.print("abfkjfasbkfjhnafs");
            pn.setBackground(new Color(255 -(int)(percentcorrect*2.5), 0+(int)(percentcorrect*2), 0));
        }
        else{
            pn.setBackground(new Color(0,255, 0));
        }
        open();
        return percentcorrect;

    }


    public void fire(int Type, boolean Wipe){
        if(Type == 0) {
            fireWrapped();
        }
        else if(Type == 1){
            fireScreen();
        }
        else if(Type == 2){
            fireLong();
        }

        if(Wipe){
            expected = new String[length];                                                             //
            out = new String[length];
            index = 0;
        }
    }



}
