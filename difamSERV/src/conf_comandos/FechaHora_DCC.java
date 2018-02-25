package conf_comandos;

import java.sql.*;

public class FechaHora_DCC {
	/*public static void main(String[] args) {
		Connection con = DataSource.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM ALUMNO";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				//Date fecha = rs.getDate("FECHA_ALTA");
				//Time hora = rs.getTime("FECHA_ALTA");
				Timestamp fechaHoraTS = rs.getTimestamp("FECHA_ALTA");
				java.util.Date fecha = convierteADateUtil(rs.getDate("FECHA_ALTA"));
				java.util.Date hora = convierteATimeUtil(rs.getTime("FECHA_ALTA"));
				java.util.Date fechaHora = convierteATimestampUtil(rs.getTimestamp("FECHA_ALTA"));
				System.out.println("FECHA = " + fecha);
				System.out.println("HORA = " + hora);
				System.out.println("FECHA HORA = " + fechaHora);
				System.out.println("DATE:" + new java.util.Date());
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		} finally{
			try{rs.close();}catch(Exception ex){}
			try{stmt.close();}catch(Exception ex){}
		}		
		DataSource.closeConnection(con);
	}*/
	
	/*-------------------------------- DATE -----------------------------------*/
	public static java.util.Date convierteADateUtil(java.sql.Date fechaSQL){
		java.util.Date fechaUtil = null;
		if(fechaSQL != null){
			fechaUtil = new java.util.Date(fechaSQL.getTime());
		}
		return fechaUtil;
	}
	
	public static java.sql.Date convierteADateSQL(java.util.Date fechaUtil){
		java.sql.Date fechaSQL = null;
		if(fechaUtil != null){
			fechaSQL = new java.sql.Date(fechaUtil.getTime());
		}
		return fechaSQL;
	}
	
	/*-------------------------------- TIME -----------------------------------*/
	public static java.util.Date convierteATimeUtil(java.sql.Time horaSQL){
		java.util.Date horaUtil = null;
		if(horaSQL != null){
			horaUtil = new java.util.Date(horaSQL.getTime());
		}
		return horaUtil;
	}
	
	public static java.sql.Time convierteATimeSQL(java.util.Date horaUtil){
		java.sql.Time horaSQL = null;
		if(horaUtil != null){
			horaSQL = new java.sql.Time(horaUtil.getTime());
		}
		return horaSQL;
	}	
	
	/*------------------------------ TIMESTAMP --------------------------------*/
	public static java.util.Date convierteATimestampUtil(java.sql.Timestamp fechaHoraSQL){
		java.util.Date fechaHoraUtil = null;
		if(fechaHoraSQL != null){
			fechaHoraUtil = new java.util.Date(fechaHoraSQL.getTime());
		}
		return fechaHoraUtil;
	}
	
	public static java.sql.Timestamp convierteATimestampSQL(java.util.Date fechaHoraUtil){
		java.sql.Timestamp fechaHoraSQL = null;
		if(fechaHoraUtil != null){
			fechaHoraSQL = new java.sql.Timestamp(fechaHoraUtil.getTime());
		}
		return fechaHoraSQL;
	}

	/*------------------------------ CALENDAR ---------------------------------*/
	public static java.util.Calendar convierteACalendarUtil(java.util.Date fechaUtil){
		java.util.Calendar fechaCalendar = null;
		if(fechaUtil != null){
			fechaCalendar = new java.util.GregorianCalendar();
			fechaCalendar.setTime(fechaUtil);
		}
		return fechaCalendar;
	}
}