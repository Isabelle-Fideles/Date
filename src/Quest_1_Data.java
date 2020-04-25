import java.util.Date;

public class Quest_1_Data {
	private int DD, MM, AAAA;
	private int max_ano; 
	
	public Quest_1_Data() {
		this.max_ano=1000000;
		setAAAA(2020);
		setMM(04);
		Date dia = new Date();
		setDD(dia.getDate());	
	}
	
	public Quest_1_Data(int DD, int MM,int AAAA) {
			this.max_ano=1000000;
		if (verifica(DD, MM, AAAA)){
			setAAAA(AAAA);
			setMM(MM);
			setDD(DD);
		}
	}
	
	public int getDD() {
		return DD;
	}

	public void setDD(int dD) {
			DD=dD;
	}
				
	public int getMax_ano() {
		return max_ano;
	}

	public int getMM() {
		return MM;
	}

	public void setMM(int mM) {
			MM = mM;
	}

	public int getAAAA() {
		return AAAA;
	}

	public void setAAAA(int aAAA) {
			AAAA = aAAA;
	}
	
	private boolean verifica(int dia, int mes, int ano) {
		if((ano>0)&&(ano<getMax_ano())) {
			if((mes==1)||(mes==3)||(mes==5)||(mes==7)||(mes==8)||(mes==10)||(mes==12)) {
				if((dia<=31)&&(dia>0)) {
					return true;
				}
				else {
					System.out.println("Data inválida");
					return false;
				}
			}
			else
			if (mes==2) {
				if(ano%4 == 0) {
					if((dia<=29)&&(dia>0)) {
						return true;
					}
					else {
						System.out.println("Data inválida");
						return false;
					}
				}	
				else
					if((dia<=28)&&(dia>0)) {
						return true;
					}
					else {
						System.out.println("Data inválida");
						return false;
					}
			}
			else
				if((mes==4)||(mes==6)||(mes==9)||(mes==11)){
					if((dia<=30)&&(dia>0)) {
						return true;
					}
					else {
						System.out.println("Data inválida");
						return false;
					}
				}
				else {
					System.out.println("Data inválida");
					return false;
				}
			}
		else {
			System.out.println("Data inválida");
			return false;
		}
	}

	public int diasEntreDatas(Quest_1_Data data2) {
		if ((getDD()!=0)&&(data2.getDD()!=0)) {
			int dia=0;
			int dif = data2.getAAAA() - getAAAA();
			if(dif>0) {
				for(int i=getAAAA(); i< data2.getAAAA()  ; i++) {
					if(i%4==0) {
						dia=dia+366;
					}
					else {
						dia=dia+365;
					}
				}
			}
			else if (dif<0) {
				for(int i=data2.getAAAA(); i< getAAAA()  ; i++) {
					if(i%4==0) {
						dia=dia-366;
					}
					else {
						dia=dia-365;
					}
				}
			}

			int difmes= data2.getMM()-getMM();
			
			if(difmes>0) {
				for(int i=getMM(); i< data2.getMM()  ; i++) {
					if((i==1)||(i==3)||(i==5)||(i==7)||(i==8)||(i==10)||(i==12)) {
						dia=dia+31;
					}
					else
						if (i==2) {					
							if(getAAAA()%4 == 0) {
								dia=dia+29;
							}
							else
								dia=dia+28;
						}
						else {
							dia=dia+30;
						}
				}
			}
			else if (difmes<0) {
				for(int i=data2.getMM(); i< getMM()  ; i++) {
					if((i==1)||(i==3)||(i==5)||(i==7)||(i==8)||(i==10)||(i==11)) {
						dia=dia-31;
					}
					else
						if (i==2) {					
							if(getAAAA()%4 == 0) {
								dia=dia-29;
							}
							else
								dia=dia-28;
						}
						else {
							dia=dia-30;
					}
				}
			}
			int difdia= data2.getDD()-getDD();
			dia = dia + difdia;
			return dia;
			}
		else {
			System.out.print("0- OPERAÇÃO INVÁLIDA -");
			return 0;
		}
			
	}
	
	public String toString() {

		if(getDD()!=0){
			String d,m,a =null;
			if(getDD()<10) {
				d= "0"+getDD();	
			}
			else {
				d= ""+getDD();
			}
			
			if(getMM()<10) {
				m="0"+getMM();
			}
			else {
				m=""+getDD();
			}
			
			if (getAAAA()<10) {
				a="000"+getAAAA();
			}
			else 
				if(getAAAA()<100) {
					a="00"+getAAAA();
				}
				else
					if(getAAAA()<1000) {
						a="0"+getAAAA();
					}
					else {
						a=""+getAAAA();
					}
			
			return d+"/"+m+"/"+a;
		}
		else 
			return "";
	}
}