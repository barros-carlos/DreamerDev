import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Profile extends JFrame implements ActionListener{
    
    private static JButton btnVoltar;
    private static JLabel lSeuPerfil, lCodJogador, lNickJogador, LTempoJogador;
    private static JFrame s;
    static ConnectionDB con;
    String nomeJogador, TempoJogador;
    int codJogador;
    
    public Profile(int codJogador){
        this.codJogador = codJogador;
        
        ConnectionDB con = new ConnectionDB();
        String a = con.getProfile(codJogador);
        System.out.println(a);
        String[] jogador = a.split("/");
        //String[] jogador = con.getProfile(codJogador).split("/");
        nomeJogador = jogador[0];
        if(jogador.length > 2)
            TempoJogador = jogador[1]+"."+jogador[2];


        s = new JFrame("Perfil");
        s.setLayout(null);
        s.setResizable(false);
        s.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        s.setSize(250,350);
        s.setLocationRelativeTo(null);
        s.setBackground(new Color(50, 50, 50));

        //Profile sc = new Profile();
        
        lSeuPerfil = new JLabel("Seu perfil");
        lCodJogador = new JLabel("Codigo: " + codJogador);
        lNickJogador = new JLabel("Nome: " + nomeJogador);
        LTempoJogador = new JLabel("Tempo: " + TempoJogador);
        btnVoltar = new JButton("Voltar");

        
        lSeuPerfil.setBounds(50,50,150,30);
        lCodJogador.setBounds(50,90,150,30);
        lNickJogador.setBounds(50,130,150,30);
        LTempoJogador.setBounds(50,170,150,30);

        btnVoltar.setBounds(50, 220, 100, 30);

        btnVoltar.addActionListener(this);


        s.add(lSeuPerfil);
        s.add(lCodJogador);
        s.add(lNickJogador);
        s.add(LTempoJogador);
        s.add(btnVoltar);

        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setBackground(new Color(50,10,60));
        s.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if(s.equals("Voltar")){
           Game game = new Game(codJogador, this.s);
        }
    }
}
