import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame implements ActionListener{
    
    private static JButton btnLogin, btnCadastrar;
    private static JTextField tfLogin, tfSenha;
    private static JLabel lLogin, lSenha, lErroSessao;
    private static JFrame s;
    static ConnectionDB con;
    
    public Login(){
        
        s = new JFrame("Login");
        s.setLayout(null);
        s.setResizable(false);
        s.setSize(300,300);
        s.setLocationRelativeTo(null);
        s.setBackground(new Color(50, 50, 50));

        //Login sc = new Login();
        
        lLogin = new JLabel("Login");
        lSenha = new JLabel("Senha");
        lErroSessao = new JLabel("");
        btnCadastrar = new JButton("Cadastrar");
        btnLogin = new JButton("Login");
        tfLogin = new JTextField();
        tfSenha = new JTextField();
        
        tfLogin.setBounds(100,50,100,30);
        tfSenha.setBounds(100,100,100,30);
        lLogin.setBounds(60,50,40,30);
        lSenha.setBounds(60,100,40,30);
        lErroSessao.setBounds(130,200,80,30);
        btnLogin.setBounds(150, 150, 100, 30);
        btnCadastrar.setBounds(50, 150, 100, 30);

        btnLogin.addActionListener(this);
        btnCadastrar.addActionListener(this);

        s.add(tfLogin);
        s.add(tfSenha);
        s.add(btnLogin);
        s.add(btnCadastrar);
        s.add(lLogin);
        s.add(lSenha);
        s.add(lErroSessao);

        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setBackground(new Color(50,10,60));
        s.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if(s.equals("Login")){
            con = new ConnectionDB();
            String username = tfLogin.getText();
            String password = tfSenha.getText();
            try {
                if(con.IsPlayer(username,password)){
                    int userID = con.getUserId(username, password);
                    if(userID > 0){
                        lErroSessao.setText("Logado");
                        Game game = new Game(userID, Login.s);
                        con.closeConnection();
                    }
                }else{
                    lErroSessao.setText("Erro ao logar");
                }
            } catch (Exception e1) {
                
            }
            tfLogin.setText("");
            tfSenha.setText("");
        }else if(s.equals("Cadastrar")){
            Cadastro cad = new Cadastro(Login.s);
            cad.requestFocus();
        }
    }
}
