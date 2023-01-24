package sist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Alugar {
    private Connection conexao;
    
    public Alugar(Connection conexao){
        this.conexao=conexao;  
    }
    
    public void create(String cnh, String placa, int kmatual) throws SQLException{
    Statement stm = this.conexao.createStatement();
    ResultSet rs;
    Date d = new Date(System.currentTimeMillis());
    SimpleDateFormat df;
    df = new SimpleDateFormat("dd/MM/yyyy");
    String data = df.format(d);
    String sql = "INSERT INTO ALUGA (FK_CLIENTE,FK_VEICULO,DTALUGUEL,KMATUAL) VALUES ('"+cnh+"','"+placa+"','"+data+"',"+kmatual+")";
  
    String sql1 = "UPDATE VEICULO SET DISPONIVEL = 'N' WHERE placa = '"+placa+"'"; 
    int i = stm.executeUpdate(sql1);
    int a = stm.executeUpdate(sql);
    }
    
    public boolean retriveExistente (String cnh) throws SQLException{
        Statement stm = this.conexao.createStatement();
        ResultSet rs;
        System.out.println(cnh +"oioioi");
        String sql = "SELECT fk_cliente FROM ALUGA";
        String CNH= "";
        rs = stm.executeQuery(sql);
        while (rs.next()){
            CNH = rs.getString("fk_cliente");
        }
            if (CNH.equals(cnh)){
                return true;
            }else{
                return false;
            }
        
    }
    
    public void devolver(String cnh) throws SQLException{
    Statement stm = this.conexao.createStatement();
    ResultSet rs, rs1, rs2;

    String sql = "SELECT * FROM ALUGA WHERE fk_cliente = '"+cnh+"'";
            String placa = null;
            rs = stm.executeQuery(sql);
            while(rs.next()){
                placa = rs.getString("fk_veiculo");
            }
    
    
        String sql1 = "UPDATE VEICULO SET DISPONIVEL = 'S' WHERE placa = '"+placa+"'"; 
       int i = stm.executeUpdate(sql1);

    String sql2 = "DELETE FROM ALUGA WHERE fk_cliente = '"+cnh+"'"; 
    int j = stm.executeUpdate(sql2);
    
    }
    
    
      public ResultSet retriveAluga (String cnh) throws SQLException{
            Statement stm = this.conexao.createStatement();
            ResultSet rs;
            String sql = "SELECT * FROM ALUGA WHERE fk_cliente = '"+cnh+"'";
            rs = stm.executeQuery(sql);
            return rs;
    }

      
}
