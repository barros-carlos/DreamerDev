import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cadastro extends JFrame implements ActionListener {

    private static JButton btnLogin, btnCadastrar, btnVerificaNome;
    private static JTextField tfLogin, tfSenha;
    private static JLabel lLogin, lSenha, lErroNome;
    private static JFrame s;
    static ConnectionDB con;

    Cadastro(JFrame s2){ 
        s2.dispose();
        s = new JFrame("Cadastrar");
        s.setResizable(false);
        s.setLayout(null);
        s.setSize(400, 300);
        s.setLocationRelativeTo(null);

        //Cadastro sc = new Cadastro();

        lLogin = new JLabel("Login");
        lSenha = new JLabel("Senha");
        lErroNome = new JLabel("");
        btnCadastrar = new JButton("Cadastrar");
        btnLogin = new JButton("Login");
        btnVerificaNome = new JButton("Verificar Nome");
        tfLogin = new JTextField();
        tfSenha = new JTextField();

        tfLogin.setBounds(100, 50, 100, 30);
        tfSenha.setBounds(100, 100, 100, 30);
        lLogin.setBounds(60, 50, 40, 30);
        lSenha.setBounds(60, 100, 40, 30);
        lErroNome.setBounds(130, 200, 80, 30);
        btnLogin.setBounds(200, 150, 100, 30);
        btnCadastrar.setBounds(80, 150, 100, 30);
        btnVerificaNome.setBounds(230, 50, 100, 30);

        btnLogin.addActionListener(this);
        btnCadastrar.addActionListener(this);
        btnVerificaNome.addActionListener(this);

        s.add(tfLogin);
        s.add(tfSenha);
        s.add(btnLogin);
        s.add(btnCadastrar);
        s.add(btnVerificaNome);
        s.add(lLogin);
        s.add(lSenha);
        s.add(lErroNome);
        
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setBackground(new Color(50, 10, 60));
        s.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Login")) {
            Login login = new Login();
            s.dispose();
            
        } else if (action.equals("Cadastrar")) {
            con = new ConnectionDB();
            String username = tfLogin.getText();
            String password = tfSenha.getText();
            try {
                if(!username.isEmpty() && !password.isEmpty()){
                    if (con.IsNameValidated(username)) {
                        lErroNome.setText("Indisponivel");
                    }
                    else{
                        if(con.RegisterUser(username, password)){
                            lErroNome.setText("Cadastrado");
                            Login login = new Login();
                            s.dispose();
                        }
                        else{
                            lErroNome.setText("Erro ao Cadastrar");
                        }
                    }
                }
            } catch (Exception e1) {
                
            }
        } else if (action.equals("Verificar Nome")) {
            con = new ConnectionDB();
            String username = tfLogin.getText();
            try {
                if(!username.isEmpty()){
                    if (con.IsNameValidated(username)) {
                        lErroNome.setText("Indisponivel");
                    }
                    else{
                        lErroNome.setText("Disponivel");
                    }
                }
            } catch (Exception e1) {

            }
        }
    }
}
