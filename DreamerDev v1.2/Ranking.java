import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ranking extends JFrame implements ActionListener{
    
    private static JButton btnVoltar;
    private static JLabel lRanking, lTitulos;
    private static JFrame s;
    private static JTable tab;
    static ConnectionDB con;
    String nomeJogador, TempoJogador;
    int codJogador;
    
    public Ranking(int codJogador){
        this.codJogador = codJogador;
        
        ConnectionDB con = new ConnectionDB();
        String jogadores[][] = con.getTopFive();
        String titulos[] = {"Posicao","Codigo","Nome","Tempo"};

        s = new JFrame("Perfil");
        s.setLayout(null);
        s.setResizable(false);
        s.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        s.setSize(500,350);
        s.setLocationRelativeTo(null);
        s.setBackground(new Color(50, 50, 50));

        //Ranking sc = new Ranking();
        
        lRanking = new JLabel("Ranking");
        lTitulos = new JLabel("Pos                         Codigo                        Nome                     Tempo");
        tab = new JTable(jogadores, titulos);
        btnVoltar = new JButton("Voltar");


        
        lRanking.setBounds(50,20,150,30);
        lTitulos.setBounds(50,90,400,30);
        tab.setBounds(50,120,400,150);
        btnVoltar.setBounds(350, 20, 100, 30);
        tab.setEnabled(false);
        btnVoltar.addActionListener(this);
        JScrollPane jsp = new JScrollPane(tab);
        

        s.add(lRanking);
        s.add(lTitulos);
        s.add(tab);
        s.add(jsp);
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

