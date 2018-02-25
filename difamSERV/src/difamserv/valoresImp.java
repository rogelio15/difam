package difamserv;

import javax.swing.JOptionPane;

public class valoresImp {
    public char tipoE = '\n';
    public String idEmp = "";
    public String idSurt = "0000000001";
    public String idExp="";
    public char getTipoE(){
        return tipoE;
    }

    public void setIDEmpleado(String idEmpleado){
        this.idEmp = idEmpleado;
    }

    public String getEmpleado(){
        return idEmp;
    }

    public void setIDSurtido(String idS){
        idSurt = idS;
    }

    public String getIDSurtido(){
        return idSurt;
    }

    public void setTipoUsuario(char tipoE){
        this.tipoE = tipoE;
    }

    public void setIdExp(String idExp){
        this.idExp = idExp;
        //JOptionPane.showMessageDialog(null,"ID Exp: "+idExp);
    }

    public String getIdExp(){
       // JOptionPane.showMessageDialog(null,"ID Exp: "+idExp);
        return idExp;
    }
}
