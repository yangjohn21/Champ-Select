import java.awt.Dimension;
import java.util.HashSet;

import java.util.Scanner;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.GapContent;

public class StartChoice {
 
    public static void run(){
        playerInput();
    }
    public static void playerInput(){
        JFrame frame = new JFrame();
        
        //frame.setMinimumSize(new Dimension(200,200));
        frame.setResizable(true);
       // frame.setPreferredSize(new Dimension(200,200));
        JTextField energyInput = new JTextField(1);
        energyInput.setBounds(100, 100, 50, 50);
        frame.add(energyInput);
        JLabel energyLabel = new JLabel("how energetic are you?");
        energyLabel.setBounds(100, 90, 60, 20);
        frame.add(energyLabel);

        JTextField brainInput = new JTextField(1);
        brainInput.setBounds(300, 100, 50, 50);
        frame.add(brainInput);
        JLabel brainLabel = new JLabel("how much brain?");
        brainLabel.setBounds(300, 90, 60, 20);
        frame.add(brainLabel);

        JButton resultButton = new JButton("find champ");
        resultButton.setBounds(300,300,50,50);
        resultButton.addActionListener(e->{
            int energy = Integer.parseInt(energyInput.getText());
            int brain = Integer.parseInt(brainInput.getText());
            PlayerFeeling player = new PlayerFeeling(energy, brain);
            Set<String> champPool = getChampPool();
            chooseChamp(player, false, champPool);
        });
        frame.add(resultButton);


        frame.setLocationRelativeTo(null);

        

        frame.pack();
        frame.setVisible(true);

    }
    private static void chooseChamp(PlayerFeeling player, boolean isRandom, Set<String> champSet){
        /*
        champSet.add("garen");
        champSet.add("tryndamere");
        champSet.add("fiora");
        champSet.add("rammus");
        champSet.add("akali");
        champSet.add("camille");
        champSet.add("sion");
        */
        ChampMatrix cm = new ChampMatrix(champSet);      
      
        ChampSelecter cs = new ChampSelecter(player, cm.getResult());
        System.out.print("the champ u should play is: "+cs.getResultChamp(isRandom));
    }
    /*
    public static void playerInput(){
        System.out.println("For the following questions please provide an integer answer from 0 to 100 :)");
        System.out.print("How much energy do you have today? ");
        
        int energy = getNextInt();
        
        System.out.print("How much of your brain do you want to use? ");        
        int brain = getNextInt();
        System.out.print("do you want some randomness in your champ choice? ");
        boolean isRandom = getYesOrNo();
        PlayerFeeling player = new PlayerFeeling(energy, brain);
        Set<String> champPool = getChampPool();
        chooseChamp(player, isRandom, champPool);
    }*/
   

    public static int getNextInt(){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){            
            int input = sc.nextInt();
            if(input>100||input<0){
                System.out.println("between 0 and 10 dumbass");
                return getNextInt();
            }
            return input;
        }else{
            System.out.println("thats not an integer shitter try again");
            return getNextInt();
        }
    }
    public static boolean getYesOrNo(){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext()){
            String input = sc.next();
            if(input.equals("yes")){
                return true;
            }
            if(input.equals("no")){
                return false;
            }else{
                System.out.print("A yes or no answer please");
                return getYesOrNo();
            }
        }
        System.out.print("i broke");
        return false;
    }
    public static Set<String> getChampPool(){
        System.out.println("please give me ur champ pool with each champion separated by a comma (no spaces please)");
        Scanner sc = new Scanner(System.in);
        String input =  sc.next();
        sc.close();
        sc = new Scanner(input);
        //parse input for champ names
        Set<String> champSet = new HashSet<>();
        sc.useDelimiter(",");
        Set<String> allChampSet = ChampMatrix.getAllChampSet();
        while(sc.hasNext()){
            String champString = sc.next();
            if(allChampSet.contains(champString)){
                champSet.add(champString);
            }else{
                System.out.println(champString+" is not a champ name");
            }
            
        }
        sc.close();
        return champSet;
    }
}
