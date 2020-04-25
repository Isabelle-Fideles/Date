import java.util.Date;

public class Quest_1_Teste {
	public static void main (String[]args) {
		
		Quest_1_Data data1 = new Quest_1_Data(14,01,2000);
		System.out.println(data1);
		
		Quest_1_Data data2 = new Quest_1_Data();
		System.out.println(data2);
		
		System.out.println(data1.diasEntreDatas(data2));
	}
}
