//package pAdcionais;
//
//import javax.swing.JOptionPane;
//
//public class FuncoesAdicionais {
//	public boolean verificaCPF(Long cpf) {
//		String sCpf = ""+cpf;
//		char[] caCpf = sCpf.toCharArray();
//		
//		if(caCpf.length != 11) {
//			JOptionPane.showMessageDialog(null, "Insira um CPF válido","Erro", JOptionPane.ERROR_MESSAGE);
//			return false;
//		}else {
//			int soma1 = 0;
//			for (int i = 0; i < 9; i++) {
//				soma1 += (caCpf[i] * i);
//			}
//			int digV1 = soma1%caCpf.length; 
//			if(digV1 == 10) digV1 = 0;
//		}
//		
//		
//	}
//}
