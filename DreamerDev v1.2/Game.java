import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Game extends JFrame implements ActionListener {

    JLabel lblTItulo, lblCreditos;
    JButton btnJogar, btnPerfil, btnRanking, btnSair;
    JFrame f;
    int playerCode;

    public Game(int playerCode , JFrame s){
        s.dispose();
        this.playerCode = playerCode;

        f = new JFrame("Tela Inicial");
        f.setResizable(false);
        f.setLayout(null);
        f.setSize(300, 400);
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.setLocationRelativeTo(null);
        
        btnJogar = new JButton("Jogar");
        btnPerfil = new JButton("Perfil");
        btnRanking = new JButton("Ranking");
        btnSair = new JButton("Sair");
        lblTItulo = new JLabel("DreamerDev");
        lblCreditos = new JLabel("Equipe DreamerDev");

        lblTItulo.setBounds(110,20,100,30);
        lblCreditos.setBounds(90,300,120,30);
        btnJogar.setBounds(100,80,100,40);
        btnPerfil.setBounds(100,130,100,40);
        btnRanking.setBounds(100,180,100,40);
        btnSair.setBounds(100,230,100,40);

        btnJogar.addActionListener(this);
        btnPerfil.addActionListener(this);
        btnRanking.addActionListener(this);
        btnSair.addActionListener(this);

        f.add(lblTItulo);
        f.add(lblCreditos);
        f.add(btnJogar);
        f.add(btnPerfil);
        f.add(btnRanking);
        f.add(btnSair);
        
        
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if(s.equals("Jogar")){
            Main main = new Main(f, playerCode);
            f.dispose();
        }
        else if(s.equals("Perfil")){
            Profile profile = new Profile(playerCode);
            f.dispose();
        }
        else if(s.equals("Ranking")){
            Ranking ranking = new Ranking(playerCode);
            f.dispose();
        }
        else if(s.equals("Sair")){
            System.exit(0);
        }
    }
}
