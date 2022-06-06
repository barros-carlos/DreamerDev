import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;



public class ConnectionDB {
  private String usuario = "root";
  // Trocar a senha do banco
  private String senha = "";
  private String host = "localhost";
  private String porta = "3306";
  private String bd = "Jogo";

  public Connection getConnection() {
    try {
      Connection c = DriverManager.getConnection(
          "jdbc:mysql://" + host + ":" + porta + "/" + bd,
          usuario,
          senha);
      return c;
    } catch (Exception e) {
      System.out.println("Erro ao conectar");
      return null;
    }
  }

  public void closeConnection() {
    Connection con = getConnection();
    if (con != null) {
      try {
        con.close();
        System.out.println("Fechado");
      } catch (SQLException e) {
        System.out.println("Erro ao fechar");
      }
    }
  }
  public boolean IsPlayer(String username, String password) throws SQLException{
    if(username.isEmpty() && password.isEmpty()){
      return false;
    }
    else{
      String query = "SELECT * FROM Jogadores WHERE nickJogador = '"+username +"' AND senhaJogador = '"+ password +"'";
      try(Connection con  = getConnection();
      PreparedStatement ps =  con.prepareStatement(query);){
        
        //ps.setString(1, username);
        //ps.setString(2, password);

        ResultSet rs = ps.executeQuery(query);
        if(rs.next()){
          return true;
        }
        else{
          return false;
        }
      }
      catch(SQLException e){
        e.printStackTrace();
        return false;
      }
    }
  }
  public boolean IsNameValidated(String username){
    if(username.isEmpty()){
      return false;
    }
    else{
      String query = "SELECT * FROM Jogadores WHERE nickJogador = '"+username +"'";
      try(Connection con  = getConnection();
      PreparedStatement ps =  con.prepareStatement(query);){
        
        //ps.setString(1, username);
        //ps.setString(2, password);

        ResultSet rs = ps.executeQuery(query);
        if(rs.next()){
          return true;
        }
        else{
          return false;
        }
      }
      catch(SQLException e){
        e.printStackTrace();
        return false;
      }
    }
  }
  public boolean RegisterUser(String username, String password){
    if(username.isEmpty() && password.isEmpty()){
      return false;
    }
    else{
      String query = "INSERT INTO Jogadores (nickJogador, senhaJogador) VALUES ('"+ username +"','"+ password +"')";
      try(Connection con  = getConnection();
      PreparedStatement ps =  con.prepareStatement(query);){
        ps.execute();
        return true;
      }catch(Exception e){
        e.printStackTrace();
        return false;
      }
      
    }
  }
  public int getUserId(String username , String password){
    String query = "SELECT codJogador FROM Jogadores WHERE nickJogador = '"+username +"'";
    try(Connection con  = getConnection();
    PreparedStatement ps =  con.prepareStatement(query);){
      
      //ps.setString(1, username);
      //ps.setString(2, password);

      ResultSet rs = ps.executeQuery(query);
      if(rs.next()){
        System.out.println(rs.getInt(1));
        return rs.getInt(1);
      }
      else{
        return 0;
      }
    }
    catch(SQLException e){
      e.printStackTrace();
      return 0;
    } 
  }
  public void RecordTimePlayer(int playerCode, String timeString){
    String[] time = timeString.split(":");
    int timeSecs = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
    String miliseconds = time[2];

    String query = "Insert into Ranking (codJogador, tempo, miliseconds) values ('"+playerCode+"',sec_to_time("+timeSecs+"),"+miliseconds+")";

    try(Connection con  =  getConnection();
    PreparedStatement ps =  con.prepareStatement(query);){
        ps.execute();
        JOptionPane.showMessageDialog(null, "Tempo registrado com sucesso");
    }catch(Exception e){
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Seu tempo nao foi registrado");
    }
  }

  public String getProfile(int codJogador){
    String query = "select j.codJogador, j.nickjogador, r.tempo, r.miliseconds from jogadores as j  inner join ranking as r on j.codJogador = r.codJogador where j.codjogador = " + codJogador + " order by r.tempo asc, r.miliseconds asc limit 1";
    try(Connection con  = getConnection();){
      PreparedStatement ps =  con.prepareStatement(query);
      
      ResultSet rs = ps.executeQuery(query);
      if(rs.next()){
        
        return rs.getString(2)+"/"+rs.getString(3)+"/"+rs.getString(4);
      }else{
        query = "Select nickjogador from Jogadores where codJogador = " + codJogador;
        ps = con.prepareStatement(query);
        rs = ps.executeQuery();
        if(rs.next()){
          return rs.getString(1)+"/-:-:-/-";
        }
      }
    }
    catch(SQLException e){
      e.printStackTrace();
      return "-/-.-.-/-";
    }
    return "-/-.-.-/-"; 
  }
  public String[][] getTopFive(){
    String query = "select j.codJogador, j.nickjogador, r.tempo, r.miliseconds from jogadores as j  inner join ranking as r on j.codJogador = r.codJogador order by r.tempo asc, r.miliseconds asc limit 5";
    String[][] jogadores = new String[5][4];
    int pos = 0;
    try(Connection con  = getConnection();
    PreparedStatement ps =  con.prepareStatement(query);){
      
      ResultSet rs = ps.executeQuery(query);

      DateFormat sample = new SimpleDateFormat("HH:mm:ss");
      while(rs.next()){
        jogadores[pos][0] = Integer.toString(pos+1);
        jogadores[pos][1] = Integer.toString(rs.getInt(1));
        jogadores[pos][2] = rs.getString(2);
        jogadores[pos][3] = sample.format(rs.getTime(3))+"."+Integer.toString(rs.getInt(4));
        pos++;
      }
      return jogadores;
      }catch(SQLException e){
        return jogadores;
      }
  }
}